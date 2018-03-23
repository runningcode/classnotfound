package com.zenjob.classnotfound

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test

class ExampleInstrumentedTest {

    @Rule @JvmField var testRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        onView(allOf(withText("GO"), isDisplayed())).perform(click())
        pressBack()
        onView(withText("C")).perform(click())
        onView(allOf(withText("GO"), isDisplayed())).perform(click())
        pressBack()
        onView(withText("A")).perform(click())
    }
}
