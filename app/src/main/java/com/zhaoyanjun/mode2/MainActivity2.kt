package com.zhaoyanjun.mode2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.zhaoyanjun.R
import com.zhaoyanjun.mode1.ContentFragment
import com.zhaoyanjun.mode1.ViewPageAdapter

class MainActivity2 : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private var adapter: ViewPageAdapter2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        viewPager = findViewById(R.id.viewPager)
        adapter = ViewPageAdapter2(supportFragmentManager)
        viewPager?.adapter = adapter
        viewPager?.offscreenPageLimit = 6
        adapter?.updateDatas(getFragment())
    }

    private fun getFragment(): List<Fragment> {
        var list = mutableListOf<ContentFragment2>()
        list.add(ContentFragment2.newInstance("1"))
        list.add(ContentFragment2.newInstance("2"))
        list.add(ContentFragment2.newInstance("3"))
        list.add(ContentFragment2.newInstance("4"))
        list.add(ContentFragment2.newInstance("5"))
        return list
    }
}
