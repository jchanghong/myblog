/**
 *
 */
package changhong.com.serverce;

import java.util.List;

import org.springframework.dao.DataAccessException;

import changhong.com.entity.Blog;
import changhong.com.entity.Image;
import changhong.com.entity.User;

/**
 * @author jiang
 *
 */
public interface BlogServerce {

	void save(User user) throws DataAccessException;

	void saveblog(Blog blog) throws DataAccessException;

	void saveimage(Image image) throws DataAccessException;

	Blog findblogbyid(int id) throws DataAccessException;

	List<Blog> findallblog() throws DataAccessException;

	Blog findblogbytitle(String title) throws DataAccessException;

	User finduserbyname(String name) throws DataAccessException;

}
