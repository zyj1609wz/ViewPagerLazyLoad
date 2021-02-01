package com.zhaoyanjun.mode1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.zhaoyanjun.R
import com.zhaoyanjun.mode2.MainActivity2

class MainActivity : AppCompatActivity() {

    private var viewPager: ViewPager? = null
    private var adapter: ViewPageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt).setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }


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