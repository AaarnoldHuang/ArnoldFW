package tk.arnoldwho.arnold.arnoldfw;

import android.app.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class AppinfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);
        ListView listView = (ListView)findViewById(R.id.applist);
        AppBaseAdapter mBaseAdapter = new AppBaseAdapter(getApplicationContext());
        listView.setAdapter(mBaseAdapter);
        mBaseAdapter.getAppInfo();


    }
}
