package com.example.fiveactivities

import android.view.MotionEvent
import org.junit.Assert.assertEquals
import org.junit.Test
import org.robolectric.RobolectricTestRunner
import org.junit.runner.RunWith


@RunWith(RobolectricTestRunner::class)
class DetermineFlingDetectionTest {
    @Test
    fun testRightToLeftFling() {
        val event1 = MotionEvent.obtain(0, 0, 0, 150f, 100f, 0)
        val event2 = MotionEvent.obtain(0, 0, 0, 40f, 100f, 0)
        assertEquals(MainActivity.FlingDirection.RIGHT_TO_LEFT, MainActivity.determineFlingDirection(event1, event2))
    }

    @Test
    fun testLeftToRightFling() {
        val event1 = MotionEvent.obtain(0, 0, 0, 100f, 100f, 0)
        val event2 = MotionEvent.obtain(0, 0, 0, 220f, 100f, 0)
        assertEquals(MainActivity.FlingDirection.LEFT_TO_RIGHT, MainActivity.determineFlingDirection(event1, event2))
    }

    @Test
    fun testUpToDownFling() {
        val event1 = MotionEvent.obtain(0, 0, 0, 150f, 50f, 0)
        val event2 = MotionEvent.obtain(0, 0, 0, 40f, 300f, 0)
        assertEquals(MainActivity.FlingDirection.UP_TO_DOWN, MainActivity.determineFlingDirection(event1, event2))
    }

    @Test
    fun testDownToUpFling() {
        val event1 = MotionEvent.obtain(0, 0, 0, 100f, 300f, 0)
        val event2 = MotionEvent.obtain(0, 0, 0, 220f, 50f, 0)
        assertEquals(MainActivity.FlingDirection.DOWN_TO_UP, MainActivity.determineFlingDirection(event1, event2))
    }
}