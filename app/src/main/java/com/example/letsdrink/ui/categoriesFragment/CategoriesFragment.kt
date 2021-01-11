package com.example.letsdrink.ui.categoriesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.databinding.FragmentCategoriesBinding
import com.example.letsdrink.utils.Resource.Status.*
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : FragmentBase(), CategoryAdapter.ItemListener {

    private var binding: FragmentCategoriesBinding by autoCleared()
    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.categories.observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    binding.fragmentCategoriesProgressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                ERROR ->
                    showSnackbar(binding.fragmentCategories, "${it.message}", requireContext())

                LOADING ->
                    binding.fragmentCategoriesProgressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = CategoryAdapter(this)
        binding.fragmentCategoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.fragmentCategoriesRecyclerView.adapter = adapter
    }

    override fun onClicked(strCategory: String) {
        findNavController().navigate(
            R.id.action_categoriesFragment_to_drinksFragment, bundleOf("strCategory" to strCategory)
        )
    }

}