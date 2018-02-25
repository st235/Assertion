package github.com.st235.assertionutils;

import org.junit.Test;

import github.com.st235.assertlib.Assert;

public class AssertionUnitTest {

    @Test
    public void assertNull_isCorrect_whenObjectIsNull() {
        Assert.assertNull("Object must be null", null);
    }


    @Test(expected = IllegalStateException.class)
    public void assertNull_throwException_whenObjectNotNull() {
        Assert.assertNull("Object must be null", new Object());
    }


    @Test
    public void assertNotNull_isCorrect_whenObjectNotNull() {
        Assert.assertNotNull("Object must be not null", new Object());
    }


    @Test(expected = IllegalStateException.class)
    public void assertNotNull_throwException_whenObjectIsNull() {
        Assert.assertNotNull("Object must be not null", null);
    }

    @Test
    public void assertTrue_isCorrect_whenItIsTrue() {
        Assert.assertTrue("Statement must be true", true);
    }


    @Test(expected = IllegalStateException.class)
    public void assertTrue_throwException_whenItIsFalse() {
        Assert.assertTrue("Statement must be true", false);
    }

    @Test
    public void assertFalse_isCorrect_whenItIsFalse() {
        Assert.assertFalse("Statement must be false", false);
    }


    @Test(expected = IllegalStateException.class)
    public void assertFalse_throwException_whenItIsTrue() {
        Assert.assertFalse("Statement must be false", true);
    }

    @Test
    public void assertEquals_isCorrect_whenObjectReallyEquals() {
        String a = "hello";
        String b = "hello";

        Assert.assertEquals("Strings must be equals", a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertEquals_throwsIllegalArgumentException_whenAIsArray() {
        Integer[] a = new Integer[1];

        Assert.assertEquals("Strings must be equals", a, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertEquals_throwsIllegalArgumentException_whenBIsArray() {
        Integer[] b = new Integer[1];

        Assert.assertEquals("Strings must be equals", null, b);
    }

    @Test(expected = IllegalStateException.class)
    public void assertEquals_throwsError_whenObjectNotEquals() {
        String a = "hello";
        String b = "world";

        Assert.assertEquals("Strings must be equals", a, b);
    }


    @Test(expected = IllegalStateException.class)
    public void assertEquals_throwsError_whenAObjectIsNull() {
        String b = "hello";

        Assert.assertEquals("Strings must be equals", null, b);
    }

    @Test(expected = IllegalStateException.class)
    public void assertEquals_throwsError_whenBObjectIsNull() {
        String a = "hello";

        Assert.assertEquals("Strings must be equals", a, null);
    }

    @Test
    public void assertNotEquals_isCorrect_whenObjectNotEquals() {
        String a = "hello";
        String b = "world";

        Assert.assertNotEquals("Strings must be not equals", a, b);
    }

    @Test
    public void assertNotEquals_isCorrect_whenAObjectIsNull() {
        String b = "world";

        Assert.assertNotEquals("Strings must be not equals", null, b);
    }

    @Test
    public void assertNotEquals_isCorrect_whenBObjectIsNull() {
        String a = "hello";

        Assert.assertNotEquals("Strings must be not equals", a, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEquals_throwsIllegalArgumentException_whenAIsArray() {
        Integer[] a = new Integer[1];

        Assert.assertEquals("Strings must be equals", a, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEquals_throwsIllegalArgumentException_whenBIsArray() {
        Integer[] b = new Integer[1];

        Assert.assertEquals("Strings must be equals", null, b);
    }


    @Test(expected = IllegalStateException.class)
    public void assertNotEquals_throwsError_whenObjectsEquals() {
        String a = "hello";
        String b = "hello";

        Assert.assertNotEquals("Strings must be not equals", a, b);
    }

    @Test
    public void assertArraysEquals_isCorrect_whenArraysReallyEquals() {
        Integer[] a = new Integer[]{1, 2, 3};
        Integer[] b = new Integer[]{1, 2, 3};

        Assert.assertArraysEquals("Two arrays must be equals", a, b);
    }

    @Test(expected = IllegalStateException.class)
    public void assertArraysEquals_throwsError_whenArraysNotEquals() {
        Integer[] a = new Integer[]{1, 2, 3};
        Integer[] b = new Integer[]{1, 2, 3, 4};

        Assert.assertArraysEquals("Two arrays must be equals", a, b);
    }


    @Test(expected = IllegalStateException.class)
    public void assertArraysEquals_throwsError_whenAIsNull() {
        Integer[] b = new Integer[]{1, 2, 3, 4};

        Assert.assertArraysEquals("Two arrays must be equals", null, b);
    }

    @Test(expected = IllegalStateException.class)
    public void assertArraysEquals_throwsError_whenBIsNull() {
        Integer[] a = new Integer[]{1, 2, 3};

        Assert.assertArraysEquals("Two arrays must be equals", a, null);
    }

    @Test
    public void assertArraysNotEquals_isCorrect_whenArraysNotEquals() {
        Integer[] a = new Integer[]{1, 2, 3};
        Integer[] b = new Integer[]{1, 2, 3, 4};

        Assert.assertArraysNotEquals("Two arrays must be not equals", a, b);
    }

    @Test
    public void assertArraysNotEquals_isCorrect_whenAIsNull() {
        Integer[] b = new Integer[]{1, 2, 3, 4};

        Assert.assertArraysNotEquals("Two arrays must be not equals", null, b);
    }

    @Test
    public void assertArraysNotEquals_isCorrect_whenBIsNull() {
        Integer[] a = new Integer[]{1, 2, 3};

        Assert.assertArraysNotEquals("Two arrays must be not equals", a, null);
    }

    @Test(expected = IllegalStateException.class)
    public void assertArraysNotEquals_throwsError_whenArraysEquals() {
        Integer[] a = new Integer[]{1, 2, 3, 4};
        Integer[] b = new Integer[]{1, 2, 3, 4};

        Assert.assertArraysNotEquals("Two arrays must be not equals", a, b);
    }
}