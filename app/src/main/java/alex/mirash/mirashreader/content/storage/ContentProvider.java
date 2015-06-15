package alex.mirash.mirashreader.content.storage;

import android.os.AsyncTask;

import alex.mirash.mirashreader.ReaderApplication;
import alex.mirash.mirashreader.utils.FileUtils;

import static alex.mirash.mirashreader.utils.LogUtils.log;

/**
 * @author Mirash
 */
public class ContentProvider {
    public String mText = "";
    private AsyncTask mReadTask;
    private ReadListener mReadListener;

    public ContentProvider() {
        generateText();
    }

    private void generateText() {
        log("read file from assets");
        mReadTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void[] params) {
                final StringBuilder builder = new StringBuilder();
                FileUtils.readFileFromAssets(ReaderApplication.getAppContext(), "what.txt", new FileUtils.ReadListener() {
                    @Override
                    public void onLineRead(String line) {
                        log("onLineRead: " + line);
                        builder.append(line);
                    }
                });
                return builder.toString();
            }

            @Override
            protected void onPostExecute(String text) {
                mReadTask = null;
                mText = text;
                if (mReadListener != null) {
                    mReadListener.onRead(mText);
                    mReadListener = null;
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public String getNextPage() {
        return mText;
    }

    public String getPreviousPage() {
        return mText;
    }

    public String getText() {
        return mText;
    }

    public boolean isReady() {
        return mReadTask == null;
    }

    public void getText(ReadListener listener) {
        mReadListener = listener;
    }

    public interface ReadListener {
        void onRead(String text);
    }
}
