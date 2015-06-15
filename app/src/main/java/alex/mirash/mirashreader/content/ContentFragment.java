package alex.mirash.mirashreader.content;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alex.mirash.mirashreader.R;
import alex.mirash.mirashreader.ReaderApplication;
import alex.mirash.mirashreader.base.BaseFragment;
import alex.mirash.mirashreader.content.views.ReaderLayout;

/**
 * @author Mirash
 */
public class ContentFragment extends BaseFragment {
    private ReaderLayout mReaderLayout;
    private ReaderController mReaderController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReaderController = new ReaderController(ReaderApplication.getContentProvider());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mReaderController = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.reader_content, null);
        mReaderLayout = (ReaderLayout) contentView.findViewById(R.id.reader_layout);
        initReaderLayout();
        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mReaderController.clear();
        removeReaderCallbacks();
    }

    private void initReaderLayout() {
        mReaderLayout.setGesturesDetectorCallback(null/*mReaderController*/);
    }

    private void removeReaderCallbacks() {
        mReaderLayout.setGesturesDetectorCallback(null);
    }
}
