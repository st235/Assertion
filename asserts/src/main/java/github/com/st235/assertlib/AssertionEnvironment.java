package github.com.st235.assertlib;

public abstract class AssertionEnvironment {
    public  abstract boolean isEnabled();

    void fall(String message) {
        throw new IllegalStateException(message);
    }
}
