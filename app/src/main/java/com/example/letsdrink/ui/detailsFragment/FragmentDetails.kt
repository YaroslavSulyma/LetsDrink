package com.example.letsdrink.ui.detailsFragment

import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.MainActivity

class FragmentDetails : FragmentBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        (activity as MainActivity)?.hideBottomNavigation()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity)?.showBottomNavigation()
    }
}