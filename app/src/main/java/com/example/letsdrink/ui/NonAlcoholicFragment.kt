package com.example.letsdrink.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.letsdrink.viewModels.DrinksViewModel
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.R
import com.example.letsdrink.model.DrinksModel
import com.example.letsdrink.request.Servicey
import com.example.letsdrink.response.DrinksResponse
import com.example.letsdrink.utils.ICocktailApi
import kotlinx.android.synthetic.main.fragment_non_alcoholic.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NonAlcoholicFragment : FragmentBase() {

    private var drinksViewModel = DrinksViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_non_alcoholic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button2.setOnClickListener(View.OnClickListener {
            getRetrofitResponse()
        })
        drinksViewModel = ViewModelProvider(this).get(DrinksViewModel::class.java)
    }

    private fun observeAnyChange() {
        drinksViewModel.getDrinks().observe(this,
            Observer<List<DrinksModel>> {

            })
    }

    private fun getRetrofitResponse() {
        val cocktailApi: ICocktailApi = Servicey.getCocktailApi()

        val responseCall: Call<DrinksResponse> = cocktailApi.allAlcoholicAndNonAlcoholicCocktails(
            "Non_Alcoholic"
        )

        responseCall.enqueue(object : Callback<DrinksResponse> {
            override fun onResponse(
                call: Call<DrinksResponse>,
                response: Response<DrinksResponse>
            ) {
                if (response.code() == 200) {
                    Log.v("Tag", "the response " + response.body().toString())

                    val nonAlcoholicCocktailsList: List<DrinksModel> =
                        ArrayList(response.body()!!.drinks)

                    for (drink in nonAlcoholicCocktailsList) {
                        Log.v("Tag", "The list $drink")
                    }
                } else {
                    try {
                        Log.v("Tag", "ERROR" + response.errorBody()!!.string())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<DrinksResponse>, t: Throwable) {
                showSnackbar(fragment_non_alcoholic_recycler_view, "$t", context!!)
            }
        })

    }
}