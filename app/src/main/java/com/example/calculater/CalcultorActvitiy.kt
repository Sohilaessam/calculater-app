package com.example.calculater

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalcultorActvitiy : AppCompatActivity() {

    lateinit var inputEDT: TextView
       var result:String=""

    var lastOperation:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEDT = findViewById(R.id.textView_input_numbers)
    }

     public fun onClick(v: View) {
        when (v!!.id) {
            R.id.button_zero -> appendText("0")
            R.id.button_one -> appendText("1")
            R.id.button_two -> appendText("2")
            R.id.button_three -> appendText("3")
            R.id.button_four -> appendText("4")
            R.id.button_five -> appendText("5")
            R.id.button_six -> appendText("6")
            R.id.button_seven -> appendText("7")
            R.id.button_eight -> appendText("8")
            R.id.button_nine -> appendText("9")
            R.id.button_dot -> appendText(".")
            R.id.button_addition -> appendOperationText("+")
            R.id.button_subtraction -> appendOperationText("-")
            R.id.button_multiplication -> appendOperationText("*")
            R.id.button_division -> appendOperationText("/")
            R.id.button_percent -> appendOperationText("/")
            R.id.button_clear -> {
                inputEDT.text = ""
            }
            R.id.button_equal -> {
                var operations = Operations()
                result = operations.recognize(inputEDT.text.toString())
                appendText("=$result")
            }

        }
    }

    //50+
//50+70
    /*
    5
    0
     */
    private fun appendText(str: String) {
        if (inputEDT.text.contains("="))
        {
            inputEDT.text = "${result}$lastOperation$str"
            result=""
        }
        else
        {
            inputEDT.text = "${inputEDT.text}$str"
        }
    }
    private fun appendOperationText(operation: String) {
        lastOperation=operation

        if (inputEDT.text.contains("="))
        {
            inputEDT.text = "${result}$operation"
            result=""
        }
        else
        {
            inputEDT.text = "${inputEDT.text}$operation"
        }
    }
}

