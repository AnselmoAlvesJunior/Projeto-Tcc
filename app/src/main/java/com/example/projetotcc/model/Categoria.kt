package com.example.projetotcc.model

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Categoria {
    private val id_categoria: String? = null
    private val descricao: String? = null
    private val titulo: String? = null

    val db = Firebase.firestore.collection("categoria").get()

}