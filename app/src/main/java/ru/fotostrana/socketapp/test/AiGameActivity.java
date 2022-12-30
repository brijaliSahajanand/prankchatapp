package ru.fotostrana.socketapp.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.constant.Preference;

public class AiGameActivity extends Activity implements View.OnClickListener {

    Button[][] btns;
    TextView btnResetGame;
    TextView tvWIn;
    int counter = 0;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Activity activity;
    ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_game);
        activity = AiGameActivity.this;
        tvWIn = (TextView) findViewById(R.id.tvUWin);
        tvWIn.setVisibility(View.INVISIBLE);
        btnResetGame = (TextView) findViewById(R.id.btnPAgain);
        btnResetGame.setOnClickListener(this);
        btnResetGame.setVisibility(View.INVISIBLE);
        imgback = findViewById(R.id.imgback);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        //
        btns = new Button[3][3];
        btns[0][0] = btn1;
        btns[0][1] = btn2;
        btns[0][2] = btn3;
        btns[1][0] = btn4;
        btns[1][1] = btn5;
        btns[1][2] = btn6;
        btns[2][0] = btn7;
        btns[2][1] = btn8;
        btns[2][2] = btn9;

        Typeface typeface = ResourcesCompat.getFont(activity, R.font.text_bold);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                btns[i][j].setTextSize(30);
                btns[i][j].setOnClickListener(this);
                btns[i][j].setBackground(getResources().getDrawable(R.drawable.light_pink_sq));
                btns[i][j].setTextColor(getResources().getColor(R.color.colorPrimarydark));
                btns[i][j].setTextSize(30);
                btns[i][j].setTypeface(typeface);

            }

        }
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (btnResetGame == v) {

            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        } else
            userTurn(v);
    }


    public void userTurn(View v) {
        Button btn = (Button) v;
        int r = 1 + (int) (Math.random() * 4);
        if (btn.getText().toString().equals("") && !doWeHaveAWinner()) {
            btn.setText("O");
            counter++;
            if (doWeHaveAWinner()) {
            } else {
                robot();
                doWeHaveAWinner();
            }
        }
    }

    // do we have a winner
    public boolean doWeHaveAWinner() {
        if (isWin() > 0) {
            if (isWin() == 1) {
                tvWIn.setText("O Win");
                btnResetGame.setText("Get Your coin Now");
                Preference.setFinalPoints(Preference.getFinalPoints() + 10);


            } else if (isWin() == 2) {
                tvWIn.setText("program Win");
                btnResetGame.setText("Sorry you loss chance !!!\n Get coin now");

            }
            btnResetGame.setVisibility(View.VISIBLE);
            tvWIn.setVisibility(View.VISIBLE);
            return true;
        } else if (counter > 8) {
            tvWIn.setVisibility(View.VISIBLE);
            tvWIn.setText("No One Win");
            btnResetGame.setText("Sorry you loss chance !!!\n Get coin now");
            btnResetGame.setVisibility(View.VISIBLE);
            return true;
        }
        return false;
    }

    //return
    public int isWin() {
        if (counter > 4) {
            int j = 0;
            for (int i = 0; i < 3; i++) {
                if (btns[i][j].getText().toString().length() > 0 && btns[i][j].getText().toString().equals(btns[i][j + 1].getText().toString()) && btns[i][j].getText().toString().equals(btns[i][j + 2].getText().toString())) {
                    if (btns[i][j].getText().toString().equals("O"))
                        return 1;//0 win  - odd counting
                    return 2;//x win
                } else if (btns[j][i].getText().toString().length() > 0 && btns[j][i].getText().toString().equals(btns[j + 1][i].getText().toString()) && btns[j][i].getText().toString().equals(btns[j + 2][i].getText().toString())) {
                    if (btns[j][i].getText().toString().equals("O"))
                        return 1;//user win - even win
                    return 2;
                }

            }//end of for
            //checking diagonal
            if (btns[0][0].getText().toString().length() > 0 && btns[0][0].getText().toString().equals(btns[1][1].getText().toString()) && btns[0][0].getText().toString().equals(btns[2][2].getText().toString())) {
                if (btns[0][0].getText().toString().equals("O"))
                    return 1;//0 win  - odd counting
                return 2;//x win
            }
            if (btns[0][2].getText().toString().length() > 0 && btns[0][2].getText().toString().equals(btns[1][1].getText().toString()) && btns[0][2].getText().toString().equals(btns[2][0].getText().toString())) {
                if (btns[0][2].getText().toString().equals("O"))
                    return 1;//o win  - odd counting
                return 2;
            }
        }
        return -1;//no one win
    }

    //reset game and screen
    public void reset() {
        counter = 0;
        btnResetGame.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                btns[i][j].setText("");
        }
        tvWIn.setVisibility(View.INVISIBLE);
    }

    //AI
    public void robot() {
        if (counter <= 1) {
            if (btns[1][1].getText().toString().equals("O"))
                rMiddle();
            else
                rPutOnCorner();
        } else if (rWin()) {
            Log.d("robot", "rWin");
        } else if (rBlock()) {
            Log.d("robot", "rBlock");
        } else {
            rRandomturn();
            Log.d("robot", "rRandomturn");
        }
        counter++;
    }

    public void rRandomturn() {
        Random random = new Random();
        boolean find = false;
        while (!find) {
            int col = random.nextInt(10) % 3;
            int line = random.nextInt(10) % 3;
            if (btns[line][col].getText().toString().equals("")) {
                btns[line][col].setText("X");
                Log.d("Random turn", "put on: " + line + ", " + col);
                find = true;
            }
        }
    }

    //put on corner
    public void rPutOnCorner() {
        int r = 1 + (int) (Math.random() * 4);
        switch (r) {
            case 1:
                if (btns[0][0].getText().toString().equals("")) {
                    btns[0][0].setText("X");
                    break;
                } else if (btns[0][2].getText().toString().equals("")) {
                    btns[0][2].setText("X");
                    break;
                } else if (btns[2][0].getText().toString().equals("")) {
                    btns[2][0].setText("X");
                    break;
                } else if (btns[2][2].getText().toString().equals("")) {
                    btns[2][2].setText("X");
                    break;
                }
            case 2:
                if (btns[0][2].getText().toString().equals("")) {
                    btns[0][2].setText("X");
                    break;
                } else if (btns[0][0].getText().toString().equals("")) {
                    btns[0][0].setText("X");
                    break;
                } else if (btns[2][0].getText().toString().equals("")) {
                    btns[2][0].setText("X");
                    break;
                } else if (btns[2][2].getText().toString().equals("")) {
                    btns[2][2].setText("X");
                    break;
                }
            case 3:
                if (btns[2][0].getText().toString().equals("")) {
                    btns[2][0].setText("X");
                    break;
                } else if (btns[0][0].getText().toString().equals("")) {
                    btns[0][0].setText("X");
                    break;
                } else if (btns[0][2].getText().toString().equals("")) {
                    btns[0][2].setText("X");
                    break;
                } else if (btns[2][2].getText().toString().equals("")) {
                    btns[2][2].setText("X");
                    break;
                }
            case 4:
                if (btns[2][2].getText().toString().equals("")) {
                    btns[2][2].setText("X");
                    break;
                } else if (btns[0][0].getText().toString().equals("")) {
                    btns[0][0].setText("X");
                    break;
                } else if (btns[0][2].getText().toString().equals("")) {
                    btns[0][2].setText("X");
                    break;
                } else if (btns[2][0].getText().toString().equals("")) {
                    btns[2][0].setText("X");
                    break;
                }
        }
    }

    //middle
    public void rMiddle() {
        int n = 1 + (int) (Math.random() * 4);
        switch (n) {
            case 1: {
                btns[1][0].setText("X");
                break;
            }
            case 2: {
                btns[0][1].setText("X");
                break;
            }
            case 3: {
                btns[1][2].setText("X");
                break;
            }
            case 4: {
                btns[2][1].setText("X");
                break;
            }
        }
    }

    //block the man
    public boolean rBlock() {
        if (rBlockHorizontals())
            return true;
        if (rBlockVerticals())
            return true;
        if (rBlockDiagonals())
            return true;
        return false;
    }

    //block horizontals
    public boolean rBlockHorizontals() {
        int count = 0;
        int free = -1;
        boolean loc1 = false, loc2 = false;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBtn = btns[i][j];
                if (tempBtn.getText().toString().equals("O")) {
                    if (count != 2) {
                        count++;
                        if (!loc1)
                            loc1 = true;
                        else
                            loc2 = true;
                    } else {
                        count = 0;
                        loc1 = false;
                        loc2 = false;
                        free = -1;
                        continue;
                    }
                } else if (tempBtn.getText().toString().equals(""))
                    free = j;
                if (loc1 && loc2 && free != -1) {
                    btns[i][free].setText("X");
                    Log.d("r Block Horizontals", "blocked: " + String.valueOf(i + ", " + free));
                    return true;
                }
            }
            count = 0;
            loc1 = false;
            loc2 = false;
            free = -1;
        }
        Log.d("Block Horizontals", "return false");
        return false;
    }

    //block verticals
    public boolean rBlockVerticals() {
        int count = 0;
        int freeI = -1, freeJ = -1;
        boolean loc1 = false, loc2 = false;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Log.d("Block Verticals", "i: " + i + ", j: " + j + ", loc1: " + loc1 + ", loc2: " + loc2 + ", freeJ: " + freeJ + "freeI: " + freeI);
                tempBtn = btns[j][i];
                if (tempBtn.getText().toString().equals("O")) {
                    if (count != 2) {
                        count++;
                        if (!loc1) {
                            loc1 = true;
                            Log.d("r Block Verticals", "loc1 = : " + i);
                        } else {
                            loc2 = true;
                            Log.d("r Block Verticals", "loc2 = : " + i);
                        }
                    } else {
                        count = 0;
                        loc1 = false;
                        loc2 = false;
                        freeI = -1;
                        freeJ = -1;
                        continue;
                    }
                } else if (tempBtn.getText().toString().equals("")) {
                    freeI = i;
                    freeJ = j;
                    Log.d("r Block Verticals", "free found: " + String.valueOf(freeJ + ", " + freeI) + " | content: " + tempBtn.getText().toString() + ", is there are x inside: " + tempBtn.getText().toString().equals("X"));
                }
                if (loc1 && loc2 && freeI != -1 && freeJ != -1) {
                    btns[freeJ][freeI].setText("X");
                    Log.d("r Block Verticals", "blocked: " + String.valueOf(freeJ + ", " + freeI));
                    return true;
                }
            }
            count = 0;
            loc1 = false;
            loc2 = false;
            freeI = -1;
            freeJ = -1;
        }
        Log.d("Block Verticals", "return false");
        return false;
    }

    //block diagonals
    public boolean rBlockDiagonals() {
        if (rBlockDiagonals_TLeftToBRight())
            return true;
        if (rBlockDiagonals_TRightToBLeft())
            return true;
        return false;

    }

    //block diagonals from top left to bottom right
    public boolean rBlockDiagonals_TLeftToBRight() {
        int count = 0;
        int loc1 = -1, loc2 = -1, free = -1;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            tempBtn = btns[i][i];
            if (tempBtn.getText().toString().equals("O")) {
                if (count != 2) {
                    count++;
                    if (loc1 == -1)
                        loc1 = i;
                    else
                        loc2 = i;
                }
            } else if (tempBtn.getText().toString().equals(""))
                free = i;
            if (loc1 != -1 && loc2 != -1 && free != -1) {
                btns[free][free].setText("X");
                return true;
            }
        }
        return false;
    }

    //block diagonals from top right to bottom left
    public boolean rBlockDiagonals_TRightToBLeft() {
        int count = 0;
        int loc1 = -1, loc2 = -1, freeI = -1, freeJ = -1;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + j == 2) {
                    tempBtn = btns[i][j];
                    if (tempBtn.getText().toString().equals("O")) {
                        if (count != 2) {
                            count++;
                            if (loc1 == -1)
                                loc1 = i;
                            else
                                loc2 = i;
                        }
                    } else if (tempBtn.getText().toString().equals("")) {
                        freeI = i;
                        freeJ = j;
                    }
                }
                if (loc1 != -1 && loc2 != -1 && freeI != -1 && freeJ != -1) {
                    btns[freeI][freeJ].setText("X");
                    return true;
                }
            }
        }

        return false;
    }

    //win
    public boolean rWin() // like block (copy & paste) but with two X instead of two O
    {
        if (rWinHorizontals())
            return true;
        if (rWinVerticals())
            return true;
        if (rWinDiagonals())
            return true;
        return false;
    }

    //win horizontals
    public boolean rWinHorizontals() {
        Log.d("win horizontal", "start");
        int count = 0;
        int loc1 = -1, loc2 = -1, free = -1;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBtn = btns[i][j];
                if (tempBtn.getText().toString().equals("X")) {
                    if (count != 2) {
                        count++;
                        if (loc1 == -1)
                            loc1 = j;
                        else
                            loc2 = j;
                    } else {
                        count = 0;
                        loc1 = -1;
                        loc2 = -1;
                        free = -1;
                        continue;
                    }
                } else if (tempBtn.getText().toString().equals(""))
                    free = j;
                if (loc1 != -1 && loc2 != -1 && free != -1) {
                    Log.d("win horizontal", "set on " + String.valueOf(i + " " + j));
                    btns[i][free].setText("X");
                    return true;
                }
            }
            count = 0;
            loc1 = -1;
            loc2 = -1;
            free = -1;
        }
        return false;
    }

    //win verticals
    public boolean rWinVerticals() {
        int count = 0;
        int freeI = -1, freeJ = -1;
        boolean loc1 = false, loc2 = false;
        Button tempBtn1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tempBtn1 = btns[j][i];
                if (tempBtn1.getText().toString().equals("X")) {
                    if (count != 2) {
                        count++;
                        if (!loc1) {
                            loc1 = true;
                        } else {
                            loc2 = true;

                        }
                    } else {
                        count = 0;
                        loc1 = false;
                        loc2 = false;
                        freeI = -1;
                        freeJ = -1;
                        continue;
                    }
                } else if (tempBtn1.getText().toString().equals("")) {
                    freeI = i;
                    freeJ = j;
                }
                if (loc1 && loc2 && freeI != -1 && freeJ != -1) {
                    btns[freeJ][freeI].setText("X");

                    return true;
                }
            }
            count = 0;
            loc1 = false;
            loc2 = false;
            freeI = -1;
            freeJ = -1;
        }
        Log.d("win Verticals", "return false");
        return false;
    }

    //win diagonals
    public boolean rWinDiagonals() {
        if (rWinDiagonals_TLeftToBRight())
            return true;
        if (rWinDiagonals_TRightToBLeft())
            return true;
        return false;
    }

    //win diagonals top left to bottom right
    public boolean rWinDiagonals_TLeftToBRight() {
        int count = 0;
        int loc1 = -1, loc2 = -1, free = -1;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            tempBtn = btns[i][i];
            if (tempBtn.getText().toString().equals("X")) {
                if (count != 2) {
                    count++;
                    if (loc1 == -1)
                        loc1 = i;
                    else
                        loc2 = i;
                }
            } else if (tempBtn.getText().toString().equals(""))
                free = i;
            if (loc1 != -1 && loc2 != -1 && free != -1) {
                btns[free][free].setText("X");
                return true;
            }
        }
        return false;
    }

    //win diagonals top right to bottom left
    public boolean rWinDiagonals_TRightToBLeft() {
        int count = 0;
        int loc1 = -1, loc2 = -1, freeI = -1, freeJ = -1;
        Button tempBtn;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + j == 2) {
                    tempBtn = btns[i][j];
                    if (tempBtn.getText().toString().equals("X")) {
                        if (count != 2) {
                            count++;
                            if (loc1 == -1)
                                loc1 = i;
                            else
                                loc2 = i;
                        }
                    } else if (tempBtn.getText().toString().equals("")) {
                        freeI = i;
                        freeJ = j;
                    }
                }
                if (loc1 != -1 && loc2 != -1 && freeI != -1 && freeJ != -1) {
                    btns[freeI][freeJ].setText("X");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}