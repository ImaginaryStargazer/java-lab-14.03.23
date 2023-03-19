class Task2 {
    public static void main(String[] args) {
        ScreenCleaner.clearScreen();

        Car car = new Car("Model", "Brand", 2010, 100000, "red", 10);
        System.out.println("> toString() method:");
        System.out.println(car.toString());

        System.out.println("> sell() method:");
        car.sell();
        System.out.println(car.getQuantity());

        System.out.println("> a couple of setters:");
        car.setBrand("Tesla");
        car.setModel("Model 3");
        car.setQuantity(car.getQuantity() + 1);
        car.deliver(); // works the same as the previous line
        car.deliver(10); // method overloading

        System.out.println("> toString() method:");
        System.out.println(car.toString());
    }
}

class Car {
    private String model;
    private String brand;
    private int year;
    private int price;
    private String color;
    private int quantity;

    public Car(String model, String brand, int year, int price, String color, int quantity) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand
                + ", color=" + color
                + ", model=" + model
                + ", price=" + price
                + ", quantity=" + quantity
                + ", year=" + year + "]";
    }

    public void deliver(int quantity) {
        this.quantity += quantity;
        System.out.println("Delivered this much cars: " + quantity);
    }

    public void deliver() {
        deliver(1);
    }

    public void sell(int quantity) {
        if (this.quantity == 0 || this.quantity - quantity < 0) {
            System.out.println("Not enough cars to sale!");
            return;
        }

        this.quantity -= quantity;
        System.out.println("Sold a car");
    }

    public void sell() {
        sell(1);
    }

    public boolean isEquals(Car car) {
        if (this.model == car.model
                && this.brand == car.brand
                && this.year == car.year
                && this.price == car.price
                && this.color == car.color
                && this.quantity == car.quantity) {
            return true;
        }

        return false;
    }
}
