package com.example.realtimesysconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mBinaryEditText,mOctalEditText,mDecimalEditText,mHexaEditText;
    boolean isInBinary=false,isInOctal=false;
    int sValue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinaryEditText=findViewById(R.id.binary_editText);
        mOctalEditText=findViewById(R.id.octal_editText);
        mDecimalEditText=findViewById(R.id.decimal_editText);
        mHexaEditText=findViewById(R.id.hexadecimal_editText);

        mBinaryEditText.setText("");
        mOctalEditText.setText("");
        mDecimalEditText.setText("");
        mHexaEditText.setText("");

        /** ظبط مين لما يتداس يشتغل*/
        mBinaryEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this,"binary clicked",Toast.LENGTH_SHORT).show();
                BinaryTextListener();
                return false;
            }
        });
        mOctalEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this,"octal clicked",Toast.LENGTH_SHORT).show();
                OctalTextListener();
                return false;
            }
        });

    }


    public void BinaryTextListener()
    {
        Toast.makeText(MainActivity.this,"binary",Toast.LENGTH_SHORT).show();
        mBinaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try{

                    String v = mBinaryEditText.getText().toString();
                    Long l = new Long(v);
                    FromBinary fromBinary = new FromBinary(l);
                    mOctalEditText.setText(String.valueOf(fromBinary.Octal));
                    mDecimalEditText.setText(String.valueOf(fromBinary.Decimal));
                    mHexaEditText.setText(fromBinary.Hexa);

                }catch (Exception e){

                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    Log.d("BinField",e.getMessage());
                    mOctalEditText.setText("");
                    mDecimalEditText.setText("");
                    mHexaEditText.setText(e.getMessage());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void OctalTextListener()
    {
        Toast.makeText(MainActivity.this,"octal",Toast.LENGTH_SHORT).show();
        mOctalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {

                    String v = mOctalEditText.getText().toString();
                    int l = Integer.parseInt(v);
                    FromOctal fromOctal = new FromOctal(l);
                    mBinaryEditText.setText(String.valueOf(fromOctal.Binary));
                    mDecimalEditText.setText(String.valueOf(fromOctal.Decimal));
                    mHexaEditText.setText(fromOctal.Hexa);
                } catch (Exception e) {

                    Log.d("OctField",e.getMessage());
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    mBinaryEditText.setText("");
                    mDecimalEditText.setText("");
                    mHexaEditText.setText(e.getMessage());
                }


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
