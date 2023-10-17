package com.example.fiveactivities

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSwipeRight_shouldOpenEastActivity() {
        onView(isRoot()).perform(swipeRight())
        // Add assertions here, for example:
        // onView(withId(R.id.east_textview)).check(matches(isDisplayed()))
    }

    @Test
    fun testSwipeLeft_shouldOpenWestActivity() {
        onView(isRoot()).perform(swipeLeft())
        // Add assertions here
    }

    @Test
    fun testSwipeUp_shouldOpenNorthActivity() {
        onView(isRoot()).perform(swipeUp())
        // Add assertions here
    }

    @Test
    fun testSwipeDown_shouldOpenSouthActivity() {
        onView(isRoot()).perform(swipeDown())
        // Add assertions here
    }
}
