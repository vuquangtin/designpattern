package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class FBUtils {
	public static final Pattern fbCover = Pattern.compile("[0-9]_[0-9]*_[0-9]*");
	public static final Pattern fbURLPhotoCover = Pattern.compile("[0-9]\\.[0-9]*\\.[0-9]*");

	public static String getPicId(String urlScontentCoverOrPicture) {
		// https://scontent.xx.fbcdn.net/v/t1.0-1/p50x50/13906762_503520226523380_4696441362911374914_n.jpg?oh=1709a7acedffe342c529cdad739e809e&oe=59F1B91E
		// "source":
		// "https://scontent.xx.fbcdn.net/v/t1.0-9/12208303_10153677667932243_3947247653592132179_n.jpg?_nc_cat=0&oh=d522f5456414dcaf17f02291adcc6cf4&oe=5B735233"
		if (urlScontentCoverOrPicture == null)
			return null;
		try {
			if (urlScontentCoverOrPicture.startsWith("https://")) {
				Matcher m = fbCover.matcher(urlScontentCoverOrPicture);
				String newVal = null;
				while (m.find()) {
					newVal = m.group();
					return newVal.substring(newVal.indexOf("_") + "_".length(), newVal.lastIndexOf("_"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (urlScontentCoverOrPicture.matches("[0-9]*")) {
			return urlScontentCoverOrPicture;
		}
		return null;
	}

	public static String getGlobalId(String urlCoverOrPicture) {
		if (urlCoverOrPicture == null)
			return null;
		if (urlCoverOrPicture.startsWith("https://") && urlCoverOrPicture.contains("photo.php?fbid=")) {
			Matcher m = fbURLPhotoCover.matcher(urlCoverOrPicture);
			String newVal = null;
			// picture
			// https://www.facebook.com/photo.php?fbid=145677999233601&set=a.114469579021110.1073741827.100013742051615&type=3&theater
			// cover
			// https://www.facebook.com/photo.php?fbid=10153677667932243&set=a.10152669987177243.1073741833.649092242&type=3
			while (m.find()) {
				newVal = m.group();
				return newVal.substring(newVal.lastIndexOf(".") + ".".length());

			}
		}
		return null;
	}
}
