package ru.dzgeorgy.backdropsample

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.back_layer.*
import kotlinx.android.synthetic.main.front_layer.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setSupportActionBar(second_toolbar)
        show_backdrop.setOnClickListener {
            second_backdrop.showBackdrop()
        }
        hide_backdrop.setOnClickListener {
            second_backdrop.hideBackdrop()
        }
        open_activity.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        second_backdrop.setupWithMenuItem(menu.findItem(R.id.menu_filter))
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
