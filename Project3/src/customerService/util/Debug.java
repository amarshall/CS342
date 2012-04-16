
package customerService.util;

public class Debug {
	public static int DEBUG_VALUE;

	public static void log(int debugCompare, String message) {
		if(DEBUG_VALUE >= debugCompare) {
			System.out.println(message);
		}
	}
}
