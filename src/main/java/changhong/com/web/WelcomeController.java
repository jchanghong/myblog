package changhong.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/22gggggff")
	public String welcome() {
		System.out.println("hello");
		return "controller";
	}

	@ResponseBody
	@RequestMapping("/22ss")
	public WelcomeController welcome1() {
		return this;
	}
}
