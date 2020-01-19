package github.com.st235.assertlib

class DefaultEnvironment(
        private val enabled: Boolean
) : AssertionEnvironment() {

    override val isEnabled: Boolean = enabled
}
