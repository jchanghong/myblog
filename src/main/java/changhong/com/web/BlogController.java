/**
 *
 */
package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Blog;
import changhong.com.reposity.BlogNodata;
import changhong.com.serverce.BlogServerce;

/**
 * @author jiang
 *
 */
@RestController
public class BlogController {

	static int blogid = 1;
	@Autowired
	BlogServerce server;

	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public List<BlogNodata> getallblog() {
		return server.findbloglist();
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
	public Blog getallblog(@PathVariable int id) {
		Blog blog = server.findblogbyid(id);
		return blog;
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.POST)
	public String saveblog(@PathVariable int id, String data, String title, BindingResult bResult) {
		if (bResult.hasErrors()) {
			System.out.println(bResult.getAllErrors());
			return "0";
		} else {
			Blog blog = new Blog();
			blog.setData(data);
			blog.setCreatetime(new Date());
			blog.setComplete((byte) 1);
			blog.setTitle(title);
			blog.setUpdatetime(new Date());
			blog.setId(BlogController.blogid++);
			server.saveblog(blog);
		}
		return "1";

	}

	@RequestMapping(value = "/blog/new", method = RequestMethod.GET)
	public Blog newblog() {
		Blog blog = new Blog();
		blog.setId(BlogController.blogid++);
		return blog;

	}

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
