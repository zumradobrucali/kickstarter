package com.dobrucali.kickstarterproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dobrucali.kickstarterproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = MainFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.projectList.adapter = ProjectAdapter(ProjectAdapter.OnClickListener {
            viewModel.displayProjectDetails(it)
        })

        viewModel.navigateToSelectedProject.observe(viewLifecycleOwner, Observer { project ->
            if (null != project) {
                this.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(project))
                viewModel.displayProjectDetailsComplete()
            }
        })

        return binding.root
    }
}