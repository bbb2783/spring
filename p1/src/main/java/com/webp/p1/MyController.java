package com.webp.p1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	@GetMapping("/ex01")
	public String ex01() {
	return "ex01";
	}
	@PostMapping("/ex01/answer")
	public String ex01Answer(String id, String pw, Model model) {
	model.addAttribute("id", id);
	model.addAttribute("pw", pw);
	return "ex01Answer";
	}
}
