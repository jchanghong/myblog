/**
 *
 */
package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import changhong.com.entity.Blog;
import changhong.com.reposity.BlogNodata;
import changhong.com.serverce.BlogServerce;

/**
 * @author jiang
 *
 */
@Controller
public class BlogController {

	static int blogid = 1;
	@Autowired
	BlogServerce server;

	@ResponseBody
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public List<BlogNodata> getallblog() {
		return server.findbloglist();
	}

	@RequestMapping(value = "/blog/show/{id}", method = RequestMethod.GET)
	public String getallblog(@PathVariable int id, Model model) {
		Blog blog = server.findblogbyid(id);
		model.addAttribute("id", blog.getId());
		model.addAttribute("title", blog.getTitle());
		model.addAttribute("data", blog.getData());
		model.addAttribute("createtime", blog.getCreatetime());
		return "forward:/ablog.jsp";
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.POST)
	public String saveblog(@PathVariable int id, Blog blog) {
		server.saveblog(blog);
		return "ok";
	}

	@ResponseBody
	@RequestMapping(value = "/addblog", method = RequestMethod.GET)
	public int addablgo() {

		Blog blog = new Blog();
		blog.setData("111111111");
		blog.setCreatetime(new Date());
		blog.setComplete((byte) 1);
		blog.setTitle("title");
		blog.setUpdatetime(new Date());
		blog.setId(BlogController.blogid++);
		server.saveblog(blog);
		return blog.getId();
	}
}
