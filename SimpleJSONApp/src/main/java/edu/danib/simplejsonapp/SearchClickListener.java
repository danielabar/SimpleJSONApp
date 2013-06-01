package edu.danib.simplejsonapp;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Daniela on 01/06/13.
 */
public class SearchClickListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private EditText searchText;

    public SearchClickListener(EditText searchText, MainActivity mainActivity) {
        this.searchText = searchText;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        String query = getSearchText().getText().toString();
        new SearchTask(getMainActivity()).execute(query);
    }

    public EditText getSearchText() {
        return searchText;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

}
