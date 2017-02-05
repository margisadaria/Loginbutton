package com.example.margi.practical3_96;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userET,passwordET;
    Button btnSubmit,btnclear;
    String uname="margi";
    String password="margi";
    boolean usrstatus,pwdstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userET = (EditText) findViewById(R.id.etuname);
        passwordET = (EditText) findViewById(R.id.etpassword);


        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setEnabled(false);
        btnclear = (Button) findViewById(R.id.btnclear);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MainActivity.this,userET.getText().toString().concat("         congratulation yu ar succesfully login"),Toast.LENGTH_LONG).show();
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener()
        {
          //final EditText uname = (EditText) findViewById(R.id.etuname);
         //final EditText  password = (EditText) findViewById(R.id.etpassword);

            @Override
            public void onClick(View view)
            {
                userET.setText("");
                passwordET.setText("");
            }
        });

        userET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                        if(uname.equals(userET.getText().toString()))
                        {
                           usrstatus=true;
                        }else
                        {
                             usrstatus=false;
                        }

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if (usrstatus&&pwdstatus)
                {
                    btnSubmit.setEnabled(true);
                }
                else {
                    btnSubmit.setEnabled(false);
                }
            }
        });
       passwordET.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
           {
                    if(password.equals(passwordET.getText().toString()))
                    {
                        pwdstatus=true;
                    }
               else
                    {
                        pwdstatus=false;
                    }
           }

           @Override
           public void afterTextChanged(Editable editable)
           {
               if (usrstatus&&pwdstatus)
               {
                   btnSubmit.setEnabled(true);
               }
               else {
                   btnSubmit.setEnabled(false);
               }

           }
       });
    }
}
