package com.hannoverdrei.yogurt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    Button button;
    ConnectionHandler connectionHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final LinkedList<Ingredient> obstZutaten = new LinkedList<>();
        obstZutaten.add(new Ingredient("Avocado", 0,R.drawable.avocado));
        obstZutaten.add(new Ingredient("Banane", 1, R.drawable.banana));
        obstZutaten.add(new Ingredient("Erdbeere", 2, R.drawable.strawberry));
        obstZutaten.add(new Ingredient("Mango", 4, R.drawable.mango));
        obstZutaten.add(new Ingredient("Tomate", 5, R.drawable.tomato));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectionHandler = new ConnectionHandler();
        button = (Button) findViewById(R.id.buttonOrder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = new Order(obstZutaten);
                if (order.totalValue() > 0)
                    connectionHandler.sendPOSTstring(order.sendOrderAsJSON());

                for(Ingredient ing : obstZutaten) {
                    ing.setValue(0);
                }
            }
        });

        ListView lv = (ListView) findViewById(R.id.listView);//hier wird das Listenelement mit dem xml file verknüpft
        lv.setAdapter(new YourAdapter(MainActivity.this, obstZutaten));//diese klasse ist die "logik" zum xml file

    }
}
