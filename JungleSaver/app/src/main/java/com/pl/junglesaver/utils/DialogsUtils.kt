package com.pl.junglesaver.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class DialogsUtils : AppCompatDialogFragment() {

    private var listener: ExampleDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder
            .setTitle("Внимание!")
            .setMessage("Вы поменяли обои, на вбирании !")
            .setPositiveButton("Да") {
                    dialogInterface: DialogInterface?,
                    i: Int -> listener!!.onYesClicked()
            }
        return builder.create()
    }

    interface ExampleDialogListener {
        fun onYesClicked()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as ExampleDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement ExampleDialogListener")
        }
    }
}