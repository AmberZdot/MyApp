package com.example.user.myapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CheckBox.OnCheckedChangeListener{
    CheckBox cb_basket;
    CheckBox cb_base;
    CheckBox cb_bedm;
    TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_basket=(CheckBox)findViewById(R.id.cbBasket);
        cb_base=(CheckBox)findViewById(R.id.cbBase);
        cb_bedm=(CheckBox)findViewById(R.id.cbBedm);
        tv_show=(TextView)findViewById(R.id.tvShow);

        cb_basket.setOnCheckedChangeListener(this);
        cb_base.setOnCheckedChangeListener(this);
        cb_bedm.setOnCheckedChangeListener(this);
    }
    public void showResult(){
        int count=0;
        if(cb_basket.isChecked() ){
            tv_show.setText(cb_basket.getText().toString());
            count++;
            }
        if(cb_base.isChecked()) {
            tv_show.setText(tv_show.getText()+cb_base.getText().toString());
            count++;
        }
        if(cb_bedm.isChecked()) {
            tv_show.setText(tv_show.getText()+cb_bedm.getText().toString());
            count++;
        }
        tv_show.setText(tv_show.getText()+ Integer.toString(count));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        showResult();
    }
}

