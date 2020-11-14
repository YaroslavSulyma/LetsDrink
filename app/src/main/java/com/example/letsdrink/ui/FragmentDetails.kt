package com.example.letsdrink.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.letsdrink.FragmentBase
import com.example.letsdrink.model.CocktailDetailModel
import com.example.letsdrink.request.Servicey
import com.example.letsdrink.response.CocktailDetailResponse
import com.example.letsdrink.utils.ICocktailApi
import kotlinx.android.synthetic.main.fragment_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDetails : FragmentBase() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button4.setOnClickListener {
            getRetrofitResponse()
        }
    }

    private fun getRetrofitResponse() {
        val cocktailApi: ICocktailApi = Servicey.getCocktailApi()

        val responseCall: Call<CocktailDetailResponse> = cocktailApi.cocktailDetails("11007")

        responseCall.enqueue(object : Callback<CocktailDetailResponse> {
            override fun onResponse(
                call: Call<CocktailDetailResponse>,
                response: Response<CocktailDetailResponse>
            ) {
                if (response.code() == 200) {
                    Log.v("Tag", "the response " + response.body().toString())

                    val cocktailDetails: List<CocktailDetailModel> =
                        ArrayList(response.body()!!.detail)
                } else {
                    try {
                        Log.v("Tag", "ERROR")
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<CocktailDetailResponse>, t: Throwable) {
                showSnackbar(fragment_details_constraint_layout, "$t", context!!)
            }
        })
    }
}