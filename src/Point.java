import processing.core.PVector;

public class Point {
    PVector pos;
    PVector vel;
    int numberOfRays = 360 /10;
    int angle;
    Ray[] r;

    Point (PVector pos, int angle) {
        this.pos = pos;
        r = new Ray[numberOfRays];
        for (int i = 0; i < r.length; i++) {
            r[i].start = pos;
        }
    }

    public void display () {
        MainClass.processing.fill(255,0,0,100);
        MainClass.processing.noStroke();
        MainClass.processing.circle(0,0,16);
    }
}
