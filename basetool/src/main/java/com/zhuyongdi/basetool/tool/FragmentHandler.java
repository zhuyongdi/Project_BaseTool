package com.zhuyongdi.basetool.tool;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Fragment助手
 * 注意:此Fragment为support包下v4的Fragment
 * 1.只是实例化Fragment并不会引起Fragment的生命周期和创建,需要Fragment添加到Activity中.
 */
public class FragmentHandler {

    private static final int ADD_AND_HIDE = 1; //添加并隐藏
    private static final int ADD_AND_SHOW = 2; //添加并隐藏
    private static final int SHOW = 3; //显示
    private static final int HIDE = 4; //隐藏

    public static FragmentHandler obtain() {
        return ClassHolder.INSTANCE;
    }

    private FragmentHandler() {
    }

    private static final class ClassHolder {
        private static final FragmentHandler INSTANCE = new FragmentHandler();
    }

    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private FragmentManager fragmentManager;
    private int containerId;

    /**
     * 设置FragmentManager
     *
     * @param fragmentManager FragmentManager
     */
    public FragmentHandler with(FragmentManager fragmentManager) {
        this.fragmentList.clear();
        this.fragmentManager = fragmentManager;
        return this;
    }

    /**
     * 设置需要将Fragment嵌入的布局ID
     *
     * @param containerId 布局ID
     */
    public FragmentHandler embed(int containerId) {
        this.containerId = containerId;
        return this;
    }

    /**
     * 添加并隐藏Fragment
     *
     * @param fragment 需要添加并隐藏的Fragment
     */
    public FragmentHandler addAndHide(Fragment fragment) {
        this.fragmentList.add(fragment);
        this.handleFragment(ADD_AND_HIDE, fragment);
        return this;
    }

    /**
     * 添加并显示Fragment
     * 如果当前Fragment已经添加,那么就只显示
     *
     * @param fragment 需要添加并显示的Fragment
     */
    public FragmentHandler addAndShow(Fragment fragment) {
        if (isFragmentAdded(fragment)) {
            this.show(fragment);
        } else {
            this.handleFragment(ADD_AND_SHOW, fragment);
            this.fragmentList.add(fragment);
        }
        return this;
    }

    /**
     * 显示Fragment
     *
     * @param fragment 需要显示的Fragment
     */
    public void show(Fragment fragment) {
        this.handleFragment(SHOW, fragment);
    }

    /**
     * 隐藏所有的Fragment
     */
    private void hideAllFragment() {
        if (!this.fragmentList.isEmpty()) {
            for (Fragment fragment : this.fragmentList) {
                this.handleFragment(HIDE, fragment);
            }
        }
    }

    /**
     * Fragment是否已经添加
     *
     * @param fragment Fragment
     */
    private boolean isFragmentAdded(Fragment fragment) {
        if (!this.fragmentList.isEmpty() && fragment != null) {
            for (Fragment frg : this.fragmentList) {
                if (fragment == frg || fragment.equals(frg)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 操作Fragment
     *
     * @param operation 操作Fragment的类型
     */
    private void handleFragment(int operation, Fragment fragment) {
        if (fragmentManager == null || fragment == null) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (operation) {
            //添加并隐藏
            case ADD_AND_HIDE:
                transaction.add(containerId, fragment);
                transaction.hide(fragment);
                break;
            //添加并显示
            case ADD_AND_SHOW:
                hideAllFragment();
                transaction.add(containerId, fragment);
                break;
            //显示
            case SHOW:
                hideAllFragment();
                transaction.show(fragment);
                break;
            //隐藏
            case HIDE:
                transaction.hide(fragment);
                break;
        }
        transaction.commit();
    }

}
