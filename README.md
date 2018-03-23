# ClassNotFound


Run `./gradlew connectedCheck` to reproduce.

The app throws an exception when restoring a fragments state inside a ViewPager.


The manual repro steps are as follows:
switch to 3rd tab
open activity (with button)
press back
switch back to 1st tab

This reproduces 100% of the time on SDK 19.
```
Caused by: android.os.BadParcelableException: ClassNotFoundException when unmarshalling: android.support.v7.widget.RecyclerView$SavedState
at android.os.Parcel.readParcelableCreator(Parcel.java:2147)
at android.os.Parcel.readParcelable(Parcel.java:2097)
at android.os.Parcel.readValue(Parcel.java:2013)
at android.os.Parcel.readSparseArrayInternal(Parcel.java:2363)
at android.os.Parcel.readSparseArray(Parcel.java:1735)
at android.os.Parcel.readValue(Parcel.java:2070)
at android.os.Parcel.readArrayMapInternal(Parcel.java:2314)
at android.os.Bundle.unparcel(Bundle.java:249)
at android.os.Bundle.putBoolean(Bundle.java:422)
at android.support.v4.app.Fragment.setUserVisibleHint(Fragment.java:960)
at android.support.v4.app.FragmentStatePagerAdapter.instantiateItem(FragmentStatePagerAdapter.java:121)
at android.support.v4.view.ViewPager.addNewItem(ViewPager.java:1004)
at android.support.v4.view.ViewPager.populate(ViewPager.java:1152)
at android.support.v4.view.ViewPager.setCurrentItemInternal(ViewPager.java:663)
at android.support.v4.view.ViewPager.setCurrentItemInternal(ViewPager.java:625)
at android.support.v4.view.ViewPager.setCurrentItem(ViewPager.java:606)
at android.support.design.widget.TabLayout$ViewPagerOnTabSelectedListener.onTabSelected(TabLayout.java:2170)
at android.support.design.widget.TabLayout.dispatchTabSelected(TabLayout.java:1165)
at android.support.design.widget.TabLayout.selectTab(TabLayout.java:1158)
at android.support.design.widget.TabLayout.selectTab(TabLayout.java:1128)
at android.support.design.widget.TabLayout$Tab.select(TabLayout.java:1427)
at android.support.design.widget.TabLayout$TabView.performClick(TabLayout.java:1537)
at android.view.View$PerformClick.run(View.java:18422)
at android.os.Handler.handleCallback(Handler.java:733)
at android.os.Handler.dispatchMessage(Handler.java:95)
at android.support.test.espresso.base.Interrogator.loopAndInterrogate(Interrogator.java:160)
at android.support.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:472)
at android.support.test.espresso.base.UiControllerImpl.loopUntil(UiControllerImpl.java:419)
at android.support.test.espresso.base.UiControllerImpl.injectMotionEvent(UiControllerImpl.java:240)
at android.support.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:138)
at android.support.test.espresso.action.MotionEvents.sendUp(MotionEvents.java:119)
at android.support.test.espresso.action.Tap.sendSingleTap(Tap.java:153)
at android.support.test.espresso.action.Tap.access$100(Tap.java:33)
at android.support.test.espresso.action.Tap$1.sendTap(Tap.java:44)
at android.support.test.espresso.action.GeneralClickAction.perform(GeneralClickAction.java:128)
at android.support.test.espresso.ViewInteraction$SingleExecutionViewAction.perform(ViewInteraction.java:356)
at android.support.test.espresso.ViewInteraction.doPerform(ViewInteraction.java:241)
at android.support.test.espresso.ViewInteraction.access$100(ViewInteraction.java:62)
at android.support.test.espresso.ViewInteraction$1.call(ViewInteraction.java:149)
at android.support.test.espresso.ViewInteraction$1.call(ViewInteraction.java:146)
at java.util.concurrent.FutureTask.run(FutureTask.java:237)
at android.os.Handler.handleCallback(Handler.java:733)
at android.os.Handler.dispatchMessage(Handler.java:95)
at android.os.Looper.loop(Looper.java:136)
at android.app.ActivityThread.main(ActivityThread.java:5017)
at java.lang.reflect.Method.invokeNative(Native Method)
at java.lang.reflect.Method.invoke(Method.java:515)
at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:779)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:595)
at dalvik.system.NativeStart.main(Native Method)


java.lang.RuntimeException: Parcel android.os.Parcel@9d0a10d8: Unmarshalling unknown type code 7209057 at offset 320
at android.os.Parcel.readValue(Parcel.java:2080)
at android.os.Parcel.readArrayMapInternal(Parcel.java:2313)
at android.os.Bundle.unparcel(Bundle.java:249)
at android.os.Bundle.putBoolean(Bundle.java:422)
at android.support.v4.app.Fragment.setUserVisibleHint(Fragment.java:960)
at android.support.v4.app.FragmentStatePagerAdapter.instantiateItem(FragmentStatePagerAdapter.java:121)
at android.support.v4.view.ViewPager.addNewItem(ViewPager.java:1004)
at android.support.v4.view.ViewPager.populate(ViewPager.java:1152)
at android.support.v4.view.ViewPager.populate(ViewPager.java:1086)
at android.support.v4.view.ViewPager$3.run(ViewPager.java:267)
at android.view.Choreographer$CallbackRecord.run(Choreographer.java:761)
at android.view.Choreographer.doCallbacks(Choreographer.java:574)
at android.view.Choreographer.doFrame(Choreographer.java:543)
at android.view.Choreographer$FrameDisplayEventReceiver.run(Choreographer.java:747)
at android.os.Handler.handleCallback(Handler.java:733)
at android.os.Handler.dispatchMessage(Handler.java:95)
at android.os.Looper.loop(Looper.java:136)
at android.app.ActivityThread.main(ActivityThread.java:5017)
at java.lang.reflect.Method.invokeNative(Native Method)
at java.lang.reflect.Method.invoke(Method.java:515)
at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:779)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:595)
at dalvik.system.NativeStart.main(Native Method)
```


