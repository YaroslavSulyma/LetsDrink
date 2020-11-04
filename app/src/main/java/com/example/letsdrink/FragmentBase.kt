package com.example.letsdrink

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class FragmentBase : Fragment() {

    fun showSnackbar(layoutId: View, message: String, context: Context) {
        val snackbar = Snackbar.make(layoutId, message, Snackbar.LENGTH_LONG)
        val sbView = snackbar.view
        val sbText = sbView.findViewById<TextView>(R.id.snackbar_text)
        sbView.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPurple))
        sbText.setTextColor(ContextCompat.getColor(context, R.color.colorWhite))
        snackbar.show()
    }
}