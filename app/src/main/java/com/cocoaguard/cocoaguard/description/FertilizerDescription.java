package com.cocoaguard.cocoaguard.description;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cocoaguard.cocoaguard.R;

public class FertilizerDescription extends AppCompatActivity {


    private Button informationButton, ingredientsButton, usageButton, warningsButton, resetButton;
    private ImageView picture;
    private TextView infoText, nameText, ingredientsText, usageText, warningsText;
    private ScrollView infoScrollView, ingredientsScrollView, usageScrollView, warningsScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Buttons
        informationButton = (Button) findViewById(R.id.buttonInformationDesc);
        ingredientsButton = (Button) findViewById(R.id.buttonIngredientsDesc);
        usageButton = (Button) findViewById(R.id.buttonUsageDesc);
        warningsButton = (Button) findViewById(R.id.buttonWarningsDesc);
        resetButton = (Button) findViewById(R.id.buttonReset);
        //ImageView
        picture = (ImageView)findViewById(R.id.fertilizerImage);
        //TextView
        infoText = (TextView) findViewById(R.id.labelInfoDesc);
        nameText = (TextView) findViewById(R.id.labelNameDesc);
        ingredientsText = (TextView) findViewById(R.id.labelIngredientsDesc);
        usageText = (TextView) findViewById(R.id.labelUsageDesc);
        warningsText = (TextView) findViewById(R.id.labelWarningsDesc);
        //Scroll Views
        infoScrollView = (ScrollView) findViewById(R.id.scrollViewInfo);
        ingredientsScrollView = (ScrollView) findViewById(R.id.scrollViewIngredients);
        usageScrollView = (ScrollView) findViewById(R.id.scrollViewUsage);
        warningsScrollView = (ScrollView) findViewById(R.id.scrollViewWarning);


        //This method will show the default layout of having the 4 main buttons visible
        showButtons();







        //Set string for the info box
        infoText.setText("A type of fertilizer subsidized by the government so the price is cheap and affordable to farmers." +
                " Referred to as a compound fertilizer consisting of several macro nutrients. " +
                "The fertilizer is known to increase agriculture production (yield) and quality at a cheap cost. ");

        nameText.setText("Phonska");

        ingredientsText.setText("Nitrogen (N) - 15%\n" +
                "P2O5 (Fosfat) - 15%\n" +
                "K2O (Kalium) - 15%\n" +
                "Sulfur (S) - 10%\n" +
                "Water content maximum - 2%\n");

        usageText.setText("Measure out proper fertilizer amount to use based on land size (can be measured weight)\n\n" +
                "Dig a hole to put the fertilizer into at the base of the tree\n\n" +
                "Fill the hole back in and perform consistent maintenance\n\n");

        warningsText.setText("Plant fertilizer and household plant food poisoning can occur if someone swallows these substances.\n\n" +
                "Plant fertilizers are mildly poisonous if swallowed in small doses. Larger doses can be harmful to children. Touching large " +
                "quantities of plant fertilizers may cause severe burns.\n\n" +
                "Poisonous ingredients include:\n" +
                "Nitrates and Nitrites " +
                "\n\nSymptoms of poison: \n" +
                "Blue-colored fingernails, lips, or palms of the hand, " +
                "Burning skin, " +
                "Burning of the throat, nose, and eyes, " +
                "Dizziness, " +
                "Fainting, " +
                "Itchy skin, " +
                "Low blood pressure, " +
                "Seizures, " +
                "Shortness of breath, " +
                "Skin redness, " +
                "Stomach pain, " +
                "and Upset stomach\n\n\n\n");



        informationButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                hideButtons();
                infoScrollView.setVisibility(View.VISIBLE);
                infoText.setVisibility(View.VISIBLE);




            }

        });

        ingredientsButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {

                hideButtons();
                ingredientsScrollView.setVisibility(View.VISIBLE);
                ingredientsText.setVisibility(View.VISIBLE);
            }

        });
        usageButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {

                hideButtons();
                usageScrollView.setVisibility(View.VISIBLE);
                usageText.setVisibility(View.VISIBLE);
            }

        });
        warningsButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {

                hideButtons();
                warningsScrollView.setVisibility(View.VISIBLE);
                warningsText.setVisibility(View.VISIBLE);

            }

        });

        resetButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view)
            {
                showButtons();

            }

        });












    }


    public void showButtons()
    {
        informationButton.setVisibility(View.VISIBLE);
        ingredientsButton.setVisibility(View.VISIBLE);
        usageButton.setVisibility(View.VISIBLE);
        warningsButton.setVisibility(View.VISIBLE);
        picture.setVisibility(View.VISIBLE);
        nameText.setVisibility(View.VISIBLE);


        infoText.setVisibility(View.INVISIBLE);
        ingredientsText.setVisibility(View.INVISIBLE);
        usageText.setVisibility(View.INVISIBLE);
        warningsText.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
        ingredientsScrollView.setVisibility(View.INVISIBLE);
        infoScrollView.setVisibility(View.INVISIBLE);
        usageScrollView.setVisibility(View.INVISIBLE);
        warningsScrollView.setVisibility(View.INVISIBLE);




    }

    public void hideButtons()
    {
        informationButton.setVisibility(View.INVISIBLE);
        ingredientsButton.setVisibility(View.INVISIBLE);
        usageButton.setVisibility(View.INVISIBLE);
        warningsButton.setVisibility(View.INVISIBLE);
        picture.setVisibility(View.INVISIBLE);
        nameText.setVisibility(View.INVISIBLE);

        nameText.setVisibility(View.VISIBLE);
        picture.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.VISIBLE);
    }

}
