package com.fkg002c.networkutils.app.ui.cell

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CellViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Cellular Fragment"
    }
    val text: LiveData<String> = _text
}