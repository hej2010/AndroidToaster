import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

public class Toaster {
    private static Toaster toaster;
    private static android.widget.Toast toast;
    private final WeakReference<Context> weakReference;

    private Toaster(@NonNull Context context) {
        weakReference = new WeakReference<>(context);
    }

    public static Toaster getInstance(@NonNull Context context) {
        if (toaster == null)
            toaster = new Toaster(context.getApplicationContext());
        return toaster;
    }

    public void showShort(@NonNull String message) {
        show(message, false);
    }

    public void showLong(@NonNull String message) {
        show(message, true);
    }

    private void show(@NonNull String message, boolean duration) {
        if (toast != null)
            toast.cancel();
        // Toast.LENGTH_LONG is having 1 int value.
        // Toast.LENGTH_SHORT is having 0 int value.
        toast = Toast.makeText(weakReference.get(), message, duration ? 1 : 0);
        toast.show();
    }

}
