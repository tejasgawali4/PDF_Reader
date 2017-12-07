package in.techdrop.tejas.pdf_reader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.File;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;
import es.voghdev.pdfviewpager.library.asset.CopyAsset;
import es.voghdev.pdfviewpager.library.asset.CopyAssetThreadImpl;


/**
 * Created by Carl_johnson on 04-12-2017.
 */

public class VIewPDF extends AppCompatActivity {

    PDFViewPager pdfViewPager;
    BasePDFPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpdf);

        pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");

        Toast.makeText(getApplicationContext(),"Reading " + url ,Toast.LENGTH_SHORT).show();

        CopyAsset copyAsset = new CopyAssetThreadImpl(this, new Handler());
        copyAsset.copy(url, new File(getCacheDir(), url).getAbsolutePath());

        adapter = new PDFPagerAdapter(this, url);
        pdfViewPager.setAdapter(adapter);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
