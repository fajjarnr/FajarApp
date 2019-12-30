package com.fajar.fajar175.practice6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajar.fajar175.R
import com.fajar.fajar175.practice6.entity.TempatWisata
import com.fajar.fajar175.practice6.viewModel.TempatWisataViewModel
import kotlinx.android.synthetic.main.activity_practice6.*

class Practice6Activity : AppCompatActivity() {

    private lateinit var tempatWisataViewModel: TempatWisataViewModel
    private val newTempatWisataActivityRequestCode = 1
    private val editTempatWisataActivityRequestCode = 2
    private val deleteTempatWisataActivityRequestCode = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice6)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = Practice6Adapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        tempatWisataViewModel = ViewModelProvider(this).get(TempatWisataViewModel::class.java)
        tempatWisataViewModel.allTempatWisata.observe(this, Observer { tempatWisata ->
            tempatWisata?.let { adapter.setTempatWisata(it) }
        })

        fab.setOnClickListener {
            val intent = Intent(this@Practice6Activity, Practice6DetailActivity::class.java)
            startActivityForResult(intent, newTempatWisataActivityRequestCode)
        }

        adapter.setOnItemClickCallback(object : Practice6Adapter.OnItemClickCallback {
            override fun onItemClicked(data: TempatWisata) {
                val moveWithObjectIntent =
                    Intent(this@Practice6Activity, Practice6DetailActivity::class.java)
                moveWithObjectIntent.putExtra(Practice6DetailActivity.EXTRA_DATA, data)
                startActivityForResult(moveWithObjectIntent, editTempatWisataActivityRequestCode)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == editTempatWisataActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val extraData =
                data?.getParcelableExtra(Practice6DetailActivity.EXTRA_DATA) as TempatWisata
            tempatWisataViewModel.update(extraData)
        } else if (resultCode == deleteTempatWisataActivityRequestCode) {
            val extraData =
                data?.getParcelableExtra(Practice6DetailActivity.EXTRA_DATA) as TempatWisata
            tempatWisataViewModel.deleteData(extraData)
        } else if (requestCode == newTempatWisataActivityRequestCode && resultCode == Activity.RESULT_OK) {
            val extraData =
                data?.getParcelableExtra(Practice6DetailActivity.EXTRA_DATA) as TempatWisata
            tempatWisataViewModel.insert(extraData)
        }
//        else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG).show()
//        }
    }
}
