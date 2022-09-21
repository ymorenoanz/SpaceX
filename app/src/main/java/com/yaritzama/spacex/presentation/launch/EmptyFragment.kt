package com.yaritzama.spacex.presentation.launch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yaritzama.spacex.R
import com.yaritzama.spacex.databinding.FragmentEmptyBinding
import com.yaritzama.spacex.databinding.FragmentLaunchBinding

class EmptyFragment : Fragment()
{
    lateinit var binding: FragmentEmptyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmptyBinding.inflate(inflater, container, false)
        return binding.root
    }

}