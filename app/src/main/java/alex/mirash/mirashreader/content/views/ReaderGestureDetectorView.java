package alex.mirash.mirashreader.content.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import alex.mirash.mirashreader.content.tools.ReaderGesturesDetector;

/**
 * @author Mirash
 */
public class ReaderGestureDetectorView extends FrameLayout {
    private ReaderGesturesDetector mGestureDetector;

    public ReaderGestureDetectorView(Context context) {
        super(context);
    }

    public ReaderGestureDetectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReaderGestureDetectorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector != null && mGestureDetector.handleTouchEvent(event);
    }

    public void setGestureListener(ReaderGesturesDetector.ReaderGestureListener gestureListener) {
        mGestureDetector = new ReaderGesturesDetector(getContext(), gestureListener);
    }
}
