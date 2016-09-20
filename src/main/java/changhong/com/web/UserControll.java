/**
 *
 */
package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	public static int userid = 1;
	BlogServerce server;

	/**
	 * @param server
	 */
	@Autowired
	public UserControll(BlogServerce server) {
		super();
		this.server = server;
		List<User> list = server.findalluser();
		UserControll.userid = list.stream().mapToInt(a -> a.getId()).max().orElse(1);
	}

	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public User saveblog(@RequestBody User user) {
		if (user.getId() < 1) {
			user.setId(UserControll.userid++);
			user.setLogintime(new Date());
		}
		server.save(user);
		return user;
	}

	@RequestMapping(value = "/user/new", method = RequestMethod.GET)
	public User saveblognew() {
		User user = new User();
		if (user.getId() < 1) {
			user.setId(UserControll.userid++);

		}
		return user;
	}

	@RequestMapping(value = "/user/show/{name}", method = RequestMethod.GET)
	public User addablgo(@PathVariable String name) {
		User blog = server.finduserbyname(name);
		return blog;
	}

}
