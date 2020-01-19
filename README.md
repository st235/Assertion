[ ![Download](https://api.bintray.com/packages/st235/maven/assertion-utils/images/download.svg) ](https://bintray.com/st235/maven/assertion-utils/_latestVersion)
[![CircleCI](https://circleci.com/gh/st235/Assertion.svg?style=svg)](https://circleci.com/gh/st235/Assertion)

# Assertion Util

Do `assertions` wisely!

## Installation

- Maven
```
<dependency>
  <groupId>com.github.st235</groupId>
  <artifactId>assertion-utils</artifactId>
  <version>X.X.X</version>
  <type>pom</type>
</dependency>
```

- Gradle
```
implementation 'com.github.st235:assertion-utils:X.X.X'
```
**Note**: `compile` at the old versions of Gradle

- Ivy
```
<dependency org='com.github.st235' name='assertion-utils' rev='X.X.X'>
  <artifact name='assertion-utils' ext='pom' />
</dependency>
```

P.S.: Check out latest version code in badge at the top of this page.

## SetUp

First of all, you should set up your assertion environment.
Usually it happens in your Application class.

```kotlin
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Assert.setEnvironment(DefaultEnvironment(BuildConfig.DEBUG))
    }
}
```

Then you're able to use it in your code.

```kotlin
        when (calculateType()) {
            A -> Log.d(TAG, "A")
            B -> Log.d(TAG, "B")
            else -> {
                // should fail only at production
                Assert.assertFail("Unknown statement reached")
            }
        }
```

## Environment

There is one default environment called `DefaultEnvironemt`. Its really easy to use - it accepts boolean flag, 
which means do assertion enabled in current build or not.

Usage example:

```kotlin
    DefaultEnvironment(BuildConfig.DEBUG)
```

But if u need more flexibility in environment set up, you're always able to inherit base class for all
the environments `AssertionEnvironment`

```kotlin
abstract class AssertionEnvironment {

    abstract val isEnabled: Boolean

    open fun fall(message: String?) {
        throw AssertionException(message)
    }
}
```

**val isEnabled: Boolean** - switch on or off the assertion mechanism

**fun fall(message: String?)** - assertion fails and environment calls this method to react properly. Default behavior
will throws `AssertionException`

## Java

This util is backward compatible with java code. Use it as in examples below.

```java
    private static class DefaultEnvironment extends AssertionEnvironment {
        @Override
        public boolean isEnabled() {
            return BuildConfig.DEBUG;
        }
    }

    @Override
    public void onCreate() {
        Assert.setEnvironment(new DefaultEnvironment());
    }

    Assert.assertNull("Object must be null", a);
    Assert.assertNotNull("Object must be not null", b);
```

## License

```text
MIT License

Copyright (c) 2018 - present Alexander Dadukin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
