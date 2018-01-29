package tk.arnoldwho.arnold.arnoldfw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by arnold on 18-1-29.
 */

public class ItemBaseAdapter extends BaseAdapter{
    public Context context;
    private ArrayList<Itemsinfo> Items = new ArrayList<>();
    int b = 0;

    public ItemBaseAdapter(Context context, ArrayList<Itemsinfo> Items) {
        super();
        this.context = context;
        this.Items = Items;
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
        return Items.size();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final Holder holder;
        if (convertView == null) {
            holder = new  Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,
                    null);
            holder.textView = (TextView) convertView.findViewById(R.id.items);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.textView.setText(Items.get(position).itemName);
        holder.textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int flag = Items.get(position).flag;
                int textColor;
                if (flag == 0){
                    Items.get(position).flag = 1;
                    textColor = R.color.red;
                }
                else {
                    Items.get(position).flag = 0;
                    textColor = R.color.word;
                }
                holder.textView.setTextColor(context.getResources().getColor(textColor));

            }
        });
        return convertView;
    }

    public final static class Holder {
        TextView textView;
    }
}
