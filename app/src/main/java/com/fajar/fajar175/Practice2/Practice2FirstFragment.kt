package com.fajar.fajar175.Practice2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.fajar.fajar175.R
import kotlinx.android.synthetic.main.fragment_practice2_first.*

/**
 * A simple [Fragment] subclass.
 */
class Practice2FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice2_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnToSecondFragment.setOnClickListener{
            val namaSaya = inputNamaSaya.text.toString()
            if (namaSaya.isEmpty()) {
                inputNamaSaya.error = "Nama Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val nimSaya = inputNimSaya.text.toString()
            if (nimSaya.isEmpty()) {
                inputNimSaya.error = "Nim Tidak Boleh Kosong"
                return@setOnClickListener
            }
            val mReadDataFragment = Practice2ReadDataFragment()
            val mBundle = Bundle()
            mBundle.putString(Practice2ReadDataFragment.EXTRA_NAMA, namaSaya)
            mReadDataFragment.arguments = mBundle
            mReadDataFragment.nim = nimSaya.toInt()
            val mFragmentManager = fragmentManager as FragmentManager
            mFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container, mReadDataFragment, Practice2ReadDataFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }


}
