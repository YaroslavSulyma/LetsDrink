package com.example.letsdrink.ui.drinksFragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.databinding.FragmentDrinksBinding
import com.example.letsdrink.ui.DrinksAdapter
import com.example.letsdrink.utils.Resource.Status.*
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrinksFragment : FragmentBase(), DrinksAdapter.ItemListener {

    private var binding: FragmentDrinksBinding by autoCleared()
    private val viewModel: DrinksViewModel by viewModels()
    private lateinit var adapter: DrinksAdapter
    private lateinit var gridLayoutManager: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDrinksBinding.inflate(layoutInflater)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("strCategory")?.let { viewModel.start(it) }
        setupObservers()
        setupRecyclerView()
    }

    private fun setupObservers() {
        viewModel.drinks.observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    binding.fragmentDrinksProgressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                LOADING -> {
                    binding.fragmentDrinksProgressBar.visibility = View.VISIBLE
                }
                ERROR -> {
                    showSnackbar(
                        binding.fragmentDrinksConstraintLayout,
                        "${it.message}",
                        requireContext()
                    )
                }
            }
        })
    }


    private fun setupRecyclerView() {
        adapter = DrinksAdapter(this)
        gridLayoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        binding.fragmentDrinksRecyclerView.layoutManager =
            gridLayoutManager
        binding.fragmentDrinksRecyclerView.adapter = adapter
    }

    override fun onClicked(idDrink: Int) {
        findNavController().navigate(
            R.id.action_drinksFragment_to_fragmentDetails, bundleOf("idDrink" to idDrink)
        )
    }
}