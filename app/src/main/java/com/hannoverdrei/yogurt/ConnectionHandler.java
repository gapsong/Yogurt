package com.hannoverdrei.yogurt;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConnectionHandler {

    //private String DEST_URL = "http://64.100.10.242:5000/order";
    private String DEST_URL = "http://10.0.2.2:3000/test";


    public void sendPOSTstring(String orderJSON) {
        AsyncTaskRunner response = new AsyncTaskRunner();//Daten an den Thread weitergeben
        response.execute("POST", orderJSON);
    }

    //****************************************
    //@params
    //@destURL destination URL
    //@JSONObject Sends JSON
    //****************************************
    public StringBuffer request(String requestType, String orderJSON) throws Exception {
        StringBuffer chaine = new StringBuffer("");

        URL url = new URL(DEST_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestType);

        //build JSON
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("data", new JSONArray(orderJSON));

        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoInput(true);
        connection.setDoOutput(false);

        //Send request
        DataOutputStream os = new DataOutputStream(connection.getOutputStream());
        try {
            os.writeBytes(jsonParam.toString());
        } catch (Exception e) {
        }
        os.close();

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
                request(params[0], params[1]);
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
