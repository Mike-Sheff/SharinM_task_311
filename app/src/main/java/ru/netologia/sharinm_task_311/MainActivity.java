package ru.netologia.sharinm_task_311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisplayResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        txtDisplayResult = findViewById(R.id.displayResult);

        Button btn0 = findViewById(R.id.button0);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button6);
        Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);
        Button btnPoint = findViewById(R.id.buttonPoint);

        Button btnDel = findViewById(R.id.buttonDelete);
        Button btnClear = findViewById(R.id.buttonClear);

        btn0.setOnClickListener(new NumberButtonClickListener());
        btn1.setOnClickListener(new NumberButtonClickListener());
        btn2.setOnClickListener(new NumberButtonClickListener());
        btn3.setOnClickListener(new NumberButtonClickListener());
        btn4.setOnClickListener(new NumberButtonClickListener());
        btn5.setOnClickListener(new NumberButtonClickListener());
        btn6.setOnClickListener(new NumberButtonClickListener());
        btn7.setOnClickListener(new NumberButtonClickListener());
        btn8.setOnClickListener(new NumberButtonClickListener());
        btn9.setOnClickListener(new NumberButtonClickListener());
        btnPoint.setOnClickListener(new NumberButtonClickListener());

        btnDel.setOnClickListener(new OperationButtonClickListener());
        btnClear.setOnClickListener(new OperationButtonClickListener());
    }

    class OperationButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (txtDisplayResult.getText().toString().equals("0")) {
                Toast.makeText(MainActivity.this, getString(R.string.textMessageDeleteOrClear), Toast.LENGTH_LONG).show();
            } else {
                switch (v.getId()) {
                    case R.id.buttonClear:
                        String display = txtDisplayResult.getText().toString();
                        if (display.length() == 1) {
                            txtDisplayResult.setText("0");
                        } else {
                            txtDisplayResult.setText(display.substring(0, display.length() - 1));
                        }
                        break;
                    case R.id.buttonDelete:
                        txtDisplayResult.setText("0");
                        break;
                }
            }
        }
    }

    class NumberButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String addText = "";
            String displayText = txtDisplayResult.getText().toString();

            switch (v.getId()) {
                case R.id.button0:
                    addText = "0";
                    break;
                case R.id.button1:
                    addText = "1";
                    break;
                case R.id.button2:
                    addText = "2";
                    break;
                case R.id.button3:
                    addText = "3";
                    break;
                case R.id.button4:
                    addText = "4";
                    break;
                case R.id.button5:
                    addText = "5";
                    break;
                case R.id.button6:
                    addText = "6";
                    break;
                case R.id.button7:
                    addText = "7";
                    break;
                case R.id.button8:
                    addText = "8";
                    break;
                case R.id.button9:
                    addText = "9";
                    break;
                case R.id.buttonPoint:
                    if (displayText.contains(".")) {
                        Toast.makeText(MainActivity.this, getString(R.string.textMessageTwoPoint), Toast.LENGTH_LONG).show();
                    } else {
                        if (displayText.equals("0")) {
                            addText = "0.";
                        } else {
                            addText = ".";
                        }
                    }
                    break;
            }

            if (displayText.equals("0")) {
                displayText = addText;
            } else {
                displayText += addText;
            }

            txtDisplayResult.setText(displayText);
        }
    }
}
