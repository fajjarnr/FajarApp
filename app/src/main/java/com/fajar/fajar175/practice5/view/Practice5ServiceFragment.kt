package com.fajar.fajar175.practice5.view


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.fajar.fajar175.R
import com.fajar.fajar175.practice5.service.MyService
import kotlinx.android.synthetic.main.fragment_practice5_service.*
import kotlinx.android.synthetic.main.fragment_practice5_service.view.*

/**
 * A simple [Fragment] subclass.
 */
class Practice5ServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_practice5_service, container, false)
        root.btn_start_myservice.setOnClickListener{
            activity!!.startService(Intent(activity, MyService::class.java))
        }
        activity!!.registerReceiver(broadcastReceiver, intentActionName)
        return root
    }

    private val intentActionName = IntentFilter("myservice")
    var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val name = intent.getStringExtra("name")
            val data = intent.getStringExtra("data")
            tv_log_myservice.append(name+": "+data+"\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity!!.unregisterReceiver(broadcastReceiver)
    }


}
