package com.handen.cookassistant.presentation.ext

import android.app.Activity
import android.app.Dialog
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

fun <T> lazyUnsafe(initializer: () -> T): Lazy<T> =
    lazy(LazyThreadSafetyMode.NONE, initializer)

fun <T : View> Dialog.viewId(@IdRes id: Int): Lazy<T> =
    lazyUnsafe { findViewById<T>(id) }

fun <T : View> Fragment.viewId(@IdRes id: Int): Lazy<T> =
    lazyUnsafe { requireView().findViewById<T>(id) }

fun <T : View> View.viewId(@IdRes id: Int): Lazy<T> =
    lazyUnsafe { this.findViewById<T>(id) }

fun <T : View> Activity.viewId(@IdRes id: Int): Lazy<T> =
    lazyUnsafe { this.findViewById<T>(id) }