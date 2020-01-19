package github.com.st235.assertionutils

import github.com.st235.assertlib.Assert.assertArraysEquals
import github.com.st235.assertlib.Assert.assertArraysNotEquals
import github.com.st235.assertlib.Assert.assertEquals
import github.com.st235.assertlib.Assert.assertFalse
import github.com.st235.assertlib.Assert.assertNotEquals
import github.com.st235.assertlib.Assert.assertNotNull
import github.com.st235.assertlib.Assert.assertNull
import github.com.st235.assertlib.Assert.assertTrue
import github.com.st235.assertlib.Assert.setEnvironment
import github.com.st235.assertlib.AssertionEnvironment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AssertionUnitTest {
    private class TestEnvironment : AssertionEnvironment() {
        override val isEnabled: Boolean
            get() = true
    }

    @Before
    fun setUp() {
        setEnvironment(TestEnvironment())
    }

    @Test
    fun assertNull_isCorrect_whenObjectIsNull() {
        assertNull<Any>("Object must be null", null)
    }

    @Test(expected = IllegalStateException::class)
    fun assertNull_throwException_whenObjectNotNull() {
        assertNull("Object must be null", Any())
    }

    @Test
    fun assertNotNull_isCorrect_whenObjectNotNull() {
        assertNotNull("Object must be not null", Any())
    }

    @Test(expected = IllegalStateException::class)
    fun assertNotNull_throwException_whenObjectIsNull() {
        assertNotNull<Any>("Object must be not null", null)
    }

    @Test
    fun assertTrue_isCorrect_whenItIsTrue() {
        assertTrue("Statement must be true", true)
    }

    @Test(expected = IllegalStateException::class)
    fun assertTrue_throwException_whenItIsFalse() {
        assertTrue("Statement must be true", false)
    }

    @Test
    fun assertFalse_isCorrect_whenItIsFalse() {
        assertFalse("Statement must be false", false)
    }

    @Test(expected = IllegalStateException::class)
    fun assertFalse_throwException_whenItIsTrue() {
        assertFalse("Statement must be false", true)
    }

    @Test
    fun assertEquals_isCorrect_whenObjectReallyEquals() {
        val a = "hello"
        val b = "hello"
        assertEquals("Strings must be equals", a, b)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assertEquals_throwsIllegalArgumentException_whenAIsArray() {
        val a = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assertEquals_throwsIllegalArgumentException_whenBIsArray() {
        val b = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertEquals_throwsError_whenObjectNotEquals() {
        val a = "hello"
        val b = "world"
        assertEquals("Strings must be equals", a, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertEquals_throwsError_whenAObjectIsNull() {
        val b = "hello"
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertEquals_throwsError_whenBObjectIsNull() {
        val a = "hello"
        assertEquals("Strings must be equals", a, null)
    }

    @Test
    fun assertNotEquals_isCorrect_whenObjectNotEquals() {
        val a = "hello"
        val b = "world"
        assertNotEquals("Strings must be not equals", a, b)
    }

    @Test
    fun assertNotEquals_isCorrect_whenAObjectIsNull() {
        val b = "world"
        assertNotEquals("Strings must be not equals", null, b)
    }

    @Test
    fun assertNotEquals_isCorrect_whenBObjectIsNull() {
        val a = "hello"
        assertNotEquals("Strings must be not equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assertNotEquals_throwsIllegalArgumentException_whenAIsArray() {
        val a = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun assertNotEquals_throwsIllegalArgumentException_whenBIsArray() {
        val b = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertNotEquals_throwsError_whenObjectsEquals() {
        val a = "hello"
        val b = "hello"
        assertNotEquals("Strings must be not equals", a, b)
    }

    @Test
    fun assertArraysEquals_isCorrect_whenArraysReallyEquals() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3)
        assertArraysEquals("Two arrays must be equals", a, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertArraysEquals_throwsError_whenArraysNotEquals() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysEquals("Two arrays must be equals", a, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertArraysEquals_throwsError_whenAIsNull() {
        val b = arrayOf(1, 2, 3, 4)
        assertArraysEquals("Two arrays must be equals", null, b)
    }

    @Test(expected = IllegalStateException::class)
    fun assertArraysEquals_throwsError_whenBIsNull() {
        val a = arrayOf(1, 2, 3)
        assertArraysEquals("Two arrays must be equals", a, null)
    }

    @Test
    fun assertArraysNotEquals_isCorrect_whenArraysNotEquals() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", a, b)
    }

    @Test
    fun assertArraysNotEquals_isCorrect_whenAIsNull() {
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", null, b)
    }

    @Test
    fun assertArraysNotEquals_isCorrect_whenBIsNull() {
        val a = arrayOf(1, 2, 3)
        assertArraysNotEquals("Two arrays must be not equals", a, null)
    }

    @Test(expected = IllegalStateException::class)
    fun assertArraysNotEquals_throwsError_whenArraysEquals() {
        val a = arrayOf(1, 2, 3, 4)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", a, b)
    }
}