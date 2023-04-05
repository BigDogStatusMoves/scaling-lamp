package com.example.skuta.sharedpreferencesassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var check: CheckBox

    lateinit var saveButton: Button
    lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.edit_name)
        age = findViewById(R.id.edit_age)
        check = findViewById(R.id.gamer_check)
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)

        saveButton.setOnClickListener{

            val sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.apply{
                putString("name",name.text.toString())
                putString("age", age.text.toString())
                putBoolean("gamer", check.isChecked)
                apply()
            }
        }

        loadButton.setOnClickListener{
            val sharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)

            val key1 = sharedPreferences.getString("name", "No Name")
            val key2 = sharedPreferences.getString("age", "0")
            val key3 = sharedPreferences.getBoolean("gamer", false)

            name.setText(key1)
            age.setText(key2)
            check.isChecked = key3
        }
    }



}