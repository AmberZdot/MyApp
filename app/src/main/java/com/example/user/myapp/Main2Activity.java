package com.example.user.myapp;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    RadioButton rb_m, rb_nm;
    EditText ed_b1, ed_b2, ed_b3;
    CheckBox cb_s, cb_p;
    Button bt_sub;
    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rb_m=(RadioButton)findViewById(R.id.rbM);
        rb_nm=(RadioButton)findViewById(R.id.rbNM);
        ed_b1=(EditText)findViewById(R.id.etQty1);
        ed_b2=(EditText)findViewById(R.id.etQty2);
        ed_b3=(EditText)findViewById(R.id.etQty3);
        cb_p=(CheckBox)findViewById(R.id.cbProtect);
        cb_s=(CheckBox)findViewById(R.id.cbShipping);
        bt_sub=(Button)findViewById(R.id.btnSub);
        show=(TextView)findViewById(R.id.tvShow);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showResult(View sum){
        double total=0;
        double discnt=0.9;
        double shipping=1000;
        double protect=2000;
        int b1=Integer.parseInt(ed_b1.getText().toString());
        int b1price=2;
        int b2=Integer.parseInt(ed_b2.getText().toString());
        int b2price=20;
        int b3=Integer.parseInt(ed_b3.getText().toString());
        int b3price=300;

        if(rb_m.isChecked()){
            total=(b1*b1price+b2*b2price+b3*b3price)*discnt;
            if(cb_s.isChecked()){
                total=total+shipping;
            }
            if(cb_p.isChecked()) {
                total = total + protect;
            }
            DecimalFormat df= new DecimalFormat("#,###.##");
            total=Double.parseDouble(df.format(total));
            show.setText(Double.toString(total));
        }
        else{
            total=(double)(b1*b1price+b2*b2price+b3*b3price);
            if(cb_s.isChecked()){
                total=total+shipping;
            }
            if(cb_p.isChecked()){
                total=total+protect;
            }
            DecimalFormat df= new DecimalFormat("#,###.##");
            total=Double.parseDouble(df.format(total));
            show.setText(Double.toString(total));
        }
    }
}
