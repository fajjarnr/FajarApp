package com.fajar.fajar175

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fajar.fajar175.Practice1.tugas1
import com.fajar.fajar175.Practice2.Practice2Activity
import com.fajar.fajar175.practice3.Practice3Activity
import com.fajar.fajar175.practice4.Practice4Activity
import com.fajar.fajar175.practice5.Practice5Activity
import com.fajar.fajar175.practice6.Practice6Activity
import com.fajar.fajar175.practice7.Practice7Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTugas1.setOnClickListener {
            val intent = Intent(this, tugas1::class.java)
            startActivity(intent)
        }

        btnTugas2.setOnClickListener {
            val intent = Intent(this, Practice2Activity::class.java)
            startActivity(intent)
        }

        btnTugas3.setOnClickListener {
            val intent = Intent(this, Practice3Activity::class.java)
            startActivity(intent)
        }

        btnTugas4.setOnClickListener{
            val intent = Intent(this, Practice4Activity::class.java)
            startActivity(intent)
        }

        btnTugas5.setOnClickListener{
            val intent = Intent(this, Practice5Activity::class.java)
            startActivity(intent)
        }

        btnTugas6.setOnClickListener{
            val intent = Intent(this, Practice6Activity::class.java)
            startActivity(intent)
        }

        btnTugas7.setOnClickListener{
            val intent = Intent(this, Practice7Activity::class.java)
            startActivity(intent)
        }
    }
}