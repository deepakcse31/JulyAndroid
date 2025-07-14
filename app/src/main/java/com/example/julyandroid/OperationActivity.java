package com.example.julyandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OperationActivity extends AppCompatActivity {
    EditText edfirstNo,edtsecondNo;
    Button btnsum;
    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_operation);
        edfirstNo=findViewById(R.id.edt1);
        edtsecondNo=findViewById(R.id.edt2);
        btnsum=findViewById(R.id.btnsum);
        textView=findViewById(R.id.tvresult);

        btnsum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input1=edfirstNo.getText().toString();
                String input2=edtsecondNo.getText().toString();

                int num1=Integer.parseInt(input1);
                int num2=Integer.parseInt(input2);

                int sum=num1+num2;

                String result=String.valueOf(sum);

                textView.setText(result);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}