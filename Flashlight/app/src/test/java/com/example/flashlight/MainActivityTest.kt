package com.example.flashlight

import android.hardware.camera2.CameraManager
import org.junit.Assert.*
import com.example.flashlight.flashlightCameraSetting
import org.junit.Before

import org.junit.Test

class MainActivityTest {

    private lateinit var cameraManager: CameraManager
    private lateinit var flashlight: flashlightCameraSetting

    @Before
    fun setup(){
        flashlight = flashlightCameraSetting()
    }

    @Test
    fun testFlashLightOn(){
        if(flashlight.isFlashlightOn){
            assertEquals(true,flashlight.isFlashlightOn)
        }
    }

    @Test
    fun testFlashLightOff(){
        if(flashlight.isFlashlightOn){
            assertEquals(false,flashlight.isFlashlightOn)
        }
    }

}