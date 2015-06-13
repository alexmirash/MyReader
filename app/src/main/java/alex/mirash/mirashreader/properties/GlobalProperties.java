package alex.mirash.mirashreader.properties;

import alex.mirash.mirashreader.ReaderApplication;
import alex.mirash.mirashreader.properties.local.BackgroundProperties;
import alex.mirash.mirashreader.properties.local.ControlProperties;
import alex.mirash.mirashreader.properties.local.FontProperties;
import alex.mirash.mirashreader.properties.local.MarginProperties;
import alex.mirash.mirashreader.properties.local.ScrollProperties;

/**
 * @author Mirash
 */
public class GlobalProperties {
    private FontProperties mFontProperties;
    private BackgroundProperties mBackgroundProperties;
    private MarginProperties mMarginProperties;
    private ControlProperties mControlsProperties;
    private ScrollProperties mScrollProperties;

    public GlobalProperties() {
        mScrollProperties = new ScrollProperties();
    }

    public static float getMinimalFlingScrollDistance() {
        return ReaderApplication.getGlobalProperties().mScrollProperties.getMinimalFlingSwapPageDistance();
    }
}
