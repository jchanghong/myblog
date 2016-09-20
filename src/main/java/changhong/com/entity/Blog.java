package changhong.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import changhong.com.util.StaticImageurl;
import changhong.com.web.BlogController;

/**
 * The persistent class for the blog database table.
 *
 */
@Entity
@Table(name = "blog")
// @NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private byte complete;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date createtime;

	@Lob
	@Column(nullable = false)
	private String data;

	@Column(nullable = false, length = 255)
	private String title;
	@Column(nullable = false, length = 255)
	private String image;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date updatetime;

	public Blog() {
		id = BlogController.blogid++;
		image = StaticImageurl.getaurl();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getComplete() {
		return this.complete;
	}

	public void setComplete(byte complete) {
		this.complete = complete;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}