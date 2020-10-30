package dev.rezaur.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView subPanel;
    private TextView mainPanel;
    private Double firstNumber;
    private Double secondNumber;
    private boolean plusFlag = false;
    private boolean minusFlag = false;
    private boolean multiplyFlag = false;
    private boolean divideFlag = false;
    private boolean ansFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPanel = findViewById(R.id.subPanel);
        mainPanel = findViewById(R.id.mainPanel);
    }

    public void falseAllFlag() {
        plusFlag = false;
        minusFlag = false;
        multiplyFlag = false;
        divideFlag = false;
        ansFlag = false;
    }

    public void clearMethod(View view) {
        mainPanel.setText("");
        subPanel.setText("");
        falseAllFlag();
    }

    public void plusMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(!mainPanel.getText().toString().trim().equals("")) {
            plusFlag = true;
            firstNumber = new Double(mainPanel.getText().toString().trim());
            subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim() + "+");
            mainPanel.setText("");
        }
    }

    public void minusMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(!mainPanel.getText().toString().trim().equals("") && !mainPanel.getText().toString().trim().equals("-")) {
            minusFlag = true;
            firstNumber = new Double(mainPanel.getText().toString().trim());
            subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim() + "-");
            mainPanel.setText("");
        } else {
            mainPanel.setText(mainPanel.getText().toString().trim() + "-");
        }
    }

    public void multiplyMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(!mainPanel.getText().toString().trim().equals("")) {
            multiplyFlag = true;
            firstNumber = new Double(mainPanel.getText().toString().trim());
            subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim() + "*");
            mainPanel.setText("");
        }
    }

    public void divideMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(!mainPanel.getText().toString().trim().equals("")) {
            divideFlag = true;
            firstNumber = new Double(mainPanel.getText().toString().trim());
            subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim() + "/");
            mainPanel.setText("");
        }
    }

    public void equalMethod(View view) {
        if(!mainPanel.getText().toString().trim().equals("")) {
            if (plusFlag) {
                ansFlag = true;
                secondNumber = new Double(mainPanel.getText().toString().trim());
                subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim());
                mainPanel.setText((firstNumber + secondNumber) + "");
                plusFlag = false;
            } else if (minusFlag) {
                ansFlag = true;
                secondNumber = new Double(mainPanel.getText().toString().trim());
                subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim());
                mainPanel.setText((firstNumber - secondNumber) + "");
                minusFlag = false;
            } else if (multiplyFlag) {
                ansFlag = true;
                secondNumber = new Double(mainPanel.getText().toString().trim());
                subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim());
                mainPanel.setText((firstNumber * secondNumber) + "");
                multiplyFlag = false;
            } else if (divideFlag) {
                ansFlag = true;
                secondNumber = new Double(mainPanel.getText().toString().trim());
                subPanel.setText(subPanel.getText().toString().trim() + mainPanel.getText().toString().trim());
                mainPanel.setText((firstNumber / secondNumber) + "");
                divideFlag = false;
            } else {
                ansFlag = true;
                subPanel.setText(mainPanel.getText().toString().trim());
            }
        } else {
            Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        }
    }

    public void dotPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(mainPanel.getText().toString().trim().equals(""))
            mainPanel.setText("0.");
        else
            mainPanel.setText(mainPanel.getText().toString().trim() + ".");
    }

    public void zeroPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "0");
    }

    public void onePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "1");
    }

    public void twoPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "2");
    }

    public void threePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "3");
    }

    public void fourPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "4");
    }

    public void fivePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "5");
    }

    public void sixPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "6");
    }

    public void sevenPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "7");
    }

    public void eightPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "8");
    }

    public void ninePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        mainPanel.setText(mainPanel.getText().toString().trim() + "9");
    }
}