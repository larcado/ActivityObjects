package de.larcado.activityobjectsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import de.larcado.activityobjects.ActivityObjects;

/**
 * Created by larcado on 21.06.2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Object> objectList = new ArrayList<>();
        objectList.add(new MyOwnObject("cool objects", 3));
        objectList.add(new MyOwnObject("cool objects 2", 7));

        ActivityObjects.passObjectsToActivity(this, SecondActivity.class, objectList);
    }
}
