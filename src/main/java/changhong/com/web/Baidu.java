/**
 *
 */
package changhong.com.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.ActionEnter;

/**
 * @author jiang
 *
 */
@RestController
public class Baidu {
	@RequestMapping(value = "jsp/{path}.jsp")
	public String get(@PathVariable String path, HttpServletRequest request) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// response.setHeader("Content-Type" , "text/html");

		String rootPath = request.getServletContext().getRealPath("/");

		String dd = new ActionEnter(request, rootPath).exec();
		System.out.println(dd);
		return dd;

	}

}
