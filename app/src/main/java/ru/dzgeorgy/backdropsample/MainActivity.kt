package ru.dzgeorgy.backdropsample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.back_layer.*
import kotlinx.android.synthetic.main.front_layer.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        backdrop.setupWithToolbar(toolbar)
        hide_backdrop.setOnClickListener {
            backdrop.hideBackdrop()
        }
        show_backdrop.setOnClickListener {
            backdrop.showBackdrop()
        }
        open_activity.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}

