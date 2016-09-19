/**
 *
 */
package changhong.com.serverce;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import changhong.com.entity.Blog;
import changhong.com.entity.Image;
import changhong.com.entity.User;
import changhong.com.reposity.BlogRepository;
import changhong.com.reposity.ImageRepository;
import changhong.com.reposity.UserRepository;

/**
 * @author jiang
 *
 */
@Service
public class BlogServerImpl implements BlogServerce {

	BlogRepository blogRepository;
	UserRepository UserRepository1;
	ImageRepository ImageRepository1;

	/**
	 * @param blogRepository
	 * @param userRepository1
	 * @param imageRepository1
	 */
	@Autowired
	public BlogServerImpl(BlogRepository blogRepository, UserRepository userRepository1,
			ImageRepository imageRepository1) {
		super();
		this.blogRepository = blogRepository;
		this.UserRepository1 = userRepository1;
		this.ImageRepository1 = imageRepository1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#save(changhong.com.entity.User)
	 */
	@Override
	public void save(User user) throws DataAccessException {
		// TODO Auto-generated method stub
		UserRepository1.save(user);

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * changhong.com.serverce.BlogServerce#saveblog(changhong.com.entity.Blog)
	 */
	@Override
	public void saveblog(Blog blog) throws DataAccessException {
		// TODO Auto-generated method stub

		blogRepository.save(blog);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * changhong.com.serverce.BlogServerce#saveimage(changhong.com.entity.Image)
	 */
	@Override
	public void saveimage(Image image) throws DataAccessException {
		// TODO Auto-generated method stub

		ImageRepository1.save(image);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#findblogbyid(int)
	 */
	@Override
	public Blog findblogbyid(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#findallblog()
	 */
	@Override
	public List<Blog> findallblog() throws DataAccessException {
		// TODO Auto-generated method stub
		List<Blog> list = new ArrayList<Blog>();
		for (Blog blog : blogRepository.findAll()) {
			list.add(blog);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * changhong.com.serverce.BlogServerce#findblogbytitle(java.lang.String)
	 */
	@Override
	public Blog findblogbytitle(String title) throws DataAccessException {
		// TODO Auto-generated method stub
		return blogRepository.findByTitle(title);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#finduserbyname(java.lang.String)
	 */
	@Override
	public User finduserbyname(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return UserRepository1.findByName(name);
	}

}
