import android.content.Context
import android.hardware.Sensor.TYPE_ACCELEROMETER
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import com.example.fiveactivities.BaseShakeActivity
import com.example.fiveactivities.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DetermineShakeTest {
    private lateinit var sensorManager: SensorManager
    private lateinit var shakeActivity: BaseShakeActivity
    private lateinit var rootView: FrameLayout

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        shakeActivity = Robolectric.buildActivity(BaseShakeActivity::class.java).create().get()
        rootView = FrameLayout(context)
        rootView.addView(View(context))
        shakeActivity.setContentView(rootView)
    }

    @Test
    fun testShakeActionTriggered() {

        val sensorEvent = createSensorEvent(TYPE_ACCELEROMETER, floatArrayOf(100.0f, 200.0f, 300.0f))


        sensorManager.getDefaultSensor(TYPE_ACCELEROMETER)
        val sensorEventListener = shakeActivity as SensorEventListener
        sensorEventListener.onSensorChanged(sensorEvent)

        val animation = AnimationUtils.loadAnimation(shakeActivity, R.anim.shake)
        val animationStarted = rootView.animation === animation
        assert(animationStarted)
    }

    private fun createSensorEvent(sensorType: Int, values: FloatArray): SensorEvent {
        val sensorEvent = SensorEvent::class.java.newInstance()
        val sensorField = SensorEvent::class.java.getDeclaredField("values")
        sensorField.isAccessible = true
        sensorField.set(sensorEvent, values)
        val sensorTypeField = SensorEvent::class.java.getDeclaredField("sensor")
        sensorTypeField.isAccessible = true
        sensorTypeField.set(sensorEvent, sensorType)
        return sensorEvent
    }
}