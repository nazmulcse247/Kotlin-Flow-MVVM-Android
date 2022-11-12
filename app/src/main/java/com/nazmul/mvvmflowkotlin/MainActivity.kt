package com.nazmul.mvvmflowkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.coroutineScope
import com.nazmul.mvvmflowkotlin.databinding.ActivityMainBinding
import com.nazmul.mvvmflowkotlin.utils.NetworkResult
import com.nazmul.mvvmflowkotlin.viewmodel.PopularTvShowViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : PopularTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.getPopularTvShow(0)
        viewModel.tvShowResponse.observe(this) {

            when (it) {
                is NetworkResult.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                }
                is NetworkResult.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is NetworkResult.Success -> {
                    Toast.makeText(this,it.data.tv_shows.size.toString(), Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.GONE
                }
            }

        }


    }
}