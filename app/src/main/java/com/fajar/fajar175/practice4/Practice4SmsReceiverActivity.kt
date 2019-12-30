package com.fajar.fajar175.practice4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fajar.fajar175.R
import kotlinx.android.synthetic.main.activity_practice4_sms_receiver.*

class Practice4SmsReceiverActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice4_sms_receiver)

        title = getString(R.string.incoming_message)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        tv_from.text = getString(R.string.coming_from) + ": " + senderNo
        tv_message.text = senderMessage

        val tipu = listOf("hadia", "pulsa", "selamat", "blogspot", "wordpress", "transfer", "mobil", "polisi", "rumah")
        var s = senderMessage
        s = s.toLowerCase()
        val words:Array<String> = s.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (i in words.indices){
            words[i] = words[i].replace("[^\\w]".toRegex(),"")
        }

        var numtipu = 0
        for (i in words){
            for (j in tipu){
                if (i == j){
                    numtipu++
                    if(numtipu == 2){
                        break;
                    }
                }
            }
        }

        if(numtipu >=2 ){
            tv_tipu.text = "SMS ini Penipuan"
        }else{
            tv_tipu.text = ""
        }
        btn_close.setOnClickListener { finish() }
    }
}
