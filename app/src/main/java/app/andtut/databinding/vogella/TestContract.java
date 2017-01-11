package app.andtut.databinding.vogella;

/**
 * Created by tuannt on 11/01/2017.
 */
interface TestContract {

    interface Presenter {
        void onShowData(TemperatureData temperatureData);
    }

    interface View {
        void showData(TemperatureData temperatureData);
    }

}
