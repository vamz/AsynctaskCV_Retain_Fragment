package com.example.martin.asynctaskcv;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListFragment;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends ListFragment {


    private String[] databazaData = {"item 1", "item 2", "item 3", "item 4", "item 5", "item 6", "item 7", "item 8", "item 9", "item 10", "item 11", "item 12", "item 13", "item 14", "item 15", "item 16", "item 17", "item 18", "item 19", "item 20", "item 21", "item 22"};
    private ArrayList<String> model;
    private ArrayAdapter<String> newArrayAdapter;
    private OnFragmentInteractionListener mListener;


    public static ItemFragment newInstance() {
        ItemFragment fragment = new ItemFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Use this fragment as RetainFragment http://developer.android.com/guide/topics/resources/runtime-changes.html
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
            //TODO run AddStringTask as AsyncTask.execute
        }


        //newArrayAdapter = //TODO create new arrayAdapter //
        setListAdapter(newArrayAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onFragmentInteraction(model.get(position));
        }
    }


    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(String item);
    }

    //TODO use AsyncTask for filling newArrayAdapter with data from databazaData
    // Link: http://developer.android.com/reference/android/os/AsyncTask.html
    // Hint:
    // Load data in 'for' cycle. Every cycle iteration slowdown with use of 'SystemClock.sleep(500)' wich will emulate slow loading
    // For adding data to 'arrryAdapter' use : newArrayAdapter.add(values[0])

    class AddStringTask extends AsyncTask<Void, String, Void> {
    }

}
