package com.github.jesushzc.tvapp.utils

import android.view.View

/**
 * Created by Jesus Hernandez on 24/07/2023.
 * Extension functions to handle the visibility of the views
 * @property View
 * @property show Function to set the visibility of a view to visible: myView.show()
 * @property hide Function to set the visibility of a view to gone: myView.hide()
 */
fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}