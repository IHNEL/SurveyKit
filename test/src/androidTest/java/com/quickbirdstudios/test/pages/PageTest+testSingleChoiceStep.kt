package com.quickbirdstudios.test.pages

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.quickbirdstudios.test.R

internal fun PageTest.testSingleChoiceStep(context: Context) {
    checkIfTitleInfoAndContinueAreDisplayed()

    onView(withId(R.id.button_continue)).check(matches(isEnabled()))
    onView(withId(R.id.singleChoicePart)).check(matches(isDisplayed()))

    onView(withText(R.string.maybe)).check(matches(isChecked()))
    onView(withText(context.getString(R.string.no))).perform(scrollTo(), click())
    onView(withText(R.string.no)).check(matches(isChecked()))
    onView(withText(context.getString(R.string.yes))).perform(scrollTo(), click())
    onView(withText(R.string.yes)).check(matches(isChecked()))
    onView(withText(R.string.no)).check(matches(isNotChecked()))

    continueToNextStep()
}
