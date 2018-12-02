package com.example.a21091.firstproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public class ButtonListener implements MenuItem.OnMenuItemClickListener {
        private final MainActivity mainActivity;
        private MenuItem menuItem;


        public ButtonListener(MenuItem menuItem, MainActivity mainActivity) {
            this.menuItem = menuItem;
            this.mainActivity = mainActivity;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {

            return true;
        }
    }

    public void onClickAddMenu (View view){

            MenuItem add = menu.add(0, 4, 4, "Новый пункт меню ");

            add.setOnMenuItemClickListener(new ButtonListener(add, this));
    }

    private Menu menu;
    private int Normal = 100;
    private int Max = 500;
    private int Min = 50;

    Button b1;
    Button b2;
    Button b3;
    Button go;
    Button print;
    EditText enterText;
    TextView textView;

    public void CreateElements(){
        b1 = (Button) (findViewById(R.id.button4));
        b2 = (Button) (findViewById(R.id.button5));
        b3 = (Button) (findViewById(R.id.button6));
        go = (Button) (findViewById(R.id.button));
        print = (Button) findViewById(R.id.button2);
        enterText = (EditText) findViewById(R.id.enterText);
        textView = (TextView) findViewById(R.id.textView2);

        go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setContentView(R.layout.butlayout);
            }
        });

        print.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        CreateElements();
    }

    public void BackToMain(View view){
        setContentView(R.layout.main);
        CreateElements();
    }

    @Override
    public void onClick(View v) {

        String string = enterText.getText().toString();
        textView.setText(string);
    }

    public void Add(MenuItem.OnMenuItemClickListener view){
        //LinearLayout l = new LinearLayout(R.layout.main);
        Button btn = new Button(MainActivity.this);
        btn.setText("NewButton");
        btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 2));
        LinearLayout buttons = (LinearLayout) findViewById(R.id.newLay);
        //LinearLayout l = new LinearLayout(MainActivity.this);
        buttons.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Сообщение!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //LinearLayout.addview(btn);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu){

        this.menu = menu;

        menu.add(0, 0, 0, "Первый").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Привет!", Toast.LENGTH_SHORT);
                toast.show();

                return true;
            }
        });

        menu.add(0, 1, 1, "Второй").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Log.d("MyTag", "Привет мир!");

                Add(this);
                return true;
            }
        });

        menu.add(0, 2, 2, "Третий").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Нажат третий пункт")
                        .setMessage("Все хорошо")
                        .setCancelable(false)
                        .setPositiveButton("Закрыть", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

                return true;
            }
        });

        menu.add(0, 3, 3, "Назад").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                setContentView(R.layout.main);
                CreateElements();

                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void onMyButtonMaxClick(View view)   {

        b1.setWidth(Max); b1.setHeight(Max);
        b2.setWidth(Min); b2.setHeight(Min);
        b3.setWidth(Min); b3.setHeight(Min);
    }

    public void onMyButtonMaxClick1(View view)    {

        b3.setWidth(Max); b3.setHeight(Max);
        b2.setWidth(Min); b2.setHeight(Min);
        b1.setWidth(Min); b1.setHeight(Min);

    }

    public void onMyButtonMaxClick2(View view)    {

        b3.setWidth(Normal); b3.setHeight(Normal);
        b2.setWidth(Normal); b2.setHeight(Normal);
        b1.setWidth(Normal); b1.setHeight(Normal);

    }

    class DrawView extends View {
        private Paint paint;

        public DrawView(Context context) {
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas) {

            canvas.drawARGB(20, 100, 200, 100);

            paint = new Paint();

            paint.setColor(Color.BLUE);
            paint.setTextSize(50);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);

            Rect rect = new Rect(100,100,100,100);
            canvas.drawRect(rect, paint);
            canvas.drawText("Полковниченко Ярослав. № 7. ИС-16.", 100, 100, paint);
        }
    }

    public void clickButtonGraphic(View view) {
        setContentView(new DrawView(this));
    }
}
