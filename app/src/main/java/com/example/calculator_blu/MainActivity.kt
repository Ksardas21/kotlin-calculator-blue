package com.example.calculator_blu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentOpperand = currentOpperand
        val previousOpperand = previousOpperand
        var output = false

        buttonOne.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "1"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                    currentOpperand.text = "" + "1"
            }
        }

        buttonTwo.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "2"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "2"
            }
        }

        buttonThree.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "3"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "3"
            }
        }

        buttonFour.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "4"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "4"
            }
        }

        buttonFive.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "5"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "5"
            }
        }

        buttonSix.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "6"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "6"
            }
        }

        buttonSeven.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "7"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "1"
            }
        }

        buttonEight.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "8"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "1"
            }
        }

        buttonNine.setOnClickListener {
            currentOpperand.text = currentOpperand.text.toString() + "9"
            if(currentOpperand.text.toString().startsWith("0") && currentOpperand.text.toString().length <= 2){
                currentOpperand.text = "" + "1"
            }
        }

        buttonZero.setOnClickListener {
            when  {
                currentOpperand.text.toString().length == 1 && currentOpperand.text.toString().startsWith("0") -> {
                    currentOpperand.text = currentOpperand.text.toString() + ""
                }
                else -> {
                    currentOpperand.text = currentOpperand.text.toString() + "0"
                }
            }
        }

        buttonDot.setOnClickListener {
            when {
                currentOpperand.text.toString().isEmpty() -> {
                    currentOpperand.text = currentOpperand.text.toString() + ""
                }
                currentOpperand.text.toString().indexOf('.') < 1 -> {
                    currentOpperand.text = currentOpperand.text.toString() + "."
                    currentOpperand.requestLayout()
                }
                else -> {
                    currentOpperand.text = currentOpperand.text.toString() + ""
                }

            }
        }

        buttonClearAll.setOnClickListener {
            currentOpperand.text = ""
            previousOpperand.text = ""
        }

        buttonClear.setOnClickListener{
            if(currentOpperand.text.toString().isNotEmpty()){
                currentOpperand.text = currentOpperand.text.toString().dropLast(1)
            }
        }

        buttonPlus.setOnClickListener {
            val currentResult : Float? = currentOpperand.text.toString().toFloatOrNull()
            val previousResult: Float? = previousOpperand.text.toString().replace("+", "").toFloatOrNull()
            val result : Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                previousResult.toString().toFloatOrNull()
                    ?.plus(it1)
            }

            if(currentOpperand.text.toString().isNotEmpty()) {
                if(previousOpperand.text.isEmpty()){
                    previousOpperand.text = currentResult.toString() + "+"
                    currentOpperand.text = ""

                }
                else{
                    previousOpperand.text = ""
                    currentOpperand.text = result.toString()
                }
            }

            output = true
        }



        buttonMinus.setOnClickListener {
            val currentResult : Float? = currentOpperand.text.toString().toFloatOrNull()
            val previousResult: Float? = previousOpperand.text.toString().replace("-", "").toFloatOrNull()
            val result : Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                previousResult.toString().toFloatOrNull()
                    ?.minus(it1)
            }

            if(currentOpperand.text.toString().isNotEmpty()) {
                if(previousOpperand.text.isEmpty()){
                    previousOpperand.text = currentResult.toString() + "-"
                    currentOpperand.text = ""

                }
                else{
                    previousOpperand.text = ""
                    currentOpperand.text = result.toString()
                }
            }

            output = true
        }

        buttonDivide.setOnClickListener {
            val currentResult : Float? = currentOpperand.text.toString().toFloatOrNull()
            val previousResult: Float? = previousOpperand.text.toString().replace("÷", "").toFloatOrNull()
            val result : Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                previousResult.toString().toFloatOrNull()
                    ?.div(it1)
            }

            if(currentOpperand.text.toString().isNotEmpty()) {
                if(previousOpperand.text.isEmpty()){
                    previousOpperand.text = currentResult.toString() + "÷"
                    currentOpperand.text = ""

                }
                else{
                    previousOpperand.text = ""
                    currentOpperand.text = result.toString()
                }
            }

            output = true
        }

        buttonMultiply.setOnClickListener {
            val currentResult: Float? = currentOpperand.text.toString().toFloatOrNull()
            val previousResult: Float? = previousOpperand.text.toString().replace("×", "").toFloatOrNull()
            val result: Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                previousResult.toString().toFloatOrNull()
                    ?.times(it1)
            }

            if (currentOpperand.text.toString().isNotEmpty())
            {
                if (previousOpperand.text.isEmpty()) {
                    previousOpperand.text = currentResult.toString() + "×"
                    currentOpperand.text = ""
                }
                else {
                    previousOpperand.text = ""
                    currentOpperand.text = result.toString()
                }
            }
            output = true
        }


       buttonEquals.setOnClickListener {
            if (output && currentOpperand.text.toString().isNotEmpty() && previousOpperand.text.toString().isNotEmpty()){

                if(previousOpperand.text.toString().endsWith("+")){
                        val currentResult : Float? = currentOpperand.text.toString().toFloatOrNull()
                        val previousResult: Float? = previousOpperand.text.toString().replace("+", "").toFloatOrNull()
                        val result : Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                            previousResult.toString().toFloatOrNull()
                                ?.plus(it1)
                        }

                        if(currentOpperand.text.toString().isNotEmpty()) {
                            if(previousOpperand.text.isEmpty()){
                                previousOpperand.text = currentResult.toString() + "+"
                                currentOpperand.text = ""

                            }
                            else{
                                previousOpperand.text = ""
                                currentOpperand.text = result.toString()
                            }
                        }
                }

                if(previousOpperand.text.toString().endsWith("-")) {
                    val currentResult: Float? = currentOpperand.text.toString().toFloatOrNull()
                    val previousResult: Float? =
                        previousOpperand.text.toString().replace("-", "").toFloatOrNull()
                    val result: Float? =
                        currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                            previousResult.toString().toFloatOrNull()
                                ?.minus(it1)
                        }

                    if (currentOpperand.text.toString().isNotEmpty()) {
                        if (previousOpperand.text.isEmpty()) {
                            previousOpperand.text = currentResult.toString() + "-"
                            currentOpperand.text = ""

                        } else {
                            previousOpperand.text = ""
                            currentOpperand.text = result.toString()
                        }
                    }
                }


                if(previousOpperand.text.toString().endsWith("÷")){
                    val currentResult : Float? = currentOpperand.text.toString().toFloatOrNull()
                    val previousResult: Float? = previousOpperand.text.toString().replace("÷", "").toFloatOrNull()
                    val result : Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                        previousResult.toString().toFloatOrNull()
                            ?.div(it1)
                    }

                    if(currentOpperand.text.toString().isNotEmpty()) {
                        if(previousOpperand.text.isEmpty()){
                            previousOpperand.text = currentResult.toString() + "÷"
                            currentOpperand.text = ""

                        }
                        else{
                            previousOpperand.text = ""
                            currentOpperand.text = result.toString()
                        }
                    }
                }

                if(previousOpperand.text.toString().endsWith("×")){
                    val currentResult: Float? = currentOpperand.text.toString().toFloatOrNull()
                    val previousResult: Float? = previousOpperand.text.toString().replace("×", "").toFloatOrNull()
                    val result: Float? = currentOpperand.text.toString().toFloatOrNull()?.let { it1 ->
                        previousResult.toString().toFloatOrNull()
                            ?.times(it1)
                    }

                    if (currentOpperand.text.toString().isNotEmpty())
                    {
                        if (previousOpperand.text.isEmpty()) {
                            previousOpperand.text = currentResult.toString() + "×"
                            currentOpperand.text = ""
                        }
                        else {
                            previousOpperand.text = ""
                            currentOpperand.text = result.toString()
                        }
                    }
                }
            }
       }
    }
}