package com.hannoverdrei.yogurt;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConnectionHandler implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private String DEST_URL = "http://64.100.10.242:5000/order";
    //private String DEST_URL = "http://10.0.2.2:3000/test";
    ///////////////////////////////////////////////////////////////////////////////////////////////////////77
    ///////////////////////////////////////////////////////////////////////////////////////
    public static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    GoogleApiClient mGoogleApiClient;
    AppCompatActivity activity;


    public ConnectionHandler(AppCompatActivity activity, FirebaseAuth.AuthStateListener mAuthListener) {
        this.activity = activity;
        //**********************
        //Google Sign In
        //**********************
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(this.activity.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this.activity)
                .enableAutoManage(this.activity, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //***********************
        //Firebase log in (Database entry)
        //***********************
        mAuth = FirebaseAuth.getInstance();
        this.mAuthListener = mAuthListener;
        mAuth.addAuthStateListener(mAuthListener);

    }

    public ConnectionHandler(){

    }

    public void signInGoogle() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        this.activity.startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    public void logOutGoogle() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                Log.d("yo", "signed out");
            }
        });
        mAuth.signOut();
    }

    // [START auth_with_google]
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this.activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("yo", "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("yo", "signInWithCredential", task.getException());
                        }
                    }
                });
    }
    // [END auth_with_google]

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////7
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
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
