package com.example.apiAccess

data class Classe(
    val access: String,
    val `class`: String,
    val fields: List<Field>,
    val methods: List<Method>
)