package com.dobrucali.kickstarterproject.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DetailViewModel(@Suppress("UNUSED_PARAMETER")project: Project, app: Application) : AndroidViewModel(app) {

    private val _selectedProject = MutableLiveData<Project>()
    val selectedProject: LiveData<Project>
        get() = _selectedProject
    init {
        _selectedProject.value = project
    }
}