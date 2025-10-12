package com.fkg002c.networkutils.app.ui.cell

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.application
import com.fkg002c.networkutils.Api
import com.fkg002c.networkutils.log.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CellViewModel(app: Application) : AndroidViewModel(app) {
    init {
        Logger.v("CellViewModel", "init")
        CoroutineScope(Dispatchers.IO).launch {
            val wnt = Api.getWirelessNetworkType(application.applicationContext)
            CoroutineScope(Dispatchers.Main).launch {
                _text.value = wnt.toString()
            }
            Logger.v("CellViewModel", "getWirelessNetworkType completed")
        }
        CoroutineScope(Dispatchers.IO).launch {
            val cellInfoList = Api.getCellInfo(application.applicationContext, TAG)
            CoroutineScope(Dispatchers.Main).launch {
                _text.value = "all: ${cellInfoList.size}".plus("\n")
                    .plus("registered: ${cellInfoList.filter { it.isRegistered }.size}")
            }
            Logger.v("CellViewModel", "collectCellInfo completed")
        }
        Logger.v("CellViewModel", "init completed")
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is Cellular Fragment"
    }
    val text: LiveData<String> = _text

    companion object {
        private const val TAG = "CellViewModel"
    }
}