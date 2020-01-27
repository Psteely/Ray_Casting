import processing.core.PVector;

import java.util.ArrayList;

public class Point {
    PVector pos;
    PVector vel;
    int rayAngle = 1;
    int angle;
    Ray[] r;
    float xOff = 0;
    float yOff = 1000000 ;

    Point(PVector pos) {
        this.pos = pos;
        r = new Ray[360/rayAngle];
       // MainClass.processing.println(r.length);
        for (int i = 0; i < 360; i = i + rayAngle) {
            r[i/rayAngle] = new Ray(pos,i);
        }
    }

    public void display(ArrayList<Wall> Walls) {
        for (int i = 0; i < 360 / rayAngle; i++) {
            r[i].display(Walls);
        }
        MainClass.processing.fill(255, 0, 0, 100);
        MainClass.processing.noStroke();
        MainClass.processing.circle(pos.x, pos.y, 16);
    }

    public void movePoint() {

        float moveFactor = 3;
        vel = new PVector(MainClass.processing.noise(xOff),MainClass.processing.noise(yOff));
        xOff += MainClass.processing.random(-0.5f,0.5f);
        yOff += MainClass.processing.random(-0.5f,0.5f);

        pos.add(vel);

    }
}
