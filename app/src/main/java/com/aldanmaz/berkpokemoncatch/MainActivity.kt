package com.aldanmaz.berkpokemoncatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score = 0
    var imageArray =  ArrayList<ImageView>()
    var runnable = Runnable { }
    var handler: Handler = Handler(Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)


        hideImages()


       object : CountDownTimer(15000,1000) {
           override fun onFinish() {
               timeText.text = "Time: 0"

               handler.removeCallbacks(runnable)
               for (image in imageArray) {
                   image.visibility = View.INVISIBLE
               }


               val alertDialog = AlertDialog.Builder(this@MainActivity)
               alertDialog.setTitle("Game Over")
               alertDialog.setMessage("Do you wanna play again?")

               alertDialog.setPositiveButton("Yes") { dialog,which->
                    val intent = intent
                   finish()
                   startActivity(intent)
               }
               alertDialog.setNegativeButton("No") {dialog,which->
                   Toast.makeText(applicationContext,"Game Over!",Toast.LENGTH_LONG).show()


               }
               alertDialog.show()
           }


            override fun onTick(millisUntilFinished: Long) {
                timeText.text = "Time: " + millisUntilFinished/1000
            }



        }.start()

    }

    fun hideImages() {

        runnable = object: Runnable{
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(16)

                imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }

        handler.post(runnable)


    }

    fun increaseScore (view: View) {
        score = score + 1
        scoreText.text = "Score: $score"

    }


}