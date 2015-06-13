package alex.mirash.mirashreader.menu.item;

import alex.mirash.mirashreader.menu.item.strategy.MenuNavigable;
import alex.mirash.mirashreader.menu.item.view.MenuItem;

/**
 * @author Mirash
 */
public interface MenuItemClickListener {
    void onMenuItemClick(MenuNavigable menuNavigable, MenuItem menuItem);
}
