	package com.example.p1;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class VanController1 {
@Autowired
private MemberRepository memRep;

@GetMapping("/test1")
public String test1()
{
	return "test1";
}
@GetMapping("/signup2")
public String signup2()
{
	return "signup2";
}
@GetMapping("/member/list")
public String memberList(Model mo) {
List<Member> list = memRep.findAll(); 
mo.addAttribute("list",list);
return "memberList";
}

@GetMapping("new/member/list")
public String newmemberList(Model mo) {
List<Member> list = memRep.findAll(); 
mo.addAttribute("list",list);
return "newmemberList";
}


@GetMapping("/main")
public String main() {
	return "main";
}

@GetMapping("/login")
public String login() { 
return "login";
}

@GetMapping("/member/register")
public String memberRegister() { 
return "memberRegister";
}

@GetMapping("/member/insert")
public String memberInsert(String id, String pw, String pw2, String email, Model mo) {
    if (memRep.existsById(id)) {
        mo.addAttribute("msg", id + "는 이미 사용되고 있는 아이디 입니다.");
        mo.addAttribute("url", "back");
    } else {
        if (!pw.equals(pw2)) {
            mo.addAttribute("msg", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            mo.addAttribute("url", "back");
        } else {
            Member m = new Member();
            m.id = id;
            m.pw = pw;
            m.pw2 = pw2;
            m.email = email;
            m.compare = "person";
            m.balance = 0;
            memRep.save(m);
            mo.addAttribute("msg", id + "님, 반갑습니다");
            mo.addAttribute("url", "/test1");
        }
    }
    return "popus";
}

@GetMapping("new/member/insert")
public String newmemberInsert(String id, String pw, String pw2, String email, String num1, String address, String compare, Integer compare2, Model mo) {
    if (memRep.existsById(id)) {
        mo.addAttribute("msg", id + "는 이미 사용되고 있는 아이디 입니다.");
        mo.addAttribute("url", "back");
    } else {
        if (!pw.equals(pw2)) {
            mo.addAttribute("msg", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            mo.addAttribute("url", "back");
        } else if (memRep.existsByNum1(num1)) { // 추가: num1 중복 확인
            mo.addAttribute("msg", num1 + "는 이미 사용되고 있는 사업자 번호 입니다.");
            mo.addAttribute("url", "back");
        } else {
            Member m = new Member();
            m.id = id;
            m.pw = pw;
            m.pw2 = pw2;
            m.email = email;
            m.num1 = num1;
            m.address = address;
            m.compare = "bussiness";
            m.compare2 = 1;
            m.balance = 0;
            memRep.save(m);
            mo.addAttribute("msg", id + "님, 반갑습니다");
            mo.addAttribute("url", "/test1");
        }
    }
    return "popus";
}

@GetMapping("/login/check")
public String loginCheck(HttpSession session, String id, String pw, Model mo) {
    if (id == null || id.trim().isEmpty() || pw == null || pw.trim().isEmpty()) {
        // 아이디 또는 비밀번호가 빈 칸인 경우
        mo.addAttribute("msg", "아이디와 비밀번호를 모두 입력해주세요.");
        mo.addAttribute("url", "back");
        return "popus";
    }

    // 아이디로 회원 정보를 데이터베이스에서 조회합니다.
    Optional<Member> optionalMember = memRep.findById(id);

    if (optionalMember.isPresent()) { // 해당 아이디의 회원 정보가 존재하는 경우
        Member member = optionalMember.get();
        // 데이터베이스에 저장된 비밀번호를 가져옵니다.
        String storedPassword = member.getPw();

        // 사용자가 입력한 비밀번호와 저장된 비밀번호를 비교합니다.
        if (pw.equals(storedPassword)) 
        {
            // 비밀번호가 일치하는 경우, 로그인 성공으로 처리합니다.
            session.setAttribute("id", id);
            return "redirect:/menu";
        }
        else
        {
            mo.addAttribute("msg", "비밀번호가 올바르지 않습니다.");
            mo.addAttribute("url", "back");
            return "popus";
        }
    }
    else
    {
        // 아이디가 존재하지 않는 경우 처리
        mo.addAttribute("msg", "아이디가 올바르지 않습니다.");
        mo.addAttribute("url", "back");
        return "popus";
    }
}




@GetMapping("/menu")
public String menu(HttpSession session, Model mo) {
mo.addAttribute("id", session.getAttribute("id"));
mo.addAttribute("compare", session.getAttribute("compare"));
return "menu";
}

@GetMapping("/myinfo")
public String myinfo(HttpSession session, Model mo) {
String id = (String)session.getAttribute("id");
Member m = memRep.findById(id).get(); 
mo.addAttribute("m",m);
DecimalFormat df = new DecimalFormat("###,###");
mo.addAttribute("won", df.format(m.balance)+" 원");
return "myinfo";
}


}