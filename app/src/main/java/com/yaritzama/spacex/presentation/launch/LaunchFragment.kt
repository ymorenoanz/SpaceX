package com.yaritzama.spacex.presentation.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yaritzama.spacex.databinding.FragmentLaunchBinding
import com.yaritzama.spacex.domain.models.SpaceModel
import com.yaritzama.spacex.presentation.adapters.LaunchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : Fragment()
{
    lateinit var binding: FragmentLaunchBinding
    private val adapter: LaunchListAdapter by lazy { LaunchListAdapter(::onSpaceSelected) }
    private val viewModel by viewModels<LaunchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)
        //Connect to ListAdapter
        binding.recyclerSpace.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        viewModel.launchInfo.observe(viewLifecycleOwner){ newList ->
            adapter.submitList(newList)
        }
    }

    private fun onSpaceSelected(launchInfo: SpaceModel) {
        findNavController().navigate(
            LaunchFragmentDirections.actionLaunchFragmentToDetailsFragment(launchInfo)
        )
    }
}