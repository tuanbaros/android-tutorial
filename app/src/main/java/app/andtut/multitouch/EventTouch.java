package app.andtut.multitouch;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import app.andtut.BR;

/**
 * Created by tuannt on 12/01/2017.
 */
public class EventTouch extends BaseObservable {

    private float xAxis = 0f;
    private float yAxis = 0f;
    private float lastXAxis = 0f;
    private float lastYAxis = 0f;

    @Bindable
    public float getLastXAxis() {
        return lastXAxis;
    }

    public void setLastXAxis(float lastXAxis) {
        this.lastXAxis = lastXAxis;
        notifyPropertyChanged(BR.lastXAxis);
    }

    @Bindable
    public float getLastYAxis() {
        return lastYAxis;
    }

    public void setLastYAxis(float lastYAxis) {
        this.lastYAxis = lastYAxis;
        notifyPropertyChanged(BR.lastYAxis);
    }

    @Bindable
    public float getXAxis() {
        return xAxis;
    }

    public void setXAxis(float xAxis) {
        this.xAxis = xAxis;
        notifyPropertyChanged(BR.xAxis);
    }

    @Bindable
    public float getYAxis() {
        return yAxis;
    }

    public void setYAxis(float yAxis) {
        this.yAxis = yAxis;
        notifyPropertyChanged(BR.yAxis);
    }
}
