package com.example.tictactoeSample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tictactoeSample.databinding.ActivityMainBinding 

class MainActivity() : AppCompatActivity() {
    //binding class
    lateinit var binding: ActivityMainBinding

    //making global variable to use toggling
    var flag = 0
    var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //compulsory in each project
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //taking parameter as View(making fun which handle view)
    fun check(view: View) {

        cnt++ // ew know for each click cnt is increases

        //1. to identify which button click and what value on it
        val btnCurrent = view as Button

        //2. if button in blank
        if (btnCurrent.text == "") {
            if (flag == 0) {
                btnCurrent.text = "X"
                flag = 1
            } else {
                btnCurrent.text = "O"
                flag = 0
            }

            /*     we can also do with help of count with remainder function

            if(cnt %2==1) btnCurrent.text="X"
            else btnCurrent.text="O"
             */

            // 4. here we can check conditions we know for first 4 taps there is no need to check
            if (cnt > 4) {


                //winner condition
                when {
                    checkCond(binding.btn1,binding.btn2, binding.btn3) -> {
                       showMsg("Winner is ${binding.btn1.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn4,binding.btn5, binding.btn6) -> {
                        showMsg("Winner is ${binding.btn4.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn7,binding.btn8, binding.btn9) -> {
                        showMsg("Winner is ${binding.btn7.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn1,binding.btn4, binding.btn7) -> {
                        showMsg("Winner is ${binding.btn1.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn2,binding.btn5, binding.btn8) -> {
                        showMsg("Winner is ${binding.btn2.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn3,binding.btn6, binding.btn9) -> {
                        showMsg("Winner is ${binding.btn3.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn1,binding.btn5, binding.btn9) -> {
                        showMsg("Winner is ${binding.btn1.getStr()}")
                        restartGame()
                    }
                    checkCond(binding.btn3,binding.btn5, binding.btn7) -> {
                        showMsg("Winner is ${binding.btn3.getStr()}")
                        restartGame()
                    }
                    //this is draw
                    cnt==9->{
                        showMsg("Match is Draw!!")
                        restartGame()
                    }
                }


            }
        }
    }

        //3. make function to reduce redundancy of btn.text.toString()
        fun Button.getStr() = this.text.toString()

        //5. making scope function (to check condition to reduce redundancy)
        val checkCond: (Button, Button, Button) -> Boolean =
            { a, b, c ->
                a.getStr() == b.getStr()
                        && b.getStr() == c.getStr()
                        && c.getStr() != ""
            }

        // 6. function for toasting the message who is winner
        val showMsg: (String)->Unit = {
        msg:String ->  Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()
        }

       //7. for restarting the game
        fun restartGame(){
        //reset the al parameters
        cnt=0
        flag=0
    

        // reset all values in button
        binding.btn1.text=""
        binding.btn2.text=""
        binding.btn3.text=""
        binding.btn4.text=""
        binding.btn5.text=""
        binding.btn6.text=""
        binding.btn7.text=""
        binding.btn8.text=""
        binding.btn9.text=""

    }
}