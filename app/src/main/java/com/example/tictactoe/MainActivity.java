package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnNewGame;
    int flag = 0;
    int count = 0;

    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }
    private void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnNewGame = findViewById(R.id.btnNewGame);

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });
    }

    public void Check(View view) {
        Button btnCurrent = (Button) view;
        if (!btnCurrent.getText().toString().equals("")) {
            return;
        }
        count++;
        if (flag == 0) {
            btnCurrent.setText("X");
            btnCurrent.setTextColor(getResources().getColor(R.color.colorX));
            flag = 1;
        } else {
            btnCurrent.setText("O");
            btnCurrent.setTextColor(getResources().getColor(R.color.colorY));
            flag = 0;
        }

        if (count > 4) {
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            //conditions

            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                announceWinner(b1);
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                announceWinner(b4);
            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                announceWinner(b7);
            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                announceWinner(b1);
            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                announceWinner(b2);
            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                announceWinner(b3);
            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                announceWinner(b1);
            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                announceWinner(b3);
            } else if (count == 9) {
                Toast.makeText(this, "Game is a Draw", Toast.LENGTH_SHORT).show();
                newGame(); // Optionally restart the game
            }
        }
    }
    public void announceWinner(String winner) {
        Toast.makeText(this, "Winner is " + winner, Toast.LENGTH_SHORT).show();
        newGame(); // Call newGame to reset the board
    }

    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }


}