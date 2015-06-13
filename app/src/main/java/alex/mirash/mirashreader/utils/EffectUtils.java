package alex.mirash.mirashreader.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author Mirash
 */
public final class EffectUtils {
    private static int EXPAND_DURATION = 500;

    public static void collapse(final View view) {
        final int initialHeight = view.getHeight();
        final ViewGroup.LayoutParams lp = view.getLayoutParams();
        Animation collapseAnimation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                lp.height = interpolatedTime == 1 ? 0 : initialHeight - (int) (initialHeight * interpolatedTime);
                view.requestLayout();
            }
        };
        collapseAnimation.setDuration(EXPAND_DURATION);
        view.startAnimation(collapseAnimation);
    }

    public static void expand(final View view, final int totalHeight) {
        final int initialHeight = view.getHeight();
        final ViewGroup.LayoutParams lp = view.getLayoutParams();
        Animation expandAnimation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                lp.height = interpolatedTime == 1 ? ViewGroup.LayoutParams.WRAP_CONTENT :
                        initialHeight + (int) ((totalHeight - initialHeight) * interpolatedTime);
                view.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        expandAnimation.setDuration((long) (EXPAND_DURATION * (1 - ((float) initialHeight / totalHeight))));
        view.startAnimation(expandAnimation);
    }

    public class AnimationListenerForLazy implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
