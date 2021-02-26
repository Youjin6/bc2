package code.wk3_wed;

/**
 * Rectangle class
 */


public class Rectangle<T> {
    private T length;
    private T width;

    /**
     * Constructor
     *
     * @param len The length of the rectangle.
     * @param w   The width of the rectangle.
     */

    public Rectangle(T len, T w) {
        length = len;
        width = w;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
              "length=" + length +
              ", width=" + width +
              '}';
    }

    /**
     * The setLength method stores a value in the
     * length field.
     *
     * @param len The value to store in length.
     */

    public void setLength(T len) {
        length = len;
    }

    /**
     * The setWidth method stores a value in the
     * width field.
     *
     * @param w The value to store in width.
     */

    public void setWidth(T w) {
        width = w;
    }

    /**
     * The getLength method returns a Rectangle
     * object's length.
     *
     * @return The value in the length field.
     */

    public T getLength() {
        return length;
    }

    /**
     * The getWidth method returns a Rectangle
     * object's width.
     *
     * @return The value in the width field.
     */

    public T getWidth() {
        return width;
    }



}
