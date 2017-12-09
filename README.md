# PDF_Reader
Offline PDF reader

1. Add app level depedencies 
  compile 'com.github.barteksc:android-pdf-viewer:2.8.1'
  
2. Add xml code to view PDF    

<com.github.barteksc.pdfviewer.PDFView
        android:id="@+id/pdfView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
        
3. Create asset folder and paste the "sample.pdf"         
        
4. in java class

public class VIewPDF extends AppCompatActivity {

    PDFView pdfView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpdf);

        pdfView = (PDFView) findViewById(R.id.pdfView);

        pdfView.fromAsset("sample.pdf").load();

    }
}

 
 
