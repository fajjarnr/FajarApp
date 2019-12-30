package com.fajar.fajar175.practice4

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.fajar.fajar175.R
import com.fajar.fajar175.practice4.Practice4SmsReceiverActivity.Companion.EXTRA_SMS_MESSAGE
import com.fajar.fajar175.practice4.Practice4SmsReceiverActivity.Companion.EXTRA_SMS_NO
import kotlinx.android.synthetic.main.activity_practice4.*
import kotlinx.android.synthetic.main.activity_practice4_sms_receiver.*

class Practice4Activity : AppCompatActivity() {

    companion object {
        private const val SMS_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice4)

        btn_permission.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.RECEIVE_SMS),
                    SMS_REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        if (requestCode == SMS_REQUEST_CODE) { title = getString(R.string.incoming_message)
        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)
        tv_from.text = getString(R.string.coming_from) + ": " + senderNo
        tv_message.text = senderMessage
        btn_close.setOnClickListener { finish() }
    }
        when {
            grantResults[0] == PackageManager.PERMISSION_GRANTED -> Toast.makeText(
                this,
                "Sms receiver permission diterima",
                Toast.LENGTH_SHORT
            ).show()
            else -> Toast.makeText(
                this,
                "Sms receiver permission ditolak",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}