package com.cerlaw.learningapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cerlaw.learningapplication.ViewMove.MoveActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickButton(v: View) {
        when (v.id) {
            R.id.bt_move_activity -> {
                val intent = Intent(this, MoveActivity::class.java)
                startActivity(intent)
            }
        }
    }
}