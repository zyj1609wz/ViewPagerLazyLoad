package com.zhaoyanjun.mode2

import androidx.fragment.app.Fragment

abstract class BaseFragment2 : Fragment() {

    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        //增加了Fragment是否可见的判断
        if (!isLoaded && !isHidden) {
            isLoaded = true
            onFirstLoad()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    open fun onFirstLoad() {

    }
}