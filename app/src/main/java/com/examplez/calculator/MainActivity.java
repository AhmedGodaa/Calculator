package com.examplez.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.examplez.calculator.databinding.ActivityMainBinding;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String process;
    boolean checkBracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvInput.setText("");
                binding.tvOutput.setText("");
            }
        });
        binding.btnZero.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "0");


        });
        binding.btn1.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "1");


        });
        binding.btn2.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "2");


        });
        binding.btn3.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "3");


        });
        binding.btn4.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "4");


        });
        binding.btn5.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "5");


        });
        binding.btn6.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "6");


        });
        binding.btn7.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "7");


        });
        binding.btn8.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "8");


        });
        binding.btn9.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "9");


        });
        binding.btnPlus.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "+");


        });
        binding.btnsubtract.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "-");


        });
        binding.btnDivision.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "/");


        });
        binding.btnMultiplication.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + "*");


        });
        binding.btnDot.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            binding.tvInput.setText(process + ".");


        });


        binding.btnBrackets.setOnClickListener(v -> {
            if (checkBracket) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + ")");
                checkBracket = false;
            } else {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "(");
                checkBracket = true;
            }

        });
        binding.btnEqual.setOnClickListener(v -> {
            process = binding.tvInput.getText().toString();
            process = process.replaceAll("x", "*");
            process = process.replaceAll("%", "/100");
            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);
            String finalResult = "";
            try {
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();


            } catch (Exception e) {
                finalResult = "0";

            }
            binding.tvOutput.setText(finalResult);


        });
    }
}