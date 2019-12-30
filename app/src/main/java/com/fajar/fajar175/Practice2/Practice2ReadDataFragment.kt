package com.fajar.fajar175.Practice2


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fajar.fajar175.MainActivity
import com.fajar.fajar175.R
import kotlinx.android.synthetic.main.fragment_practice2_read_data.*

/**
 * A simple [Fragment] subclass.
 */
class Practice2ReadDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice2_read_data, container, false)
    }
    var nim: Int? = null
    companion object {
        var EXTRA_NAMA = ""
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val myName = arguments?.getString(EXTRA_NAMA)
            tvMyData.text = "Nama Saya : $myName, NIM Saya : $nim"
        }
        btnKembaliBeranda.setOnClickListener{
            val mIntent = Intent(activity, MainActivity::class.java)
            startActivity(mIntent)
        }
    }



}

