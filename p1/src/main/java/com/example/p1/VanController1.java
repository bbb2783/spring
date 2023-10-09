	package com.example.p1;

import java.text.DecimalFormat;
import java.util.List;

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
@GetMapping("/member/list")
public String memberList(Model mo) {
List<Member> list = memRep.findAll(); 
mo.addAttribute("list",list);
return "memberList";
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
public String memberInsert(String id, String pw, String pw2, String email, Model mo)
{
	if (memRep.existsById(id)) {
		mo.addAttribute("msg", id+ "는 이미 사용되고 있는 아이디 입니다.");
		mo.addAttribute("url", "back");
	}
	else
	{
		Member m = new Member();
		m.id = id; m.pw = pw; m.pw2 = pw2; m.email = email;
		m.balance = 0;
		memRep.save(m);
		mo.addAttribute("msg", id+ "님, 반갑습니다");
		mo.addAttribute("url", "/newlogin");
	}
	return "popus";
}
@GetMapping("/login/check")
public String loginCheck(HttpSession session, String id, Model mo) {
if(memRep.existsById(id)) { /* 정상 로그인 */
session.setAttribute("id", id);
return "redirect:/menu"; 
}
else {
mo.addAttribute("msg", id
+"는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
mo.addAttribute("url", "/login");
return "popups";
}
}

@GetMapping("/menu")
public String menu(HttpSession session, Model mo) {
mo.addAttribute("id", session.getAttribute("id"));
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