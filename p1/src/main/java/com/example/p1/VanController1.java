package com.example.p1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class VanController1 {
@Autowired
private MemberRepository memRep;
@GetMapping("/member/list")
public String memberList(Model mo) {
List<Member> list = memRep.findAll(); 
mo.addAttribute("list",list);
return "memberList";
}
}