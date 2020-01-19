// Copyright (c) 2020 by Alexander Dadukin (hi@st235.xyz)
// All rights reserved.
package github.com.st235.assertlib

import java.util.*

/**
 * Represents a class that provides static assertions to verify your code.
 */
object Assert {
    @Volatile
    private var sCurrentEnvironment: AssertionEnvironment? = null

    private val isAssertAvailable: Boolean
        get() {
            checkNotNull(sCurrentEnvironment) { "There is no environment here. Use #setEnvironment" }
            return requireEnvironment().isEnabled
        }

    @Synchronized
    @JvmStatic
    fun setEnvironment(environment: AssertionEnvironment) {
        sCurrentEnvironment = environment
    }

    @JvmStatic
    fun <T> assertNull(message: String, obj: T?) {
        if (!isAssertAvailable || obj == null) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun <T> assertNotNull(message: String, obj: T?) {
        if (!isAssertAvailable || obj != null) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun assertTrue(message: String, flag: Boolean) {
        if (!isAssertAvailable || flag) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun assertFalse(message: String, flag: Boolean) {
        if (!isAssertAvailable || !flag) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun <T> assertEquals(message: String, one: T, another: T) {
        require(!(isArray(one) || isArray(another))) { "Arrays can not be compared with equals. Use assertArraysEquals instead." }

        if (!isAssertAvailable || equals(one, another)) {
            return
        }

        fall(message)
    }

    @JvmStatic
    fun <T> assertNotEquals(message: String, one: T, another: T) {
        require(!(isArray(one) || isArray(another))) { "Arrays can not be compared with equals. Use assertArraysNotEquals instead." }

        if (!isAssertAvailable || !equals(one, another)) {
            return
        }

        fall(message)
    }

    @JvmStatic
    fun <T> assertArraysEquals(message: String, one: Array<T>?, another: Array<T>?) {
        if (!isAssertAvailable || Arrays.equals(one, another)) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun <T> assertArraysNotEquals(message: String, one: Array<T>?, another: Array<T>?) {
        if (!isAssertAvailable || !Arrays.equals(one, another)) {
            return
        }
        fall(message)
    }

    @JvmStatic
    fun assertFail(message: String) {
        fall(message)
    }

    private fun isArray(obj: Any?): Boolean {
        return obj != null && obj.javaClass.isArray
    }

    private fun equals(a: Any?, b: Any?): Boolean = (a === b) || (a != null && a == b)

    private fun fall(message: String) {
        checkNotNull(sCurrentEnvironment) { "There is no environment here. Use #setEnvironment" }
        requireEnvironment().fall(message)
    }

    private fun requireEnvironment() = sCurrentEnvironment!!
}