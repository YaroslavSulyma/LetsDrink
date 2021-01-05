package com.example.letsdrink.ui.drinksFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.ui.DrinksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinksFragment : FragmentBase(), DrinksAdapter.ItemListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drinks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClicked(drinkName: String) {
        findNavController().navigate(
            R.id.action_drinksFragment_to_fragmentDetails,
            bundleOf("category" to drinkName)
        )
    }
}