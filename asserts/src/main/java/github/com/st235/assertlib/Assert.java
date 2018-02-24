// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package github.com.st235.assertlib;

import android.support.annotation.NonNull;

/**
 * Represents a class that provides static assertions to verify your code.
 */
public final class Assert {

    private Assert() {
    }

    public static <T> void assertNull(@NonNull String message, T object) {
        if (!isAssertAvailable() || object == null) {
            return;
        }

        throw new IllegalStateException(message);
    }

    public static <T> void assertNotNull(@NonNull String message, T object) {
        if (!isAssertAvailable() || object != null) {
            return;
        }

        throw new IllegalStateException(message);
    }

    public static void assertTrue(@NonNull String message, boolean flag) {
        if (!isAssertAvailable() || flag) {
            return;
        }

        throw new IllegalStateException(message);
    }

    public static void assertFalse(@NonNull String message, boolean flag) {
        if (!isAssertAvailable() || !flag) {
            return;
        }

        throw new IllegalStateException(message);
    }

    public static <T> void assertEquals(@NonNull String message, T one, T another) {
        if (!isAssertAvailable() || one.equals(another)) {
            return;
        }

        throw new IllegalStateException(message);
    }

    public static <T> void assertNotEquals(@NonNull String message, T one, T another) {
        if (!isAssertAvailable() || !one.equals(another)) {
            return;
        }

        throw new IllegalStateException(message);
    }

    private static boolean isAssertAvailable() {
        return BuildConfig.DEBUG;
    }
}
