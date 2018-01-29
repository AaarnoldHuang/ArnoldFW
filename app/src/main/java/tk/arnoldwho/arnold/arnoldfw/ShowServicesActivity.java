package tk.arnoldwho.arnold.arnoldfw;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowServicesActivity extends AppCompatActivity {

    public String pname = "";
    private ArrayList<String> sers = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_services);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleView = (TextView) findViewById(R.id.toolbar_title);
        titleView.setText(AppBaseAdapter.APPName);
        ImageView imgView = (ImageView) findViewById(R.id.toolbar_icon);
        imgView.setImageDrawable(AppBaseAdapter.AppIcon);
        setSupportActionBar(toolbar);

        final MakeFiles mk = new MakeFiles();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mk.Make()){
                    Snackbar.make(view, "文件已存在！", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else {
                    Snackbar.make(view, "文件已创建！", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


        getServices(this);
        listView = (ListView)findViewById(R.id.serviceslist);
        ArrayAdapter<String> activitiesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                sers);
        listView.setAdapter(activitiesAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void getServices(Context context) {
        PackageManager pm=context.getPackageManager();
        try {
            PackageInfo packageInfo=pm.getPackageInfo(AppBaseAdapter.packageName,  PackageManager.GET_SERVICES);
            ServiceInfo[] serviceInfoList = packageInfo.services;
            if (packageInfo.services == null){
                sers.add("无Service！");
                return;
            }

            for (ServiceInfo serviceInfo : serviceInfoList) {
                sers.add(serviceInfo.name);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}
