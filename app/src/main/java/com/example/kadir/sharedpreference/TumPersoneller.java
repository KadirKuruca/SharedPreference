package com.example.kadir.sharedpreference;

//Farklı Personel Türlerini Tutacak Bir Sınıf.

public class TumPersoneller<T> {

    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
