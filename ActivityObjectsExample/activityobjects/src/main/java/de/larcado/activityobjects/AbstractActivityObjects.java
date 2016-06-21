package de.larcado.activityobjects;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by larcado on 10.06.16.
 */
public abstract class AbstractActivityObjects extends AppCompatActivity {

	protected Bundle bundle;
	protected Object[] activityObjects;
    private final String AO = "ao", S="s";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		bundle = getIntent().getExtras();

		if (savedInstanceState != null) {
			activityObjects = (Object[]) getSavedActivityObject(savedInstanceState, AO);
		}
		else {
			activityObjects = ActivityObjects.getObjects(bundle);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		putSavedActivityObject(outState, AO, activityObjects);
		super.onSaveInstanceState(outState);
	}

	protected void putSavedActivityObject(Bundle outState, String key, Serializable obj) {
		Objects.requireNonNull(outState);
		Objects.requireNonNull(key);
		Objects.requireNonNull(obj);
		SavedActivityObject cso = new SavedActivityObject(obj);
		outState.putCharSequence(key, cso);
		outState.putSerializable(key + S, obj);
	}

	protected Object getSavedActivityObject(Bundle savedInstanceState, String key) {
		Objects.requireNonNull(savedInstanceState);
		Objects.requireNonNull(key);

		Object nonSerialized = savedInstanceState.get(key);
		if (nonSerialized != null && nonSerialized instanceof SavedActivityObject) {
			return ((SavedActivityObject) nonSerialized).getObject();
		}

		Object serialized = savedInstanceState.getSerializable(key + S);
		if (serialized == null) {
			throw new ActivityObjectsException("ActivityObject konnten nicht wiederhergestellt werden");
		}

		return serialized;
	}

	public void setSubtitle(String title) {
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setSubtitle(title);
		}
	}
}
