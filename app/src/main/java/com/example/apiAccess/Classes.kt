package com.example.apiAccess

data class Classes(
    val access: String,
    val className: String,
    val fields: List<Field>,
    val methods: List<Method>
)