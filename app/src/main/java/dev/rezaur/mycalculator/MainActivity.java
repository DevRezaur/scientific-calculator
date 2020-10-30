package dev.rezaur.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private TextView subPanel;
    private TextView mainPanel;
    private Double firstNumber;
    private Double secondNumber;
    private SwitchMaterial degreeSwitch;
    private boolean plusFlag = false;
    private boolean minusFlag = false;
    private boolean multiplyFlag = false;
    private boolean divideFlag = false;
    private boolean rootFlag = false;
    private boolean modFlag = false;
    private boolean aToBFlag = false;
    private boolean tenToXFlag = false;
    private boolean sinFlag = false;
    private boolean cosFlag = false;
    private boolean tanFlag = false;
    private boolean logFlag = false;
    private boolean ansFlag = false;
    private boolean degreeFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPanel = findViewById(R.id.subPanel);
        mainPanel = findViewById(R.id.mainPanel);
        degreeSwitch = findViewById(R.id.degreeSwitch);
    }

    public void falseAllFlag() {
        plusFlag = false;
        minusFlag = false;
        multiplyFlag = false;
        divideFlag = false;
        rootFlag = false;
        modFlag = false;
        aToBFlag = false;
        tenToXFlag = false;
        sinFlag = false;
        cosFlag = false;
        tanFlag = false;
        logFlag = false;
    }

    public void clearMethod(View view) {
        mainPanel.setText("");
        subPanel.setText("");
        falseAllFlag();
        ansFlag = false;
    }

    public void plusMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
        }
        if(!mainPanel.getText().toString().equals("")) {
            try {
                plusFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "+");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        }
    }

    public void minusMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("") && !mainPanel.getText().toString().equals("-")) {
            try {
                minusFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "-");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        } else {
            mainPanel.setText(mainPanel.getText().toString() + "-");
        }
    }

    public void multiplyMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("")) {
            try {
                multiplyFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "*");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        }
    }

    public void divideMethod(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("")) {
            try {
                divideFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "/");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        }
    }

    public void equalMethod(View view) {
        if(!mainPanel.getText().toString().equals("")) {
            try {
                if (plusFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((firstNumber + secondNumber) + "");
                    plusFlag = false;
                } else if (minusFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((firstNumber - secondNumber) + "");
                    minusFlag = false;
                } else if (multiplyFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((firstNumber * secondNumber) + "");
                    multiplyFlag = false;
                } else if (divideFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((firstNumber / secondNumber) + "");
                    divideFlag = false;
                } else if (rootFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(1));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((Math.sqrt(firstNumber)) + "");
                    rootFlag = false;
                } else if (modFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((firstNumber % secondNumber) + "");
                    modFlag = false;
                } else if (aToBFlag) {
                    ansFlag = true;
                    secondNumber = new Double(mainPanel.getText().toString());
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((Math.pow(firstNumber, secondNumber)) + "");
                    aToBFlag = false;
                } else if (tenToXFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(3));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((Math.pow(10, firstNumber)) + "");
                    tenToXFlag = false;
                } else if (sinFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(4));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    if(degreeSwitch.isChecked())
                        mainPanel.setText((Math.sin(firstNumber * Math.PI/180)) + "");
                    else
                        mainPanel.setText((Math.sin(firstNumber)) + "");
                    sinFlag = false;
                } else if (cosFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(4));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    if(degreeSwitch.isChecked())
                        mainPanel.setText((Math.cos(firstNumber * Math.PI/180)) + "");
                    else
                        mainPanel.setText((Math.cos(firstNumber)) + "");
                    cosFlag = false;
                } else if (tanFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(4));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    if(degreeSwitch.isChecked())
                        mainPanel.setText((Math.tan(firstNumber * Math.PI/180)) + "");
                    else
                        mainPanel.setText((Math.tan(firstNumber)) + "");
                    tanFlag = false;
                } else if (logFlag) {
                    ansFlag = true;
                    firstNumber = new Double(mainPanel.getText().toString().substring(4));
                    subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString());
                    mainPanel.setText((Math.log10(firstNumber)) + "");
                    logFlag = false;
                } else {
                    ansFlag = true;
                    subPanel.setText(mainPanel.getText().toString());
                }
            } catch (Exception e) {
                ansFlag = true;
                falseAllFlag();
                mainPanel.setText("Syntax Error");
            }
        } else {
            Toast.makeText(getApplicationContext(),"Invalid Input",Toast.LENGTH_SHORT).show();
        }
    }

    public void dotPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(mainPanel.getText().toString().equals(""))
            mainPanel.setText("0.");
        else
            mainPanel.setText(mainPanel.getText().toString() + ".");
    }

    public void zeroPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "0");
    }

    public void onePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "1");
    }

    public void twoPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "2");
    }

    public void threePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "3");
    }

    public void fourPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "4");
    }

    public void fivePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "5");
    }

    public void sixPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "6");
    }

    public void sevenPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "7");
    }

    public void eightPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "8");
    }

    public void ninePressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        mainPanel.setText(mainPanel.getText().toString() + "9");
    }

    public void sinPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("sin ")) {
            sinFlag = true;
            mainPanel.setText("sin ");
        }
    }

    public void cosPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("cos ")) {
            cosFlag = true;
            mainPanel.setText("cos ");
        }
    }

    public void tanPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("tan ")) {
            tanFlag = true;
            mainPanel.setText("tan ");
        }
    }

    public void logPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("log ")) {
            logFlag = true;
            mainPanel.setText("log ");
        }
    }

    public void rootPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("√")) {
            rootFlag = true;
            mainPanel.setText("√");
        }
    }

    public void modPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("")) {
            try {
                modFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "%");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        }
    }

    public void aToBPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("")) {
            try {
                aToBFlag = true;
                firstNumber = new Double(mainPanel.getText().toString());
                subPanel.setText(subPanel.getText().toString() + mainPanel.getText().toString() + "^");
                mainPanel.setText("");
            } catch (Exception e) {
                ansFlag = true;
                mainPanel.setText("Syntax Error");
                falseAllFlag();
            }
        }
    }

    public void tenToXPressed(View view) {
        if(ansFlag) {
            mainPanel.setText("");
            subPanel.setText("");
            falseAllFlag();
            ansFlag = false;
        }
        if(!mainPanel.getText().toString().equals("10^")) {
            tenToXFlag = true;
            mainPanel.setText("10^");
        }
    }

    public void radianToDegree(View view) {
        try {
            if(ansFlag && !degreeFlag) {
                degreeFlag = true;
                Double temp = new Double(mainPanel.getText().toString());
                mainPanel.setText((temp * (Math.PI/180)) + "");
            } else if(ansFlag && degreeFlag) {
                degreeFlag = false;
                Double temp = new Double(mainPanel.getText().toString());
                mainPanel.setText((temp / (Math.PI/180)) + "");
            }
        } catch (Exception e) {
            ansFlag = true;
            mainPanel.setText("Syntax Error");
            falseAllFlag();
        }
    }
}