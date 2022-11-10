package com.p92practicalexam2dawnnarikkattumathews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {
    Context context;
    ArrayList<RestaurantCart> al_rcitems;

    public listviewAdapter(Context context, ArrayList<RestaurantCart> al_rcitems){
        this.context = context;
        this.al_rcitems = al_rcitems;
    }

    @Override
    public int getCount() {
        return al_rcitems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;


        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_layout,parent,false);
            viewHolder.tv_itemname = (TextView) convertView.findViewById(R.id.nameofitem);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.priceofitem);
            viewHolder.tv_ingredients = (TextView) convertView.findViewById(R.id.nameofingredients);
            viewHolder.btn_buyitem = (Button) convertView.findViewById(R.id.buyitem);
//            viewHolder.btn_additem = (Button) convertView.findViewById(R.id.addQuantity);
//            viewHolder.btn_subtractitem = (Button) convertView.findViewById(R.id.subtractQuantity);
            viewHolder.iv_itemimage = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.tv_itemname.setText(al_rcitems.get(position).getItem_name());
        viewHolder.tv_price.setText(al_rcitems.get(position).getItem_price());
        viewHolder.tv_ingredients.setText(al_rcitems.get(position).getItem_ingredients());
        viewHolder.iv_itemimage.setImageResource(al_rcitems.get(position).getItem_image());

        viewHolder.btn_buyitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* //updateListRow(position);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context.getApplicationContext());
                // Setting Alert Dialog Title
                alertDialogBuilder.setTitle("Would you like to buy...");
                // Icon Of Alert Dialog
                alertDialogBuilder.setIcon(R.drawable.shrimp);
                // Setting Alert Dialog Message
                alertDialogBuilder.setMessage("Are you sure,You would like to buy");
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //finish();
                        Toast.makeText(context.getApplicationContext(),"You clicked over No",Toast.LENGTH_SHORT).show();

                    }
                });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(context.getApplicationContext(),"You clicked over No",Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context.getApplicationContext(),"You clicked on Cancel",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();*/
            }
        });

/*        viewHolder.btn_additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListRow(position);
            }
        });

        viewHolder.btn_subtractitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListRow(position);
            }
        });*/



        return convertView;
    }

    private static class ViewHolder{
        TextView tv_itemname;
        TextView tv_price;
        TextView tv_ingredients;
        ImageView iv_itemimage;
        Button btn_buyitem;
    }

    private void updateListRow(Integer position) {

/*        RestaurantCart restaurantCart = al_rcitems.get(position);
        restaurantCart.setItem_ingredients("123");

        notifyDataSetChanged();
        */
        Intent intent = new Intent(context.getApplicationContext(),BuyItem.class);
        intent.putExtra("id",0);
        context.getApplicationContext().startActivity(intent);


    }

/*

    private void updateListRow(Integer position) {

        ShoppingCart shoppingCart = al_scitems.get(position);
        shoppingCart.setItem_price("123");

        notifyDataSetChanged();

    }

    private void IncrementQuantity(Integer position) {

        ShoppingCart shoppingCart = al_scitems.get(position);
        shoppingCart.setItem_price("123");

        notifyDataSetChanged();

    }*/
}
