package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.databinding.FragmentNonAlcoholicBinding
import com.example.letsdrink.utils.Resource
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicFragment : FragmentBase() {

    private val viewModel: NonAlcoholicFragmentViewModel by viewModels()
    private var binding: FragmentNonAlcoholicBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonAlcoholicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.drinks.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    //set data into adapter
                    binding.fragmentNonAlcoholicProgressBar.visibility = View.GONE
                    Log.d("Tag", "${it.data}")
                }
                Resource.Status.LOADING -> {
                    binding.fragmentNonAlcoholicProgressBar.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    //show error message
                    showSnackbar(binding.fragmentNonAlcoholic, "${it.message}", requireContext())
                }
            }
        })
    }

}