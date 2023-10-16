package com.example.fiveactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event != null) {
            gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onFling(p1: MotionEvent?, p2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (p1 != null) {
            Log.d("FLING", "Start X: ${p1.x}, End X: ${p2.x}, Delta X: ${p1.x - p2.x}")
            Log.d("FLING", "Start Y: ${p1.y}, End Y: ${p2.y}, Delta Y: ${p1.y - p2.y}")

            when {
                p1.x - p2.x > 100 -> {
                    Log.d("FLING", "Detected Right-to-Left Fling")
                    startActivity(Intent(this, WestActivity::class.java))
                }
                p2.x - p1.x > 100 -> {
                    Log.d("FLING", "Detected Left-to-Right Fling")
                    startActivity(Intent(this, EastActivity::class.java))
                }
                p1.y - p2.y > 100 -> {
                    Log.d("FLING", "Detected Down-to-Up Fling")
                    startActivity(Intent(this, NorthActivity::class.java))
                }
                p2.y - p1.y > 100 -> {
                    Log.d("FLING", "Detected Up-to-Down Fling")
                    startActivity(Intent(this, SouthActivity::class.java))
                }
            }
        }
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        Log.d("Down", "Detected Down")
        return false
    }

    override fun onShowPress(p0: MotionEvent) {
        Log.d("onShowPress", "Detected Show Press")
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        Log.d("onSingleTapUp", "Single Tap Up")
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        Log.d("onScroll", "Detected scroll")
        return false
    }

    override fun onLongPress(p0: MotionEvent) {
        Log.d("onLongPress", "Detected Long Press")
    }
}