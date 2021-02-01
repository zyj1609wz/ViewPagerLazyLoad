package com.zhaoyanjun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    /**
     * 用户是否可见
     */
    protected var mIsVisibleToUser = false

    /**
     * view是否创建
     */
    protected var mIsViewCreated = false

    /**
     * 是否是第一次加载
     */
    protected var mIsFirstLoad = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mIsViewCreated = true
        if (mIsVisibleToUser) {
            firstLoad()
        }
    }

    /**
     * 懒加载模式下生效
     */
    fun firstLoad() {
        if (mIsFirstLoad) {
            return
        }
        mIsFirstLoad = true
        onFirstLoad()
    }

    open fun onFirstLoad() {

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        mIsVisibleToUser = isVisibleToUser
        if (mIsVisibleToUser && mIsViewCreated) {
            firstLoad()
        }
    }

    override fun onDestroyView() {
        mIsVisibleToUser = false
        mIsViewCreated = false
        mIsFirstLoad = false
        super.onDestroyView()
    }
}