package sudoko_solver.mytwistedidea.wordpress.com.sodukosolver;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import sudoko_solver.mytwistedidea.wordpress.com.sodukosolver.Sudoko;

public class MainActivity extends AppCompatActivity {

    Sudoko sudoko;
    TextView tv[][][] = new TextView[11][4][4];
    Button bt[] = new Button[10];
    int x = 0, y = 0, z = 0;
    FrameLayout myView = null;

    int k1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initllize();


        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    final int finalI = i;
                    final int finalJ = j;
                    final int finalK = k;

                    k1=0;

                    tv[i][j][k].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (finalI == x && finalJ == y && finalK == z) {
                                tv[finalI][finalJ][finalK].setBackgroundColor(Color.YELLOW);
                                x = y = z = 0;
                            } else {
                                if (x == 0) {
                                    x = finalI;
                                    y = finalJ;
                                    z = finalK;
                                }
                                final int x1 = x;
                                final int y1 = y;
                                final int z1 = z;

                                tv[x1][y1][z1].setBackgroundColor(Color.YELLOW);

                                x = finalI;
                                y = finalJ;
                                z = finalK;

                                tv[finalI][finalJ][finalK].setBackgroundColor(Color.BLUE);
                            }
                        }
                    });


                    tv[i][j][k].setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            tv[finalI][finalJ][finalK].setText(" ");
                            tv[finalI][finalJ][finalK].setBackgroundColor(Color.YELLOW);
                            x = y = z = 0;
                            return false;
                        }
                    });
                }
            }
            k1=0;
            final int finalI1 = i;
            bt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (x != 0) {
                            tv[x][y][z].setText(finalI1 + "");
                            tv[x][y][z].setBackgroundColor(Color.parseColor("#cccc00"));
                    } else {
                        Toast.makeText(MainActivity.this, "Select a Box!!!!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x != 0) {
                    tv[x][y][z].setText(" ");
                    tv[x][y][z].setGravity(Gravity.CENTER);
                } else {
                    Toast.makeText(MainActivity.this, "Select a Box!!!!", Toast.LENGTH_LONG).show();
                }
                k1=0;
            }
        });

        bt[0].setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resetAll();
                k1=0;
                return false;
            }
        });
    }

    private void initllize() {

        bt[1] = (Button) findViewById(R.id.bT1);
        bt[2] = (Button) findViewById(R.id.bT2);
        bt[3] = (Button) findViewById(R.id.bT3);
        bt[4] = (Button) findViewById(R.id.bT4);
        bt[5] = (Button) findViewById(R.id.bT5);
        bt[6] = (Button) findViewById(R.id.bT6);
        bt[7] = (Button) findViewById(R.id.bT7);
        bt[8] = (Button) findViewById(R.id.bT8);
        bt[9] = (Button) findViewById(R.id.bT9);
        bt[0] = (Button) findViewById(R.id.bT0);

        for (int i = 1; i <= 9; i++) {
            String idTest = "R.id.box_" + i;
            switch (i) {
                case 1:
                    myView = (FrameLayout) findViewById(R.id.box_1);
                    break;
                case 2:
                    myView = (FrameLayout) findViewById(R.id.box_2);
                    break;
                case 3:
                    myView = (FrameLayout) findViewById(R.id.box_3);
                    break;
                case 4:
                    myView = (FrameLayout) findViewById(R.id.box_4);
                    break;
                case 5:
                    myView = (FrameLayout) findViewById(R.id.box_5);
                    break;
                case 6:
                    myView = (FrameLayout) findViewById(R.id.box_6);
                    break;
                case 7:
                    myView = (FrameLayout) findViewById(R.id.box_7);
                    break;
                case 8:
                    myView = (FrameLayout) findViewById(R.id.box_8);
                    break;
                case 9:
                    myView = (FrameLayout) findViewById(R.id.box_9);
                    break;
            }
            tv[i][1][1] = (TextView) myView.findViewById(R.id.tv_1);
            tv[i][1][2] = (TextView) myView.findViewById(R.id.tv_2);
            tv[i][1][3] = (TextView) myView.findViewById(R.id.tv_3);
            tv[i][2][1] = (TextView) myView.findViewById(R.id.tv_4);
            tv[i][2][2] = (TextView) myView.findViewById(R.id.tv_5);
            tv[i][2][3] = (TextView) myView.findViewById(R.id.tv_6);
            tv[i][3][1] = (TextView) myView.findViewById(R.id.tv_7);
            tv[i][3][2] = (TextView) myView.findViewById(R.id.tv_8);
            tv[i][3][3] = (TextView) myView.findViewById(R.id.tv_9);

        }
        resetAll();
    }

    private void resetAll() {
        //TODO reset all TV

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    tv[i][j][k].setText(" ");
                    tv[i][j][k].setBackgroundColor(Color.YELLOW);
                    tv[i][j][k].setGravity(Gravity.CENTER_HORIZONTAL);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        k1=0;
        int id = item.getItemId();
        switch (id) {
            case R.id.action_go:
                convertToArray();
                break;

            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, Dev2Activity.class);
                startActivity(intent);
                break;

            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void convertToArray() {

        int a=0,b=0;
        int[][] matrix = new int[11][11];
        for(int k = 1;k<=9;k++) {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    //CompletedTODO get the array

                    int val = 0;
                    if(!tv[k][i][j].getText().toString().equals(" "))
                        val = Integer.parseInt(tv[k][i][j].getText().toString());

                    switch (k) {
                        case 1:
                        case 2:
                        case 3:
                            a = i;
                            switch (k) {
                                case 1:
                                    b = j;
                                    break;
                                case 2:
                                    b = j + 3;
                                    break;
                                case 3:
                                    b = j + 6;
                                    break;
                                }
                            break;
                        case 4:
                        case 5:
                        case 6:
                            a = i + 3;
                            switch (k) {
                                case 4:
                                    b = j;
                                    break;
                                case 5:
                                    b = j+3;
                                    break;
                                case 6:
                                    b = j+6;
                                    break;
                                }
                            break;
                        case 7:
                        case 8:
                        case 9:
                            a = i + 6;
                            switch (k) {
                                case 7:
                                    b = j;
                                    break;
                                case 8:
                                    b = j + 3;
                                    break;
                                case 9:
                                    b = j + 6;
                                    break;
                                }
                            break;
                    }

                    matrix[a-1][b-1] = val;
                }
            }
        }

        if (sudoko.unSolvable(matrix))    // solves in place
            writeMatrix(matrix);
        else {
            Toast tos = Toast.makeText(MainActivity.this,"No solution!!!! ",Toast.LENGTH_LONG);

            View vi = tos.getView();
            vi.setBackgroundColor(Color.parseColor("#ff00ff"));
            tos.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM,0,0);
            tos.show();
        }
    }

    private void writeMatrix(int[][] matrix) {
        //TODO Write Answer in TextView
        int p,q,r;
        p=q=r=0;
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= 9;j++){

                if(j >= 1 && j <= 3){
                    if(i>=1 && i<=3){
                        p = 1;
                    }
                    else if(i>=4 && i<=6){
                        p = 4;
                    }
                    else if(i>=7 && i<=9){
                        p = 7;
                    }
                }
                else if(j >= 4 && j <= 6){
                    if(i>=1 && i<=3){
                        p = 2;
                    }
                    else if(i>=4 && i<=6){
                        p = 5;
                    }
                    else if(i>=7 && i<=9){
                        p = 8;
                    }
                }
                else if(j >= 7 && j <= 9){
                    if(i>=1 && i<=3){
                        p = 3;
                    }
                    else if(i>=4 && i<=6){
                        p = 6;
                    }
                    else if(i>=7 && i<=9){
                        p = 9;
                    }
                }
                q = (i%3);
                r = (j%3);
                if(i%3 == 0)
                    q = 3;
                if(j%3 == 0)
                    r = 3;
                if(matrix[i-1][j-1] != 0)
                    tv[p][q][r].setText(matrix[i-1][j-1]+"");
                else    tv[p][q][r].setText(" ");
            }
        }
    }

    @Override
    public void onBackPressed() {
        if( k1 >= 3)
        super.onBackPressed();
        else {
            Toast.makeText(this,"Press Again To Exit.",Toast.LENGTH_SHORT).show();
            k1++;
        }
    }
}
