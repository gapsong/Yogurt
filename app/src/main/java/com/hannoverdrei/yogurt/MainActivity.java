package com.hannoverdrei.yogurt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    Button button;
    ConnectionHandler connectionHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final LinkedList<Ingredient> obstZutaten = new LinkedList<>();
        obstZutaten.add(new Ingredient("Avocado", 0, R.drawable.avocado));
        obstZutaten.add(new Ingredient("Banane", 1, R.drawable.banana));
        obstZutaten.add(new Ingredient("Erdbeere", 2, R.drawable.strawberry));
        obstZutaten.add(new Ingredient("Mango", 3, R.drawable.mango));
        obstZutaten.add(new Ingredient("Tomate", 4, R.drawable.tomato));
        obstZutaten.add(new Ingredient("Gurke", 5, R.drawable.cucumber));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectionHandler = new ConnectionHandler();

        ListView lv = (ListView) findViewById(R.id.listView);//hier wird das Listenelement mit dem xml file verknüpft
        final YourAdapter myAdapter = new YourAdapter(MainActivity.this, obstZutaten);
        lv.setAdapter(myAdapter);//diese klasse ist die "logik" zum xml file
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.mango);
        button = (Button) findViewById(R.id.buttonOrder);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order order = new Order(obstZutaten);
                if (order.totalValue() > 0)
                    connectionHandler.sendPOSTstring(order.sendOrderAsJSON());

            }
        });


    }
}
