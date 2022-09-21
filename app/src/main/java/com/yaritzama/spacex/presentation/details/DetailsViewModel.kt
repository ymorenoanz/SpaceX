package com.yaritzama.spacex.presentation.details

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
class DetailsViewModel @Inject constructor(
 val repository: LaunchRepository
): ViewModel()
{
    private val _spaceDetails = MutableLiveData<SpaceModel>()
    val spaceDetails : LiveData<SpaceModel> get() = _spaceDetails

    fun fetchDetails(item: SpaceModel){
        viewModelScope.launch(Dispatchers.IO){
            val schools = repository.getLaunchDetails(item)
            _spaceDetails.postValue(item as SpaceModel)
        }
    }
}