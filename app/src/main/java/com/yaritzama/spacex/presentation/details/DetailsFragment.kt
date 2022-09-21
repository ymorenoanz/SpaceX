package com.yaritzama.spacex.presentation.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.yaritzama.spacex.R
import com.yaritzama.spacex.databinding.FragmentDetailsBinding
import com.yaritzama.spacex.databinding.FragmentLaunchBinding
import com.yaritzama.spacex.domain.helpers.ToFormatDate
import com.yaritzama.spacex.presentation.launch.LaunchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment()
{
    lateinit var binding: FragmentDetailsBinding
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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val spaceDetails = args.spaceModel
        with(binding){
            txtMission.text = getString(R.string.mission_name) + spaceDetails.missionName
            txtLaunchDate.text = getString(R.string.launch_date) + spaceDetails.launchDate.ToFormatDate()
            txtRocketName.text = getString(R.string.launch_date) + spaceDetails.rocketName
            txtLaunchSiteName.text = getString(R.string.launch_date) + spaceDetails.launchSiteName
        }

    }

}