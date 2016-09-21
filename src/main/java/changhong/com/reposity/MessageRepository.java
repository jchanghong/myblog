/**
 *
 */
package changhong.com.reposity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import changhong.com.entity.Message;

/**
 * @author 长宏
 *
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

	List<Message> findByNameNotNull();
}
