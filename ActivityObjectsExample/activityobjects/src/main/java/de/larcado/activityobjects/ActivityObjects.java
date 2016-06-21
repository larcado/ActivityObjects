package de.larcado.activityobjects;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.List;

/**
 * Created by larcado on 29.04.16.
 */
public class ActivityObjects {

	public static final String ACTIVITY_OBJECTS = "ActivityObjects";
	private static int request = 0;
	private static HashMap<String, Object[]> hashMap = new HashMap<>();

	public static Intent passObjectsToActivity(Context from, Class to, List<Object> objects) {
		return passObjectsToActivity(from, to, objects.toArray());
	}

	public static Intent passObjectsToActivity(Context from, Class to, Object[] objects) {
		request++;
		String key = String.valueOf(request);
		Intent intent = new Intent(from, to);
		intent.putExtra(ACTIVITY_OBJECTS, key);
		hashMap.put(key, objects);
		return intent;
	}

	public static Object[] getObjects(Bundle bundle) {
		String key = bundle.getString(ACTIVITY_OBJECTS);
		if (key == null) {
			return null;
		}
		Object[] objects = hashMap.get(key);
		hashMap.remove(key);
		return objects;
	}
}
