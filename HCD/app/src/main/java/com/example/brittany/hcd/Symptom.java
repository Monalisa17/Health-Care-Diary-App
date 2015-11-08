package com.example.brittany.hcd;

/**
 * Created by Britt-Britt on 11/7/2015.
 */
public class Symptom extends Entry {

    int pain;
    int duration;

    public int getPainLevel(){return pain;}
    public void setPainLevel(int p){this.pain=p;}

    public int getDuration(){return duration;}
    public void setDuration(int d){this.duration=d;}

    public Symptom(String n, String d, int p, int dur){
        super();
        this.pain=p;
        this.duration=dur;
    }

}
