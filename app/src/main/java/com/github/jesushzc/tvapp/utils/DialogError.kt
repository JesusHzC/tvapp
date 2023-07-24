package com.github.jesushzc.tvapp.utils

import android.app.AlertDialog
import android.content.Context
import com.github.jesushzc.tvapp.R

/**
 * Created by Jesus Hernandez on 24/07/2023.
 * @param context Context
 * @param message String
 * @param retryButton Function<Unit>
 * Function to show a dialog with an error message and a retry button
 */
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