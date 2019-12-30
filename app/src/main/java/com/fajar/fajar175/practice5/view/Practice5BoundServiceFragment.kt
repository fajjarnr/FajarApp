package com.fajar.fajar175.practice5.view


import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fajar.fajar175.R
import com.fajar.fajar175.practice5.service.MyBoundService
import kotlinx.android.synthetic.main.fragment_practice5_bound.*
import kotlinx.android.synthetic.main.fragment_practice5_bound.view.*

/**
 * A simple [Fragment] subclass.
 */
class Practice5BoundServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_practice5_bound, container, false)
        root.btn_start.setOnClickListener {
            val mBoundServiceIntent = Intent(activity, MyBoundService::class.java)
            activity!!.bindService(
                mBoundServiceIntent,
                mServiceConnection,
                Context.BIND_AUTO_CREATE
            )
        }
        root.btn_end.setOnClickListener {
            if (mServiceBound) {
                activity!!.unbindService(mServiceConnection)
                mServiceBound = false
            }
        }
        activity!!.registerReceiver(broadcastReceiver, intentActionName)
        return root
    }

    private lateinit var mBoundService: MyBoundService
    private var mServiceBound = false
    private val mServiceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            mServiceBound = false
        }

        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val myBinder = service as MyBoundService.MyBinder
            mBoundService = myBinder.getService
            mServiceBound = true
        }
    }

    private val intentActionName = IntentFilter("boundservice")
    var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val name = intent.getStringExtra("name")
            val data = intent.getStringExtra("data")
            tv_log_bound_service.append(name + ": " + data + "\n")
            tv_log_bound_service.setMovementMethod(ScrollingMovementMethod())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity!!.unregisterReceiver(broadcastReceiver)
        if (mServiceBound) {
            activity!!.unbindService(mServiceConnection)
            mServiceBound = false
        }
    }


}
