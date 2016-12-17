package com.equinooxe.module.dashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	@GetMapping("/home")
	public String home() {
		return "/home";
	}
}
