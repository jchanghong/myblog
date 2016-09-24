package changhong.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Types;
import changhong.com.serverce.BlogServerce;

/**
 * @author 长宏
 *
 */
@RestController
public class BlogTypeControll {
	public static int messageid;

	BlogServerce servers;

	/**
	 * @param servers
	 */
	@Autowired
	public BlogTypeControll(BlogServerce servers) {
		super();
		this.servers = servers;
		BlogTypeControll.messageid = servers.getalltypes().stream().mapToInt(Types::getId).max().orElse(1);
	}

	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public List<Types> getallmessage() {
		return servers.getalltypes();
	}

	@RequestMapping(value = "/type/new", method = RequestMethod.POST)
	public Types addmeaage(@RequestBody Types message) {
		if (message.getId() < 1) {
			message.setId(BlogTypeControll.messageid++);
		}

		servers.addtypes(message);

		return message;

	}
}
