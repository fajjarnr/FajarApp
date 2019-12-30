package com.fajar.fajar175.Practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fajar.fajar175.R

class Practice2ForFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice2_for_fragment)

        val mFragmentManager = supportFragmentManager
        val mFirstFragment = Practice2FirstFragment()
        val fragment = mFragmentManager.findFragmentByTag(Practice2FirstFragment::class.java.simpleName)
        if (fragment !is Practice2FirstFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + Practice2FirstFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mFirstFragment, Practice2FirstFragment::class.java.simpleName)
                .commit()
        }
    }
}
