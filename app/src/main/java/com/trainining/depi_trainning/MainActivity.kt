package com.trainining.depi_trainning

import Emergency
import EmergenyAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.trainining.depi_trainning.R
import com.trainining.depi_trainning.databinding.ActivityMainBinding
import kotlin.math.floor


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val currentPaddingLeft = v.paddingLeft
            val currentPaddingTop = v.paddingTop
            val currentPaddingRight = v.paddingRight
            val currentPaddingBottom = v.paddingBottom

            v.setPadding(
                currentPaddingLeft.takeIf { it != 0 } ?: systemBars.left,
                currentPaddingTop.takeIf { it != 0 } ?: systemBars.top,
                currentPaddingRight.takeIf { it != 0 } ?: systemBars.right,
                currentPaddingBottom.takeIf { it != 0 } ?: systemBars.bottom
            )
            insets
        }

        val emergencies = arrayListOf<Emergency>()

        emergencies.add(Emergency(R.drawable.police, getString(R.string.police), "122"))

        emergencies.add(
            Emergency(
                R.drawable.baseline_health_and_safety_24,
                getString(R.string.ambulance), "123"
            )
        )

        emergencies.add(
            Emergency(
                R.drawable.baseline_fireplace_24,
                getString(R.string.fire), "118"
            )
        )

        emergencies.add(
            Emergency(
                R.drawable.baseline_child_care_24,
                getString(R.string.care), "16000"
            )
        )

        val adapter = EmergenyAdapter(this, emergencies)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.adapter = adapter

    }

    override fun onBackPressed() {

        val exit = ExitDialog()
        exit.isCancelable = false
        exit.show(supportFragmentManager, null)
    }


}
