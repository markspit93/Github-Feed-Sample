package com.github.feed.sample.ext

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityOptions
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.github.feed.sample.R

fun AppCompatActivity.findFragment(tag: String): Fragment? {
    return supportFragmentManager.findFragmentByTag(tag)
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String) {
    supportFragmentManager.doTransaction { add(frameId, fragment, tag) }
}

inline fun FragmentManager.doTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun Activity.setTaskColor(color: Int) {
    setTaskDescription(ActivityManager.TaskDescription(getString(R.string.app_name), BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher), color))
}

fun Activity.startActivityTransition(intent: Intent) {
    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
}
