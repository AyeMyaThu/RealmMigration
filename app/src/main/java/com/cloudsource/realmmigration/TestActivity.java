package com.cloudsource.realmmigration;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.cloudsource.realmmigration.obj.TablesJoin;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ayemyathu on 8/16/16.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RealmConfiguration config = new RealmConfiguration.Builder(this).build();

        RealmConfiguration consConfig = new RealmConfiguration.Builder(this)
                .name("constitution.realm")
                .modules(Realm.getDefaultModule(),new TablesJoin())
                .build();


        showStatus("opening multiple realms");

    }

    private void showStatus(String txt) {
        Log.i("mylog", txt);

    }
}
