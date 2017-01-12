package app.andtut.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import app.andtut.BR;

/**
 * Created by tuannt on 10/01/2017.
 * android-tutorial
 */
public class User extends BaseObservable{
    private String firstName;
    private String lastName;
    private boolean adult;

    public User(String firstName, String lastName, boolean isAdult) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adult = isAdult;
    }

    @Bindable
    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
        notifyPropertyChanged(BR.adult);
    }

    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
