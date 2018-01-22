package tk.arnoldwho.arnold.arnoldfw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by arnold on 18-1-22.
 */

public class ChooseAdapter extends BaseAdapter {
    private String[] data;
    public Context context;

    public ChooseAdapter(Context context, String[] data) {
        super();
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return 3;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            holder = new ChooseAdapter.Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,
                    null); //change
            holder.textView = (TextView) convertView.findViewById(R.id.name_view);   //change
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(data[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    private final static class Holder {
        TextView textView;

    }
}
