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
import com.fajar.fajar175.practice5.service.MyIntentService
import kotlinx.android.synthetic.main.fragment_practice5_intent.*
import kotlinx.android.synthetic.main.fragment_practice5_intent.view.*

/**
 * A simple [Fragment] subclass.
 */
class Practice5IntentServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_practice5_intent, container, false)
        root.btn_start_intent_service.setOnClickListener{
            val mStartIntentService = Intent(activity, MyIntentService::class.java)
            mStartIntentService.putExtra(MyIntentService.EXTRA_DURATION, 5000L)
            activity!!.startService(mStartIntentService)
        }
        activity!!.registerReceiver(broadcastReceiver, intentActionName)
        return root
    }

    private val intentActionName = IntentFilter("intentservice")
    var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val name = intent.getStringExtra("name")
            val data = intent.getStringExtra("data")
            tv_log_intent_service.append(name+": "+data+"\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity!!.unregisterReceiver(broadcastReceiver)
    }


}
