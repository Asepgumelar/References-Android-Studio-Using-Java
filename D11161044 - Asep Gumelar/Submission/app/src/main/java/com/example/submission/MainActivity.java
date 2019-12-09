package com.example.submission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collections;
import android.content.res.TypedArray;

public class MainActivity extends AppCompatActivity {
    private RecyclerView list_item;
    private ArrayList<Motorcycle> MotorcycleData;
    private MotorcyclesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list_item = (RecyclerView)findViewById(R.id.list_items);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        list_item.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        MotorcycleData = new ArrayList<>();
        mAdapter = new MotorcyclesAdapter(this, MotorcycleData);
        list_item.setAdapter(mAdapter);
        initializeData();
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

    }

    private void initializeData() {
        String[] imageTitle = getResources().getStringArray(R.array.images_title);
        String[] imagePrice = getResources().getStringArray(R.array.images_price);
        String[] imageDesc = getResources().getStringArray(R.array.images_desc);
        TypedArray MotorcyclesImageResources = getResources().obtainTypedArray(R.array.images_src);
        MotorcycleData.clear();
        for(int i=0; i<imageTitle.length; i++){
            MotorcycleData.add(new Motorcycle(imageTitle[i], imagePrice[i], imageDesc[i],
                    MotorcyclesImageResources.getResourceId(i,0)));
        }
        MotorcyclesImageResources.recycle();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
                default:
        }
        return super.onOptionsItemSelected(item);
    }
}
