package com.fajar.fajar175.Practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.fajar.fajar175.R

class tugas1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas1)
    }
    override fun onStart() {
        super.onStart()
        printState("Lifecycle On Start")
    }
    override fun onResume(){
        super.onResume()
        printState("Lifecycle On Resume")
    }
    override fun onPause(){
        super.onPause()
        printState("Lifecycle On Pause")
    }
    override fun onStop(){
        super.onStop()
        printState("Lifecycle On Stop")
    }
    override fun onRestart(){
        super.onRestart()
        printState("Lifecycle On Restart")
    }
    override fun onDestroy() {
        super.onDestroy()
        printState("Lifecycle On Destroy")
    }
    fun printState(msg: String){
        Log.d("ActivityState",msg)
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show() }
}
