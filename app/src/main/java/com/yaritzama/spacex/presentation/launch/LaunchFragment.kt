package com.yaritzama.spacex.presentation.launch

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.yaritzama.spacex.R
import com.yaritzama.spacex.databinding.FragmentLaunchBinding
import com.yaritzama.spacex.domain.models.SpaceModel
import com.yaritzama.spacex.presentation.adapters.LaunchListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LaunchFragment : Fragment() {
    lateinit var binding: FragmentLaunchBinding
    private val adapter: LaunchListAdapter by lazy { LaunchListAdapter(context, ::onSpaceSelected) }
    private val viewModel by viewModels<LaunchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchBinding.inflate(inflater, container, false)
        //Connect to ListAdapter
        binding.recyclerSpace.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.launchInfo.observe(viewLifecycleOwner) { newList ->
            adapter.submitList(newList)
        }
    }

    private fun onSpaceSelected(
        launchInfo: SpaceModel,
        lastItemPosition: Int?,
        currentItemPosition: Int?
    ) {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            lastItemPosition?.let {
                adapter.notifyItemChanged(it)
            }

            currentItemPosition?.let {
                adapter.notifyItemChanged(it)
            }
            val navHostFragment =
                childFragmentManager.findFragmentById(R.id.fragment_container_land) as NavHostFragment?
            val bundle = bundleOf("spaceModel" to launchInfo)
            navHostFragment?.navController?.navigate(R.id.detailsFragment2, bundle)
        } else {
            findNavController().navigate(
                LaunchFragmentDirections.actionLaunchFragmentToDetailsFragment(launchInfo)
            )
        }

    }
}