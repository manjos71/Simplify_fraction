package com.math.anjos71.simplify_fraction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView lblGCD, lblNum, lblDen, lblDiv;
    EditText n1, n2;
    Button ex, rs;
    String op, st, eq, v1, v2, blk;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//find elements
        lblGCD = (TextView) findViewById(R.id.lblGCD);
        lblNum = (TextView) findViewById(R.id.lblNum);
        lblDen = (TextView) findViewById(R.id.lblDen);
        lblDiv = (TextView) findViewById(R.id.lblDiv);
        n1 = (EditText) findViewById(R.id.txtNum);
        n2 = (EditText) findViewById(R.id.txtDen);
        ex = (Button) findViewById(R.id.button1);
        rs = (Button) findViewById(R.id.button2);

// Set a listener
        ex.setOnClickListener(this);
        rs.setOnClickListener(this);
    }

    public int gcd(int a, int b) {

        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public void onClick(View v) {

        if (n1.getText().toString().isEmpty() || n2.getText().toString().isEmpty()) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage(R.string.Message);
            dlg.setNeutralButton("OK", null);
            dlg.show();
            return;
        }

        int a = Integer.parseInt(n1.getText().toString());
        int b = Integer.parseInt(n2.getText().toString());
        int c = gcd(a, b);
        int v1 = 0;
        int v2 = 0;

        switch (v.getId()) {
            case R.id.button1:
                v1 = Integer.parseInt(n1.getText().toString());
                v2 = Integer.parseInt(n2.getText().toString());
                op = " / ";
                st = " ";
                eq = " = ";
                a = (int) (v1 / c);
                b = (int) (v2 / c);
                lblGCD.setText(st + eq + c);
                lblNum.setText(st + a);
                lblDen.setText(st + b);
                lblDiv.setText(" _________ ");
                break;
            case R.id.button2:
                //("")<>(" ") não sobrescreve o hint
                n1.setText("");
                n2.setText("");
                lblGCD.setText(" ");
                lblNum.setText(" ");
                lblDiv.setText(" ");
                lblDen.setText(" ");
                n1.requestFocus();
                break;
            default:
                break;
        }
    }
}