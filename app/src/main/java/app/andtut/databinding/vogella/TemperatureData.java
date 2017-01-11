package app.andtut.databinding.vogella;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import app.andtut.BR;

/**
 * Created by tuannt on 11/01/2017.
 */
public class TemperatureData extends BaseObservable {

    private String celsius;

    TemperatureData(String celsius) {
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        notifyPropertyChanged(BR.celsius);
    }

}
