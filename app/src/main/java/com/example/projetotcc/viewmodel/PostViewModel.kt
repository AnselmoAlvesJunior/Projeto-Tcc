package com.example.projetotcc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetotcc.model.Usuario

class PostViewModel:ViewModel() {

    fun save(){

    }
    /*private val mPostViewModel= Usu*/
    private val _text= MutableLiveData<String>().apply {
        value="this is the user posts"
    }
    val text: LiveData<String> =_text

    fun load(){

    }
}