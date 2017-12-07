package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;


/**
 * Created by Carl_johnson on 04-12-2017.
 */

public class VIewPDF extends AppCompatActivity {

    PDFViewPager pdfViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpdf);
        setTitle("This is file");
        pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        Toast.makeText(getApplicationContext(),"Reading " + url ,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BasePDFPagerAdapter) pdfViewPager.getAdapter()).close();
    }
}
