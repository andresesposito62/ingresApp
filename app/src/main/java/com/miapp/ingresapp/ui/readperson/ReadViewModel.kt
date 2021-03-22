package com.miapp.ingresapp.ui.readperson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miapp.domain.Person
import kotlinx.coroutines.launch

class ReadViewModel() : ViewModel(), ReadInteractor.OnReadFinishedListener {

    private val _progressVisibility = MutableLiveData<Boolean>()
    val progressVisibility : LiveData<Boolean> get() = _progressVisibility

    private var readInteractor = ReadInteractor()

    private var person = Person("123", "123", "123", "123","123","123")


    fun onButtonLoginClicked(){
        _progressVisibility.value = true
        viewModelScope.launch {
          queryToDB()
        }
    }

    private fun queryToDB() {
        readInteractor.queryToDataBase(person, this@ReadViewModel, this@ReadViewModel)
    }

    override fun onQueryError() {
        _progressVisibility.value = false
    }

    override fun onSuccess() {
        _progressVisibility.value = false
    }


}