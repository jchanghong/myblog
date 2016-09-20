/**
 *
 */
package changhong.com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public String saveblog(User user) {
		if (user.getId() < 1) {
			user.setId(UserControll.blogid++);

		}
		server.save(user);
		return "ok";
	}

	@RequestMapping(value = "/user/new", method = RequestMethod.GET)
	public User saveblognew() {
		User user = new User();
		if (user.getId() < 1) {
			user.setId(UserControll.blogid++);

		}
		return user;
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public User addablgo(@PathVariable String name) {

		User blog = server.finduserbyname(name);
		return blog;
	}

}
