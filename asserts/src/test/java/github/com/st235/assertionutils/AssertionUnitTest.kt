package github.com.st235.assertionutils

import github.com.st235.assertlib.Assert.assertArraysEquals
import github.com.st235.assertlib.Assert.assertArraysNotEquals
import github.com.st235.assertlib.Assert.assertEquals
import github.com.st235.assertlib.Assert.assertFail
import github.com.st235.assertlib.Assert.assertFalse
import github.com.st235.assertlib.Assert.assertNotEquals
import github.com.st235.assertlib.Assert.assertNotNull
import github.com.st235.assertlib.Assert.assertNull
import github.com.st235.assertlib.Assert.assertTrue
import github.com.st235.assertlib.Assert.setEnvironment
import github.com.st235.assertlib.AssertionEnvironment
import github.com.st235.assertlib.AssertionException
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
    fun `assertNull is correct when object is null`() {
        assertNull<Any>("Object must be null", null)
    }

    @Test(expected = AssertionException::class)
    fun `assertNull throws exception when object not null`() {
        assertNull("Object must be null", Any())
    }

    @Test
    fun `assertNotNull correct when object not null`() {
        assertNotNull("Object must be not null", Any())
    }

    @Test(expected = AssertionException::class)
    fun `assertNotNull throws exception when object is null`() {
        assertNotNull<Any>("Object must be not null", null)
    }

    @Test
    fun `assertTrue correct when true`() {
        assertTrue("Statement must be true", true)
    }

    @Test(expected = AssertionException::class)
    fun `assertTrue throws exception when false`() {
        assertTrue("Statement must be true", false)
    }

    @Test
    fun `assertFalse correct when false`() {
        assertFalse("Statement must be false", false)
    }

    @Test(expected = AssertionException::class)
    fun `assertFalse throws exception when true`() {
        assertFalse("Statement must be false", true)
    }

    @Test
    fun `assertEquals correct when objects really equals`() {
        val a = "hello"
        val b = "hello"
        assertEquals("Strings must be equals", a, b)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `assertEquals throws assertion exception when is array`() {
        val a = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `assertEquals throws assertion exception when b is array`() {
        val b = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertEquals throws exception when objects not equals`() {
        val a = "hello"
        val b = "world"
        assertEquals("Strings must be equals", a, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertEquals throws exception when a is null`() {
        val b = "hello"
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertEquals throws exception when b is null`() {
        val a = "hello"
        assertEquals("Strings must be equals", a, null)
    }

    @Test
    fun `assertNotEquals correct when objects not equals`() {
        val a = "hello"
        val b = "world"
        assertNotEquals("Strings must be not equals", a, b)
    }

    @Test
    fun `assertNotEquals correct when a is null`() {
        val b = "world"
        assertNotEquals("Strings must be not equals", null, b)
    }

    @Test
    fun `assertNotEquals correct when b is null`() {
        val a = "hello"
        assertNotEquals("Strings must be not equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `assertNotEquals throws assertion exception when array`() {
        val a = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", a, null)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `assertNotEquals throws assertion exception when b is array`() {
        val b = arrayOfNulls<Int>(1)
        assertEquals("Strings must be equals", null, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertNotEquals throws exception when objects equals`() {
        val a = "hello"
        val b = "hello"
        assertNotEquals("Strings must be not equals", a, b)
    }

    @Test
    fun `assertArraysEquals correct when arrays equals`() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3)
        assertArraysEquals("Two arrays must be equals", a, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertArraysEquals throws exception when arrays equals`() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysEquals("Two arrays must be equals", a, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertArraysEquals throws exception when a is null`() {
        val b = arrayOf(1, 2, 3, 4)
        assertArraysEquals("Two arrays must be equals", null, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertArraysEquals throws exception when b is null`() {
        val a = arrayOf(1, 2, 3)
        assertArraysEquals("Two arrays must be equals", a, null)
    }

    @Test
    fun `assertArraysNotEquals correct when arrays not equals`() {
        val a = arrayOf(1, 2, 3)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", a, b)
    }

    @Test
    fun `assertArraysNotEquals correct when a is null`() {
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", null, b)
    }

    @Test
    fun `assertArraysNotEquals correct when b is null`() {
        val a = arrayOf(1, 2, 3)
        assertArraysNotEquals("Two arrays must be not equals", a, null)
    }

    @Test(expected = AssertionException::class)
    fun `assertArraysNotEquals throws exception when arrays equals`() {
        val a = arrayOf(1, 2, 3, 4)
        val b = arrayOf(1, 2, 3, 4)
        assertArraysNotEquals("Two arrays must be not equals", a, b)
    }

    @Test(expected = AssertionException::class)
    fun `assertFail should always fails`() {
        assertFail("Fail")
    }
}