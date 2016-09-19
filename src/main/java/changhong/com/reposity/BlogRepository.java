/**
 *
 */
package changhong.com.reposity;

import org.springframework.data.repository.CrudRepository;

import changhong.com.entity.Blog;

/**
 * @author jiang
 *
 */
public interface BlogRepository extends CrudRepository<Blog, Integer> {
	Blog findByTitle(String title);

}
