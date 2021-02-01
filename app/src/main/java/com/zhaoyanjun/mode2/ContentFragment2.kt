package com.zhaoyanjun.mode2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhaoyanjun.R

class ContentFragment2 : BaseFragment2() {

    private var param1: String? = null
    private var rootView: View? = null
    private var nameTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_content, container, false)
        nameTv = rootView?.findViewById(R.id.name)
        return rootView
    }

    override fun onFirstLoad() {
        super.onFirstLoad()
        //第一次加载
        Log.d("zhaoyanjun-mode2 ", "firstLoad index: $param1")
        nameTv?.text = param1
    }

    companion object {

        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: String) =
            ContentFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}