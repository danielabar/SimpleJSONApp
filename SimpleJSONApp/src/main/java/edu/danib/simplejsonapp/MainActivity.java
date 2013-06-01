package edu.danib.simplejsonapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText searchText;
    private Button searchButton;
    private TextView searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViewsById();
        searchButton.setOnClickListener(new SearchClickListener(searchText, this));
    }

    public void showResults(String result) {
        this.searchResults.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void findAllViewsById() {
        searchText = (EditText) findViewById(R.id.searchInput);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchResults = (TextView) findViewById(R.id.searchResults);
    }
    
}
