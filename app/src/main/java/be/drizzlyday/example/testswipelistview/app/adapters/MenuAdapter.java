package be.drizzlyday.example.testswipelistview.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testswipelistview.app.R;

/**
 * Created by Kevin on 15/04/2014.
 */
public class MenuAdapter extends ArrayAdapter<String> {

    private Context context;
    private int layout;
    private String[] data;

    public MenuAdapter(Context context, int resource, String[] data) {
        super(context, resource, data);
        this.context = context;
        this.layout = resource;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.ivMenuLogo = (ImageView) convertView.findViewById(R.id.iv_logo);
            viewHolder.tvMenuName = (TextView) convertView.findViewById(R.id.tv_menu_item);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvMenuName.setText(data[position]);
        viewHolder.ivMenuLogo.setImageResource(R.drawable.ic_action_email);

        return convertView;
    }

    private static class ViewHolder {
        public ImageView ivMenuLogo;
        public TextView tvMenuName;
    }
}
