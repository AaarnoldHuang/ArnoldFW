package tk.arnoldwho.arnold.arnoldfw;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
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
        final ArrayList<AppinfoActivity> appList = new ArrayList<AppinfoActivity>();      //新建ArrayList
        final ArrayAdapter<AppinfoActivity> list;        //新建Adapter
        list = new ArrayAdapter<AppinfoActivity> (this, R.layout.list_item, R.id.name_view, appList);

        applistview.setAdapter(list);

        List<PackageInfo> packages = this.getPackageManager().getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (int i = 0; i < packages.size(); i++) {
            AppinfoActivity tmpInfo = new AppinfoActivity();
            PackageInfo packageInfo = packages.get(i);
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(this.getPackageManager()).toString();
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(this.getPackageManager());
            tmpInfo.packageName = packageInfo.packageName;
            appList.add(tmpInfo);
        }
        //list.notifyDataSetChanged();

    }
}
