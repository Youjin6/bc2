package midterm;

public class Volume {
   private int height;
   private int width;
   private int depth;
   private static int totalVolume = 0;

   public Volume(int height, int width, int depth) {
      this.height = height;
      this.width = width;
      this.depth = depth;
      totalVolume += getVolume();
   }

   public int getVolume(){
      return height * width * depth;
   }

   public int getTotalVolume() {
      return totalVolume;
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Box [ height = ");
      sb.append(height);
      sb.append(", width = ");
      sb.append(width);
      sb.append(", depth = ");
      sb.append(depth);
      sb.append(", volume = ");
      sb.append(getVolume());
      sb.append(" ]");
      return sb.toString();
   }

   public void rotate() {
      setHeight(width);
      setWidth(depth);
      setDepth(height);
   }

   private void setHeight(int height) {
      this.height = height;
   }

   private void setWidth(int width) {
      this.width = width;
   }

   private void setDepth(int depth) {
      this.depth = depth;
   }
}
