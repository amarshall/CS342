
package customerService.util;

public class Debug {
	private static int DEBUG_VALUE;
	public static void setDebug(int debug) {
        if(debug > 4) {
            System.err.println("Invalid Debug Value");
            System.exit(1);
        }
        else {
            DEBUG_VALUE = debug;
        }
    }
	public static void log(int debugCompare, String message) {
		if(DEBUG_VALUE >= debugCompare) {
			System.out.println(message);
		}
	}
}
