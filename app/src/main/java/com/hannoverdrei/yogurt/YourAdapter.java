package com.hannoverdrei.yogurt;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

class YourAdapter extends BaseAdapter {

    Context context;
    private static LayoutInflater inflater = null;
    LinkedList<Ingredient> ingredientList;

    public YourAdapter(Context context, LinkedList<Ingredient> ingredientList) {
        this.context = context;
        this.ingredientList = ingredientList;
    }

    public YourAdapter(Context context) {
        this.context = context;
        this.ingredientList = new LinkedList<Ingredient>();
    }


    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int i) {
        return 5;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {//hier greift man auf das view in der liste zu.
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = LayoutInflater.from(context).
                    inflate(R.layout.row, parent, false);

        TextView anzahl = (TextView) vi.findViewById((R.id.anzahl));
        Button plusButton = (Button) vi.findViewById(R.id.plus);
        TextView obstView = (TextView) vi.findViewById((R.id.obst));
        obstView.setText(ingredientList.get(position).getName());
        plusButton.setOnClickListener(new OnClickWrapper(position, anzahl));
        Button minusButton = (Button) vi.findViewById(R.id.minus);
        minusButton.setOnClickListener(new OnClickWrapper(position, anzahl));
        ImageView imageView = (ImageView) vi.findViewById(R.id.icon);
        imageView.setImageResource(ingredientList.get(position).getImageID());

        return vi;
    }

    private class OnClickWrapper implements View.OnClickListener {

        private int position;
        private TextView anzahl;

        public OnClickWrapper(int position, TextView anzahl) {
            this.position = position;
            this.anzahl = anzahl;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plus:
                    ingredientList.get(position).setValue(ingredientList.get(position).getValue() + 1);
                    anzahl.setText("" + (ingredientList.get(position).getValue()));
                    break;
                case R.id.minus:
                    ingredientList.get(position).setValue(ingredientList.get(position).getValue() - 1);
                    anzahl.setText("" + (ingredientList.get(position).getValue()));
                    break;
            }
        }
    }

}