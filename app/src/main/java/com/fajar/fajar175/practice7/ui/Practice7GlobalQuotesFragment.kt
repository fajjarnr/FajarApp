package com.fajar.fajar175.practice7.ui


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.fajar.fajar175.R
import com.fajar.fajar175.practice7.CoroutineContextProvider
import com.fajar.fajar175.practice7.MainView
import com.fajar.fajar175.practice7.api.MainPresenter
import com.fajar.fajar175.practice7.model.Quote
import com.fajar.fajar175.practice7.model.Student
import kotlinx.android.synthetic.main.fragment_practice7_quotes.*
import org.jetbrains.anko.support.v4.onRefresh

class Practice7GlobalQuotesFragment : Fragment(), MainView {
    override fun resultAction(data: String) {
    }

    override fun showLoading() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressbar.visibility = View.INVISIBLE
    }


    override fun showMessage(messsage: String) {
        Toast.makeText(activity!!, messsage, Toast.LENGTH_SHORT).show()
    }

    override fun resultStudent(data: List<Student>) {
    }

    override fun resultQuote(data: List<Quote>) {
        quotes.clear()
        quotes.addAll(data)
        adapter.notifyDataSetChanged()
        swiperefresh.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        progressbar.visibility = View.INVISIBLE
        presenter.getAllQuotes()
    }

    private lateinit var presenter: MainPresenter
    private var quotes: MutableList<Quote> = mutableListOf()
    private lateinit var adapter: Practice7GlobalQuotesAdapter
    private val addQuoteCode = 1
    private val editQuoteCode = 2
    private val deleteQuoteCode = 3
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_practice7_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview_global_quotes.layoutManager = LinearLayoutManager(activity)
        adapter = Practice7GlobalQuotesAdapter(quotes, activity!!)
        recyclerview_global_quotes.adapter = adapter
        presenter =
            MainPresenter(this, CoroutineContextProvider())
        progressbar.visibility = View.VISIBLE
        presenter.getAllQuotes()
        fab.setOnClickListener { view ->
            val intent = Intent(activity!!, Practice7DetailActivity::class.java)
            intent.putExtra(Practice7DetailActivity.REQUEST_CODE, addQuoteCode);
            startActivityForResult(intent, addQuoteCode)
        }
        adapter.setOnItemClickCallback(object : Practice7GlobalQuotesAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Quote) {
                val intent = Intent(activity!!, Practice7DetailActivity::class.java)
                intent.putExtra(Practice7DetailActivity.REQUEST_CODE, editQuoteCode);
                intent.putExtra(Practice7DetailActivity.EXTRA_DATA, data)
                startActivityForResult(intent, editQuoteCode)
            }
        })
        swiperefresh.onRefresh {
            progressbar.visibility = View.INVISIBLE
            presenter.getAllQuotes()
        }
    }
}
