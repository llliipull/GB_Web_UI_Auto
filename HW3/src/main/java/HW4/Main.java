package HW4;

public class Main {

    public static void main(String[] args) {

        System.out.println("Triangle square is: " + calculateTriangleSquare(5.0, 4.0, 3.0));


    }

    public static double calculateTriangleSquare (double a, double b, double c){

        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }
}
