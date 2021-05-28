package com.example.tranminhnghiaandroidthithu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    EditText edtEmail, edtPassword;
    Button btnDangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhaplayout);
        btnDangnhap=this.findViewById(R.id.btnDangnhap);

        auth = FirebaseAuth.getInstance();
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fmDangnhap(v);
            }
        });
    }
    public void fmDangnhap(View v){
        edtEmail = this.findViewById(R.id.edtEmail);
        edtPassword = this.findViewById(R.id.edtMatkhau);
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Dang nhap thanh cong.",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "That bai.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}