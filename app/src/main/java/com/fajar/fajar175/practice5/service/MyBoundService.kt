package com.fajar.fajar175.practice5.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.CountDownTimer
import android.os.IBinder

class MyBoundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        makeBroadcast("onBind")
        mTimer.start()
        return mBinder
    }

    override fun onUnbind(intent: Intent): Boolean {
        makeBroadcast("onUnbind")
        mTimer.cancel()
        return super.onUnbind(intent)
    }

    private var mBinder = MyBinder()
    private val startTime = System.currentTimeMillis()
    internal inner class MyBinder : Binder() {
        val getService: MyBoundService = this@MyBoundService
    }

    private var mTimer: CountDownTimer = object : CountDownTimer(100000, 1000) {
        override fun onTick(l: Long) {
            val elapsedTime = System.currentTimeMillis() - startTime
            makeBroadcast("onTick $elapsedTime")
        }
        override fun onFinish() {
        }
    }

    fun makeBroadcast(data:String){
        val intent = Intent()
        intent.action = "boundservice"
        intent.putExtra("name", "Bound Service")
        intent.putExtra("data", data)
        sendBroadcast(intent)
    }
}
