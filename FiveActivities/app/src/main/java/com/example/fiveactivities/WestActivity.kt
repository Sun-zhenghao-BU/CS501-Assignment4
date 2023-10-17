package com.example.fiveactivities

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Toast

class WestActivity : BaseShakeActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_west)

        gestureDetector = GestureDetector(this, this)

        // initialize shaking animation
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)

        Toast.makeText(this, "You are in WestActivity", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "You are in MainActivity", Toast.LENGTH_SHORT).show()
    }


    override fun onFling(p1: MotionEvent?, p2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (p1 != null && p2.x - p1.x > 100) { // Left to Right Swipe
            finish() // This will end the WestActivity and return you to the MainActivity
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
