import processing.core.PVector;

import java.util.ArrayList;

public class Point {
    PVector pos;
    PVector direction;
    int rayAngle = 1;
    int angle;
    Ray[] r;
    float xOff = 0;
    float yOff = 10000 ;

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
            r[i].display(Walls, pos);
        }
        MainClass.processing.fill(255, 0, 0, 100);
        MainClass.processing.noStroke();
        MainClass.processing.circle(pos.x, pos.y, 16);
    }

    public void movePoint() {

        float moveFactor = 3;
        direction = new PVector(MainClass.processing.noise(xOff) * MainClass.processing.width,MainClass.processing.noise(yOff) * MainClass.processing.height);
//        xOff += MainClass.processing.random(-0.1f,0.1f);
//        yOff += MainClass.processing.random(-0.1f,0.1f);
        xOff += 0.01;
        yOff += 0.01;

        pos = direction;

    }
}
