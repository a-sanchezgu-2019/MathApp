package com.example.ejemplo

import android.app.PendingIntent
import android.app.PendingIntent.getActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.

        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.ejemplo", appContext.packageName)
    }
@Test
fun test_escritura_campo ()  {

    onView(withId(R.id.ec_1_campo)).perform(click())
    onView(withId(R.id.ec_1_campo)).perform(typeText("2"))
    onView(withId(R.id.ec_1_campo)).check(matches(withText("2")))
}

}