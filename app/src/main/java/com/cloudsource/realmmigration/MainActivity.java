package com.cloudsource.realmmigration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String constitution = copyBundledRealmFile(this.getResources().openRawResource(R.raw.tbl_constitution), "tbl_constitution");
        String contact = copyBundledRealmFile(this.getResources().openRawResource(R.raw.tbl_contact), "tbl_contact");

        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .name("tbl_constitution")
                .assetFile(this, constitution)
                .schemaVersion(3)
                .build();

        try {
            Realm.migrateRealm(config,new MyMigration());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        realm = Realm.getInstance(config);
        showStatus("tbl_constitution");
        showStatus(realm);
        realm.close();


        RealmConfiguration configContact = new RealmConfiguration.Builder(this)
                .name("tbl_contact")
                .assetFile(this,contact)
                .schemaVersion(3)
                .migration(new MyMigration())
                .build();

        realm = Realm.getInstance(configContact);
        showStatus("tbl_contact");
        showStatus(realm);
        realm.close();
    }

    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void showStatus(Realm realm) {
        showStatus(realmString(realm));
    }

    private String realmString(Realm realm) {
        StringBuilder stringBuilder = new StringBuilder();
        for (tbl_constitution constitution : realm.where(tbl_constitution.class).findAll()) {
            stringBuilder.append(constitution.toString()).append("\n");
        }

        return (stringBuilder.length() == 0) ? "<data was deleted>" : stringBuilder.toString();
    }

    private void showStatus(String txt) {
        Log.i("mylog", txt);

    }
}
