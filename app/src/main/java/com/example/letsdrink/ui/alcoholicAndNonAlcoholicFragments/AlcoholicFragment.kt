package com.example.letsdrink.ui.alcoholicAndNonAlcoholicFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.databinding.FragmentAlcoholicBinding
import com.example.letsdrink.ui.DrinksAdapter
import com.example.letsdrink.utils.Resource.Status.*
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AlcoholicFragment : FragmentBase(), DrinksAdapter.ItemListener {

    private var binding: FragmentAlcoholicBinding by autoCleared()
    private val viewModel: AlcoholicFragmentViewModel by viewModels()
    private lateinit var adapter: DrinksAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlcoholicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = DrinksAdapter(this)
        gridLayoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        binding.fragmentAlcoholicRecyclerView.layoutManager = gridLayoutManager
        binding.fragmentAlcoholicRecyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.drinks.observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    binding.fragmentAlcoholicProgressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                LOADING -> {
                    binding.fragmentAlcoholicProgressBar.visibility = View.VISIBLE
                }
                ERROR -> {
                    showSnackbar(binding.fragmentAlcoholic, "${it.message}", requireContext())
                }
            }
        })
    }

    override fun onClicked(idDrink: Int) {
        findNavController().navigate(
            R.id.action_alcoholicFragment_to_fragmentDetails, bundleOf("idDrink" to idDrink)
        )
    }
}