package com.p92practicalexam2dawnnarikkattumathews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowDBdata extends AppCompatActivity {


    ArrayList<RestaurantCart> al_rcitems;
    ListView lv_Items;

    private final static String TAG = "MainActivity";
    DatabaseHelper dbHelper= null;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_dbdata);
        dbHelper = new DatabaseHelper(this, getFilesDir().getAbsolutePath());


        lv_Items = (ListView) findViewById(R.id.listViewItems);
        al_rcitems = new ArrayList<>();


        try {
            dbHelper.prepareDatabase();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        showData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//           getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void showData() {

//		ArrayList<String> al_details = new ArrayList<>();
//		al_details = dbHelper.al_details();
//
//
//		for (int i=0; i<al_details.size();i++){
//			Log.e("Value",al_details.get(i));
//		}

//        List<RestaurantCart> list = dbHelper.getRestaurantItems();
//
//        StringBuffer data = new StringBuffer();
//        for (int i =0; i< list.size(); i++) {
//            RestaurantCart res = list.get(i);
//            data.append(res.getItem_name()).append(",").append(res.getItem_ingredients())
//                    .append(",").append(res.getItem_price()).append("<br/>");
//        }
//        TextView textView = (TextView)findViewById(R.id.bodytext);
//        textView.setText(Html.fromHtml(data.toString()));


        List<RestaurantCart> list = dbHelper.getRestaurantItems();

        StringBuffer data = new StringBuffer();
        for (int i =0; i< list.size(); i++) {
            RestaurantCart res = list.get(i);
            data.append(res.getItem_name()).append(",").append(res.getItem_ingredients())
                    .append(",").append(res.getItem_price()).append("<br/>");
            al_rcitems.add(new RestaurantCart(res.getItem_name(), res.getItem_price(), res.getItem_ingredients(), R.drawable.shrimp));

        }

        al_rcitems.add(new RestaurantCart("Shish Taouk", "3.95", "Saumon furne ,riz", R.drawable.shrimp));
        al_rcitems.add(new RestaurantCart("The Mile End bagel", "2.95", "Saumon frais, riz", R.drawable.sushi));
        al_rcitems.add(new RestaurantCart("Poutine", "2.95", "Tilapia, riz", R.drawable.tuna));

        listviewAdapter lvadapter = new listviewAdapter(getApplicationContext(), al_rcitems);
        lv_Items.setAdapter(lvadapter);


    }
}
