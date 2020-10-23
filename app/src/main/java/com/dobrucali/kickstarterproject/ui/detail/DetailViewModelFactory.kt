package com.dobrucali.kickstarterproject.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dobrucali.kickstarterproject.network.Project

class DetailViewModelFactory(
    private val project: Project,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(project, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
