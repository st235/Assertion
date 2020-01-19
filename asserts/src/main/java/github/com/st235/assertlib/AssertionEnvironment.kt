// Copyright (c) 2020 by Alexander Dadukin (hi@st235.xyz)
// All rights reserved.
package github.com.st235.assertlib

abstract class AssertionEnvironment {

    abstract val isEnabled: Boolean

    open fun fall(message: String?) {
        throw IllegalStateException(message)
    }
}