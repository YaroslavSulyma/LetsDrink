package com.example.letsdrink.ui.detailsFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.MainActivity
import com.example.letsdrink.data.entities.DrinkDetailsModel
import com.example.letsdrink.data.repository.CocktailsRepository
import com.example.letsdrink.databinding.FragmentDetailsBinding
import com.example.letsdrink.databinding.ListOfIngredientsBinding
import com.example.letsdrink.databinding.ListOfProportionsBinding
import com.example.letsdrink.utils.Resource.Status.*
import com.example.letsdrink.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentDetails : FragmentBase() {

    private var binding: FragmentDetailsBinding by autoCleared()
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("idDrink")?.let {
            viewModel.start(it)
            setupObservers()
        }
    }

    private fun setupObservers() {
        viewModel.details.observe(viewLifecycleOwner, {
            when (it.status) {
                SUCCESS -> {
                    binding.fragmentDetailsProgressBar.visibility = View.GONE
                    bindDetails(it.data)
                }
                LOADING -> {
                    binding.fragmentDetailsProgressBar.visibility = View.VISIBLE
                }
                ERROR -> {
                    showSnackbar(
                        binding.fragmentDetailsScrollView,
                        "${it.message}",
                        requireContext()
                    )
                }
            }
        })
    }

    private fun bindDetails(details: DrinkDetailsModel?) {
        Glide.with(binding.root)
            .load(details?.strDrinkThumb)
            .into(binding.fragmentDetailsThumbnail)
        binding.fragmentDetailsCocktailName.text = details?.strDrink
        binding.fragmentDetailsCocktailType.text = details?.strTags
        binding.fragmentDetailsAlcohol.text = details?.strAlcoholic
        binding.fragmentDetailsGlass.text = details?.strGlass
        binding.fragmentDetailsIngredients.fragmentDetailsIngredient1.text = details?.strIngredient1
        binding.fragmentDetailsIngredients.fragmentDetailsIngredient2.text = details?.strIngredient2
        binding.fragmentDetailsIngredients.fragmentDetailsIngredient3.text = details?.strIngredient3
        binding.fragmentDetailsIngredients.fragmentDetailsIngredient4.text = details?.strIngredient4
        binding.fragmentDetailsIngredients.fragmentDetailsIngredient5.text = details?.strIngredient5
        binding.fragmentDetailsProportions.fragmentRecipeProportion1.text = details?.strMeasure1
        binding.fragmentDetailsProportions.fragmentRecipeProportion2.text = details?.strMeasure2
        binding.fragmentDetailsProportions.fragmentRecipeProportion3.text = details?.strMeasure3
        binding.fragmentDetailsProportions.fragmentRecipeProportion4.text = details?.strMeasure4
        binding.fragmentDetailsProportions.fragmentRecipeProportion5.text = details?.strMeasure5
        binding.fragmentDetailsInstruction.text = details?.strInstructions
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).hideBottomNavigation()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).showBottomNavigation()
    }
}