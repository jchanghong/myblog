/**
 *
 */
package changhong.com;

import java.io.File;
import java.io.IOException;

/**
 * @author 长宏
 *
 */
public class Test {

	public static void main(String[] args) {
		File file = new File("ff.java");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
