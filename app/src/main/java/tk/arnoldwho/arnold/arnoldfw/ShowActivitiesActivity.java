package tk.arnoldwho.arnold.arnoldfw;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowActivitiesActivity extends AppCompatActivity {

    final ArrayList<Itemsinfo> acts = new ArrayList<>();
    private ListView listView;
    public static String string = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activities);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView titleView = (TextView) findViewById(R.id.toolbar_title);    //顶部显示App名字
        titleView.setText(AppBaseAdapter.APPName);
        ImageView imgView = (ImageView) findViewById(R.id.toolbar_icon);     //顶部显示App图标
        imgView.setImageDrawable(AppBaseAdapter.AppIcon);
        setSupportActionBar(toolbar);

        final MakeFiles mk = new MakeFiles();            //生成IFW文件

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for (int i = 0; i < acts.size(); i++){
                    if (acts.get(i).flag == 1){
                        string += "<component-filter name=\\\"" + acts.get(i).itemName + "\\\" />\\n";
                    }
                }
                mk.Make(1);
                Snackbar.make(view, "文件已创建！", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        getActivities(this);
        listView = (ListView)findViewById(R.id.activitieslist);
        ItemBaseAdapter itemBaseAdapter = new ItemBaseAdapter(getApplicationContext(), acts);
        listView.setAdapter(itemBaseAdapter);
    }

    public void getActivities(Context context) {
        PackageManager pm=context.getPackageManager();
        try {
            PackageInfo packageInfo=pm.getPackageInfo(AppBaseAdapter.packageName,  PackageManager.GET_ACTIVITIES);
            ActivityInfo[] activityInfoList = packageInfo.activities;
            if (packageInfo.activities == null){
                Itemsinfo tempInfo = new Itemsinfo();
                tempInfo.itemName = "No Activity!";
                acts.add(tempInfo);
                return;
            }
            else {
                for (ActivityInfo activityInfo : activityInfoList) {
                    Itemsinfo tempInfo = new Itemsinfo();
                    tempInfo.itemName = activityInfo.name;
                    acts.add(tempInfo);
                }
            }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
    }
}
