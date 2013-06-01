package edu.danib.simplejsonapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by Daniela on 01/06/13.
 */
public class SearchTask extends AsyncTask<String, Void, String> {

    private TwitterService twitterService;
    private MainActivity mainActivity;
    private ProgressDialog progressDialog;

    public SearchTask(MainActivity mainActivity) {
        this.twitterService = new TwitterService();
        this.progressDialog = new ProgressDialog(mainActivity);
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        String query = params[0];
        return getTwitterService().getTwitterSearch(query);
    }

    @Override
    protected void onPostExecute(final String result) {
        mainActivity.showResults(result);
        progressDialog.dismiss();
    }

    public TwitterService getTwitterService() {
        return twitterService;
    }
}
