package com.fajar.fajar175.practice5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fajar.fajar175.R
import com.fajar.fajar175.practice5.view.Practice5BoundServiceFragment
import com.fajar.fajar175.practice5.view.Practice5IntentServiceFragment
import com.fajar.fajar175.practice5.view.Practice5MediaPlayerServiceFragment
import com.fajar.fajar175.practice5.view.Practice5ServiceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_practice5.*

class Practice5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        goToService(getString(R.string.service))
    }

    fun goToService(title:String){
        supportActionBar?.title = title
        val mFragmentManager = supportFragmentManager
        val myFragment = Practice5ServiceFragment()
        val fragment =
            mFragmentManager.findFragmentByTag(Practice5ServiceFragment::class.java.simpleName)
        if (fragment !is Practice5ServiceFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, myFragment, Practice5ServiceFragment::class.java.simpleName)
                .commit()
        }
    }
    fun goToIntentService(title:String){
        supportActionBar?.title = title
        val mFragmentManager = supportFragmentManager
        val myFragment = Practice5IntentServiceFragment()
        val fragment =
            mFragmentManager.findFragmentByTag(Practice5IntentServiceFragment::class.java.simpleName)
        if (fragment !is Practice5IntentServiceFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, myFragment,
                    Practice5IntentServiceFragment::class.java.simpleName)
                .commit()
        }
    }
    fun goToBoundService(title:String){
        supportActionBar?.title = title
        val mFragmentManager = supportFragmentManager
        val myFragment = Practice5BoundServiceFragment()
        val fragment =
            mFragmentManager.findFragmentByTag(Practice5BoundServiceFragment::class.java.simpleName)
        if (fragment !is Practice5BoundServiceFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, myFragment,
                    Practice5BoundServiceFragment::class.java.simpleName)
                .commit()
        }
    }
    fun goToMediaPlayerService(title:String){
        supportActionBar?.title = title
        val mFragmentManager = supportFragmentManager
        val myFragment = Practice5MediaPlayerServiceFragment()
        val fragment =
            mFragmentManager.findFragmentByTag(Practice5MediaPlayerServiceFragment::class.java.simpleName)
        if (fragment !is Practice5MediaPlayerServiceFragment) {
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, myFragment,
                    Practice5MediaPlayerServiceFragment::class.java.simpleName)
                .commit()
        }
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment
            val bundle: Bundle
            when (item.itemId) {
                R.id.nav_service-> {
                    goToService(getString(R.string.service))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_intent_service -> {
                    goToIntentService("Intent Service")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_bound_service -> {
                    goToBoundService("Bound Service")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_media_player_service -> {
                    goToMediaPlayerService("Media Player Service")
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
