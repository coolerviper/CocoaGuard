package com.cocoaguard.cocoaguard.UI;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.cocoaguard.cocoaguard.Model.ModelData;
import com.cocoaguard.cocoaguard.R;
import com.cocoaguard.cocoaguard.description.FertilizerDescription;

import java.util.ArrayList;
import java.util.List;

public class FertilizerActivity extends AppCompatActivity
{
    private List<ModelData>  myFertilizers = new ArrayList<ModelData>();
    EditText fertilizerSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        populateFertilizerList();
        populateListView();




    }


    private void populateFertilizerList()
    {
        myFertilizers.add(new ModelData("NPK Fertilizer", "Phonska", R.drawable.phonska_pic));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
        myFertilizers.add(new ModelData("...", "...", R.drawable.cocoa_bean_default));
    }

    private void populateListView()
    {

        ArrayAdapter<ModelData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.fertilizerListView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {

               // String fertilizer = (String) adapterView.getItemAtPosition(i);

                if(i ==0)
                {
                    Intent s = new Intent(view.getContext(), FertilizerDescription.class);
                    startActivity(s);
                }



            }


        });

    }



    private class MyListAdapter extends ArrayAdapter<ModelData>
    {
        public MyListAdapter()
        {
            super(FertilizerActivity.this, R.layout.fertilizer_item, myFertilizers);

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //make Sure we have view to work with
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.fertilizer_item,parent,false);
            }

            //Find the fungicide to work with
            ModelData currentFertilizer = myFertilizers.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.fertilizerIcon);
            imageView.setImageResource(currentFertilizer.getIconID());


            //shortName:
            TextView shortNameText = (TextView) itemView.findViewById(R.id.labelNameShort);
            shortNameText.setText(currentFertilizer.getShortName());

            //shortname:
            TextView longNameText = (TextView) itemView.findViewById(R.id.labelNameLong);
            longNameText.setText(currentFertilizer.getLongName());
            return itemView;

            //return super.getView(position, convertView, parent);
        }



    }


}
