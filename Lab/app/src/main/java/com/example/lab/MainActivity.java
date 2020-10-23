package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton radiobutton6, radioButton5, radioButton4;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        radiobutton6 = findViewById(R.id.radioButton6);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton4 = findViewById(R.id.radioButton4);
        btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_name.length()<1)
                    tv_text.setText("請輸入玩家姓名");
                else{
                    tv_name.setText(String.format("名字\n%s",
                                        ed_name.getText().toString()));
                    if(radiobutton6.isChecked())
                        tv_mmora.setText("我方出拳\n剪刀");
                    else if(radioButton5.isChecked())
                        tv_mmora.setText("我方出拳\n石頭");
                    else
                        tv_mmora.setText("我方出拳\n布");
                    int computer = (int)(Math.random()*3);
                    if(computer==0)
                        tv_cmora.setText("電腦出拳\n剪刀");
                    else if(computer==1)
                        tv_cmora.setText("電腦出拳\n石頭");
                    else
                        tv_cmora.setText("電腦出拳\n布");
                    if((radiobutton6.isChecked()&&computer==2) ||
                        (radioButton5.isChecked()&&computer==0)||
                                (radioButton4.isChecked()&&computer==1)){
                        tv_winner.setText("勝利者\n"+
                                            ed_name.getText().toString());
                        tv_text.setText("恭喜你獲勝了");
                    }
                    else if((radiobutton6.isChecked()&&computer==1)||
                            (radioButton5.isChecked()&&computer==2)||
                                (radioButton4.isChecked()&&computer==0)){
                        tv_winner.setText("勝利者\n電腦");
                        tv_text.setText("可惜,電腦獲勝了!");
                    }
                    else{
                        tv_winner.setText("勝利者\n平手");
                        tv_text.setText("平局,請在試一次!");
                    }
                }
            }
        });
    }
}