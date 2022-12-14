package com.example.appdoctruyen_cuoiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText editEmail,editPass,confirm;
    private Button btnSignUp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        editEmail = (EditText) findViewById(R.id.txtemail);
        editPass = (EditText) findViewById(R.id.passsignup);
        confirm = (EditText) findViewById(R.id.signupconfirm);

        ImageView signupback = findViewById(R.id.signupback);
        signupback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView signuplogin = findViewById(R.id.signuplogin);
        signuplogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpFireBase();
            }
        });

    }

    public void SignUpFireBase(){
        String email, pass , passconfirm;
        email = editEmail.getText().toString();
        pass = editPass.getText().toString();
        passconfirm = confirm.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Nh???p Email !",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Nh???p Password !",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(passconfirm)){
            Toast.makeText(this,"X??c nh???n Password !",Toast.LENGTH_SHORT).show();
            return;
        }

        if(!pass.equals(passconfirm)){
            Toast.makeText(this,"X??c nh???n Password sai!",Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"????ng k?? th??nh c??ng ! ",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"????ng k?? th???t b???i !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}