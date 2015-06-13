package alex.mirash.mirashreader.utils;

import android.util.Log;

/**
 * @author Mirash
 */
public final class LogUtils {
    public static final String TAG = "LOL";

    public static void log(String message) {
        log(TAG, message);
    }

    public static void log(String tag, String message) {
        Log.d(tag, message);
    }
}
