package xh.utils;

public class UUID {

	public static String random32() {
		String uuid = java.util.UUID.randomUUID().toString();
		char[] cs = new char[32];
		char c = 0;
		for (int i = uuid.length(), j = 0; i-- > 0;) {
			if ((c = uuid.charAt(i)) != '-') {
				cs[j++] = c;
			}
		}
		return new String(cs);
	}
	public static String random36() {
		return null;
	}
	public static void main(String[] args) {
		String r=random32();
		System.out.println(r);
	}
}
