package edu.usna.mobileos.rssfeedexample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RssItemAdapter extends ArrayAdapter<RssItem> {

    private Context context;

    public RssItemAdapter(Context context, int textViewResourceId,
                          List<RssItem> items) {
        super(context, textViewResourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_layout, null);
        }

        RssItem item = getItem(position);
        if (item != null) {
            // our layout has two TextView elements
            TextView titleView = (TextView) view.findViewById(R.id.titleText);
            TextView descView = (TextView) view
                    .findViewById(R.id.descriptionText);

            titleView.setText(item.getTitle());
            descView.setText(item.getDescription());
        }

        return view;
    }
}