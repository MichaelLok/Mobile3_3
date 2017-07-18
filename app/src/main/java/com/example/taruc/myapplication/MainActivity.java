package com.example.taruc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerAge;
    private TextView textViewPremium;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxSmoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        //Create an array
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setAdapter(adapter);
    }

    public void calculatePremium(View v) {
        double premium = 0;
        int gender = radioGroupGender.getCheckedRadioButtonId();
        int age = spinnerAge.getSelectedItemPosition();

            switch (age) {
                case 0:
                    premium += 50;
                    break;
                case 1:
                    premium +=55;
                    break;
                case 2:
                    premium += 60;
                    if (gender == R.id.radioButtonMale){
                        premium += 50;
                    }
                    break;
                case 3:
                    premium += 70;
                    if (gender == R.id.radioButtonMale){
                        premium += 100;
                    }
                    if (checkBoxSmoker.isChecked()) {
                        premium+=100;
                    }
                    break;
                case 4:
                    premium += 120;
                    if (gender == R.id.radioButtonMale){
                        premium += 100;
                    }
                    if (checkBoxSmoker.isChecked()) {
                        premium+=150;
                    }
                    break;
                case 5:
                    premium += 160;
                    if (gender == R.id.radioButtonMale){
                        premium += 50;
                    }
                    if (checkBoxSmoker.isChecked()) {
                        premium+=150;
                    }
                    break;
                case 6:
                    premium +=200;
                    if (gender == R.id.radioButtonMale){
                        premium +=0;
                    }
                    if (checkBoxSmoker.isChecked()) {
                        premium+=250;
                    }
                    break;
                case 7:
                    premium +=250;
                    if (checkBoxSmoker.isChecked()) {
                        premium += 250;

                    }

                    break;

            }
        textViewPremium.setText("Premium  :"+premium);
    }
}