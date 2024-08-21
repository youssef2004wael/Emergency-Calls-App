package com.trainining.depi_trainning

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment

class ExitDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireActivity())

        builder
            .setIcon(R.drawable.baseline_exit_to_app_24)
            .setTitle(getString(R.string.title))
            .setMessage(getString(R.string.message))
            .setPositiveButtonIcon(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_check_24
                )
            )
            .setPositiveButton(getString(R.string.posButton)) { _, _ -> activity?.finish() }
            .setNegativeButtonIcon(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_close_24
                )
            )
            .setNegativeButton(getString(R.string.NegButton)) { dialog, _ ->
                dialog.dismiss()

            }


        return builder.create()

    }
}