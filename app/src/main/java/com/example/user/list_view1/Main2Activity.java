package com.example.user.list_view1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Intent t1;
    double num1 , d , sum1;
    int typeProj1;
    int i = 0;
    ListView lv1;
    Double[] array1;
    TextView tv1 , tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView1);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);

        lv1 = (ListView) findViewById(R.id.ListView1);
        lv1.setOnItemClickListener(this);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        array1 = new Double[20];
        ArrayAdapter<Double> adp;
        adp = new ArrayAdapter<Double>(this,R.layout.support_simple_spinner_dropdown_item , array1);
        lv1.setAdapter(adp);
        t1 = getIntent();
        num1 = t1.getDoubleExtra("firstNum", 1);
        typeProj1 = t1.getIntExtra("typeProj", 1);
        d = t1.getDoubleExtra("d", 1);
        array1[0] = num1;
        if (typeProj1 == 1) {
            num1 = t1.getDoubleExtra("firstNum", 1);
            for (i = 1; i < 20; i++) {
                array1[i] = num1 + d;
                num1 = num1 + d;
            }
        }
        if (typeProj1 == 2) {
            num1 = t1.getDoubleExtra("firstNum", 1);
            for (i = 1; i < 20; i++) {
                array1[i] = num1 * d;
                num1 = num1 * d;
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        num1 = t1.getDoubleExtra("firstNum", 1);
        tv1.setText("X1=  "+num1);
        tv2.setText("d=  " + d);
        tv3.setText("n=  "+ (position+1));
        sum1 = 0;
        for (i=0; i<=position; i++) {
            sum1 = array1[i] + sum1;
        }

        tv4.setText("Sn=  "+ sum1);
    }
}