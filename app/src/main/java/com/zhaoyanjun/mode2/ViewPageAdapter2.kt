package com.zhaoyanjun.mode2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

/**
如果 behavior 的值为 BEHAVIOR_SET_USER_VISIBLE_HINT，那么当 Fragment 对用户的可见状态发生改变时，setUserVisibleHint 方法会被调用。
如果 behavior 的值为 BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ，那么当前选中的 Fragment 在 Lifecycle.State#RESUMED 状态 ，其他不可见的 Fragment 会被限制在 Lifecycle.State#STARTED 状态。
 */
class ViewPageAdapter2(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

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
