/**
 *
 */
package changhong.com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 长宏
 *
 */
public class SimpleBlog implements Serializable {
	private static final long serialVersionUID = 1L;
	public int id;
	public String data;
	public String title;
	public String image;
	public Date Updatetime;
	public int complete;

	/**
	 *
	 */
	public SimpleBlog(Blog blog) {
		// TODO Auto-generated constructor stub
		id = blog.getId();
		if (blog.getDatanohtml().length() < 30) {
			data = blog.getDatanohtml();
		} else {
			data = blog.getDatanohtml().substring(0, 30) + "...";
		}
		title = blog.getTitle();
		image = blog.getImage();
		Updatetime = blog.getUpdatetime();
		complete = blog.getComplete();

	}

}
