/**
 *
 */
package changhong.com.reposity;

import org.springframework.data.repository.CrudRepository;

import changhong.com.entity.User;

/**
 * @author jiang
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByName(String name);

}
