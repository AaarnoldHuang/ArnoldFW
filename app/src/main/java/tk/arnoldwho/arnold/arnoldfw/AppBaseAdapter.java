package tk.arnoldwho.arnold.arnoldfw;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arnold on 18-1-21.
 */


public class AppBaseAdapter extends BaseAdapter {

    public Context context;
    final ArrayList<Appinfo> appList = new ArrayList<>();
    private LayoutInflater mInflater;

    public AppBaseAdapter(Context context) {
        this.context = context;
    }

    public void getAppInfo(){
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        for (int i = 0; i < packages.size(); i++) {
            Appinfo tmpInfo = new Appinfo();
            PackageInfo packageInfo = packages.get(i);
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(pm).toString();
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(pm);
            tmpInfo.packageName = packageInfo.packageName;
            if((packageInfo.applicationInfo.flags& ApplicationInfo.FLAG_SYSTEM)==0)
            {
                appList.add(tmpInfo);
            }
        }
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount(){
        return appList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item,null);
        TextView textView = (TextView) view.findViewById(R.id.name_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_view);
        textView.setText(appList.get(position).appName);
        imageView.setImageDrawable(appList.get(position).appIcon);
        return view;
    }
}
