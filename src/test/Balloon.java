package test;

import java.awt.*;

public class Balloon {
   private String text;
   private double height, width;
   private Point location;

   public Balloon(String text, double height, double width, Point location) {
      this.text = text;
      this.height = height;
      this.width = width;
      this.location = location;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public double getHeight() {
      return height;
   }

   public void setHeight(double height) {
      this.height = height;
   }

   public double getWidth() {
      return width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public Point getLocation() {
      return location;
   }

   public void setLocation(Point location) {
      this.location = location;
   }


}
