package alex.mirash.mirashreader;

import android.app.Application;
import android.content.Context;

import alex.mirash.mirashreader.content.storage.ContentProvider;
import alex.mirash.mirashreader.properties.GlobalProperties;
import alex.mirash.mirashreader.utils.LogUtils;
import alex.mirash.mirashreader.utils.LoneUtils;

/**
 * @author Mirash
 */
public class ReaderApplication extends Application {
    private static ReaderApplication mInstance;
    private GlobalProperties mGlobalProperties;
    private ContentProvider mContentProvider;

    public static ReaderApplication getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }

    public static ContentProvider getContentProvider() {
        return mInstance.getReaderContentProvider();
    }

    public static GlobalProperties getGlobalProperties() {
        return mInstance.mGlobalProperties;
    }

    @Override
    public void onCreate() {
        LogUtils.log("application onCreate");
        super.onCreate();
        mInstance = this;
        mGlobalProperties = LoneUtils.getDefaultGlobalProperties();
        mContentProvider = new ContentProvider();
    }

    private void initContentProvider() {
        mContentProvider = new ContentProvider();
    }

    ContentProvider getReaderContentProvider() {
        return mContentProvider;
    }
}
