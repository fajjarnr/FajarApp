package com.fajar.fajar175.practice7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.fajar.fajar175.BuildConfig
import com.fajar.fajar175.R
import com.fajar.fajar175.practice7.api.MainPresenter
import com.fajar.fajar175.practice7.model.Quote
import com.fajar.fajar175.practice7.model.Student
import kotlinx.android.synthetic.main.nav_header_practice7.view.*

class Practice7Activity : AppCompatActivity(), MainView {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice7)
        presenter = MainPresenter(this, CoroutineContextProvider())
        presenter.getDetailStudent(BuildConfig.NIM)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_my_quotes, R.id.nav_class_quotes, R.id.nav_global_quotes
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun resultAction(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resultStudent(data: List<Student>) {
        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView = navView.getHeaderView(0)
        data[0].name?.let {
            headerView.nav_header_title.text = it
        }
        data[0].nim?.let {
            headerView.nav_header_nim.text = it
        }
        data[0].class_name?.let {
            headerView.nav_header_class.text = it
        }
    }

    override fun resultQuote(data: List<Quote>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(messsage: String) {
        Toast.makeText(this, messsage, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}
