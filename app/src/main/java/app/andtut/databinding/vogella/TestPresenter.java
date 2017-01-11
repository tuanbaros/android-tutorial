package app.andtut.databinding.vogella;

/**
 * Created by tuannt on 11/01/2017.
 */
public class TestPresenter implements TestContract.Presenter {

    private TestContract.View mTestView;

    TestPresenter(TestContract.View testView) {
        this.mTestView = testView;
    }

    @Override
    public void onShowData(TemperatureData temperatureData) {
        mTestView.showData(temperatureData);
    }

    public void onUpdateText(TemperatureData temperatureData) {
        temperatureData.setCelsius("hello");
    }
}
