package github.com.st235.assertlib

class AssertionException : IllegalStateException {

    constructor(): super()

    constructor(message: String?): super(message)

    constructor(message: String?, cause: Throwable): super(message, cause)

    constructor(cause: Throwable): super(cause)
}
