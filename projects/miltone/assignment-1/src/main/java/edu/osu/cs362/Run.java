package edu.osu.cs362;

/**
 * Created by dudeman on 4/6/17.
 */
public class Run {

    public void main() {

        Point origin = new Point();
        Point SixSix = new Point(6,6);
        Point TenTen = new Point(10,10);
        Point ZeroOne = new Point(0,1);
        Point OneZero = new Point(1,0);

        Point[] pointArray = {SixSix, TenTen, ZeroOne, OneZero};

        double dist;
        for (Point currPoint : pointArray) {
            dist = origin.distanceFrom(currPoint);
            System.out.println(dist);
        }
    }
}
