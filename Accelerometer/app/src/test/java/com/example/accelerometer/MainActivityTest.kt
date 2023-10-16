package com.example.accelerometer


import org.junit.Test

import org.junit.Assert.assertEquals


class MainActivityTest {

    val sigmove = SigMove()

    @Test
    fun testNonSigmovement(){
        val sense = 1f
        assertEquals( sigmove.isSignificantMovement(0f,0f,0f,sense), false)
    }

    @Test
    fun testSigmovement(){
        val sense = 1f
        assertEquals( sigmove.isSignificantMovement(2f,3f,5f,sense), true)
    }



}