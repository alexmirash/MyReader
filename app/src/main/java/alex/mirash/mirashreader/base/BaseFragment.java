package alex.mirash.mirashreader.base;

import android.app.Activity;
import android.app.Fragment;

import alex.mirash.mirashreader.ContentActivity;

/**
 * @author Mirash
 */
public abstract class BaseFragment extends Fragment {
    protected ContentActivity mContentActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContentActivity = (ContentActivity) activity;
    }

    public void handleBackPressedEvent() {
    }

}
