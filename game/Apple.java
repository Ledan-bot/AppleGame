package game;

public class Apple implements GamePiece {
  public static final int SMALL = 0;
  public static final int MEDIUM = 1;
  public static final int LARGE = 2;

  int size;
  double diameter;
  double mass;
  int centerX, centerY;
  Physicist myPhysicist;

}