package com.example.enquiry1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.enquiry1.adapter.Entery_adapter;
import com.example.enquiry1.model.entry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

     private TextView YourDashboard;
     private TextView YourEntries;
     private TextView NewEntries;
     private Button GoBack;
     FloatingActionButton add;
     Button submit;
     EditText name,num,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView rv=findViewById(R.id.rv_entry);
        getSupportActionBar().setTitle("Dashboard");
        add =  findViewById(R.id.fab_add);
        submit = findViewById(R.id.submit);
        name = findViewById(R.id.et_add_name);
        num = findViewById(R.id.et_add_num);
        date = findViewById(R.id.et_add_time);

        ArrayList<entry> list = new ArrayList<>();

        list.add(new entry("prakhar","+91 12345678","18:00"));
        list.add(new entry("Tandon","+91 12345678","07:00"));
        list.add(new entry("Sonu","+91 12345678","8 DEC"));
        list.add(new entry("Sahil","+91 12345678","7 DEC"));

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Entery_adapter(this,list));
        rv.setHasFixedSize(true);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setVisibility(View.GONE);
                findViewById(R.id.lay_add).setVisibility(View.VISIBLE);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(new entry(name.getText().toString(),num.getText().toString(),date.getText().toString()));
                rv.getAdapter().notifyDataSetChanged();
                add.setVisibility(View.VISIBLE);
                findViewById(R.id.lay_add).setVisibility(View.GONE);
                num.setText("");
                name.setText("");
                date.setText("");
            }
        });
    }

}