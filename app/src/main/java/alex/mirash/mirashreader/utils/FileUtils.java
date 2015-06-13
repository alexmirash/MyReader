package alex.mirash.mirashreader.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Mirash
 */
public class FileUtils {
    public static void loadFile() {

    }

    public static void readFileFromAssets(Context context, String fileName, ReadListener readListener) {
        BufferedReader reader;
        try {
            final InputStream file = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            readListener.onLineRead(line);
            while (line != null) {
                line = reader.readLine();
                readListener.onLineRead(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            Log.d("LOL", "epic fail " + ioe.getMessage());
        }
    }

    public interface ReadListener {
        void onLineRead(String line);
    }
}
