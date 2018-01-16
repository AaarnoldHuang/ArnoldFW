package tk.arnoldwho.arnold.arnoldfw;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AppinfoActivity extends Activity {
    public String appName="";
    public String packageName="";
    public Drawable appIcon=null;
    public void print()
    {
        Log.v("app","Name:"+appName+" Package:"+packageName);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appinfo);
        ListView applistview = (ListView) findViewById(R.id.applist);
        final ArrayList<AppinfoActivity> appList = new ArrayList<AppinfoActivity>();
        final ArrayList<String> appnamelist = new ArrayList<>();

        List<Object> applistinfo = new ArrayList<>();

        final ArrayAdapter<String> list;   //适配器
        list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appnamelist);    //绑定适配器
        applistview.setAdapter(list);

        List<PackageInfo> packages = this.getPackageManager().getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (int i = 0; i < packages.size(); i++) {
            AppinfoActivity tmpInfo = new AppinfoActivity();
            PackageInfo packageInfo = packages.get(i);
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(this.getPackageManager()).toString();
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(this.getPackageManager());
            tmpInfo.packageName = packageInfo.packageName;
            //appList.add(tmpInfo);
            if((packageInfo.applicationInfo.flags& ApplicationInfo.FLAG_SYSTEM)==0)
            {
                appList.add(tmpInfo);//如果非系统应用，则添加至appList
            }
        }
        for (int i = 0; i < appList.size(); i++) {
            appnamelist.add(appList.get(i).appName);
            //applistinfo.add(new HashMap<String, Object>().put("image", appList.get(i).appIcon));
            applistinfo.add(new HashMap<String, Object>().put("name", appList.get(i).appName));

        }
    }
}
