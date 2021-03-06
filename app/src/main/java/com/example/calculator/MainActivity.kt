package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator_blu.R
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dot = true
        var operation = false
        var dotOp = false
        var negative = true
        if (currentOpperand.text.isEmpty()) {
            negative = true
            dot = true
            dotOp = false
            negative = true
        }
        buttonDivide.setOnClickListener {
            if(!operation)setTextFields("")
            if(currentOpperand.text.lastOrNull() in arrayOf('-', '+', '/', '*'))
            currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "/"
            else setTextFields("/")
            if(!dot) {dotOp = true}
            if(dot) {dotOp = false}
            dot = true
            operation = false
            negative = true
        }
        buttonMultiply.setOnClickListener {
            if(!operation)setTextFields("")
            if(currentOpperand.text.lastOrNull() in arrayOf('-', '+', '/', '*'))
            currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "*"
            else setTextFields("*")
            if(!dot) {dotOp = true}
            if(dot) {dotOp = false}
            dot = true
            operation = false
            negative = true
        }
        buttonMinus.setOnClickListener {
            if(!operation)setTextFields("")
            if(currentOpperand.text.lastOrNull() in arrayOf('-', '+', '/', '*'))
                currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "-"
            else setTextFields("-")
            if(!dot) {dotOp = true}
            if(dot) {dotOp = false}
            dot = true
            operation = false
            negative = true
        }
        buttonPlus.setOnClickListener {
            if(!operation)setTextFields("")
            if(currentOpperand.text.lastOrNull() in arrayOf('-', '+', '/', '*'))
            currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "+"
            else setTextFields("+")
            if(!dot) {dotOp = true}
            if(dot) {dotOp = false}
            dot = true
            operation = false
            negative = true
            negative = true
        }
        buttonNegative.setOnClickListener {
            if(!negative)setTextFields("")
            if(currentOpperand.text.endsWith("-") && !negative){ currentOpperand.text =
                currentOpperand.text.toString().dropLast(1)
                negative = true}
            else if (negative){setTextFields("-")
            negative = false
            operation = false}
        }
        buttonOne.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "1"
            else setTextFields("1")
            operation = true
            negative = false
        }
        buttonTwo.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "2"
            else setTextFields("2")
            operation = true
            negative = false
        }
        buttonThree.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "3"
            else setTextFields("3")
            operation = true
            negative = false
        }
        buttonFour.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "4"
            else setTextFields("4")
            operation = true
            negative = false
        }
        buttonFive.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "5"
            else setTextFields("5")
            operation = true
            negative = false
        }
        buttonSix.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "6"
            else setTextFields("6")
            operation = true
            negative = false
        }
        buttonSeven.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "7"
            else setTextFields("7")
            operation = true
            negative = false
        }
        buttonEight.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "8"
            else setTextFields("8")
            operation = true
            negative = false
        }
        buttonNine.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text =
                "" + "9"
            else setTextFields("9")
            operation = true
            negative = false
        }
        buttonZero.setOnClickListener {
            when {
                currentOpperand.text.toString().length == 1 && currentOpperand.text.toString().startsWith("0") -> setTextFields("")
                else -> setTextFields("0")
            }
            operation = true
            negative = false
        }
        buttonDot.setOnClickListener {
            if(!dot) {setTextFields("")}
            if(currentOpperand.text.endsWith(".")) {setTextFields("")}
            else if(dot){setTextFields(".")}
            dot = false
            operation = true
            negative = false
        }
        buttonClear.setOnClickListener {
            if (currentOpperand.text.lastOrNull() in arrayOf('+', '/', '-', '*') && dotOp){
                operation = true
                dot = false}
            if (currentOpperand.text.lastOrNull() in arrayOf('+', '/', '-', '*') && !dotOp){
                operation = true
                dot = true}
            if (currentOpperand.text.endsWith(".")){ dot = true}
            if (currentOpperand.text.toString().isNotEmpty()){ currentOpperand.text =
                currentOpperand.text.toString().dropLast(1)}
        }
        buttonEquals.setOnClickListener {
            try {
                val calculation = ExpressionBuilder(currentOpperand.text.toString()).build().evaluate()
                val answer = calculation.toDouble()
                Result.text = answer.toString()
            }
            catch (e:Exception){
                Log.d("Error", "Message: ${e.message}")
            }
        }
    }
    private fun setTextFields(str: String){
        if(Result.text.toString().isNotEmpty()) currentOpperand.text = Result.text
        Result.text = ""
        currentOpperand.append(str)
    }
}