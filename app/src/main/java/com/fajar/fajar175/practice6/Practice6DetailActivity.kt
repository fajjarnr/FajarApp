package com.fajar.fajar175.practice6

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.fajar.fajar175.R
import com.fajar.fajar175.practice6.entity.TempatWisata
import kotlinx.android.synthetic.main.activity_practice6_detail.*

class Practice6DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice6_detail)

        var extraData = intent.getParcelableExtra(EXTRA_DATA) as? TempatWisata
        if (extraData != null) {
            edit_nama.setText(extraData.nama)
            edit_alamat.setText(extraData.alamat)
            edit_deskripsi.setText(extraData.deskripsi)
            edit_url.setText(extraData.gambar)
        }
        btnSimpan.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(edit_nama.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                var newData = TempatWisata(
                    0,
                    edit_nama.text.toString(),
                    edit_alamat.text.toString(),
                    edit_deskripsi.text.toString(),
                    edit_url.text.toString()
                )
                if (extraData != null) {
                    newData = TempatWisata(
                        extraData!!.id,
                        edit_nama.text.toString(),
                        edit_alamat.text.toString(),
                        edit_deskripsi.text.toString(),
                        edit_url.text.toString()
                    )
                }
                replyIntent.putExtra(EXTRA_DATA, newData)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_practice6_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.delete) {
            val builder = AlertDialog.Builder(this@Practice6DetailActivity)
            var extraData = intent.getParcelableExtra(EXTRA_DATA) as? TempatWisata
            builder.setTitle("Delete " + extraData!!.nama)
            builder.setMessage("Are you sure to delete" + extraData!!.nama + "?")
            builder.setPositiveButton("YES") { dialog, which ->
                var newData = TempatWisata(
                    extraData!!.id,
                    edit_nama.text.toString(),
                    edit_alamat.text.toString(),
                    edit_deskripsi.text.toString(),
                    edit_url.text.toString()
                )
                val replyIntent = Intent()
                replyIntent.putExtra(EXTRA_DATA, newData)
                setResult(Activity.RESULT_OK, replyIntent)
                setResult(3, replyIntent)
                finish()
            }
            builder.setNegativeButton("No") { dialog, which ->
                Toast.makeText(applicationContext, "You are not sure.", Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}