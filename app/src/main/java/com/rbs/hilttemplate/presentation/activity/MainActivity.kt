package com.rbs.hilttemplate.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rbs.hilttemplate.databinding.ActivityMainBinding
import com.rbs.hilttemplate.presentation.adapter.TourismAdapter
import com.rbs.hilttemplate.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: HomeViewModel by viewModels()
    private val tourismAdapter by lazy { TourismAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
        setData()
    }

    private fun setAdapter() {
        binding.rvTourism.adapter = tourismAdapter
    }

    private fun setData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect { viewState ->
                    viewState.apply {
                        setProgressBar(isLoading)
                        if (!isLoading) tourismAdapter.submitList(data)
                    }
                }
            }
        }
    }

    private fun setProgressBar(isVisible: Boolean) {
        binding.progressBar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}