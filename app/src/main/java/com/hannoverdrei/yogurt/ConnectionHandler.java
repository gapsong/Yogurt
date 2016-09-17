package com.hannoverdrei.yogurt;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gap on 17.09.16.
 */
public class ConnectionHandler {

    private String DEST_URL = "http://10.0.2.2:3000/";


    public void sendGETstring() {
        AsyncTaskRunner response = new AsyncTaskRunner();//Daten an den Thread weitergeben
        response.execute("GET");
    }

    //****************************************
    //@params
    //@destURL destination URL
    //@JSONObject Sends JSON
    //****************************************
    public StringBuffer request(String requestType) throws Exception {
        StringBuffer chaine = new StringBuffer("");

        URL url = new URL(DEST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestType);

        //Get response
        InputStream inputStream = connection.getInputStream();

        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = rd.readLine()) != null) {
            chaine.append(line);
        }
        Log.d("yo", chaine.toString());
        return chaine;
    }

    //***************************************
    //Thread for the http request
    //***************************************
    private class AsyncTaskRunner extends AsyncTask<String, Integer, String> {

        //*****************************
        //@params stringBitmap
        //*****************************
        @Override
        protected String doInBackground(String... params) {
            try {
                request(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            super.onPostExecute(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }


    }
}
