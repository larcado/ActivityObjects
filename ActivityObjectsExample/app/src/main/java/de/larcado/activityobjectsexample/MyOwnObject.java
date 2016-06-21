package de.larcado.activityobjectsexample;

import java.io.Serializable;

/**
 * Created by larcado on 21.06.2016.
 */
public class MyOwnObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int number;

    public MyOwnObject(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
