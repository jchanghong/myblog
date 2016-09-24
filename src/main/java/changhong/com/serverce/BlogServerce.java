/**
 *
 */
package changhong.com.serverce;

import java.util.List;

import org.springframework.dao.DataAccessException;

import changhong.com.entity.Blog;
import changhong.com.entity.Image;
import changhong.com.entity.Message;
import changhong.com.entity.SimpleBlog;
import changhong.com.entity.Types;
import changhong.com.entity.User;
import changhong.com.reposity.Userpasswordandname;

/**
 * @author jiang
 *
 */
public interface BlogServerce {
	List<Types> getalltypes() throws DataAccessException;

	void addtypes(Types types) throws DataAccessException;

	// mesage
	void addmessage(Message message) throws DataAccessException;

	List<Message> getallmessaget() throws DataAccessException;

	// mesage
	/**
	 * @param namedd
	 * @return
	 */
	Userpasswordandname finduserpassword(String name);

	/**
	 * @param text
	 *            空格代表and 如rr rr rr4
	 * @return
	 * @throws DataAccessException
	 */
	List<SimpleBlog> serch(String text) throws DataAccessException;

	List<SimpleBlog> findbloglist();

	void save(User user) throws DataAccessException;

	void saveblog(Blog blog) throws DataAccessException;

	void saveimage(Image image) throws DataAccessException;

	Blog findblogbyid(int id) throws DataAccessException;

	List<Blog> findallblog() throws DataAccessException;

	List<User> findalluser() throws DataAccessException;

	Blog findblogbytitle(String title) throws DataAccessException;

	User finduserbyname(String name) throws DataAccessException;

	long blogcounts() throws DataAccessException;

}
