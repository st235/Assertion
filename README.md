[ ![Download](https://api.bintray.com/packages/st235/maven/identiconview/images/download.svg) ](https://bintray.com/st235/maven/identiconview/_latestVersion)
[![Build Status](https://travis-ci.org/st235/Assertion.svg?branch=master)](https://travis-ci.org/st235/Assertion)

# Assertion Util

Do `assertions` wisely!

## Installation

- Maven
```
<dependency>
  <groupId>com.github.st235</groupId>
  <artifactId>assertion-utils</artifactId>
  <version>0.0.2</version>
  <type>pom</type>
</dependency>
```

- Gradle
```
implementation 'com.github.st235:assertion-utils:0.0.2'
```
**Note**: `compile` at the old versions of Gradle

- Ivy
```
<dependency org='com.github.st235' name='assertion-utils' rev='0.0.2'>
  <artifact name='assertion-utils' ext='pom' />
</dependency>
```

## Usage

Some examples listed below

```java
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