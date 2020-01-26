import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class MainClass extends PApplet {
    public static PApplet processing;

    //
    public static void main(String[] args) {
        PApplet.main("MainClass", args);
    }

    PVector start;
    PVector end;
    Ray r;
    ArrayList<Wall> Walls = new ArrayList<Wall>();
    Point p;

    public void setup() {
        processing = this;
        surface.setSize(900, 900);
        r = new Ray(new PVector(width / 2, height / 2), new PVector(mouseX, mouseY), 1);

    }

    public void draw() {
        background(255);
        for (Wall w : Walls) {
            w.display();
        }
        // p.display();
        r.display(Walls);



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
        MainClass.processing.println(Walls.size());
    }


}