package com.example.final1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weight = 0.0
        var Height = 0
        var Age = 0
        var Tdee = 0.0
        var sex = ""

        val radiogroup = findViewById<RadioGroup>(R.id.radiogroup)
        val radiosex = findViewById<RadioGroup>(R.id.radiosex)

        radiosex.setOnCheckedChangeListener { group, checkedId ->
            when (radiosex.checkedRadioButtonId){
                R.id.men -> {
                    sex = "men"
                    Toast.makeText(this,"$sex",Toast.LENGTH_SHORT).show()
                }
                R.id.women -> {
                    sex = "women"
                    Toast.makeText(this,"$sex",Toast.LENGTH_SHORT).show()
                }
            }
        }


        radiogroup.setOnCheckedChangeListener { group, checkedId ->
            when (radiogroup.checkedRadioButtonId){
                R.id.R1 -> {
                    Tdee = 1.2
                    Toast.makeText(this,"$Tdee",Toast.LENGTH_SHORT).show()

                }
                R.id.R2 -> {
                    Tdee = 1.375
                    Toast.makeText(this,"$Tdee",Toast.LENGTH_SHORT).show()
                }
                R.id.R3 -> {
                    Tdee = 1.55
                    Toast.makeText(this,"$Tdee",Toast.LENGTH_SHORT).show()
                }
                R.id.R4 -> {
                    Tdee = 1.725
                    Toast.makeText(this,"$Tdee",Toast.LENGTH_SHORT).show()
                }
                R.id.R5 -> {
                    Tdee = 1.9
                    Toast.makeText(this,"$Tdee",Toast.LENGTH_SHORT).show()
                }
            }
        }

        submit.setOnClickListener {

            Height = eheight.text.toString().toInt()
            weight = eweight.text.toString().toDouble()
            Age = eage.text.toString().toInt()

            var intent = Intent(this,calculate::class.java)
                intent.putExtra("weight",weight)
                intent.putExtra("height",Height)
                intent.putExtra("age",Age)
                intent.putExtra("tdee",Tdee)
            intent.putExtra("sex",sex)
            startActivity(intent)
            finish()
        }
    }
}