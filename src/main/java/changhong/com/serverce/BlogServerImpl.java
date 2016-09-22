/**
 *
 */
package changhong.com.serverce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import changhong.com.entity.Blog;
import changhong.com.entity.Image;
import changhong.com.entity.Message;
import changhong.com.entity.SimpleBlog;
import changhong.com.entity.User;
import changhong.com.reposity.BlogRepository;
import changhong.com.reposity.ImageRepository;
import changhong.com.reposity.MessageRepository;
import changhong.com.reposity.UserRepository;
import changhong.com.reposity.Userpasswordandname;

/**
 * @author jiang
 *
 */
@Service
public class BlogServerImpl implements BlogServerce {

	@Autowired
	MessageRepository messageRepository1;
	BlogRepository blogRepository;
	UserRepository UserRepository1;
	ImageRepository ImageRepository1;

	// @CachePut(value = "blogssimple")
	// @CacheEvict(value = "blogssimple", allEntries = true)
	public void putcache(SimpleBlog blog) {

	}

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
	// @CachePut(value = "users", key = "#user.getId()")
	// @CacheEvict(value = "users", key = "#root.targetClass")
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
	// @CachePut(value = "blogs")
	@CacheEvict(value = { "blogs", "blogssimple" }, allEntries = true)
	public void saveblog(Blog blog) throws DataAccessException {
		// TODO Auto-generated method stub
		blogRepository.save(blog);
		putcache(new SimpleBlog(blog));
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
	@Cacheable(value = "blogs")
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
	@Cacheable(value = "blogs")
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
	@Cacheable(value = "blogs")
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
	// @Cacheable(value="users",key="names.concat(#name)")
	public User finduserbyname(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return UserRepository1.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * changhong.com.serverce.BlogServerce#finduserpassword(java.lang.String)
	 */
	@Override
	// @Cacheable(value="users",key="password.concat(#name)")
	public Userpasswordandname finduserpassword(String name) {
		// TODO Auto-generated method stub
		return UserRepository1.findBynameLike(name);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#findbloglist()
	 */
	@Override
	@Cacheable(value = "blogssimple")
	public List<SimpleBlog> findbloglist() {
		// TODO Auto-generated method stub
		List<SimpleBlog> simpleBlogs = new ArrayList<>();
		Iterable<Blog> lis = blogRepository.findAll();
		lis.forEach(aa -> simpleBlogs.add(new SimpleBlog(aa)));
		return simpleBlogs;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#findalluser()
	 */
	@Override
	@Cacheable(value = "users")
	public List<User> findalluser() throws DataAccessException {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		for (User blog : UserRepository1.findAll()) {
			list.add(blog);
		}
		return list;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#serch(java.lang.String)
	 */
	@Override
	@Cacheable(value = "blogssimple")
	public List<SimpleBlog> serch(String text) throws DataAccessException {
		// TODO Auto-generated method stub
		BlogServerImpl.serchtext = text;

		List<Blog> allblog = new ArrayList<>();
		blogRepository.findAll().forEach(a -> allblog.add(a));

		return allblog.stream().filter(BlogServerImpl::doserchfilter).map(SimpleBlog::new).collect(Collectors.toList());

	}

	static String serchtext = "";

	/**
	 * @param nodata
	 * @return true 满足
	 */
	static boolean doserchfilter(Blog nodata) {
		if (BlogServerImpl.serchtext.trim().length() < 1) {
			return true;
		}
		boolean b = true;
		for (String string : BlogServerImpl.serchtext.trim().split("\\s*")) {
			if (string.length() < 1) {
				continue;
			}
			if (!nodata.getTitle().contains(string)) {
				b = false;
			}
			if (!nodata.getData().contains(string)) {
				b = false;
			}

		}
		return b;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#addmessage(changhong.com.entity.
	 * Message)
	 */
	@Override
	public void addmessage(Message message) throws DataAccessException {
		// TODO Auto-generated method stub

		messageRepository1.save(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see changhong.com.serverce.BlogServerce#getallmessaget()
	 */
	@Override
	public List<Message> getallmessaget() throws DataAccessException {
		// TODO Auto-generated method stub
		return messageRepository1.findByNameNotNull();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see changhong.com.serverce.BlogServerce#blogcounts()
	 */
	@Override
	public long blogcounts() throws DataAccessException {
		// TODO Auto-generated method stub
		return blogRepository.count();
	}

}
