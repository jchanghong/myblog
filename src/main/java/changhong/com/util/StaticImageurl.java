/**
 *
 */
package changhong.com.util;

/**
 * @author jiang
 *
 */
public class StaticImageurl {
	// static String url = "img/portfolio/thumbnails/1.jpg";
	static String url = "img/portfolio/my/";

	public static String getaurl() {

		long d = (long) (Math.random() * 200);
		long image = d % 12;

		return StaticImageurl.url + image + ".jpg";

	}

}
