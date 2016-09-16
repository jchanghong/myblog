package changhong.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome() {
		System.out.println("hello");
		return "welcome";
	}

	// @RequestMapping("/index.html")
	public String welcome1() {
		return "index";
	}
}
