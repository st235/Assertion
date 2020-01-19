package github.com.st235.assertionutils;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import github.com.st235.assertlib.Assert;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private enum Type {
        A, B, UNKNOWN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch (calculateType()) {
            case A:
                Log.d(TAG, "A");
                break;
            case B:
                Log.d(TAG, "B");
                break;
            default:
                // should fail only at production
                Assert.assertFail("Unknown statement reached");
                break;
        }
    }

    private Type calculateType() {
        return Type.A;
    }
}
