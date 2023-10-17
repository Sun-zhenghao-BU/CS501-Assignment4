package com.example.fiveactivities

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

open class BaseShakeActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var lastShakeTime: Long = 0
    protected lateinit var shakeAnimation: Animation

    companion object {
        private const val SHAKE_THRESHOLD = 600
        private var lastX = 0f
        private var lastY = 0f
        private var lastZ = 0f
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    open fun performShakeAction() {
        val shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)
        val rootView = findViewById<View>(android.R.id.content)
        rootView.startAnimation(shakeAnimation)
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            val currentTime = System.currentTimeMillis()

            if ((currentTime - lastShakeTime) > 200) {
                val diffTime = currentTime - lastShakeTime
                lastShakeTime = currentTime

                val speed = abs(x + y + z - lastX - lastY - lastZ) / diffTime * 10000

                if (speed > SHAKE_THRESHOLD) {
                    performShakeAction()
                }

                lastX = x
                lastY = y
                lastZ = z
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}
