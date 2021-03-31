package com.example.final1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculate.*
import java.math.BigDecimal
import java.math.RoundingMode

class calculate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        var BMI = 0.0
        var BMR = 0.0
        var TDEE = 0.0
        var sumBMR = 0
        var sumTDEE = 0
        var hheight = 0.0

        val intent: Intent = intent
        var weight = intent.getDoubleExtra("weight",0.0)
        var height = intent.getIntExtra("height",0)
        var age = intent.getIntExtra("age",0)
        var tdee = intent.getDoubleExtra("tdee",0.0)
        var sex = intent.getStringExtra("sex")

        hheight = (height.toDouble()/100)*2
        val decimal = BigDecimal(hheight).setScale(2, RoundingMode.HALF_EVEN)
        BMI = weight/decimal.toDouble()
        val decimalBMI = BigDecimal(BMI).setScale(2, RoundingMode.HALF_EVEN)

        if(sex == "men"){
            BMR = 66+(13.7*weight)+(5*height)-(6.8*age)
            sumBMR = BMR.toInt()
        }else{
            BMR = 665+(9.6*weight)+(1.8*height)-(4.7*age)
            sumBMR = BMR.toInt()
        }

        TDEE = sumBMR*tdee
        sumTDEE = TDEE.toInt()

        calBMI.text = BMI.toString()
        calBMR.text = sumBMR.toString()
        calTDEE.text = sumTDEE.toString()

        finish.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}