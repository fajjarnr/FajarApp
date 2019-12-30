package com.fajar.fajar175.practice5.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    fun makeBroadcast(data:String){
        val intent = Intent()
        intent.action = "myservice"
        intent.putExtra("name", "My Service")
        intent.putExtra("data", data)
        sendBroadcast(intent)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val intent1 = Intent()
        makeBroadcast("Service dijalankan...")
        GlobalScope.launch {
            delay(10000)
            stopSelf()
            makeBroadcast("Service dihentikan")
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        makeBroadcast("onDestroy:")
    }
}
