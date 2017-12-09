package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * Created by Carl_johnson on 04-12-2017.
 */

public class VIewPDF extends AppCompatActivity {

    PDFView pdfView;
    String filename,name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpdf);


        Intent intent = getIntent();
        filename = intent.getStringExtra("url");
        name = intent.getStringExtra("name");

        setTitle("Your Reading " + name);

        pdfView = (PDFView) findViewById(R.id.pdfView);

        pdfView.fromAsset(filename).load();

    }
}
