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

public class PesticideActivity extends AppCompatActivity
{
    private List<ModelData>  myPesticides = new ArrayList<ModelData>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesticide);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populatePesticideList();
        populateListView();


    }

    private void populatePesticideList()
    {
        myPesticides.add(new ModelData("Pesticide", "Malathion", R.drawable.malathion));
        myPesticides.add(new ModelData("...", "DDT", R.drawable.ddt));
        myPesticides.add(new ModelData("...", "Endosulfan", R.drawable.endosulfan));
        myPesticides.add(new ModelData("...", "Chlorpyrifos methyl", R.drawable.chlorpyrifos_methyl));
        myPesticides.add(new ModelData("...", "Chlorpyrifos", R.drawable.chlorpyrifos));
        myPesticides.add(new ModelData("...", "Permethrin", R.drawable.permethrin));
        myPesticides.add(new ModelData("...", "Thiabendazole", R.drawable.thiabendazole));
        myPesticides.add(new ModelData("...", "Carbaryl", R.drawable.carbaryl));

    }

    private void populateListView()
    {

        ArrayAdapter<ModelData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.pesticideListView);
        list.setAdapter(adapter);


    }

    private class MyListAdapter extends ArrayAdapter<ModelData>
    {
        public MyListAdapter()
        {
            super(PesticideActivity.this, R.layout.pesticide_item, myPesticides);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //make Sure we have view to work with
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.pesticide_item,parent,false);
            }

            //Find the fungicide to work with
            ModelData currentPesticide = myPesticides.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.pesticideeIcon);
            imageView.setImageResource(currentPesticide.getIconID());


            //shortName:
            TextView shortNameText = (TextView) itemView.findViewById(R.id.labelNameShort);
            shortNameText.setText(currentPesticide.getShortName());

            //shortname:
            TextView longNameText = (TextView) itemView.findViewById(R.id.labelNameLong);
            longNameText.setText(currentPesticide.getLongName());
            return itemView;

            //return super.getView(position, convertView, parent);
        }
    }
}
