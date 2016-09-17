/**
 *
 */
package changhong.com.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;

/**
 * @author jiang
 *
 */
@Controller
public class Baidu {

	@RequestMapping(value = "222baidu")
	public String getmessaget(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Content-Type", "text/html");

		String rootPath = request.getServletContext().getRealPath("/");

		return new ActionEnter(request, rootPath).exec();
		// return "controller";

	}

	@RequestMapping(value = "jsp/{path}.jsp")
	public String doit(@PathVariable String path) {
		System.out.println(path);
		return path;
	}

}
