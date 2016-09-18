package changhong.com.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/22ggg.ggff")
	public String welcome() {
		System.out.println("hello");
		return "controller";
	}

	@ResponseBody
	@RequestMapping("/22s.s")
	public WelcomeController welcome1() {
		return this;
	}
}
