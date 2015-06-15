package alex.mirash.mirashreader.content;

import alex.mirash.mirashreader.content.storage.ContentProvider;

/**
 * @author Mirash
 */
public class ReaderController {
    private ContentProvider mContentProvider;

    public ReaderController(ContentProvider contentProvider) {
        mContentProvider = contentProvider;
    }

    public void clear() {
        mContentProvider = null;
    }
}
