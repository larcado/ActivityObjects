package de.larcado.activityobjectsexample;

import android.os.Bundle;

import de.larcado.activityobjects.AbstractActivityObjects;

/**
 * Created by larcado on 21.06.2016.
 */
public class ThirdActivity extends AbstractActivityObjects {

    MyOwnObject surviver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        You can also integrate Objects only for this Activity in Android Lifecyle
        For example when device will rotate the Activity will be finished and recreated with savedInstanceState

        All Objects must be Serializable!
         */

        if(savedInstanceState==null) { //Activity first launch
            surviver = new MyOwnObject("I will survive!", 100);
        } else { //Activity recreation
            surviver = (MyOwnObject) getSavedActivityObject(savedInstanceState, "surviver key");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        putSavedActivityObject(outState, "surviver key", surviver);
        super.onSaveInstanceState(outState);
    }
}
