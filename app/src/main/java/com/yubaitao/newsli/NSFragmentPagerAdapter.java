package com.yubaitao.newsli;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yubaitao.newsli.common.ContainerFragment;

public class NSFragmentPagerAdapter extends FragmentPagerAdapter {
    public static int FRAGMENT_NUMBER = 3;
    private Fragment[] fragments = new Fragment[FRAGMENT_NUMBER];

    public NSFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        for (int i = 0;i < FRAGMENT_NUMBER; i++) {
            fragments[i] = ContainerFragment.newInstance(i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position < 0 || position >= FRAGMENT_NUMBER) {
            throw new IndexOutOfBoundsException("Fragment number out of boundary.");
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return FRAGMENT_NUMBER;
    }
}
