package com.example.martin.asynctaskcv;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *
 */
public class ItemFragment extends Fragment {


    private String[] databazaData = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10", "item 11", "item 12", "item 13", "item 14", "item 15", "item 16", "item 17", "item 18", "item 19", "item 20", "item 21", "item 22"};
    private AddStringTask addStringTask;

    public ArrayList<String> getModel() {
        return model;
    }

    private ArrayList<String> model;

    public ArrayAdapter<String> getNewArrayAdapter() {
        return newArrayAdapter;
    }

    private ArrayAdapter<String> newArrayAdapter;

    public static ItemFragment newInstance(Context context) {

        ItemFragment fragment = new ItemFragment();
        fragment.newArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Use this fragment as RetainFragment http://developer.android.com/guide/topics/resources/runtime-changes.html
        setRetainInstance(true);
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (model == null) {
            model = new ArrayList<String>();
            newArrayAdapter.addAll(model);
            //TODO run AddStringTask as AsyncTask.execute
            addStringTask = new AddStringTask();
            addStringTask.execute();
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        //addStringTask.cancel(true);
    }


    //TODO use AsyncTask for filling newArrayAdapter with data from databazaData
    // Link: http://developer.android.com/reference/android/os/AsyncTask.html
    // Hint:
    // Load data in 'for' cycle. Every cycle iteration slowdown with use of 'SystemClock.sleep(500)' wich will emulate slow loading
    // For adding data to 'arrryAdapter' use : newArrayAdapter.add(values[0])

    class AddStringTask extends AsyncTask<Void, String, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (String s : databazaData) {
                publishProgress(s);
                SystemClock.sleep(500);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            newArrayAdapter.add(values[0]);
            newArrayAdapter.notifyDataSetChanged();
        }
    }

}
