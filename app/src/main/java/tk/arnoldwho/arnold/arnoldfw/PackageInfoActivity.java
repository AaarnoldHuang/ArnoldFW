package tk.arnoldwho.arnold.arnoldfw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class PackageInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView listView = (ListView)findViewById(R.id.chooselist);
        String[] strings = {"Activities", "Services", "Broadcasts"};
        ChooseAdapter chooseAdapter = new ChooseAdapter(getApplicationContext(), strings);
        listView.setAdapter(chooseAdapter);
    }



}
