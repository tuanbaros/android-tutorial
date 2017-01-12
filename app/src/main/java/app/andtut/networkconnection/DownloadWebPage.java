package app.andtut.networkconnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by tuannt on 12/01/2017.
 * <tuanbaros>
 */
class DownloadWebPage extends AsyncTask<String, Void, String> {

    private TextView dataField;
    private Context context;
    DownloadWebPage(Context context, TextView dataField) {
        this.context = context;
        this.dataField = dataField;
    }

    //check Internet conenction.
    private void checkInternetConenction(){
        ConnectivityManager check = (ConnectivityManager) this.context.
            getSystemService(Context.CONNECTIVITY_SERVICE);
        if (check != null) {
            NetworkInfo[] info = check.getAllNetworkInfo();
            if (info != null)
                for (NetworkInfo anInfo : info)
                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                        Toast.makeText(context, "Internet is connected",
                            Toast.LENGTH_SHORT).show();
                    }
        }
        else{
            Toast.makeText(context, "Not conencted to internet",
                Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPreExecute(){
        checkInternetConenction();
    }

    @Override
    protected String doInBackground(String... arg0) {
        try{
            String link = arg0[0];
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader
//                (is, "UTF-8") );
//            String data;
//            String webPage = "";
//            while ((data = reader.readLine()) != null){
//                webPage += data + "\n";
//            }
//            return webPage;

            //json
            Scanner scanner = new Scanner(is).useDelimiter("\\A");
            String data = scanner.hasNext() ? scanner.next() : "";
//            JsonReader jsonReader = new JsonReader(new InputStreamReader(is, "UTF8"));
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject = jsonArray.getJSONObject(0);

            return jsonObject.getString("name");

        }catch(Exception e){
            return "Exception: " + e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result){
        this.dataField.setText(result);
    }
}
