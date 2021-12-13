package com.example.apiAccess

data class Method(
    val access: String,
    val name: String,
    val parameters: List<Any>,
    val returnType: Boolean
)