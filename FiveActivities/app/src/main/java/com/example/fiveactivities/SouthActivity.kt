package com.example.fiveactivities

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Toast

class SouthActivity : BaseShakeActivity(), GestureDetector.OnGestureListener{
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_south)

        gestureDetector = GestureDetector(this, this)

        // initialize shaking animation
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)

        Toast.makeText(this, "You are in SouthActivity", Toast.LENGTH_SHORT).show()
    }

    override fun onFling(p1: MotionEvent?, p2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (p1 != null && p1.y - p2.y > 100) { // Down to Up Swipe
            finish() // This will end the SouthActivity and return you to the MainActivity
            return true
        }
        return false
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event != null) {
            gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
        } else {
            super.onTouchEvent(event)
        }
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
