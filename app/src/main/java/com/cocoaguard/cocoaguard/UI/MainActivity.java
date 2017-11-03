package com.cocoaguard.cocoaguard.UI;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.cocoaguard.cocoaguard.R;

import java.util.Locale;


public class MainActivity extends AppCompatActivity
{
    //Class level buttons
    private Button cameraButton;
    private Button pesticideButton;
    private Button fungicideButton;
    private Button diseasesButton;
    private Button costEstimatorButton;
    private Button fertilizerButton;
    private Button socialMediaButton;
    private Button mapButton;

    //10 - 29 - 2016 updated the lock orientation and commented content main xml

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        // the buttons
        cameraButton = (Button) findViewById(R.id.buttonCamera);
        pesticideButton = (Button) findViewById(R.id.buttonPesticide);
        fungicideButton = (Button) findViewById(R.id.buttonFungicide);
        diseasesButton = (Button) findViewById(R.id.buttonDiseases);
        costEstimatorButton = (Button) findViewById(R.id.buttonCostEstimator);
        fertilizerButton = (Button) findViewById(R.id.buttonFertilizer);
        socialMediaButton = (Button) findViewById(R.id.buttonSocialMedia);
        mapButton = (Button) findViewById(R.id.buttonMaps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cameraButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }

        });

        pesticideButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                Intent startPesticide = new Intent(MainActivity.this, PesticideActivity.class);
                startActivity(startPesticide);
            }

        });

        fungicideButton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View view)
            {
                Intent startFungicide = new Intent(MainActivity.this, FungicideActivity.class);
                startActivity(startFungicide);
            }


        });

        diseasesButton.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View view)
            {
                Intent startDiseases = new Intent(MainActivity.this, DiseasesActivity.class);
                startActivity(startDiseases);
            }

        });

        costEstimatorButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent startCostEstimator = new Intent(MainActivity.this, CostEstimatorActivity.class);
                startActivity(startCostEstimator);
            }
        });

        fertilizerButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                Intent startFertilizer = new Intent(MainActivity.this, FertilizerActivity.class);
                startActivity(startFertilizer);
            }

        });

        socialMediaButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                Intent startSocialMedia = new Intent(MainActivity.this, SocialMediaActivity.class);
                startActivity(startSocialMedia);
            }

        });

        mapButton.setOnClickListener(new View.OnClickListener(){
            double latitude = 7.942206;
            double longitude = -1.269891;

            public void onClick(View view)
            {
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=8",latitude, longitude);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
