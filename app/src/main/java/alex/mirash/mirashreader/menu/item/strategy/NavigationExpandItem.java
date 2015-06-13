package alex.mirash.mirashreader.menu.item.strategy;

import android.content.Context;
import android.view.View;

import alex.mirash.mirashreader.ContentActivity;
import alex.mirash.mirashreader.R;
import alex.mirash.mirashreader.menu.item.MenuItemClickListener;
import alex.mirash.mirashreader.menu.item.view.ISizeDefined;
import alex.mirash.mirashreader.menu.item.view.MenuItem;
import alex.mirash.mirashreader.menu.item.view.MenuItemExpand;
import alex.mirash.mirashreader.menu.item.view.MenuLinearExpandableContent;
import alex.mirash.mirashreader.utils.LogUtils;

import java.util.Arrays;
import java.util.List;

import static alex.mirash.mirashreader.menu.item.strategy.NavigationSubItem.FONT_SETTINGS;
import static alex.mirash.mirashreader.menu.item.strategy.NavigationSubItem.MARGIN_SETTINGS;


/**
 * @author Mirash
 */
public enum NavigationExpandItem implements MenuNavigable<ContentActivity> {
    ABOUT(FONT_SETTINGS) {
        @Override
        public String getTitle() {
            return "about";
        }

        @Override
        public int getIconResourceId() {
            return R.drawable.ic_launcher;
        }

        @Override
        public String getTag() {
            return getTitle();
        }
    },
    SETTINGS(FONT_SETTINGS, MARGIN_SETTINGS, ABOUT) {
        @Override
        public String getTitle() {
            return "settings";
        }

        @Override
        public int getIconResourceId() {
            return 0;
        }

        @Override
        public String getTag() {
            return getTitle();
        }
    },
    LIBRARY {
        @Override
        public String getTitle() {
            return "library";
        }

        @Override
        public int getIconResourceId() {
            return 0;
        }

        @Override
        public String getTag() {
            return getTitle();
        }
    };

    //attributes
    private List<MenuNavigable> mSubItems;
    private boolean mIsExpandable;

    //constructors
    NavigationExpandItem() {
        this(false);
    }

    NavigationExpandItem(boolean expandable) {
        mIsExpandable = expandable;
    }

    NavigationExpandItem(MenuNavigable... menuSubItems) {
        this(true, menuSubItems);
    }

    NavigationExpandItem(boolean expandable, MenuNavigable... menuSubItems) {
        mSubItems = Arrays.asList(menuSubItems);
        mIsExpandable = expandable;
    }

    //stratrgies
    @Override
    public void handleItemClick(ContentActivity contentActivity) {
        LogUtils.log("onItemClick " + getTag());
    }

    @Override
    public MenuItem createMenuItem(Context context, final MenuItemClickListener menuItemClickListener) {
        MenuItemExpand item = new MenuItemExpand(context);
        item.setTitle(getTitle());
        if (mIsExpandable) {
            item.setImageResource(getIconResourceId());
            item.setExpandableContent(createExpandableContent(context, menuItemClickListener));
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MenuItemExpand) v).changeExpandState();
                }
            });
        } else {
            item.setExpandButtonVisibility(View.GONE);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    menuItemClickListener.onMenuItemClick(NavigationExpandItem.this, (MenuItem) v);
                }
            });
        }
        return item;
    }

    protected ISizeDefined createExpandableContent(Context context, MenuItemClickListener menuItemClickListener) {
        MenuLinearExpandableContent container = new MenuLinearExpandableContent(context);
        for (MenuNavigable item : mSubItems) {
            container.addItem(item.createMenuItem(context, menuItemClickListener));
        }
        return container;
    }

    public boolean isExpandable() {
        return mIsExpandable;
    }

    public void setExpandable(boolean isExpandable) {
        mIsExpandable = isExpandable;
    }
}
