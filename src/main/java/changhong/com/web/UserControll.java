/**
 *
 */
package changhong.com.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Blog;
import changhong.com.entity.User;
import changhong.com.serverce.BlogServerce;

/**
 * @author 长宏
 *
 */
@RestController
public class UserControll {
	static int blogid = 1;
	@Autowired
	BlogServerce server;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveblog(User user) {
		if (user.getId() < 1) {
			user.setId(UserControll.blogid++);

		}
		server.save(user);
		return "ok";
	}

	@RequestMapping(value = "/addb44444log", method = RequestMethod.GET)
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
