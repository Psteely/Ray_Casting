import processing.core.PVector;

import java.util.ArrayList;

import static processing.core.PApplet.radians;

public class Ray {
    PVector start;
    PVector end;
    PVector direction;
    PVector pointOfIntersection;
    PVector closestIntersection;

    ArrayList<Wall> Walls;

    Ray(PVector start, int angle) {
        this.start = start;
        this.direction = PVector.fromAngle(radians(angle));
       MainClass.processing.println(angle);
       //MainClass.processing.println(this.direction.angleBetween(direction,start));

    }


    public void display(ArrayList<Wall> Walls, PVector move) {
//        direction = end_.sub(start);
//        direction.normalize();
        start = move;

        if (intersectsWall(Walls)) {

            //MainClass.processing.fill(255,  200);
            MainClass.processing.stroke(255,200);
            MainClass.processing.strokeWeight(0.3f);
            MainClass.processing.line(start.x, start.y, closestIntersection.x , closestIntersection.y );
        }

        //       MainClass.processing.popMatrix();

    }

    public boolean intersectsWall(ArrayList<Wall> Walls) {
        float t = 0;
        float u = 0;
        boolean hit = false;
        float closestWall = MainClass.processing.width * MainClass.processing.height;
        for (Wall wall : Walls) {
            float x1 = wall.start.x;
            float y1 = wall.start.y;
            float x2 = wall.end.x;
            float y2 = wall.end.y;
            float x3 = start.x;
            float y3 = start.y;
            float x4 = start.x + direction.x;
            float y4 = start.y + direction.y;
            float tnum = (x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4);
            float unum = (x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3);
            float denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
            t = tnum / denom;
            u = unum / denom;
            if (t > 0 & t < 1 & u < 1) {
                pointOfIntersection = new PVector((x1 + t * (x2 - x1)), (y1 + t * (y2 - y1)));
                float dist = start.dist(pointOfIntersection);
                if (dist<closestWall) {
                    closestWall= dist;
                    closestIntersection = pointOfIntersection;
                }
               // showPointOfIntersection(closestIntersection);
                hit = true;
            }

        }
        if (hit) {
            return true;
        } else {
            return false;
        }

    }

    public void showPointOfIntersection(PVector pos) {
        MainClass.processing.fill(255, 10, 255);
        MainClass.processing.ellipse(pos.x, pos.y, 8, 8);

    }
}

