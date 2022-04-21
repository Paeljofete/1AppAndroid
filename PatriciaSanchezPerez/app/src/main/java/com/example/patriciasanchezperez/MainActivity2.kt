package com.example.patriciasanchezperez

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.Size
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity2 : AppCompatActivity() {
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        text = findViewById(R.id.textView)

        setupItalicSwitch()
    }

    private fun setupItalicSwitch() {
        val changeSwitch: SwitchMaterial = findViewById(R.id.switch1)

        changeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val typeface = if (isChecked) Typeface.ITALIC else Typeface.NORMAL
            text.setTypeface(null, typeface)

            val bold = if (isChecked) Typeface.BOLD else Typeface.NORMAL
            text.setTypeface(null, bold)

            val colorRes = if (isChecked) R.color.purple_200 else R.color.myself
            text.setTextColor(getColorValue(colorRes))
        }
    }

    private fun getColorValue(@ColorRes colorRes: Int): Int {
        return ContextCompat.getColor(this, colorRes)
    }
}
