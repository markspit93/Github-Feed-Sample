Github Feed Sample
======

A sample Android app which showcases advanced usage of Kotlin, Dagger2, Retrofit2, RxJava2, and some Architecture Components.
The diagram below demonstrates how the MVP architecture was used to achieve this:

![App Architecture Diagram](mvp_diagram.png)

As seen above, the architecture used is not pure MVP since it includes a ViewModel between the Presenter and Model.
This is the ViewModel provided by Android's Architecture Components. It's used to hold data from the repository in memory which can persist device configuration changes such as rotation.
The Repository in this sample app retrieves only remote data from a server, but it can easily have a local data source added via ORMs such as Room, Realm or Object Box.

I am aware that the fragment was completely unecessary for this simple app. It is there to demonstrate how fragments would work in more complex apps. Although many developers are against fragments, I believe that when used correctly they can be advantageous.

Usage
======

When running the app, ensure that the latest Play Services are available on the device/emulator due to downloadable fonts.
More information can be found here: https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts.html

Tests
======

The app contains both UI tests (Espresso) and unit tests (AndroidJUnit).
To run them use the following Gradle tasks:

 * runAllTests
 * runUnitTests
 * runInstrumentationTests
 
 Libraries
 ======
 
 * Anko - https://github.com/Kotlin/anko
 * Espresso - https://google.github.io/android-testing-support-library/
 * Dagger - https://google.github.io/dagger/
 * Glide - https://github.com/bumptech/glide
 * Mockito - https://github.com/mockito/mockito
 * MockWebServer - https://github.com/square/okhttp/tree/master/mockwebserver
 * Retrofit - https://github.com/square/retrofit/
 * Roboelectic - https://github.com/robolectric/robolectric
 * RxJava - https://github.com/ReactiveX/RxJava
 * SmoothProgressBar - https://github.com/castorflex/SmoothProgressBar
 * Stetho - https://github.com/facebook/stetho
 
 
