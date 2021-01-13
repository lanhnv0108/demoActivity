package com.example.androidtutorial.activityIntent.unit

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTrRun { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}
fun Fragment.addFragment(fragment: Fragment, frameId: Int) {
    activity?.supportFragmentManager?.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int) {
    activity?.supportFragmentManager?.inTransaction { replace(frameId, fragment) }
}

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}

//using Scope Function run
inline fun FragmentManager.inTrRun(func: FragmentTransaction.() -> Unit) {
    beginTransaction().run {
        func()
        addToBackStack(null)
        commit()
    }
}

inline fun FragmentManager.inTrWith(func: FragmentTransaction.() -> Unit) {
    with(beginTransaction()) {
        func()
        addToBackStack(null)
        commit()
    }

}
