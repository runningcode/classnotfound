package com.zenjob.classnotfound

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class NotFoundViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FragmentWithRecyclerView()
            1 -> FragmentWithRecyclerView()
            2 -> FragmentWithRecyclerView()
            else -> throw IllegalArgumentException()
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "A"
            1 -> "B"
            2 -> "C"
            else -> throw IllegalArgumentException()
        }
    }
}