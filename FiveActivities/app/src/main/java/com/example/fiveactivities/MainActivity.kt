package com.example.fiveactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(this, this)
    }

    override fun onFling(p1: MotionEvent?, p2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (p1 != null) {
            when {
                p1.x - p2.x > 50 -> {
                    startActivity(Intent(this, WestActivity::class.java))
                }
                p2.x - p1.x > 50 -> {
                    startActivity(Intent(this, EastActivity::class.java))
                }
                p1.y - p2.y > 50 -> {
                    startActivity(Intent(this, NorthActivity::class.java))
                }
                p2.y - p1.y > 50 -> {
                    startActivity(Intent(this, SouthActivity::class.java))
                }
            }
        }
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event ?: return super.onTouchEvent(event))
        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return false
    }

    override fun onShowPress(p0: MotionEvent) {

    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        return false
    }

    override fun onLongPress(p0: MotionEvent) {

    }
}