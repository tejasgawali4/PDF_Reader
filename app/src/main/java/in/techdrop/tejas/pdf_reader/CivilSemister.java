package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saloni on 12/10/2017.
 */

public class CivilSemister extends AppCompatActivity implements View.OnClickListener {

    Button mbtnSem1 ,mbtnSem2,mbtnSem3 ,mbtnSem4 , mbtnSem5,mbtnSem6;
    String name , filename;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.semister);

        mbtnSem1 = (Button) findViewById(R.id.btnSem1);
        mbtnSem2 = (Button) findViewById(R.id.btnSem2);
        mbtnSem3 = (Button) findViewById(R.id.btnSem3);
        mbtnSem4 = (Button) findViewById(R.id.btnSem4);
        mbtnSem5 = (Button) findViewById(R.id.btnSem5);
        mbtnSem6 = (Button) findViewById(R.id.btnSem6);

        mbtnSem1.setOnClickListener(this);
        mbtnSem2.setOnClickListener(this);
        mbtnSem3.setOnClickListener(this);
        mbtnSem4.setOnClickListener(this);
        mbtnSem5.setOnClickListener(this);
        mbtnSem6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mbtnSem1)
        {
            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","1");
            startActivity(i);
        }
        else if (v == mbtnSem2)
        {
            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","2");
            startActivity(i);
        }
        else if (v == mbtnSem3)
        {
            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","3");
            startActivity(i);

        }else if (v == mbtnSem4)
        {

            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","4");
            startActivity(i);

        }else if (v == mbtnSem5)
        {
            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","5");
            startActivity(i);

        }else if (v == mbtnSem6)
        {
            Intent i = new Intent(this,CivilSubjects.class);
            i.putExtra("semType","6");
            startActivity(i);
        }
    }
}
