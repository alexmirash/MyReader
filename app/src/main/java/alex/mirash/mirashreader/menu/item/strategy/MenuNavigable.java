package alex.mirash.mirashreader.menu.item.strategy;

import android.app.Activity;
import android.content.Context;

import alex.mirash.mirashreader.menu.item.MenuItemClickListener;
import alex.mirash.mirashreader.menu.item.view.MenuItem;

/**
 * @author Mirash
 */
public interface MenuNavigable<T extends Activity> {
    String getTitle();

    int getIconResourceId();

    String getTag();

    void handleItemClick(T contentActivity);

    MenuItem createMenuItem(Context context, MenuItemClickListener menuItemClickListener);
}
