package com.github.jesushzc.tvapp.utils

import android.app.AlertDialog
import android.content.Context
import com.github.jesushzc.tvapp.R

fun showDialogError(
    context: Context,
    message: String,
    retryButton: () -> Unit? = {}
) {
    val builder = AlertDialog.Builder(context)
    builder.setMessage(message)
    builder.setPositiveButton(R.string.positive_button) { dialog, _ ->
        dialog.dismiss()
    }
    builder.setNegativeButton(R.string.retry_button) { dialog, _ ->
        retryButton()
        dialog.dismiss()
    }
    builder.show()

}