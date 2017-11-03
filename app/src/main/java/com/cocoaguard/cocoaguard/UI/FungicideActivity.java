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

public class FungicideActivity extends AppCompatActivity
{
    private List<ModelData>  myFungicides = new ArrayList<ModelData>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fungicide);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateFungicideList();
        populateListView();


    }

    private void populateFungicideList()
    {
        myFungicides.add(new ModelData("copper hydroxide", "Kocide", R.drawable.kocide));
        myFungicides.add(new ModelData("cymoxanil/mancozeb", "Fungarrest", R.drawable.fungarrest));
        myFungicides.add(new ModelData("sulfur", "Striker", R.drawable.striker));
        myFungicides.add(new ModelData("propiconazole", "Fungi Rid", R.drawable.fungi_rid));
        myFungicides.add(new ModelData("prochloraz", "Omega", R.drawable.omega));
        myFungicides.add(new ModelData("fenhexamid", "Teldor 500 SC", R.drawable.teldor_500));
        myFungicides.add(new ModelData("cymoxanil/mancozeb", "Curzate Pro", R.drawable.curzate_pro));
        myFungicides.add(new ModelData("fosetyl-Al", "Alliete WG", R.drawable.aliette));
        myFungicides.add(new ModelData("mancozeb/cymoxanil", "Micexanil", R.drawable.micexanil));
    }

    private void populateListView()
    {

        ArrayAdapter<ModelData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.fungicideListView);
        list.setAdapter(adapter);


    }

    private class MyListAdapter extends ArrayAdapter<ModelData>
    {
        public MyListAdapter()
        {
            super(FungicideActivity.this, R.layout.fungicide_item, myFungicides);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //make Sure we have view to work with
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.fungicide_item,parent,false);
            }

            //Find the fungicide to work with
            ModelData currentFungicide = myFungicides.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.fungicideIcon);
            imageView.setImageResource(currentFungicide.getIconID());


            //shortName:
            TextView shortNameText = (TextView) itemView.findViewById(R.id.labelNameShort);
            shortNameText.setText(currentFungicide.getShortName());

            //shortname:
            TextView longNameText = (TextView) itemView.findViewById(R.id.labelNameLong);
            longNameText.setText(currentFungicide.getLongName());
            return itemView;

            //return super.getView(position, convertView, parent);
        }
    }


}
