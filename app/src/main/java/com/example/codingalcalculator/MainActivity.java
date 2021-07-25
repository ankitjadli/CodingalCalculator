package com.example.codingalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    ImageButton btnAdd;
    ImageButton btnSub;
    ImageButton btnMul;
    ImageButton btnDiv;
    ImageButton btnZero;
    ImageButton btnOne;
    ImageButton btnTwo;
    ImageButton btnThree;
    ImageButton btnFour;
    ImageButton btnFive;
    ImageButton btnSix;
    ImageButton btnSeven;
    ImageButton btnEight;
    ImageButton btnNine;
    ImageButton btnEqual;
    ImageButton btnPercentage;
    ImageButton btnBackspace;
    ImageButton btnPoint;
    TextView lblMidCauculation;
    TextView txtResult;
    Boolean btnPointclicked=false;
    ImageButton btnCancelEntry;
    ImageButton btnCancel;
    ImageButton btnPlusMinus;
    private double FindNumber()
    {
        double OurNumber;
        if (txtResult.length() != 0 && lblMidCauculation.length() != 0)
        {
            Calculate();
            OurNumber = Double.parseDouble(lblMidCauculation.getText().toString());

        }
        else if (txtResult.length() == 0 || lblMidCauculation.length() != 0)
        {
            OurNumber = GetFirstNumber(lblMidCauculation.getText().toString());
        }
        else
        {
            OurNumber = Double.parseDouble(txtResult.getText().toString());
        }
        return OurNumber;
    }


    private double GetFirstNumber(String InputString)
    {
        int InputStringLength = InputString.length();
        char temp = InputString.charAt(InputStringLength - 1);
        String FirstNumberString ="";
        for (int i = 0; i < InputStringLength - 1; i++)
        {
            FirstNumberString += InputString.charAt(i);
        }
        double FirstNumber = Double.parseDouble(FirstNumberString);
        return FirstNumber;
    }


    private void Calculate()
    {
        int lblMidCauculationLength = lblMidCauculation.length();
        String lblMidCauculationText = lblMidCauculation.getText().toString();
        char temp = lblMidCauculationText.charAt(lblMidCauculationLength - 1);
        String FirstNumber = "";
        for (int i = 0; i < lblMidCauculationLength - 1; i++)
        {
            FirstNumber += lblMidCauculationText.charAt(i);
        }
        double SecondNumber = Double.parseDouble(FirstNumber);
        double CalculatedResult;
        switch (temp)
        {
            case '+':
                CalculatedResult = SecondNumber +  Double.parseDouble(txtResult.getText().toString());
                lblMidCauculation.setText(Double.toString(CalculatedResult));
                txtResult.setText("");
                break;
            case '-':
                CalculatedResult = SecondNumber -  Double.parseDouble(txtResult.getText().toString());
                lblMidCauculation.setText(Double.toString(CalculatedResult));
                txtResult.setText("");
                break;
            case '*':
                CalculatedResult = SecondNumber *  Double.parseDouble(txtResult.getText().toString());
                lblMidCauculation.setText(Double.toString(CalculatedResult));
                txtResult.setText("");
                break;
            case '%':
                CalculatedResult = SecondNumber* (Double.parseDouble(txtResult.getText().toString())/100);
                lblMidCauculation.setText(Double.toString(CalculatedResult));
                txtResult.setText("");
                break;
            case '/':
                if (Double.parseDouble(txtResult.getText().toString()) == 0)
                {
                    Toast.makeText(MainActivity.this,"Divide by zero",Toast.LENGTH_LONG).show();
                }
                else
                {
                    CalculatedResult = SecondNumber /  Double.parseDouble(txtResult.getText().toString());
                    lblMidCauculation.setText(Double.toString(CalculatedResult));
                    txtResult.setText("");
                }
                break;
            default:
                break;

        };
    }


    public void Calculate_Helper(String s)
    {
        if (txtResult.length() != 0 && !(btnPointclicked == true && txtResult.length() == 1))
        {
            btnPointclicked = false;
            if (lblMidCauculation.length() != 0)
            {
                Calculate();
            }
            String temp = lblMidCauculation.getText().toString() + txtResult.getText().toString() + s;

            lblMidCauculation.setText(temp);
            txtResult.setText("");
        }
        else if (txtResult.length() == 0 && lblMidCauculation.length() != 0)
        {
            String temp2 = GetFirstNumber(lblMidCauculation.getText().toString()) + s;
            lblMidCauculation.setText(temp2);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          btnAdd = (ImageButton)(findViewById(R.id.signforadd));
          btnSub = (ImageButton)(findViewById(R.id.subtract));
          btnMul= (ImageButton)(findViewById(R.id.digitsmulti));
          btnDiv= (ImageButton)(findViewById(R.id.divide));
            btnPoint = (ImageButton)(findViewById(R.id.point));
          btnZero= (ImageButton)(findViewById(R.id.digitzero));
          btnOne= (ImageButton)(findViewById(R.id.digitone));
          btnTwo= (ImageButton)(findViewById(R.id.digittwo));
          btnThree= (ImageButton)(findViewById(R.id.digitthree));
          btnFour= (ImageButton)(findViewById(R.id.digitfour));
          btnFive= (ImageButton)(findViewById(R.id.digitfive));
         btnPercentage= (ImageButton)(findViewById(R.id.percentage));;
          btnSix= (ImageButton)(findViewById(R.id.digitsix));
          btnSeven= (ImageButton)(findViewById(R.id.digitseven));
          btnEight= (ImageButton)(findViewById(R.id.digiteight));
          btnNine= (ImageButton)(findViewById(R.id.digitnine));
         lblMidCauculation = (TextView)(findViewById(R.id.midcalculation));
         txtResult= (TextView)(findViewById(R.id.finalresult));
        btnEqual= (ImageButton)(findViewById(R.id.equals));
        btnPlusMinus= (ImageButton)(findViewById(R.id.plusminus));
        btnCancelEntry= (ImageButton)(findViewById(R.id.clearentry));



        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "0";
                txtResult.setText(txtResultText);

            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "1";
                txtResult.setText(txtResultText);

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "2";
                txtResult.setText(txtResultText);

            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "3";
                txtResult.setText(txtResultText);

            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "4";
                txtResult.setText(txtResultText);

            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "5";
                txtResult.setText(txtResultText);

            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "6";
                txtResult.setText(txtResultText);

            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "7";
                txtResult.setText(txtResultText);

            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "8";
                txtResult.setText(txtResultText);

            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtResultText = txtResult.getText().toString();
                txtResultText += "9";

                txtResult.setText(txtResultText);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculate_Helper("+");
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculate_Helper("-");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculate_Helper("%");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculate_Helper("*");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calculate_Helper("/");
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((txtResult.length() != 0  || lblMidCauculation.length() > 0))
                {
                    Double FinalResult = FindNumber();
                    txtResult.setText(Double.toString(FinalResult));
                    lblMidCauculation.setText("");
                }

            }
        });


        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = txtResult.getText().toString();
                for(int i=0;i<txtResult.length();i++)
                {
                    if(temp.charAt(i)=='.')
                    {
                        btnPointclicked=true;
                        break;
                    }
                }
                if (btnPointclicked == false || txtResult.length() == 0)
                {
                    btnPointclicked = true;
                    String txtPointResultText = txtResult.getText().toString();
                    txtPointResultText += ".";
                    txtResult.setText(txtPointResultText);;
                }


            }
        });
        btnCancelEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPointclicked = false;
                txtResult.setText("");
                lblMidCauculation.setText("");
            }
        });

        btnPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((txtResult.length() != 0 && !(btnPointclicked == true && txtResult.length() == 1)) || lblMidCauculation.length() > 0)
                {
                    String newtxtResultText = "";
                    if (txtResult.length() != 0 && !(btnPointclicked == true && txtResult.length() == 1))
                    {
                        btnPointclicked = false;
                        String ResultText = txtResult.getText().toString();
                        if (ResultText.charAt(0) != '-')
                        {
                            newtxtResultText += "-";
                            for (int i = 0; i < txtResult.length(); i++)
                            {
                                newtxtResultText += ResultText.charAt(i);
                            }
                        }
                        else
                        {
                            for (int i = 1; i < txtResult.length(); i++)
                            {
                                newtxtResultText += ResultText.charAt(i);
                            }
                        }
                        txtResult.setText(newtxtResultText);
                    }
                }

            }
        });
    }
}