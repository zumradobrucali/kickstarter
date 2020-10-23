package com.dobrucali.kickstarterproject.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dobrucali.kickstarterproject.network.Project

const val BASE_PROJECT_URL = "https://www.kickstarter.com"

class DetailViewModel(@Suppress("UNUSED_PARAMETER") project: Project, app: Application) :
    AndroidViewModel(
        app
    ) {

    private val _selectedProject = MutableLiveData<Project>()
    val selectedProject: LiveData<Project>
        get() = _selectedProject

    private val _projectUrl = MutableLiveData<String>()
    val projectUrl: LiveData<String>
        get() = _projectUrl

    init {
        _selectedProject.value = project
    }

    fun displayProjectOnBrowser() {
        selectedProject.value?.let {
            _projectUrl.value = BASE_PROJECT_URL.plus(it.url)
        }
    }
}