package changhong.com.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import changhong.com.entity.Message;
import changhong.com.serverce.BlogServerce;

/**
 * @author 长宏
 *
 */
@RestController
public class MessageControll {
	public static int messageid;

	BlogServerce servers;

	/**
	 * @param servers
	 */
	@Autowired
	public MessageControll(BlogServerce servers) {
		super();
		this.servers = servers;
		MessageControll.messageid = servers.getallmessaget().stream().mapToInt(Message::getId).max().orElse(1);
	}

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public List<Message> getallmessage() {
		return servers.getallmessaget();
	}

	@RequestMapping(value = "/message/new", method = RequestMethod.POST)
	public Message addmeaage(@RequestBody Message message) {
		if (message.getId() < 1) {
			message.setId(MessageControll.messageid++);
		}
		message.setTime(new Date());
		servers.addmessage(message);

		return message;

	}
}
