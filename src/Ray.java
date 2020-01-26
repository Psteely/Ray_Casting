import processing.core.PVector;

import java.util.ArrayList;

public class Ray {
    PVector start;
    PVector end;
    int angle;
    ArrayList<Wall> Walls;

    Ray (PVector start, PVector end, int angle) {
        this.start = start;
        this.end = end;
        this.angle = angle;

    }
    public void display (ArrayList<Wall> Walls) {
        if (intersectsWall(Walls)) {

            MainClass.processing.fill(255,0,0,100);
            MainClass.processing.stroke(3);
            MainClass.processing.line(start.x,start.y,MainClass.processing.mouseX,MainClass.processing.mouseY);
        }

 //       MainClass.processing.popMatrix();

    }

    public boolean intersectsWall(ArrayList<Wall> Walls) {
        float t = 0;
        float u = 0;
        boolean hit = false;
        for (Wall wall : Walls) {
            float x1 = wall.start.x;
            float y1 = wall.start.y;
            float x2 = wall.end.x;
            float y2 = wall.end.y;
            float x3 = MainClass.processing.width / 2;
            float y3 = MainClass.processing.height / 2;
            float x4 = MainClass.processing.mouseX;
            float y4 = MainClass.processing.mouseY;
            float tnum = (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4);
            float unum = (x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3);
            float denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
            t = tnum / denom;
            u = unum / denom;
            if (t > 0 & t < 1 & u < 1) {
                return true;
            }

        }
        return false;

    }
}
