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
	static String url = "img/portfolio/thumbnails/";

	public static String getaurl() {

		double d = Math.random() * 100;

		if (d < 10) {
			return StaticImageurl.url + "1.jpg";
		}
		if (d < 30) {
			return StaticImageurl.url + "2.jpg";
		}
		if (d < 50) {
			return StaticImageurl.url + "3.jpg";
		}
		if (d < 70) {
			return StaticImageurl.url + "4.jpg";
		}
		if (d < 85) {
			return StaticImageurl.url + "5.jpg";
		}
		return StaticImageurl.url + "6.jpg";

	}

}
