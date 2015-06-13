package alex.mirash.mirashreader;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;

import alex.mirash.mirashreader.base.ParallaxView;
import alex.mirash.mirashreader.menu.NavigationMenuFragment;
import alex.mirash.mirashreader.menu.item.strategy.MenuNavigable;
import alex.mirash.mirashreader.utils.LogUtils;
import alex.mirash.mirashreader.utils.LoneUtils;

/**
 * @author Mirash
 */
public class ContentActivity extends Activity implements NavigationMenuFragment.NavigationMenuListener {
    private static final int MENU_HEIGHT = ReaderApplication.getAppContext().getResources().getDimensionPixelSize(R.dimen.navigation_drawer_width);

    private NavigationMenuFragment mNavigationMenuFragment;
    private ParallaxView mParallaxView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoneUtils.hideActionBarTitle(this);
        LoneUtils.hideStatusBar(this);
        setContentView(R.layout.content_activity);
        mParallaxView = (ParallaxView) findViewById(R.id.parallax_content);
        mNavigationMenuFragment = (NavigationMenuFragment) getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationMenuFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.settings_container, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    /*~~~~~~~~~~~~~~~~ navigation menu callbacks ~~~~~~~~~~~~~~~~*/
    @Override
    public void onNavigationDrawerItemSelected(MenuNavigable menuNavigable) {
        menuNavigable.handleItemClick(this);
/*        if (position == 2) {
            LoneUtils.showStatusBar(this);
        } else {
            LoneUtils.hideStatusBar(this);
        }*/
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mParallaxView.setOffset(MENU_HEIGHT * slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        LogUtils.log("onDrawerOpened");
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        LogUtils.log("onDrawerClosed");
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        LogUtils.log("onDrawerStateChanged " + newState);
    }
}
