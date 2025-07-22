package com.siar.demoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _textLabel: MutableLiveData<String> = MutableLiveData<String>("Hola Mundo!")
    val textLabel: LiveData<String> = _textLabel
    var count = 0
    private var _lblCount: MutableLiveData<String> = MutableLiveData<String>("")
    val lblCount: LiveData<String> = _lblCount

    private fun changeLabel(){
        _textLabel.value = "Boton presionado!"
    }

    private fun setTextCount(){
        val lbl = "Contador: "
        _lblCount.value = lbl + count
    }

    fun buttonPressed(){
        count++
        changeLabel()
        setTextCount()
    }
}