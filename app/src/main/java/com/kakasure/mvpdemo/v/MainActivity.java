package com.kakasure.mvpdemo.v;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kakasure.mvpdemo.R;
import com.kakasure.mvpdemo.callback.ActivityCallback;
import com.kakasure.mvpdemo.p.MainPersenter;

/**
 * @author dashentao
 * @date 2015 9-21
 */
public class MainActivity extends AppCompatActivity implements ActivityCallback {
    private Button button;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        textview = (TextView) findViewById(R.id.textview1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPersenter.getInstance().Opreation1(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void toUI(int action, Object object) {
        switch (action) {
            case MainPersenter.ACTION_1:
                if (object != null) {
                    textview.setText((String) object);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MainPersenter.getInstance().destoryInstance();
    }
}
