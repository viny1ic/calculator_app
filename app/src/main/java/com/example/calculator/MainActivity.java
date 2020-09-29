package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText N1, Operand, N2;
    Button BtnCalculate;
    TextView Answer;
    float number1, number2, ans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Answer = findViewById(R.id.Answer);
        Answer.setVisibility(View.GONE);

        N1 = findViewById(R.id.N1);
        N2 = findViewById(R.id.N2);
        Operand = findViewById(R.id.operand);
        BtnCalculate = findViewById(R.id.BtnCalculate);

        BtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = N1.getText().toString().trim();
                String n2 = N2.getText().toString().trim();
                String oper = Operand.getText().toString().trim();
                try{
                    number1 = Float.parseFloat(n1);
                    number2 = Float.parseFloat(n2);
                }
                catch (Exception e){
                    Answer.setText("invalid input");
                    Answer.setVisibility(View.VISIBLE);
                }
                if(oper.equals("+")) {
                    ans = number1 + number2;
                    Answer.setText(String.valueOf(ans));
                }
                else if(oper.equals("-")){
                    ans = number1 - number2;
                    Answer.setText(String.valueOf(ans));
                }
                else if(oper.equals("*")){
                    ans = number1 * number2;
                    Answer.setText(String.valueOf(ans));
                }
                else if(oper.equals("/")){
                    if(number2==0)
                        Answer.setText("Cannot divide by 0");
                    else {
                        ans = number1 / number2;
                        Answer.setText(String.valueOf(ans));
                    }
                }
                else
                    Answer.setText("invalid operand");
                Answer.setVisibility(View.VISIBLE);

            }


                });
    }
}