package alex.mirash.mirashreader.content.views;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * @author Mirash
 */
public class ReaderTextView extends TextView {
    private static final int DEFAULT_TEXT_SIZE = 15;
    private static float freezedTextSize;

    public ReaderTextView(Context context) {
        super(context);
        init();
    }

    public ReaderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReaderTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, DEFAULT_TEXT_SIZE);
        setMovementMethod(new ScrollingMovementMethod());
    }

    public void freezeTextSize() {
        freezedTextSize = getTextSize();
    }

    public void scaleTextSize(float scaleFactor) {
        setTextSize(TypedValue.COMPLEX_UNIT_PX, freezedTextSize * scaleFactor);
    }
}
