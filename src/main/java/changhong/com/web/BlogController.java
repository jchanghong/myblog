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
import changhong.com.entity.SimpleBlog;
import changhong.com.serverce.BlogServerce;
import changhong.com.util.StaticImageurl;

/**
 * @author jiang
 *
 */
@RestController
public class BlogController {

	public static int blogid = -1;
	BlogServerce server;

	@RequestMapping(value = "blogs/number/sum")
	public long blognumbers() {
		return server.blogcounts();

	}

	@RequestMapping(value = "blogs/get10/{start}", method = RequestMethod.GET)
	public List<SimpleBlog> blognumbers10(@PathVariable int start) {
		System.out.println("stat is" + start);
		List<SimpleBlog> all = server.findbloglist();
		long sum = server.blogcounts();
		if (start + 10 > sum) {
			return all.subList(start, (int) sum);
		} else {
			return all.subList(start, start + 10);
		}
		// return reSimpleBlogs;

	}

	/**
	 * @param server
	 */
	@Autowired
	public BlogController(BlogServerce server) {
		super();
		this.server = server;
		List<Blog> list = server.findallblog();
		BlogController.blogid = list.stream().mapToInt(a -> a.getId()).max().orElse(-1);
	}

	@RequestMapping(value = "/blogs/{text}", method = RequestMethod.GET)
	public List<SimpleBlog> serchblog(@PathVariable String text) {
		System.out.println("serch text is:" + text);
		return server.serch(text);
	}

	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public List<SimpleBlog> getallblog() {
		return server.findbloglist();
	}

	@RequestMapping(value = "/blog/show/orup/{id}", method = RequestMethod.GET)
	public Blog getallblogup(@PathVariable int id) {
		System.out.println("id is:" + id);
		Blog blog = server.findblogbyid(id);
		while (blog == null && id >= 0) {
			blog = server.findblogbyid(id--);
		}
		return blog;
	}

	@RequestMapping(value = "/blog/show/ordown/{id}", method = RequestMethod.GET)
	public Blog getallblogdown(@PathVariable int id) {
		System.out.println("id is:" + id);
		Blog blog = server.findblogbyid(id);
		long sum = server.blogcounts();
		while (blog == null && id < sum) {
			blog = server.findblogbyid(id++);
		}
		if (blog == null) {
			blog = getallblogdown(0);
		}
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
			blog.setId(++BlogController.blogid);
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
		blog.setId(++BlogController.blogid);
		server.saveblog(blog);
		return blog.getId();
	}
}
