# ActivityObjects

ActivityObjects is a Android library to simply pass Java-Objects from one Activity to another

## In general:
We will create Activitys by AbstractActivityObjects instead by AppCompatAcvtivity
```java
public class MyActivity extends AbstractActivityObjects { // AbstractActivityObjects extends AppCompatActivity
}
```

## How to use:
First create a Object[] or List<Object> where all your Objects to pass are included
```java
List<Object> objectList = new ArrayList<>();
objectList.add(new MyOwnObject("cool objects", 3));
objectList.add(new MyOwnObject("cool objects 2", 7));
```
Now just call
```java
public static Intent passObjectsToActivity(Context from, Class to, List<Object> objects);
public static Intent passObjectsToActivity(Context from, Class to, Object[] objects);
```
from ActivityObjects
```java
Intent intent = ActivityObjects.passObjectsToActivity(this, SecondActivity.class, objectList);
//here you can add more to the Intent (e.g. flags)
startActivity(intent);
```

## Integrate Objects into Android Lifecycle for same Activity:
E.g. when the android device will rotate the current Activity will finished and recreated with savedInstances

You have a Object created in a Activity. Let us call him surviver, but android device rotated :(

Surviver was killed...

Ok. Let's start new :D

In onCreate method are savedInstances
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    if(savedInstanceState==null) { //Activity first launch
        surviver = new MyOwnObject("I will survive!", 100);
    } else { //Activity recreation
        surviver = (MyOwnObject) getSavedActivityObject(savedInstanceState, "surviver key");
    }
    
    ...
}
```
We will check if savedInstances are null (Activity first start)

If true create the surviver, if false getSavedActivityObject

But stop!!! Where comes getSavedActivityObject from?

```java
public class MyActivity extends AbstractActivityObjects { // AbstractActivityObjects extends AppCompatActivity
}
```
You must only put the surviver before in onSavedInstanceState
```java
@Override
public void onSaveInstanceState(Bundle outState) {
    putSavedActivityObject(outState, "surviver key", surviver);
    super.onSaveInstanceState(outState);
}
```

# License
No license :D !!! Feel free to share, copy, fork, ...
