package com.example.hittapersonnummer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var editText : EditText
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editTextTextPersonName)
        textView = findViewById(R.id.textView)

    }


    @SuppressLint("SetTextI18n")
    fun foundPIK(view : View){

        var total = 0
        var personnummer : String = ""

        if (textView.text != null){
            personnummer = editText.text.toString()
            if (personnummer.length != 10){
                editText.setError("Ange rätt personnummer")
                return
            }
            for(i in personnummer.indices-1){
                var siffra : Int = Integer.parseInt(personnummer[i]?.toString())
                if (i % 2 == 0){
                    var udda = siffra * 2
                    if (udda >=10){
                        total += (udda % 10).toInt()
                        total += (udda/10).toInt()
                    }
                    else {
                        total += udda
                    }
                }
                else {
                    total += siffra
                }

            }


        }

        if (total/10 == Integer.parseInt(personnummer[9].toString())){
            textView.setText("Det här personnummer är RÄTT")

        }
        else{
            textView.setText("Det här personnummer är FEL!!")
        }
    }
}
