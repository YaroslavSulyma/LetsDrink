package com.example.letsdrink.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.letsdrink.R
import com.example.letsdrink.model.CategoryModel
import com.example.letsdrink.request.Servicey
import com.example.letsdrink.response.CategoryResponse
import com.example.letsdrink.utils.ICocktailApi
import kotlinx.android.synthetic.main.fragment_categories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            getRetrofitResponse()
        }
    }

    private fun getRetrofitResponse() {
        val cocktailApi: ICocktailApi = Servicey.getCocktailApi()

        val responseCall: Call<CategoryResponse> = cocktailApi.cocktailsCategory(
            "list"
        )

        responseCall.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(
                call: Call<CategoryResponse>,
                response: Response<CategoryResponse>
            ) {
                if (response.code() == 200) {
                    Log.v("Tag", "the response " + response.body().toString())

                    val categories: List<CategoryModel> = ArrayList(response.body()?.categories!!)

                    for (category in categories) {
                        Log.v("Tag", "The list " + category.strCategory)
                    }
                } else {
                    try {
                        Log.v("Tag", "ERROR" + response.errorBody()!!.string())
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }


            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }

}