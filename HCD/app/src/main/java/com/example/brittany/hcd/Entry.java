package com.example.brittany.hcd;

/**
 * Created by Britt-Britt on 11/7/2015.
 */
public class Entry {

    private String name;
    private String description;

    public String getName(){return name;}
    public void setName(String n){this.name=n;}

    public String getDescription(){return description;}
    public void setDescription(String d){this.description=d;}

    public Entry(String n, String d){
        super();
        this.name=n;
        this.description=d;
    }

    public Entry(){
        super();
        this.name="";
        this.description="";
    }

}


