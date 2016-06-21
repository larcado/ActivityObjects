package de.larcado.activityobjectsexample;

import android.os.Bundle;

import de.larcado.activityobjects.AbstractActivityObjects;

/**
 * Created by larcado on 21.06.2016.
 */
public class SecondActivity extends AbstractActivityObjects {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOwnObject myOwnObject1 = (MyOwnObject) activityObjects[0];
        MyOwnObject myOwnObject2 = (MyOwnObject) activityObjects[1];

        myOwnObject1.getName(); // cool objects
        myOwnObject1.getNumber(); // 3

        myOwnObject2.getName(); // cool objects 2
        myOwnObject2.getNumber(); // 7
    }
}
