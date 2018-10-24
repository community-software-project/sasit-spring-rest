package oxygenfactory.com.sasit.module.tools;

import java.util.ArrayList;
import java.util.List;

import it.sauronsoftware.base64.Base64;

public final class Encryption {

	public static int getModulo(String str, int part) {
		int strLength = str.length();
		return strLength % part;
	}

	public static List<String> setArrayPart(String str, int slat) {
		int strLength = str.length();
		int _ptl = strLength / slat;
		List<String> substrList = new ArrayList<String>();
		for (int a = 0; a < slat; ++a) {
			String st = reverseStr(str.substring(_ptl * a, _ptl * (a + 1)));
			substrList.add(st);
		}
		return substrList;
	}

	public static String reverseStr(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static List<String> handleStr(String str, int slat) {
		int _mv = getModulo(str, slat);
		List<String> substrList;
		if (_mv == 0) {
			substrList = setArrayPart(str, slat);
		} else {
			int strLength = str.length();
			String mod = str.substring(strLength - _mv, strLength);
			String main = str.substring(0, strLength - _mv);
			substrList = setArrayPart(main, slat);
			substrList.add(mod);
		}
		return substrList;
	}

	public static String arrayToStr(List<String> substrList) {
		String objStr = "";
		for (int a = 0; a < substrList.size(); ++a) {
			objStr += substrList.get(a);
		}
		return objStr;
	}

	public static String reduction(String key, int slat) {
		List<String> psList = Encryption.handleStr(key, slat);
		String password = Encryption.arrayToStr(psList);
		return password;
	}

	public static void main(String[] args) {
		System.out.println(Base64.decode("MTExMTExMTE="));
	}

}
