package com.mncemngadi.inchestometer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText inchesEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesEditString = inchesEditText.getText().toString();

                if(inchesEditString.isEmpty()){

                    Toast.makeText(MainActivity.this,"Please insert a value",Toast.LENGTH_SHORT);

                }else{

                    displayResult(inchesEditString);


                }
            }
        });
    }

    private void findViews(){

        inchesEditText = findViewById(R.id.edit_text_inches);
        resultTextView = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);


    }

    private double calculateHeight(String inchesString) {

        int inches = Integer.parseInt(inchesString);

        return inches  * 0.0254;
    }
    private void displayResult(String inchesEditString) {
        double result = calculateHeight(inchesEditString);
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);

        resultTextView.setText(resultString+" Meters");
    }




}