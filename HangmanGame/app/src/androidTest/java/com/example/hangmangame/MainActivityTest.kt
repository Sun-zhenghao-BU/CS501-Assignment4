package com.example.hangmangame

import android.content.Intent
import android.content.res.Configuration
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.isClickable
//import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    private lateinit var scenario: ActivityScenario<MainActivity>
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup(){
        scenario=launchActivity()
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun click_Start_3Hints(){
        activityRule.launchActivity(Intent().apply {
            putExtra("orientation", Configuration.ORIENTATION_PORTRAIT) // or Configuration.ORIENTATION_LANDSCAPE
        })
        onView(withId(R.id.Button_Start )).perform(click())
        onView(withId(R.id.Button_Hint )).perform(click())
        onView(withId(R.id.Button_Hint )).perform(click())
        onView(withId(R.id.Button_Hint )).perform(click())
        onView(withId(R.id.Button_Start )).perform(click())
        onView(withId(R.id.Button_A )).perform(click())
        onView(withId(R.id.Button_B )).perform(click())
    }
}