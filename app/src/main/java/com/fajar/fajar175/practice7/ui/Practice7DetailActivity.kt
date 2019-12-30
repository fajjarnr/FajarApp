package com.fajar.fajar175.practice7.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fajar.fajar175.R

class Practice7DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice7_detail)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val REQUEST_CODE = "requestCode"
    }
}
