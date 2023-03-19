import java.util.Scanner;

class Task1 {
    public static void main(String[] args) {
        ScreenCleaner.clearScreen();

        // Using static methods:
        // RectangleAreaStatic.getData();
        // RectangleAreaStatic.computeField();
        // RectangleAreaStatic.displayField();

        // Using non-static class:
        // RectangleArea ra = new RectangleArea();
        // ra.getData();
        // ra.computeField();
        // ra.displayField();

        // also, we can chain methods, if we'd pass the object back in each method.

        // In one line, using the constructor, without even storing the object:
        new RectangleArea();

        // In one line, using static methods:
        // RectangleAreaStatic.doAll();
    }
}

class RectangleArea {
    private int width;
    private int height; 
    private int area;

    public RectangleArea() {
        getData();
        computeField();
        displayField();
    }

    public void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width: ");
        this.width = sc.nextInt();

        System.out.println("Enter height: ");
        this.height = sc.nextInt();

        sc.close();
    }

    public void computeField() {
        area = width * height;
    }

    public void displayField() {
        System.out.println("Area: " + area);
    }
}

class RectangleAreaStatic {
    private static int width;
    private static int height;
    private static int area;

    public static void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = sc.nextInt();

        System.out.println("Enter height: ");
        height = sc.nextInt();

        sc.close();
    }

    public static void computeField() {
        area = width * height;
    }

    public static void displayField() {
        System.out.println("Area: " + area);
    }

    public static void doAll() {
        getData();
        computeField();
        displayField();
    }
}