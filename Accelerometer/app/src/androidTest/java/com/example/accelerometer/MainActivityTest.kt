package com.example.accelerometer


import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.hamcrest.Matchers.not




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

    //test initial value of x y z directions
   @Test
    fun directionDisplay() {

       onView(withId(R.id.x_direction_text))
               .check(matches(not(withText("X axis: 0.00"))))

       onView(withId(R.id.y_direction_text))
               .check(matches(not(withText("Y axis: 0.00"))))

        onView(withId(R.id.z_direction_text))
            .check(matches(not(withText("Y axis: 0.00"))))

    }

    @Test
    fun seekbarTextDisplay(){
        onView(withId(R.id.seekbar_text))
            .check(matches(not(withText("Sense Scale"))))
    }
}







