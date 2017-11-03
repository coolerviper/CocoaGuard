package com.cocoaguard.cocoaguard.UI;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cocoaguard.cocoaguard.R;

public class CostEstimatorActivity extends AppCompatActivity
{

    private EditText laborText, fertilierText, pesticideText, transportationText, otherText, grossIncomeText;
    private Button calculate;
    private TextView resultTextView;
    private String labor, fertilizer, pesticide, transportation, other, income;
    private int laborNum, fertilizerNum, pesticideNum, transportationNum, otherNum, incomeNum;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_estimator);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        laborText = (EditText) findViewById(R.id.laborEditText);
        fertilierText = (EditText) findViewById(R.id.fertilizerEditText);
        pesticideText = (EditText) findViewById(R.id.pesticideEditText);
        transportationText = (EditText) findViewById(R.id.transportationEditText);
        otherText = (EditText) findViewById(R.id.otherEditText);
        grossIncomeText = (EditText) findViewById(R.id.incomeEditText);

        calculate = (Button) findViewById(R.id.calculateButton);

        resultTextView = (TextView) findViewById(R.id.resultsTextView);

        calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Calculator();
            }
        });

    }

    private String Calculator()
    {
       // double result = 0.0;
        int result = 0;

        labor = laborText.getText().toString();
        fertilizer = fertilierText.getText().toString();
        pesticide = pesticideText.getText().toString();
        transportation = transportationText.getText().toString();
        other = otherText.getText().toString();
        income = grossIncomeText.getText().toString();

//        laborNum = Double.parseDouble(labor);
//        fertilizerNum = Double.parseDouble(fertilizer);
//        pesticideNum = Double.parseDouble(pesticide);
//        transportationNum = Double.parseDouble(transportation);
//        otherNum = Double.parseDouble(other);
//        incomeNum = Double.parseDouble(income);

        laborNum = Integer.parseInt(labor);
        fertilizerNum = Integer.parseInt(fertilizer);
        pesticideNum = Integer.parseInt(pesticide);
        transportationNum = Integer.parseInt(transportation);
        otherNum = Integer.parseInt(other);
        incomeNum = Integer.parseInt(income);


        result = incomeNum - (laborNum + fertilizerNum + pesticideNum + transportationNum + otherNum);

//          String resultsView = Double.toString(result);
        String resultsView = Integer.toString(result);

        resultTextView.setText("Total Profit: GHC " + resultsView);

        return resultsView;
    }
}
