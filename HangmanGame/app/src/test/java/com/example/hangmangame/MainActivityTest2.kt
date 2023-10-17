package com.example.hangmangame

import android.content.res.Configuration
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import android.content.pm.ActivityInfo
//import androidx.test.rule.ActivityTestRule

import org.junit.Assert.*

import org.junit.Rule

class MainActivityTest2{
//    private lateinit var activity: MainActivity
//    private lateinit var scenario: ActivityScenario<MainActivity>
//    @get:Rule
//    val activityRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Before
//    fun setUp() {
//        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
////        activity.configuration.orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//    }

    @Test
    fun testFunctionOutput() {
//        activity.reset()
//        activity.changeImage(2)

//        val button = activity.findViewById<Button>(R.id.yourButtonId)
        assertEquals(4,2+2)
    }
}