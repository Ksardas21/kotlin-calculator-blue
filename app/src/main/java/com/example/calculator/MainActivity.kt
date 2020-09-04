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

        var dot = false
        var operation = false
        var negative = true

        buttonDivide.setOnClickListener {
            if(!operation && currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*', '.'))setTextFields("")
            if(currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*')) currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "/"
            if(operation && currentOpperand.text.toString().lastOrNull() !in arrayOf('+', '-', '/', '*','.') && currentOpperand.text.isNotEmpty())setTextFields("/")
            dot = true
            operation = false
        }
        buttonMultiply.setOnClickListener {
            if(!operation && currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*', '.'))setTextFields("")
            if(currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*'))currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "*"
            if(operation && currentOpperand.text.toString().lastOrNull() !in arrayOf('+', '-', '/', '*','.') && currentOpperand.text.isNotEmpty()) setTextFields("*")
            dot = true
            operation = false
        }
        buttonMinus.setOnClickListener {
            if(!operation && currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*', '.'))setTextFields("")
            if(currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*')) currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "-"
            if(operation && currentOpperand.text.toString().lastOrNull() !in arrayOf('+', '-', '/', '*','.') && currentOpperand.text.isNotEmpty()) setTextFields("-")
            dot = true
            operation = false
        }
        buttonPlus.setOnClickListener {
            if(!operation && currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*', '.'))setTextFields("")
            if(currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*')) currentOpperand.text = currentOpperand.text.toString().dropLast(1) + "+"
            if(operation && currentOpperand.text.toString().lastOrNull() !in arrayOf('+', '-', '/', '*','.') && currentOpperand.text.isNotEmpty()) { setTextFields("+")}
            dot = true
            operation = false
        }
        buttonPlusMinus.setOnClickListener {
            if((currentOpperand.text.firstOrNull() in arrayOf('+', '-', '/', '*'))&& !negative){
                setTextFields("-")

            }
            if(currentOpperand.text.endsWith("-") || negative) {
                currentOpperand.text.toString().dropLast(1)
                negative = false
            }
        }



        buttonOne.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "1"
            else setTextFields("1")
            operation = true
        }
        buttonTwo.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "2"
            else setTextFields("2")
            operation = true
        }
        buttonThree.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "3"
            else setTextFields("3")
            operation = true
        }
        buttonFour.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "4"
            else setTextFields("4")
            operation = true
        }
        buttonFive.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "5"
            else setTextFields("5")
            operation = true
        }
        buttonSix.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "6"
            else setTextFields("6")
            operation = true
        }

        buttonSeven.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "7"
            else setTextFields("7")
            operation = true
        }

        buttonEight.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "8"
            else setTextFields("8")
            operation = true
        }

        buttonNine.setOnClickListener {
            if (currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length < 2) currentOpperand.text = "" + "9"
            else setTextFields("9")
            operation = true
        }

        buttonZero.setOnClickListener {
            when {
                currentOpperand.text.toString().length == 1 && currentOpperand.text.toString().startsWith("0") -> setTextFields("")
                else -> setTextFields("0")
            }
            operation = true
        }

        buttonDot.setOnClickListener {
            when {
                currentOpperand.text.toString().isEmpty() || currentOpperand.text.toString().last() in arrayOf('+', '-', '/', '*', '(', ')')-> setTextFields("")
                currentOpperand.text.toString().indexOf('.')  < 1 && !dot -> setTextFields(".")
                !dot -> setTextFields("")
                dot && currentOpperand.text.toString().lastOrNull() !in arrayOf('+', '-', '/', '*', '.', ')', '(')-> setTextFields(".")
                else -> setTextFields("")
            }
            dot = false
            operation = false
        }

        buttonClearAll.setOnClickListener {
            currentOpperand.text = ""
            Result.text = ""
        }

        buttonClear.setOnClickListener {
            if (currentOpperand.text.toString().endsWith('.')) currentOpperand.text = currentOpperand.text.toString().dropLast(0)
                dot = true
                operation = true
            if (currentOpperand.text.toString().isNotEmpty())  currentOpperand.text = currentOpperand.text.toString().dropLast(1)
                dot = false
                operation = true
            if (currentOpperand.text.toString().lastOrNull() in arrayOf('+', '-', '/', '*', '.')){
                currentOpperand.text = currentOpperand.text.toString().dropLast(0)
                dot = false
                operation = true
            }
            operation = true
        }

        buttonEquals.setOnClickListener {
            try {
                val calculation =
                    ExpressionBuilder(currentOpperand.text.toString()).build().evaluate()
                val longAnswer = calculation.toLong()
                if (currentOpperand.text.contains("."))
                    Result.text = calculation.toString()
                else Result.text = longAnswer.toString()
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