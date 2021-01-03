package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.databinding.FragmentAlcoholicBinding
import com.example.letsdrink.utils.Resource.Status.*
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlcoholicFragment : FragmentBase() {

    private var binding: FragmentAlcoholicBinding by autoCleared()
    private val viewModel: AlcoholicFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlcoholicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()

    }

    private fun setupObservers() {
        viewModel.drinks.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                SUCCESS -> {
                    //set data into adapter
                    binding.fragmentAlcoholicProgressBar.visibility = View.GONE
                    Log.d("Tag","${it.data}")
                }
                LOADING -> {
                    //progress bar visible
                    binding.fragmentAlcoholicProgressBar.visibility = View.VISIBLE
                }
                ERROR -> {
                    showSnackbar(binding.fragmentAlcoholic, "${it.message}", requireContext())
                }
            }
        })
    }

}