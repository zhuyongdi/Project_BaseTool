package com.zhuyongdi.basetool.widget.swipe_menu_listview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;

/**
 * @author baoyz
 * @date 2014-8-24
 */
public abstract class XXSwipeMenuAdapter implements WrapperListAdapter, XXSwipeMenuView.OnSwipeItemClickListener {

    public abstract void createMenu(XXSwipeMenu menu, Context context);

    private ListAdapter mAdapter;
    private Context mContext;

    XXSwipeMenuAdapter(Context context, ListAdapter adapter) {
        mAdapter = adapter;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mAdapter.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return mAdapter.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        XXSwipeMenuLayout layout;
        if (convertView == null) {
            View contentView = mAdapter.getView(position, convertView, parent);
            XXSwipeMenu menu = new XXSwipeMenu(mContext);
            createMenu(menu,mContext);
            menu.setViewType(mAdapter.getItemViewType(position));
            XXSwipeMenuView menuView = new XXSwipeMenuView(menu,
                    (XXSwipeMenuListView) parent);
            menuView.setOnSwipeItemClickListener(this);
            XXSwipeMenuListView listView = (XXSwipeMenuListView) parent;
            layout = new XXSwipeMenuLayout(contentView, menuView,
                    listView.getCloseInterpolator(),
                    listView.getOpenInterpolator());
            layout.setPosition(position);
        } else {
            layout = (XXSwipeMenuLayout) convertView;
            layout.closeMenu();
            layout.setPosition(position);
            mAdapter.getView(position, layout.getContentView(),
                    parent);
        }
        return layout;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        mAdapter.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        mAdapter.unregisterDataSetObserver(observer);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return mAdapter.areAllItemsEnabled();
    }

    @Override
    public boolean isEnabled(int position) {
        return mAdapter.isEnabled(position);
    }

    @Override
    public boolean hasStableIds() {
        return mAdapter.hasStableIds();
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return mAdapter.getViewTypeCount();
    }

    @Override
    public boolean isEmpty() {
        return mAdapter.isEmpty();
    }

    @Override
    public ListAdapter getWrappedAdapter() {
        return mAdapter;
    }

}
