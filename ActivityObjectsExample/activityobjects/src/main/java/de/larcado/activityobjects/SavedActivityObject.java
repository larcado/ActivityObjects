package de.larcado.activityobjects;

import java.io.Serializable;

/**
 * Created by larcado on 10.06.16.
 */
public class SavedActivityObject implements CharSequence, Serializable {

	private static final long serialVersionUID = 1L;

	private Object objects;

	public SavedActivityObject(Object objects) {
		this.objects = objects;
	}

	public Object getObject() {
		return objects;
	}

	public void setObject(Object objects) {
		this.objects = objects;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public char charAt(int index) {
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return null;
	}

	@Override
	public String toString() {
		if(objects!=null) {
			return objects.toString();
		}
		return "";
	}
}
