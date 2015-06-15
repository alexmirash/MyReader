package alex.mirash.mirashreader.content.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import alex.mirash.mirashreader.R;
import alex.mirash.mirashreader.content.tools.ReaderGestureCallback;
import alex.mirash.mirashreader.content.tools.ReaderGesturesDetector;
import alex.mirash.mirashreader.properties.GlobalProperties;

import static alex.mirash.mirashreader.utils.LogUtils.log;

/**
 * @author Mirash
 */
public class ReaderLayout extends FrameLayout implements ReaderGesturesDetector.ReaderGestureListener {
    private ReaderGestureDetectorView mReaderGestureDetectorView;
    private ReaderFrameSwitcherView mReaderFrameSwitcherView;

    private ReaderGestureCallback mReaderGestureCallback;

    public ReaderLayout(Context context) {
        super(context);
        init(context);
    }

    public ReaderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ReaderLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.reader_container, this);
        mReaderFrameSwitcherView = (ReaderFrameSwitcherView) findViewById(R.id.reader_frame_switcher);
        mReaderGestureDetectorView = (ReaderGestureDetectorView) findViewById(R.id.reader_gesture_detector);
        mReaderGestureDetectorView.setGestureListener(this);
    }

    public void setGesturesDetectorCallback(ReaderGestureCallback readerGestureCallback) {
        mReaderGestureCallback = readerGestureCallback;
    }

    private void handleFlingEvent(float flingDistance) {
        if (flingDistance > GlobalProperties.getMinimalFlingScrollDistance()) {
            log("showNextPage");
            mReaderFrameSwitcherView.showNext();
        } else if (flingDistance < -GlobalProperties.getMinimalFlingScrollDistance()) {
            log("showPreviousPage");
            mReaderFrameSwitcherView.showPrevious();
        }
    }

    /*~~~~~~~~~~~~~~ reader gestures events ~~~~~~~~~~~~*/
    @Override
    public boolean onScale(float scaleFactor) {
        log("scaleFactor " + scaleFactor);
        return mReaderFrameSwitcherView.scaleTextSize(scaleFactor);
    }

    @Override
    public boolean onScaleBegin() {
        log("freezeTextSize");
        mReaderFrameSwitcherView.freezeTextSize();
        return true;
    }

    @Override
    public void onScaleEnd(float scaleFactor) {
        log("onScaleEnd " + scaleFactor);
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        log("onScroll " + v + "; " + v2);
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        log("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        log("onFling " + v + "; " + v2);
        handleFlingEvent(v);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        log("onDown");
        return true;
    }
}
