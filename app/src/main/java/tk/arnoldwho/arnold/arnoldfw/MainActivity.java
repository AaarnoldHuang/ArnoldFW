package tk.arnoldwho.arnold.arnoldfw;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button appbutton = (Button) findViewById(R.id.btn1);
        //Getroot.upgradeRootPermission("/data");
        appbutton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AppinfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
