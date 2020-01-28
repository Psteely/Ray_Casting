import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class MainClass extends PApplet {
    public static PApplet processing;

    // Added on Linux
    // Added on Work PC
    //
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    PVector start;
    PVector end;
   // Ray r;
    ArrayList<Wall> Walls = new ArrayList<Wall>();
    Point p;

    public void setup() {
        processing = this;
        surface.setSize(800, 800);
        Walls.add(new Wall(new PVector(0,0), new PVector(width,0)));
        Walls.add(new Wall(new PVector(width,0), new PVector(width,height)));
        Walls.add(new Wall(new PVector(width,height), new PVector(0,height)));
        Walls.add(new Wall(new PVector(0,height), new PVector(0,0)));

         p = new Point(new PVector(width/2,height/2));
    }

    public void draw() {
        background(0);
        for (Wall w : Walls) {
            w.display();
        }
        p.display(Walls);
        p.movePoint();


        if (mousePressed) {
            fill(0);
            stroke(0);
            strokeWeight(3);
            line(start.x, start.y, mouseX, mouseY);
        }

    }

    public void mousePressed() {
        start = new PVector();
        start.x = mouseX;
        start.y = mouseY;
    }

    public void mouseHeld() {
        fill(0);
        stroke(0);
        strokeWeight(3);
        line(start.x, start.y, mouseX, mouseY);
    }

    public void mouseReleased() {
        end = new PVector();
        end.x = mouseX;
        end.y = mouseY;
        Walls.add(new Wall(start, end));

    }


}