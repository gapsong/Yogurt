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

        final LinkedList<Ingredient> obstZutaten = new LinkedList<Ingredient>();
        obstZutaten.add(new Ingredient("Avocado", 0));
        obstZutaten.add(new Ingredient("Banane", 1));
        obstZutaten.add(new Ingredient("Erdbeere", 2));
        obstZutaten.add(new Ingredient("Gurke", 3));
        obstZutaten.add(new Ingredient("Mango", 4));
        obstZutaten.add(new Ingredient("Tomate", 5));


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
            }
        });


        ListView lv = (ListView) findViewById(R.id.listView);//hier wird das Listenelement mit dem xml file verknüpft
        lv.setAdapter(new YourAdapter(MainActivity.this, obstZutaten));//diese klasse ist die "logik" zum xml file

    }
}
