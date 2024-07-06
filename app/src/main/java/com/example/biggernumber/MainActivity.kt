package com.example.biggernumber

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


        private var currentToast: Toast? = null

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                val  backgroundview : ConstraintLayout = findViewById(R.id.BackGroundView)
                val btLeft : Button = findViewById(R.id.btLeft)
                val btRight : Button = findViewById(R.id.btRight)
                assignRandomNumbers(btLeft, btRight)
                btLeft.setOnClickListener{
                        checkanswer(btLeft,btRight,backgroundview)
                        assignRandomNumbers(btLeft, btRight)
                }
                btRight.setOnClickListener{
                        checkanswer(btRight,btLeft,backgroundview)
                        assignRandomNumbers(btLeft, btRight)
                }
               


        }
        private fun checkanswer(bta : Button , btb : Button , backgroundview : ConstraintLayout ){
                val bta = bta.text.toString().toInt()
                val btb  = btb.text.toString().toInt()
                if(bta > btb){
                        backgroundview.setBackgroundColor(Color.GREEN)
                        showToast("Correct ${bta}>${btb}")

                }else{
                        backgroundview.setBackgroundColor(Color.RED)
                        showToast("Wrong ${bta}<${btb}")
                }
        }
        private fun assignRandomNumbers(btLeft: Button, btRight: Button) {
                var left = Random.nextInt(100)
                var right = Random.nextInt(100)
                while (left == right) {
                        left = Random.nextInt(100)
                }
                btLeft.text = left.toString()
                btRight.text = right.toString()
        }
        private fun showToast(message : String){
                currentToast?.cancel()

                currentToast = Toast.makeText(this, message , Toast.LENGTH_LONG)
                currentToast?.show()
        }
}