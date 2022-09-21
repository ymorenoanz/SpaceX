package com.yaritzama.spacex.presentation.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaritzama.spacex.domain.LaunchRepository
import com.yaritzama.spacex.domain.models.SpaceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val repository: LaunchRepository
) : ViewModel()
{
    private val _launchInfo = MutableLiveData<List<SpaceModel>>()
    val launchInfo: LiveData<List<SpaceModel>> get() = _launchInfo

    init{
        refreshList()
    }

    fun refreshList(){
        viewModelScope.launch (Dispatchers.IO){
            val list = repository.fetchLaunchList()
            _launchInfo.postValue(list)
        }
    }
}