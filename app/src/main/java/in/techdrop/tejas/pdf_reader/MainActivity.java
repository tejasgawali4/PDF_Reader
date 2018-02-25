package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mbtnCivil, mbtncom, mbtnej;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnCivil = (Button) findViewById(R.id.btnCivil);

        mbtncom = (Button) findViewById(R.id.btnComputer);

        mbtnCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CivilSemister.class);
                startActivity(i);
            }
        });

/*        mbtnCivil.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CompSemister.class);
                startActivity(i);
            }

        });
        mbtnCivil.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EjSemister.class);
                startActivity(i);
            }

        });*/
    }
}
