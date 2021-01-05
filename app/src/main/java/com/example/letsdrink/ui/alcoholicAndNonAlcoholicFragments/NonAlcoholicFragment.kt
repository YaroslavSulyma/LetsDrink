package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.databinding.FragmentNonAlcoholicBinding
import com.example.letsdrink.ui.DrinksAdapter
import com.example.letsdrink.utils.Resource
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicFragment : FragmentBase(), DrinksAdapter.ItemListener {

    private val viewModel: NonAlcoholicFragmentViewModel by viewModels()
    private var binding: FragmentNonAlcoholicBinding by autoCleared()
    private lateinit var adapter: DrinksAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNonAlcoholicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = DrinksAdapter(this)
        gridLayoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        binding.fragmentNonAlcoholicRecyclerView.layoutManager =
            gridLayoutManager
        binding.fragmentNonAlcoholicRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.drinks.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    //set data into adapter
                    binding.fragmentNonAlcoholicProgressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.LOADING -> {
                    binding.fragmentNonAlcoholicProgressBar.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {
                    showSnackbar(binding.fragmentNonAlcoholic, "${it.message}", requireContext())
                }
            }
        })
    }

    override fun onClicked(drinkName: String) {
        findNavController().navigate(
            R.id.action_nonAlcoholicFragment_to_fragmentDetails,
            bundleOf("nameOfDrink" to drinkName)
        )
    }

}