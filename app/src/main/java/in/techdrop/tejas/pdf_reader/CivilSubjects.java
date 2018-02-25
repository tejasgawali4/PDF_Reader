package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Saloni on 2/22/2018.
 */

public class CivilSubjects extends AppCompatActivity implements View.OnClickListener {

    String json = null;
    Button btnAppiledMaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civilsubjects);
        btnAppiledMaths = (Button) findViewById(R.id.btmAppliedMath);

        btnAppiledMaths.setOnClickListener(this);
        //readJsonFromAssets();
    }

    void readJsonFromAssets()
    {
        try {
            InputStream is = getAssets().open("techdrop.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            System.out.print("json:-" + json);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getApplication(),VIewPDF.class);
        i.putExtra("url","appliedmaths.pdf");
        i.putExtra("name","Applied Mathis");
        startActivity(i);
    }
}

