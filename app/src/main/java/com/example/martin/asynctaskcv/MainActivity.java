package com.example.martin.asynctaskcv;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);


        //TODO After app. restart(configuration changes) you need to find the instance of fragment by the Tag name that you assigned when the new fragment was added.

        ItemFragment itemFragment = (ItemFragment) getFragmentManager().findFragmentByTag("retainFragment");
        if (itemFragment == null) {
            itemFragment = ItemFragment.newInstance(this);

            //TODO If doesn't exists ItemFrament than, with use of FragmentManager, create new instance of fragment. Show this new fragment in R.id.container view
            // link: http://developer.android.com/guide/components/fragments.html
            // link: Use itemfragment as RetainFragment http://developer.android.com/guide/topics/resources/runtime-changes.html

        }
        listView.setAdapter(itemFragment.getNewArrayAdapter());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
