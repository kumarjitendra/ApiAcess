package com.example.apiAccess

import org.junit.Assert.*

import org.junit.Test

class ClasseTest {

    @Test
    fun test_class_String() {
        val stringClass = String::class
        assertFalse(stringClass.isData)
        assertFalse(stringClass.isAbstract)
    }

    @Test
    fun test_class_LoggingSupport() {
        val loggingSupport = LoggingSupport::class
        assertFalse(loggingSupport.isOpen)
        assertFalse(loggingSupport.isAbstract)
        assertFalse(loggingSupport.isCompanion)
        assertTrue(loggingSupport.isData)
    }

    @Test
    fun test_class_Method() {
        val methodClass = Method::class
        assertFalse(methodClass.isOpen)
        assertFalse(methodClass.isAbstract)
        assertFalse(methodClass.isCompanion)
        assertTrue(methodClass.isData)
    }
}