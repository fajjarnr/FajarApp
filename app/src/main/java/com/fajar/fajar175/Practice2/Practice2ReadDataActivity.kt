package com.fajar.fajar175.Practice2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fajar.fajar175.R
import kotlinx.android.synthetic.main.activity_practice2_read_data.*

class Practice2ReadDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PRODI = "extra_prodi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice2_read_data)

        val prodi = intent.getStringExtra(EXTRA_PRODI)
        lblProdiSaya.text = "Prodi Saya Adalah $prodi"

    }
}
