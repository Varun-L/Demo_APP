package com.icy.myapplication99;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    String radioValue,spinnerValue;
    String[] checkboxOutput;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        checkboxOutput = new String[]{"", "", ""};
        radioValue="";
        spinnerValue="";

        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerValue = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

       Button b1= findViewById(R.id.button8);
        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity3.this,MainActivity4.class));
                return true;
            }
        });
    }

    public void cC(View view){

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){

            case R.id.checkBox:
                if(checked)
                checkboxOutput[0] = "C#";
                else checkboxOutput[0]="";
                break;
            case R.id.checkBox2:
                if(checked)
                checkboxOutput[1] = "Java";
                else checkboxOutput[1]="";
                break;
            case R.id.checkBox3:
                if(checked)
                checkboxOutput[2] = "Python";
                else checkboxOutput[2]="";
                break;
        }
    }

    public void rB(View view){
                radioValue= String.valueOf(((RadioButton) view).getText());
        }

        public  void a3fun1(View view){

        String s = "";
        s+= "You are good at: \n";
        s+= checkboxOutput[0]+" "+checkboxOutput[1]+" "+checkboxOutput[2];
        s += "\n";
        s+= "You are studying ";
        s+= radioValue;
        s += "\n";
        s+= "You are Living in ";
        s+= spinnerValue;

            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        }

}