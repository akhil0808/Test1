package com.example.test.utils

import com.example.test.ui.viewmodel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ViewModel(get()) }
}
