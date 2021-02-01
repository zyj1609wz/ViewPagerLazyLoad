package com.zhaoyanjun

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private var adapter: ViewPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        adapter = ViewPageAdapter(supportFragmentManager)
        viewPager?.adapter = adapter
        adapter?.updateDatas(getFragment())
    }

    private fun getFragment(): List<Fragment> {
        var list = mutableListOf<ContentFragment>()
        list.add(ContentFragment.newInstance("1"))
        list.add(ContentFragment.newInstance("2"))
        list.add(ContentFragment.newInstance("3"))
        list.add(ContentFragment.newInstance("4"))
        list.add(ContentFragment.newInstance("5"))
        return list
    }
}