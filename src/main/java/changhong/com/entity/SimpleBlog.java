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
	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return this.types;
	}

	/**
	 * @param types
	 *            the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return this.Updatetime;
	}

	/**
	 * @param updatetime
	 *            the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.Updatetime = updatetime;
	}

	/**
	 * @return the complete
	 */
	public int getComplete() {
		return this.complete;
	}

	/**
	 * @param complete
	 *            the complete to set
	 */
	public void setComplete(int complete) {
		this.complete = complete;
	}

	private static final long serialVersionUID = 1L;
	public int id;
	public String data;
	public String title;
	public String image;
	public String types;
	public Date Updatetime;
	public int complete;

	/**
	 *
	 */
	public SimpleBlog(Blog blog) {
		// TODO Auto-generated constructor stub
		id = blog.getId();
		if (blog.getDatanohtml().length() < 10) {
			data = "......  " + blog.getDatanohtml();
		} else {
			data = blog.getDatanohtml().substring(0, 10) + "   more...";
		}
		title = blog.getTitle();
		types = blog.getTypes();
		image = blog.getImage();
		Updatetime = blog.getUpdatetime();
		complete = blog.getComplete();

	}

}
