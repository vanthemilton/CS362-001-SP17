package edu.osu.cs362;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by dudeman on 4/6/17.
 */
public class Point {

    //              Member variables
    private int Xaxis;
    private int Yaxis;

    //              Constructor
    public Point() {
        setXaxis(0);    // set to origin
        setYaxis(0);
    }

    public Point(int X_Coordinate, int Y_Coordinate) {
        setXaxis(X_Coordinate);
        setYaxis(Y_Coordinate);
    }

    //              Getters and Setters
    public int getXaxis() {
        return Xaxis;
    }

    public void setXaxis(int newX) {
        Xaxis = newX;
    }

    public int getYaxis() {
        return Yaxis;
    }

    public void setYaxis(int newY) {
        Yaxis = newY;
    }

    public double distanceFrom(Point otherPoint) {

        double XDist, YDist, distance;
        XDist = pow(this.getXaxis() - otherPoint.getXaxis(), 2);
        YDist = pow(this.getYaxis() - otherPoint.getYaxis(), 2);

        distance = sqrt(XDist + YDist);
        return distance;

    }

}