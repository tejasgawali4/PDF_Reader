package in.techdrop.tejas.pdf_reader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Carl_johnson on 04-12-2017.
 */

class ListOfPDF extends Activity
{
    private ProgressDialog pDialog;
    ListView postListView;
    public ListOfPDF CustomViewPDF = null;
    public ArrayList<HashMap<String,String>> CustomListPostViewArray;
    ListPDFAdapter adapter;
    Resources res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewposts);

        CustomViewPDF = this;

        pDialog = new ProgressDialog(ListOfPDF.this);

        CustomListPostViewArray = new ArrayList<>();

        res = getResources();

        postListView = (ListView) findViewById(R.id.viewpost_listview);

        new ViewPost().execute();

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplication(), "Position" + i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected class ViewPost extends AsyncTask<Void , Void ,Void>
    {
        String json;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ListOfPDF.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            // Making a request to url and getting response
            String jsonStr = loadJSONFromAsset(getApplicationContext());
            Log.e("Response", "Response from url: " + jsonStr);

            if (jsonStr != null)
            {
                try
                {
                    JSONObject result = new JSONObject(jsonStr);
                    JSONArray jsonArray =  result.getJSONArray("result");
                    System.out.println("Resut :_" + result);

                    // looping through All Contacts
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject jsonResponce = jsonArray.getJSONObject(i);
                        System.out.println("jsonResponce :_" + jsonResponce);

                        String id =jsonResponce.getString("id");
                        String name = jsonResponce.getString("name");
                        String url = jsonResponce.getString("url");

                        System.out.println("\n id :- "+id+"name :-"+name+"url:-"+url);
                        // tmp hash map for single contact
                        HashMap<String, String> Post = new HashMap<>();

                        // adding each child node to HashMap key => value
                        Post.put("id",id);
                        Post.put("name", name);
                        Post.put("url",url);

                        // adding contact to contact list
                        CustomListPostViewArray.add(Post);
                    }
                } catch (final JSONException e) {
                    // Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    LENGTH_LONG)
                                    .show();
                        }
                    });
                }
            } else {
                //Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
//            Intent i = new Intent(ViewPosts.this,NoInternetConnection.class);
//            startActivity(i);
                        Toast.makeText(getApplicationContext(),"Couldn't get json from server. Check LogCat for possible errors!", LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            if (pDialog.isShowing())
                pDialog.dismiss();

            adapter = new ListPDFAdapter(CustomViewPDF, CustomListPostViewArray, res);

            postListView.setAdapter(adapter);
        }

        public String loadJSONFromAsset(Context context) {
            //Reading json from res floder
            json = null;
            try {
                InputStream is = getApplicationContext().getAssets().open("techdrop.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }
    }
}
