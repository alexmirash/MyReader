package alex.mirash.mirashreader.content.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ViewSwitcher;

import alex.mirash.mirashreader.R;
import alex.mirash.mirashreader.ReaderApplication;
import alex.mirash.mirashreader.content.storage.ContentProvider;

/**
 * @author Mirash
 */
public class ReaderFrameSwitcherView extends ViewSwitcher implements ViewSwitcher.ViewFactory {
    public ReaderFrameSwitcherView(Context context) {
        super(context);
        init(context);
    }

    public ReaderFrameSwitcherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setFactory(this);
        //TODO
        ContentProvider provider = ReaderApplication.getInstance().getReaderContentProvider();
        if (provider.isReady()) {
            setText(provider.getText());
        } else {
            provider.getText(new ContentProvider.ReadListener() {
                @Override
                public void onRead(String text) {
                    setText(text);
                }
            });
        }
    }

    public void setText(String text) {
        getCurrentView().setText(text);
        getNextView().setText(text);
    }

    @Override
    public ReaderTextView getCurrentView() {
        return (ReaderTextView) super.getCurrentView();
    }

    @Override
    public ReaderTextView getNextView() {
        return (ReaderTextView) super.getNextView();
    }

    @Override
    public void showNext() {
        setInAnimation(getContext(), R.anim.slide_right_next);
        setOutAnimation(getContext(), R.anim.slide_left_next);
        super.showNext();
    }

    @Override
    public void showPrevious() {
        setInAnimation(getContext(), R.anim.slide_right_prev);
        setOutAnimation(getContext(), R.anim.slide_left_prev);
        super.showPrevious();
    }

    public boolean scaleTextSize(float scaleFactor) {
        getCurrentView().scaleTextSize(scaleFactor);
        getNextView().scaleTextSize(scaleFactor);
        return false;
    }

    public void freezeTextSize() {
        getCurrentView().freezeTextSize();
    }

    @Override
    public View makeView() {
        ReaderTextView textView = new ReaderTextView(getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.GRAY);
        textView.setTextColor(Color.WHITE);
        return textView;
    }
}
