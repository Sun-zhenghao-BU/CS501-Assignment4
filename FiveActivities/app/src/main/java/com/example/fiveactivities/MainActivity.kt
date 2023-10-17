package com.example.fiveactivities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlin.math.abs

open class MainActivity : BaseShakeActivity(), GestureDetector.OnGestureListener {

    private lateinit var gestureDetector: GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(this, this)

        // initialize shaking animation
        shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)

        Toast.makeText(this, "You are in MainActivity", Toast.LENGTH_SHORT).show()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event != null) {
            gestureDetector.onTouchEvent(event) || super.onTouchEvent(event)
        } else {
            super.onTouchEvent(event)
        }
    }

    enum class FlingDirection {
        RIGHT_TO_LEFT, LEFT_TO_RIGHT, DOWN_TO_UP, UP_TO_DOWN, NONE
    }
    companion object {
        fun determineFlingDirection(p1: MotionEvent, p2: MotionEvent): FlingDirection {
            val deltaX = p1.x - p2.x
            val deltaY = p1.y - p2.y

            return if (abs(deltaX) > abs(deltaY)) { // Horizontal fling
                when {
                    deltaX > 100 -> FlingDirection.RIGHT_TO_LEFT
                    deltaX < -100 -> FlingDirection.LEFT_TO_RIGHT
                    else -> FlingDirection.NONE
                }
            } else { // Vertical fling
                when {
                    deltaY > 100 -> FlingDirection.DOWN_TO_UP
                    deltaY < -100 -> FlingDirection.UP_TO_DOWN
                    else -> FlingDirection.NONE
                }
            }
        }
    }

    override fun onFling(p1: MotionEvent?, p2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (p1 != null) {
            when (determineFlingDirection(p1, p2)) {
                FlingDirection.RIGHT_TO_LEFT -> {
                    Log.d("FLING", "Detected Right-to-Left Fling")
                    startActivity(Intent(this, WestActivity::class.java))
                }
                FlingDirection.LEFT_TO_RIGHT -> {
                    Log.d("FLING", "Detected Left-to-Right Fling")
                    startActivity(Intent(this, EastActivity::class.java))
                }
                FlingDirection.DOWN_TO_UP -> {
                    Log.d("FLING", "Detected Down-to-Up Fling")
                    startActivity(Intent(this, NorthActivity::class.java))
                }
                FlingDirection.UP_TO_DOWN -> {
                    Log.d("FLING", "Detected Up-to-Down Fling")
                    startActivity(Intent(this, SouthActivity::class.java))
                }
                else -> {}
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