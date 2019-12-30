package com.fajar.fajar175.practice7

import com.fajar.fajar175.practice7.model.Quote
import com.fajar.fajar175.practice7.model.Student

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMessage(messsage : String)
    fun resultQuote(data: List<Quote>)
    fun resultStudent(data: List<Student>)
    fun resultAction(data: String)
}