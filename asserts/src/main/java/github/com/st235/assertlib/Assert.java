// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package github.com.st235.assertlib;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Arrays;

/**
 * Represents a class that provides static assertions to verify your code.
 */
public final class Assert {

    @Nullable
    private static AssertionEnvironment sCurrentEnvironment;

    private Assert() {
    }

    public static void setEnvironment(@NonNull AssertionEnvironment environment) {
        sCurrentEnvironment = environment;
    }

    public static <T> void assertNull(@NonNull String message, T object) {
        if (!isAssertAvailable() || object == null) {
            return;
        }

        fall(message);
    }

    public static <T> void assertNotNull(@NonNull String message, T object) {
        if (!isAssertAvailable() || object != null) {
            return;
        }

        fall(message);
    }

    public static void assertTrue(@NonNull String message, boolean flag) {
        if (!isAssertAvailable() || flag) {
            return;
        }

        fall(message);
    }

    public static void assertFalse(@NonNull String message, boolean flag) {
        if (!isAssertAvailable() || !flag) {
            return;
        }

        fall(message);
    }

    public static <T> void assertEquals(@NonNull String message, T one, T another) {
        if (isArray(one) || isArray(another)) {
            throw new IllegalArgumentException("Arrays can not be compared with equals. Use assertArraysEquals instead.");
        }

        if (!isAssertAvailable() || equals(one, another)) {
            return;
        }

        fall(message);
    }

    public static <T> void assertNotEquals(@NonNull String message, T one, T another) {
        if (isArray(one) || isArray(another)) {
            throw new IllegalArgumentException("Arrays can not be compared with equals. Use assertArraysNotEquals instead.");
        }

        if (!isAssertAvailable() || !equals(one, another)) {
            return;
        }

        fall(message);
    }

    public static <T> void assertArraysEquals(@NonNull String message, T[] one, T[] another) {
        if (!isAssertAvailable() || Arrays.equals(one, another)) {
            return;
        }

        fall(message);
    }

    public static <T> void assertArraysNotEquals(@NonNull String message, T[] one, T[] another) {
        if (!isAssertAvailable() || !Arrays.equals(one, another)) {
            return;
        }

        fall(message);
    }

    private static boolean isArray(@Nullable Object object) {
        return object != null && object.getClass().isArray();
    }

    private static boolean equals(@Nullable Object a, @Nullable Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
    
    private static void fall(@NonNull String message) {
        if (sCurrentEnvironment == null) {
            throw new IllegalStateException("There is no environment here. Use #setEnvironment");
        }
        
        sCurrentEnvironment.fall(message);
    }

    private static boolean isAssertAvailable() {
        if (sCurrentEnvironment == null) {
            throw new IllegalStateException("There is no environment here. Use #setEnvironment");
        }

        return sCurrentEnvironment.isEnabled();
    }
}
