package com.p92practicalexam2dawnnarikkattumathews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter2 extends BaseAdapter {
    Context context;
    ArrayList<SelectedCart> al_scitems;

    public listviewAdapter2(Context context, ArrayList<SelectedCart> al_scitems){
        this.context = context;
        this.al_scitems = al_scitems;
    }

    @Override
    public int getCount() {
        return al_scitems.size();
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
        listviewAdapter2.ViewHolder viewHolder;


        if(convertView == null){
            viewHolder = new listviewAdapter2.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.listview_layout2,parent,false);
            viewHolder.tv_itemname = (TextView) convertView.findViewById(R.id.itemname);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.itemprice);
            viewHolder.tv_quantity = (TextView) convertView.findViewById(R.id.itemquantity);
            viewHolder.tv_total_price = (TextView) convertView.findViewById(R.id.totalprice);
//            viewHolder.btn_additem = (Button) convertView.findViewById(R.id.addQuantity);
//            viewHolder.btn_subtractitem = (Button) convertView.findViewById(R.id.subtractQuantity);
            viewHolder.iv_itemimage = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (listviewAdapter2.ViewHolder)convertView.getTag();
        }

        viewHolder.tv_itemname.setText(al_scitems.get(position).getItem_name());
        viewHolder.tv_price.setText(al_scitems.get(position).getItem_price());
        viewHolder.tv_quantity.setText(al_scitems.get(position).getItem_quantity());
        viewHolder.tv_total_price.setText(al_scitems.get(position).getItem_total_price());
        viewHolder.iv_itemimage.setImageResource(al_scitems.get(position).getItem_image());

        return convertView;
    }

    private static class ViewHolder{
        TextView tv_itemname;
        TextView tv_quantity;
        TextView tv_price;
        TextView tv_total_price;
        ImageView iv_itemimage;
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
