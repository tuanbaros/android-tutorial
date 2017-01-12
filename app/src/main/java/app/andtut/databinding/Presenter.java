package app.andtut.databinding;

import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.Task;

/**
 * Created by tuannt on 10/01/2017.
 * Project name: android-tutorial
 */
public class Presenter {
    public boolean onSaveClick(View view, User user){
        Log.i("Test", user.getFirstName());
        if (user.isAdult())
            user.setAdult(false);
        else
            user.setAdult(true);
        return true;
    }

    public boolean onLongClick(User user) {
        Log.i("Test", "onlongclick");
        return true;
    }

    public void onCompletedChanged(User user, boolean completed){
        user.setAdult(completed);
        Log.i("Test", "" + completed);
    }

}