package Day7.Interface;

public class Circle implements Shape, Colorable {
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void coloring() {
        System.out.println("Coloring the circle");
    }
    
}
