package com.zhaoyanjun

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class ViewPageAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val mFragments: MutableList<Fragment>

    init {
        mFragments = ArrayList()
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    fun updateDatas(fragments: List<Fragment>) {
        mFragments.clear()
        mFragments.addAll(fragments)
        notifyDataSetChanged()
    }
}
