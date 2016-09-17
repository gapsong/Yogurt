package com.hannoverdrei.yogurt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    Button button;
    ConnectionHandler connectionHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectionHandler = new ConnectionHandler();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("yo", "fdsfa");
                connectionHandler.sendGETstring();
            }
        });

        LinkedList<Ingredient> obstZutaten = new LinkedList<Ingredient>();
        obstZutaten.add(new Ingredient("Avocado", 0));
        obstZutaten.add(new Ingredient("Banane", 0));
        obstZutaten.add(new Ingredient("Erdbeere", 0));
        obstZutaten.add(new Ingredient("Gurke", 0));
        obstZutaten.add(new Ingredient("Mango", 0));
        obstZutaten.add(new Ingredient("Tomate", 0));


        ListView lv = (ListView) findViewById(R.id.listView);//hier wird das Listenelement mit dem xml file verknüpft
        lv.setAdapter(new YourAdapter(MainActivity.this, obstZutaten));//diese klasse ist die "logik" zum xml file

    }
}
