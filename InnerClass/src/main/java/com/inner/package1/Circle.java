package com.inner.package1;

public class Circle {
    private double radius = 0;
     
    public Circle(double radius) {
        this.radius = radius;
    }

    public Draw getDraw() {
        return new Draw();
    }

    public class Draw {     // 内部类
        public void drawSahpe() {
            double radius = 2.1;
            System.out.println("drawshape");
            System.out.println(radius);
            System.out.println(Circle.this.radius);
        }
    }
}