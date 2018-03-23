package com.zenjob.classnotfound

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout_my_jobs)
        val viewPager = findViewById<ViewPager>(R.id.view_pager_my_jobs)

        viewPager.adapter = NotFoundViewPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
