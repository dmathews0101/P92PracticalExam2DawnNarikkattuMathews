package com.p92practicalexam2dawnnarikkattumathews;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ArrayList<SelectedCart> al_scitems;
    ListView lv_Items;
    Button showorders;
    Button mainmenubtn;
    Button showdbdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        lv_Items = (ListView) findViewById(R.id.listViewItems);
        showorders = (Button) findViewById(R.id.btnseeorder);
        mainmenubtn = (Button) findViewById(R.id.btnmainmenu);
        showdbdata = (Button) findViewById(R.id.btnshowdbdata);


        lv_Items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Object listItem = list.getItemAtPosition(position);


                Toast.makeText(getApplicationContext(),"An item was clicked" ,Toast.LENGTH_SHORT).show();
                AlertDialog alertDialog = new AlertDialog.Builder(OrderActivity.this).create();
                alertDialog.setTitle("Show Details ...");
                alertDialog.setMessage("Product Name");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });

        al_scitems = new ArrayList<>();

        al_scitems.add(new SelectedCart("Kunsei Sake", "3", "3.95", "11.85000", R.drawable.tuna));

        al_scitems.add(new SelectedCart("Tai", "4", "2.95","11.8", R.drawable.shrimp));
        al_scitems.add(new SelectedCart("Maguro", "1","4.5","4.5", R.drawable.sushi));


        listviewAdapter2 lvadapter = new listviewAdapter2(getApplicationContext(), al_scitems);
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
