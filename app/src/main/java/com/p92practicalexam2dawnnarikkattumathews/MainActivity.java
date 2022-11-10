package com.p92practicalexam2dawnnarikkattumathews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RestaurantCart> al_rcitems;
    ListView lv_Items;
    Button showorders;
    Button mainmenubtn;
    Button showdbdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_Items = (ListView) findViewById(R.id.listViewItems);
        showorders = (Button) findViewById(R.id.btnseeorder);
        mainmenubtn = (Button) findViewById(R.id.btnmainmenu);
        showdbdata = (Button) findViewById(R.id.btnshowdbdata);


        lv_Items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Object listItem = list.getItemAtPosition(position);


                Toast.makeText(getApplicationContext(),"An item was clicked" ,Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Would you like to buy ...");
                alertDialog.setMessage("Select Okay to confirm to buy");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Buy",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });

        al_rcitems = new ArrayList<>();

        al_rcitems.add(new RestaurantCart("Shish Taouk", "3.95", "Saumon furne ,riz", R.drawable.shrimp));
        al_rcitems.add(new RestaurantCart("The Mile End bagel", "2.95", "Saumon frais, riz", R.drawable.sushi));
        al_rcitems.add(new RestaurantCart("Poutine", "2.95", "Tilapia, riz", R.drawable.tuna));
        al_rcitems.add(new RestaurantCart("Smoked meat", "3.95", "Saumon", R.drawable.shrimp));
        al_rcitems.add(new RestaurantCart("Shish Taouk", "4.5", "Saumon abc", R.drawable.shrimp));
        al_rcitems.add(new RestaurantCart("Steamies", "5", "Saumon kk", R.drawable.sushi));
        al_rcitems.add(new RestaurantCart("Shish Taouk", "9", "Saumon a", R.drawable.tuna));
        al_rcitems.add(new RestaurantCart("Poutine", "1", "Saumon b", R.drawable.sushi));
        al_rcitems.add(new RestaurantCart("The Mile End bagel", "13", "Saumon c", R.drawable.tuna));
        al_rcitems.add(new RestaurantCart("Steamies", "7", "Saumon d", R.drawable.sushi));

        listviewAdapter lvadapter = new listviewAdapter(getApplicationContext(), al_rcitems);
        lv_Items.setAdapter(lvadapter);


        showorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OrderActivity.class);
                //intent.putExtra("id",0);
                startActivity(intent);            }
        });

        mainmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OptionsPage.class);
                //intent.putExtra("id",0);
                startActivity(intent);
            }
        });

        showdbdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShowDBdata.class);
                //intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }
}
