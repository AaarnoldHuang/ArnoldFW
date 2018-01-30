package tk.arnoldwho.arnold.arnoldfw;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button appbutton = (Button) findViewById(R.id.btn1);
        appbutton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AppinfoActivity.class);
                startActivity(intent);
            }
        });
       // copyFilesFassets();
    }

    public void copyFilesFassets() {
        InputStream in = null;
        FileOutputStream out = null;
        String path = this.getApplicationContext().getFilesDir().getAbsolutePath() + "/shell/ifw.sh";
        File file = new File(path);
        if (!file.exists()) {
            try
            {
                in = this.getAssets().open("IFW.sh");
                out = new FileOutputStream(file);
                int length = -1;
                byte[] buf = new byte[1024];
                while ((length = in.read(buf)) != -1)
                {
                    out.write(buf, 0, length);
                }
                out.flush();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally{
                if (in != null)
                {
                    try {
                        in.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                if (out != null)
                {
                    try {
                        out.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
