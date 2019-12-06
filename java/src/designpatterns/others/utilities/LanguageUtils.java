package utilities;

public class LanguageUtils {
	public static int MAX_COUNT_MATCH_POST=100;
	public static boolean isFirstLanguageDetector(String language) {
		if (language == null || language.isEmpty() || language == "")
			return true;
		//int countMatches = countMatches(language);
		//if (countMatches <= 1)
		//	return true;
		return false;

	}
	public static boolean isSecondLanguageDetector(String language) {
		//if (language == null || language.isEmpty() || language == "")
		//	return false;
		int countMatches = countMatches(language);
		if (countMatches <= MAX_COUNT_MATCH_POST)
			return true;
		return false;

	}
	public static int countMatches(String language) {
		return StringUtils.countMatches(language, ",");
	}

	public static void main(String[] args) {
		System.out.println(countMatches("vi,vi"));
		System.out.println(countMatches("vi,mn,km,kt"));
		System.out.println(isSecondLanguageDetector("vi,mn,km,kt"));
		System.out.println(isSecondLanguageDetector("vi,mn"));
	}
}
