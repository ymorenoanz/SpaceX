package com.yaritzama.spacex.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yaritzama.spacex.databinding.FragmentDetailsBinding
import com.yaritzama.spacex.databinding.FragmentLaunchBinding
import com.yaritzama.spacex.domain.helpers.ToFormatDate
import com.yaritzama.spacex.presentation.launch.LaunchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment()
{
    lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModels<DetailsViewModel>()
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding =  FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchDetails(args.spaceModel)
        viewModel.spaceDetails.observe(viewLifecycleOwner){ spaceDetails ->
            with(binding){
                txtMission.text = spaceDetails.missionName
                txtLaunchDate.text = spaceDetails.launchDate.ToFormatDate()
                txtRocketName.text = spaceDetails.rocketName
                txtLaunchSiteName.text = spaceDetails.launchSiteName
            }

        }

    }

}