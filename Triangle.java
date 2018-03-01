/*
Program: Geometric subclass.
Can set length of each side of triangle.
Can get area and perimeter of the triangle.
Can use superclass's functions to set/get color, fill state and date created
**Need Geometric.java file to run this file**
Author: Hojung An
Date: February 28, 2018*/

import java.util.Scanner;

public class Triangle extends Geometric {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = s * ( (s - side1) * (s - side2) * (s - side3) );
        return Math.sqrt(area);
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public static void main(String[] args) {
        Triangle tri;

        Scanner scanner = new Scanner(System.in);

        String input;

        double s1, s2, s3;
        System.out.println("Enter properties for new Triangle");
        System.out.print("Side1 length: ");
        input = scanner.nextLine();
        s1 = Double.parseDouble(input);
        System.out.print("Side2 length: ");
        input = scanner.nextLine();
        s2 = Double.parseDouble(input);
        System.out.print("Side3 length: ");
        input = scanner.nextLine();
        s3 = Double.parseDouble(input);
        tri = new Triangle(s1, s2, s3);

        System.out.print("Triangle's color: ");
        input = scanner.nextLine();
        tri.setColor(input);

        System.out.print("Is triangle filled? ");
        input = scanner.nextLine();
        if(input == "Y" || input == "y") {
            tri.setFilled(true);
        }else {
            tri.setFilled(false);
        }

        System.out.println("Triangle's color is: " + tri.getColor());
        System.out.println(tri.isFilled() ? "Triangle is filled" : "Triangle is not filled");
        System.out.println("Triangle's area is: " + tri.getArea());
        System.out.println("Triangle's perimeter is: " + tri.getPerimeter());
        System.out.print(tri.toString());


        scanner.close();
    }
}
