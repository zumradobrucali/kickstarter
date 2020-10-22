package com.dobrucali.kickstarterproject.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {

    private val _projectList = MutableLiveData<List<Project>>()
    val projectList: LiveData<List<Project>>
        get() = _projectList

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _navigateToSelectedProject = MutableLiveData<Project>()
    val navigateToSelectedProject: LiveData<Project>
        get() = _navigateToSelectedProject

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getProjectDetails()
    }

    private fun getProjectDetails(){
        coroutineScope.launch {
            val getProjectDeferred = ProjectApi.retrofitService.getProjectList()
            try {
                val listResult = getProjectDeferred.await()
                if (listResult.isNotEmpty()) {
                _projectList.value= listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayProjectDetails(project: Project) {
        _navigateToSelectedProject.value = project
    }

    fun displayProjectDetailsComplete() {
        _navigateToSelectedProject.value = null
    }
}