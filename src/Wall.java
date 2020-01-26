import processing.core.PVector;

public class Wall {
    PVector start;
    PVector end;

    Wall(PVector start, PVector end) {
        this.start = start;
        this.end = end;
    }

    void display () {
        MainClass.processing.stroke(255,0,0);
        MainClass.processing.strokeWeight(2);
        MainClass.processing.line(start.x,start.y,end.x,end.y);

    }

}
