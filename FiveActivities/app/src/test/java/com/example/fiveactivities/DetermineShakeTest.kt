package com.example.fiveactivities

import android.content.Context
import android.hardware.Sensor.TYPE_ACCELEROMETER
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.FrameLayout
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "src/main/AndroidManifest.xml", qualifiers = "port")
class DetermineShakeTest {

    private lateinit var sensorManager: SensorManager
    private lateinit var shakeActivity: BaseShakeActivity
    private lateinit var rootView: FrameLayout

    @Before
    fun setup() {
        shakeActivity = Robolectric.buildActivity(BaseShakeActivity::class.java).create().start().resume().visible().get()
        rootView = shakeActivity.findViewById(android.R.id.content) as FrameLayout
        sensorManager = shakeActivity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @Test
    fun testShakeActionTriggered() {
        val event1 = createSensorEvent(TYPE_ACCELEROMETER, floatArrayOf(0.0f, 0.0f, 0.0f))
        val event2 = createSensorEvent(TYPE_ACCELEROMETER, floatArrayOf(100.0f, 100.0f, 100.0f))

        val sensorEventListener = shakeActivity as SensorEventListener
        sensorEventListener.onSensorChanged(event1)
        sensorEventListener.onSensorChanged(event2)

        val animationStarted = rootView.animation != null
        assertTrue(animationStarted)
    }

    private fun createSensorEvent(sensorType: Int, values: FloatArray): SensorEvent {
        val sensorEvent = SensorEvent::class.java.newInstance()

        val valuesField = SensorEvent::class.java.getDeclaredField("values")
        valuesField.isAccessible = true
        valuesField.set(sensorEvent, values)

        val sensorField = SensorEvent::class.java.getDeclaredField("sensor")
        sensorField.isAccessible = true
        val sensor = sensorManager.getDefaultSensor(sensorType)
        sensorField.set(sensorEvent, sensor)

        return sensorEvent
    }
}
