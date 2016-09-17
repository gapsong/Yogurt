package com.hannoverdrei.yogurt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Tim on 18.09.2016.
 */
public class AlertBox extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.allert_message)
                .setPositiveButton(R.string.pAllert, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // neue preis klasse
                    }
                })
                .setNegativeButton(R.string.nAllert, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       // order?
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
