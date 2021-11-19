package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
      get() = _shoeList

    private val _newShoeWasAdded = MutableLiveData<Boolean>()
    val newShoeWasAdded: LiveData<Boolean>
      get() = _newShoeWasAdded

    fun addShoe(newShoe: Shoe?) {
        if (newShoe != null) {
            _shoeList.value = _shoeList.value?.plus(listOf(newShoe))
            _newShoeWasAdded.value = true
        }
    }

    fun resetNewShoeWasAdded() {
        _newShoeWasAdded.value = false
    }

    init {
        _shoeList.value = listOf()
        _newShoeWasAdded.value = false
    }
}