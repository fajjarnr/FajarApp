package com.fajar.fajar175.practice3

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fajar.fajar175.R
import kotlinx.android.synthetic.main.activity_practice3_detail.*
import kotlinx.android.synthetic.main.content_practice3_detail.*

class Practice3DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice3_detail)
        setSupportActionBar(toolbar)

        val myData = intent.getParcelableExtra(EXTRA_MYDATA) as MyData
        supportActionBar?.title = myData.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tv_detail_description.text = myData.description.toString()
        Glide.with(this)
            .load(myData.photo.toString())
            .apply(RequestOptions().override(700, 700))
            .into(iv_detail_photo)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

            val moveWithObjectIntent = Intent(this, Practice3MapsActivity::class.java)
            moveWithObjectIntent.putExtra(Practice3MapsActivity.EXTRA_MYDATA, myData)
            startActivity(moveWithObjectIntent)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
}
