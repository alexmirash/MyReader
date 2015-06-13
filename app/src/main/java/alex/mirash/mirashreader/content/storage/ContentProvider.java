package alex.mirash.mirashreader.content.storage;

import alex.mirash.mirashreader.ReaderApplication;
import alex.mirash.mirashreader.utils.FileUtils;

import static alex.mirash.mirashreader.utils.LogUtils.log;

/**
 * @author Mirash
 */
public class ContentProvider {
    public String mText = "omfg";

    public ContentProvider() {
        generateText();
    }

    private void generateText() {
        log("read file from assets");
        FileUtils.readFileFromAssets(ReaderApplication.getAppContext(), "what.txt", new FileUtils.ReadListener() {
            @Override
            public void onLineRead(String line) {
                log("onLineRead: " + line);
                mText = mText + line;
            }
        });
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
}
