package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    // TODO: Hmmm....  could probably still manipulate the list.
    val shoeList: LiveData<MutableList<Shoe>>
      get() = _shoeList
}