package com.rbs.kointemplate.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.rbs.kointemplate.core.data.source.Resource
import com.rbs.kointemplate.databinding.ActivityMainBinding
import com.rbs.kointemplate.presentation.adapter.TourismAdapter
import com.rbs.kointemplate.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: HomeViewModel by viewModel()
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