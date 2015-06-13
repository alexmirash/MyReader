package alex.mirash.mirashreader.content;

import alex.mirash.mirashreader.content.storage.ContentProvider;
import alex.mirash.mirashreader.content.views.ReaderLayout;

/**
 * @author Mirash
 */
public class ReaderController {
    private ReaderLayout mReaderView;
    private ContentProvider mContentProvider;

    public ReaderController(ContentProvider contentProvider) {
        mContentProvider = contentProvider;
    }

    public void setReaderLayout(ReaderLayout readerView) {
        mReaderView = readerView;
        mReaderView.setText(mContentProvider.getText());
    }

    public void clear() {
        mReaderView = null;
        mContentProvider = null;
    }
}
