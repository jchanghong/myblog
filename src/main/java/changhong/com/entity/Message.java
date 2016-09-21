/**
 *
 */
package changhong.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 长宏
 *
 */
@Entity
@Table(name = "message")
public class Message {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id;
	@Column(nullable = false)
	String message;
	@Column(nullable = false)
	String name;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date time;

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
	 * @return the message
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return this.time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

}
