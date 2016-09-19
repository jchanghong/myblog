/**
 *
 */
package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Blog;
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
	public List<Blog> getallblog() {
		return server.findallblog();
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
