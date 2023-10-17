package com.example.flashlight

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.widget.EditText
import android.widget.Switch
import android.view.MotionEvent
import android.view.View
import android.os.Build
import android.util.Log
import android.view.KeyEvent
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.lang.Exception
import com.example.flashlight.flashlightCameraSetting

class MainActivity : AppCompatActivity() {

    private lateinit var flashlightSwitch: Switch
    private lateinit var actionEditText: EditText
    lateinit var cameraManager: CameraManager
    private lateinit var gestureDetector: GestureDetector
    lateinit var cameraId: String
    private lateinit var mainLayout: View
    var flashlightCamera= flashlightCameraSetting()



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flashlightSwitch = findViewById(R.id.toggleSwitch)
        actionEditText = findViewById(R.id.action_bar)
        val mainLayout = findViewById<LinearLayout>(R.id.mainLayout)

        // Initialize the camera to control the flashlight
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]



        gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(
                e1: MotionEvent?,
                e2: MotionEvent,
                velocityX: Float,
                velocityY: Float
            ): Boolean {
                Log.d("MyApp", "Entered onFling")
                if (e1 == null || e2 == null) return false
                val deltaY = e2.y - e1.y
                if (Math.abs(deltaY) > 100 && Math.abs(velocityY) > 100) {
                    if (deltaY < 0) {
                        flashlightCamera.turnOnFlashlight(cameraId, cameraManager)
                        flashlightSwitch.isChecked = true
                        Toast.makeText(this@MainActivity, "Turn On", Toast.LENGTH_SHORT).show()
                    } else {
                        flashlightCamera.turnOffFlashlight(cameraId, cameraManager)
                        flashlightSwitch.isChecked = false
                        Toast.makeText(this@MainActivity, "Turn Off", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
                return false
            }
        })

        mainLayout.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }


        // Switch function on/off to turn on/off the flashlight
        flashlightSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                flashlightCamera.turnOnFlashlight(cameraId, cameraManager)
            } else {
                flashlightCamera.turnOffFlashlight(cameraId, cameraManager)
            }
        }



        actionEditText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val actionText = actionEditText.text.toString().trim()
                if (actionText.equals("ON", ignoreCase = true)) {
                    flashlightSwitch.isChecked = true
                    flashlightCamera.turnOnFlashlight(cameraId, cameraManager)
                } else if (actionText.equals("OFF", ignoreCase = true)) {
                    flashlightSwitch.isChecked = false
                    flashlightCamera.turnOffFlashlight(cameraId, cameraManager)
                } else {
                    if (actionText.isNotEmpty()) {
                        Toast.makeText(this, "Enter only ON/OFF", Toast.LENGTH_LONG).show()
                    }
                }
                return@setOnKeyListener true
            }
            false
        }


    }



    // Turn on/off the camera flashlight
//    @RequiresApi(Build.VERSION_CODES.M)
//    fun flashlightCameraSetting(enable: Boolean) {
//        try {
//            if (enable) {
//                cameraManager.setTorchMode(cameraId, true)
//                isFlashlightOn = true
//            } else {
//                cameraManager.setTorchMode(cameraId, false)
//                isFlashlightOn = false
//            }
//        } catch (e: Exception) {}
//    }




}
