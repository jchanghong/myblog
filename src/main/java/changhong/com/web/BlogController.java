/**
 *
 */
package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Blog;
import changhong.com.reposity.BlogNodata;
import changhong.com.serverce.BlogServerce;
import changhong.com.util.StaticImageurl;

/**
 * @author jiang
 *
 */
@RestController
public class BlogController {

	public static int blogid = 1;
	BlogServerce server;

	/**
	 * @param server
	 */
	@Autowired
	public BlogController(BlogServerce server) {
		super();
		this.server = server;

		List<BlogNodata> list = server.findbloglist();
		BlogController.blogid = list.stream().mapToInt(a -> a.getId()).max().orElse(1);
	}

	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public List<BlogNodata> getallblog() {
		return server.findbloglist();
	}

	@RequestMapping(value = "/blog/show/{id}", method = RequestMethod.GET)
	public Blog getallblog(@PathVariable int id) {
		System.out.println("id is:" + id);
		Blog blog = server.findblogbyid(id);
		return blog;
	}

	@RequestMapping(value = "/blog/new", method = RequestMethod.POST)
	public Blog saveblog(@RequestBody Blog blog, BindingResult bResult) {
		// System.out.println(string + "------------------------------------");
		// Blog blog = new Blog();
		if (bResult.hasErrors()) {
			System.out.println(bResult.getAllErrors());
			return new Blog();
			// throw new RuntimeException(bResult.getAllErrors().toString());
		} else {
			// blog.setData(data);
			blog.setCreatetime(new Date());
			blog.setComplete((byte) 1);
			// blog.setTitle(title);
			blog.setUpdatetime(new Date());
			blog.setId(BlogController.blogid++);
			blog.setImage(StaticImageurl.getaurl());
			server.saveblog(blog);
		}
		return blog;

	}

	@RequestMapping(value = "/blog/new", method = RequestMethod.GET)
	public Blog newblog() {
		Blog blog = new Blog();
		return blog;

	}

	@RequestMapping(value = "/addblog/a/a", method = RequestMethod.GET)
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
