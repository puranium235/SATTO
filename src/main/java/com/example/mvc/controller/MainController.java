package com.example.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.dto.Message;
import com.ssafy.mvc.dto.Satto;
import com.ssafy.util.Util;

@Controller
public class MainController {
	Util util = Util.getInstance();

	@GetMapping("/ssato")
	String main(Model model) {
		Message msg = new Message("init", "1~45사이의 숫자를 입력해주세요");
		model.addAttribute("msg", msg);
		return "sattoForm";
	}

	@PostMapping("/ssato")
	String satto(@RequestParam String type, @RequestParam List<Integer> num, Model model) {
		Satto userSatto;

		Message msg = util.validCheck(type, num);
		if (msg.getStatus().equals("error")) {
			model.addAttribute("msg", msg);
			return "sattoForm";
		}

		if (type == "auto") {
			userSatto = new Satto();
		} else {
			userSatto = new Satto(num);
		}

		Satto serverSatto = new Satto();

		int match = userSatto.compare(serverSatto);

		model.addAttribute("userSatto", userSatto);
		model.addAttribute("serverSatto", serverSatto);
		model.addAttribute("match", match);

		return "result";
	}
}
