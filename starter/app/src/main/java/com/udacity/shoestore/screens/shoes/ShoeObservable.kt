package com.udacity.shoestore.screens.shoes

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.udacity.shoestore.models.Shoe

class ShoeObservable : BaseObservable() {
    private var _shoe: Shoe = Shoe("", 0.0, "", "")
    private var _shoeIsValid = false

    @Bindable
    fun getShoe(): Shoe? {
        if (_shoeIsValid == true) {
            return _shoe
        }
        return null
    }

    @Bindable
    fun getShoeName(): String? {
        return _shoe.name
    }

    @Bindable
    fun getShoeCompany(): String? {
        return _shoe.company
    }

    @Bindable
    fun getShoeDescription(): String? {
        return _shoe.description
    }

    @Bindable
    fun getShoeSize(): String? {
        if (_shoe.size == 0.0) {
            return null
        }
        return _shoe.size.toString()
    }

    fun setShoeName(value: String) {
        _shoe.name = value
        setShoeIsValid()
        notifyPropertyChanged(BR.shoeName)
    }

    fun setShoeCompany(value: String) {
        _shoe.company = value
        setShoeIsValid()
        notifyPropertyChanged(BR.shoeCompany)
    }

    fun setShoeDescription(value: String) {
        _shoe.description = value
        setShoeIsValid()
        notifyPropertyChanged(BR.shoeDescription)
    }

    fun setShoeSize(value: String) {
        _shoe.size = value.toDouble()
        setShoeIsValid()
        notifyPropertyChanged(BR.shoeSize)
    }

    private fun setShoeIsValid() {
        _shoeIsValid = _shoe.description != null &&
                             _shoe.company != null &&
                             _shoe.name != null &&
                             _shoe.size != null
    }
}
