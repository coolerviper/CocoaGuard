package com.cocoaguard.cocoaguard.UI;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.cocoaguard.cocoaguard.Model.ModelData;
import com.cocoaguard.cocoaguard.R;

import java.util.ArrayList;
import java.util.List;

public class DiseasesActivity extends AppCompatActivity
{

    private List<ModelData>  myDiseases = new ArrayList<ModelData>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateDiseasesList();
        populateListView();

    }


    private void populateDiseasesList()
    {
        myDiseases.add(new ModelData("Fungus","Witches' Broom", R.drawable.witches_broom));
        myDiseases.add(new ModelData( "Fungus","Frosty pod Rot", R.drawable.frosty_pod_rot));
        myDiseases.add(new ModelData( "Fungus","Phytophthora pod rot", R.drawable.phytophthora_pod_rot));
        myDiseases.add(new ModelData( "Fungus","Black Pod Disease", R.drawable.black_pod));


    }

    private void populateListView()
    {
        ArrayAdapter<ModelData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.diseasesListView);
        list.setAdapter(adapter);

    }

    private class MyListAdapter extends ArrayAdapter<ModelData>
    {
        public MyListAdapter()
        {
            super(DiseasesActivity.this, R.layout.diseases_item, myDiseases);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //make Sure we have view to work with
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.diseases_item,parent,false);
            }

            //Find the fungicide to work with
            ModelData currentDiseases = myDiseases.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.diseasesIcon);
            imageView.setImageResource(currentDiseases.getIconID());


            //shortName:
            TextView shortNameText = (TextView) itemView.findViewById(R.id.labelNameShort);
            shortNameText.setText(currentDiseases.getShortName());

            //shortname:
            TextView longNameText = (TextView) itemView.findViewById(R.id.labelNameLong);
            longNameText.setText(currentDiseases.getLongName());
            return itemView;

        }
    }




}
