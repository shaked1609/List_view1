package com.example.user.list_view1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    RadioButton rab1,rab2;
    EditText et1,et2;
    double num1,d;
    int type1;
    Button b1;
    Intent int1;
    String st1, st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        et1 = (EditText) findViewById(R.id.firstNum);
        et2 = (EditText) findViewById(R.id.MultOrDif);
        rab1 = (RadioButton) findViewById(R.id.aritProg);
        rab2 = (RadioButton) findViewById(R.id.geoProg);
    }

    public void go(View view) {
        type1 = 0;
        int1 = new Intent(this, Main2Activity.class);
        st1 = et1.getText().toString();
        st2 = et2.getText().toString();

        if (rab1.isChecked())
            type1 = 1;
        else if (rab2.isChecked())
            type1 = 2;

        if ((st1.isEmpty()) || (st1.equals(".")) || (st1.equals("-")) || (st1.equals("-.") || st2.equals(".")) || (st2.equals("-.")) || (st2.isEmpty()) || (st2.equals("-")) || ((type1!=1)&&(type1!=2)) )
            Toast.makeText(this, "you must enter a appropriate input", Toast.LENGTH_SHORT).show();
        else {
            num1 = Double.parseDouble(st1);
            d = Double.parseDouble(st2);
            int1.putExtra("typeProj", type1);
            int1.putExtra("firstNum", num1);
            int1.putExtra("d", d);
            startActivity(int1);
        }
    }

    public void credits(View view) {
        Intent t2 = new Intent(this, Main3Activity.class);
        startActivity(t2);
    }
}