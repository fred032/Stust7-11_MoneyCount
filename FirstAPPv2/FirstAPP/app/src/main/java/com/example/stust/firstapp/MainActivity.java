package com.example.stust.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txtshow;
    private EditText txtInput, txtMin,txtMax;
    public make_change mc_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        txtshow = findViewById(R.id.show);
        txtInput = findViewById(R.id.editText);
        txtMin = findViewById(R.id.editText2);
        txtMax = findViewById(R.id.editText3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mc_01 = new make_change();
                mc_01.input = Integer.parseInt(txtInput.getText().toString());
                mc_01.min = Integer.parseInt(txtMin.getText().toString());
                mc_01.max = Integer.parseInt(txtMax.getText().toString());

                mc_01.changeCoins(mc_01.input,mc_01.min,mc_01.max);
                txtshow.setText(mc_01.show);

            }
        });


    }


    public class make_change{
        int input;
        int min=0;
        int max=100;
        String show = "";

        public void changeCoins(int input,int min,int max) {//找零計算部分
            int tenCount;
            int oneCount;
            int oneCoin;
            int tenOffprice;
            for(int i = min;i<max;i++) {
                tenCount = (int) (i/10);
                oneCount = (int) (i%10);
                if(oneCount >= 5)
                    tenCount++;
                tenOffprice = i - tenCount;
                oneCoin = 10 - tenOffprice % 10;
                if(oneCoin >= 5)
                    oneCoin -= 5;
                if(input==oneCoin)
                    show += (i+"元商品" + "\r\n");
            }
        }

        public void checkInput(int input){
            if(input>5||input<0) {//輸入範圍外的數值
                show += "輸入錯誤";
                return;
            }
            else {//處理0和5的結果相反問題
                if(input==5)
                    this.input=0;
                if(input==0)
                    this.input=5;
            }
        }

    }



}
