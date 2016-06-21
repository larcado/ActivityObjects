package de.larcado.activityobjects;

/**
 * Created by larcado on 17.06.16.
 */
public class ActivityObjectsException extends RuntimeException {
	public ActivityObjectsException(String detailMessage) {
		super(detailMessage);
	}

	public ActivityObjectsException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}
}
