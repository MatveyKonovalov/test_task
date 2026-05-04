package com.example.myapplication.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.Variet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.toString

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {
    private val _varieties = MutableStateFlow<MutableList<Variet>>(mutableListOf())
    val varieties = _varieties.asStateFlow()

    private val _open = MutableStateFlow<Boolean>(false)
    val open = _open.asStateFlow()
    private val _openOptions = MutableStateFlow(false)
    val openOptions = _openOptions.asStateFlow()
    fun open(){
        _open.value = !_open.value
    }
    fun openOptions(){
        _openOptions.value = !_openOptions.value
    }
    fun add(new: String){
        open()
        _varieties.value.add(Variet(id = java.time.LocalTime.now().toString(), description = new))
    }
}