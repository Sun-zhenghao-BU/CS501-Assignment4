package com.example.flashlight
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.annotation.RequiresApi

class flashlightCameraSetting {
    lateinit var cameraManager: CameraManager
    lateinit var cameraId: String
    var isFlashlightOn :Boolean = false


    @RequiresApi(Build.VERSION_CODES.M)
    fun turnOnFlashlight() {
        try {
            cameraManager.setTorchMode(cameraId, true)
            isFlashlightOn = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun turnOffFlashlight() {
        try {
            cameraManager.setTorchMode(cameraId, false)
            isFlashlightOn = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
