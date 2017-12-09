package in.techdrop.tejas.pdf_reader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Carl_johnson on 04-12-2017.
 */

public class ListPDFAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    public Resources res;
    private Activity activity;
    private ArrayList<HashMap<String ,String>> data;

    public ListPDFAdapter(Activity a, ArrayList d, Resources resLoc)
    {
        activity = a;
        data = d;
        res = resLoc;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount()
    {
        if(data.size()<= 0)
            return 1;
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_posts,null);
            holder = new ViewHolder();

            holder.id = (TextView) convertView.findViewById(R.id.id);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.body = (TextView) convertView.findViewById(R.id.body);
            holder.btnView = (Button) convertView.findViewById(R.id.viewPdf);


        }
        else
        {
            holder = (ViewHolder) convertView.getTag();

            if(data.size()<=0)
            {
                holder.id.setText("No data");
               /*Intent f = new Intent(activity.getApplication(), NoData.class);
               activity.startActivity(f);
*/
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
        }

        holder.id.setText(data.get(position).get("id"));
        holder.title.setText(data.get(position).get("name"));
        holder.body.setText(data.get(position).get("url"));

        holder.btnView = (Button)  convertView.findViewById(R.id.viewPdf);

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity.getApplicationContext(), VIewPDF.class);
                intent.putExtra("url",data.get(position).get("url"));
                intent.putExtra("name",data.get(position).get("name"));
                activity.startActivity(intent);
            }
        });

        convertView.setTag(holder);

        return convertView;
    }


    public static class ViewHolder
    {

        public TextView id ,title, body;
        Button btnView;

    }
}
