package Day7.Interface;

public interface Colorable {
    void coloring();
    default void displayColorInfo() {
        System.out.println("This shape can be colored.");
    }
}
