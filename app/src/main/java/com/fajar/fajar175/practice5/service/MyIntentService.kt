package com.fajar.fajar175.practice5.service

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyIntentService : IntentService("MyIntentService") {

    companion object {
        internal const val EXTRA_DURATION = "extra_duration"
    }

    override fun onHandleIntent(intent: Intent?) {
        makeBroadcast("onHandleIntent: Mulai.....")
        val duration = intent?.getLongExtra(EXTRA_DURATION, 0) as Long
        try {
            Thread.sleep(duration);
            makeBroadcast("onHandleIntent: Selesai.....")
        } catch (e: InterruptedException) {
            e.printStackTrace()
            Thread.currentThread().interrupt()
        }
    }

    fun makeBroadcast(data:String){
        val intent = Intent()
        intent.action = "intentservice"
        intent.putExtra("name", "Intent Service")
        intent.putExtra("data", data)
        sendBroadcast(intent)
    }
    override fun onDestroy() {
        super.onDestroy()
        makeBroadcast("onDestroy:")
    }
}
