/**
 *
 */
package changhong.com.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.ActionEnter;

/**
 * @author 长宏
 *
 */
@Controller
public class Baidueditor {

	@ResponseBody
	@RequestMapping(value = "/baidujsp")
	public String getjsp(HttpServletRequest request, HttpEntity<String> entity) {
		String dString = entity.getBody();
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			request.setCharacterEncoding("utf-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.setHeader("Content-Type", "text/html");

		String rootPath = request.getSession().getServletContext().getRealPath("/");
		System.out.println("baidujsp-------------");

		return new ActionEnter(request, rootPath).exec();
		// out.write(new ActionEnter(request, rootPath).exec());
		// return "baidu";

	}

}
