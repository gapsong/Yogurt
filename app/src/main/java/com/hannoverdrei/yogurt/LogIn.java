package com.hannoverdrei.yogurt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by gap on 18.09.16.
 */
public class LogIn extends AppCompatActivity {

    ConnectionHandler cHandler;//verwaltet Googleanmeldung und Firebase verfizierung

    Button signOutButton;
    SignInButton signInButton;
    FirebaseAuth.AuthStateListener mAuthListener;
    AppCompatActivity appCompatActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appCompatActivity = this;
        setContentView(R.layout.activity_login);

        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new OnClickWrapper());
        signOutButton = (Button) findViewById(R.id.button);
        signOutButton.setOnClickListener(new OnClickWrapper());

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("yo", "onAuthStateChanged:signed_in:" + user.getUid());
                    //Activity wechseln, wenn das eingeloggt ist
                    Intent i = new Intent(appCompatActivity, MainActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

                    //sends key of user to activity
                    i.putExtra("key", user.getUid());
                    startActivity(i);
                    appCompatActivity.finish();
                } else {
                    // User is signed out
                    Log.d("yo", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        cHandler = new ConnectionHandler(this, mAuthListener);
    }


    private class OnClickWrapper implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sign_in_button:
                    cHandler.signInGoogle();
                    break;
                case R.id.button:
                    cHandler.logOutGoogle();
                    break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ConnectionHandler.RC_SIGN_IN:
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                if (result.isSuccess()) {
                    GoogleSignInAccount acct = result.getSignInAccount();
                    Log.d("yo", "penis " + acct.getId());//nach der Anmeldung wird direkt firebase verifiziert
                    cHandler.firebaseAuthWithGoogle(acct);//hier passiert die Firebase authentifizierung mit googleacc
                }
                break;
        }
    }
}

