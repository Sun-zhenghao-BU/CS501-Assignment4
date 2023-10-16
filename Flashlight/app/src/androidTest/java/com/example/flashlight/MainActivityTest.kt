package com.example.flashlight

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.regex.Pattern.matches

class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testFlashlightSwitch() {
        onView(withId(R.id.toggleSwitch)).check(matches(isDisplayed()))
        onView(withId(R.id.toggleSwitch)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.toggleSwitch)).perform(click())
        Thread.sleep(2000)
    }


    @Test
    fun testEditText() {
        onView(withId(R.id.action_bar)).check(matches(isDisplayed()))
        onView(withId(R.id.action_bar)).perform(typeText("ON"))
        onView(withId(R.id.action_bar)).perform(pressKey(66))
    }

}


