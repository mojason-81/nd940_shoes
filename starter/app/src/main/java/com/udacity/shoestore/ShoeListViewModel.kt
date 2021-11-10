package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
      get() = _shoeList

    fun addShoe(newShoe: Shoe) {
        _shoeList.value = _shoeList.value?.plus(listOf(newShoe))
    }

    init {
        _shoeList.value = listOf()
    }
}