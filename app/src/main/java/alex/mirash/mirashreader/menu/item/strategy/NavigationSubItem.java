package alex.mirash.mirashreader.menu.item.strategy;

import android.content.Context;
import android.view.View;

import alex.mirash.mirashreader.ContentActivity;
import alex.mirash.mirashreader.R;
import alex.mirash.mirashreader.menu.item.view.MenuItem;
import alex.mirash.mirashreader.menu.item.MenuItemClickListener;
import alex.mirash.mirashreader.menu.item.view.MenuItemSub;
import alex.mirash.mirashreader.utils.LogUtils;


/**
 * @author Mirash
 */
public enum NavigationSubItem implements MenuNavigable<ContentActivity> {
    FONT_SETTINGS {
        @Override
        public String getTitle() {
            return "font settings";
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
    MARGIN_SETTINGS {
        @Override
        public String getTitle() {
            return "margin settings";
        }

        @Override
        public int getIconResourceId() {
            return R.drawable.ic_launcher;
        }

        @Override
        public String getTag() {
            return getTitle();
        }
    };

    @Override
    public void handleItemClick(ContentActivity contentActivity) {
        LogUtils.log("onItemClick " + getTag());
    }

    @Override
    public MenuItem createMenuItem(Context context, final MenuItemClickListener menuItemClickListener) {
        MenuItemSub item = new MenuItemSub(context);
        item.setTitle(getTitle());
        item.setImageResource(getIconResourceId());
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuItemClickListener.onMenuItemClick(NavigationSubItem.this, (MenuItem) v);
            }
        });
        return item;
    }
}
