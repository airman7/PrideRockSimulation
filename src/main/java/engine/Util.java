package engine;

public class Util {

  public final static String ANSI_CLS = "\u001b[2J";
  public final static String ANSI_HOME = "\u001b[H";
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static String[][] getMapData() {
    //7 x 7
    String raw =
                "GRASS GRASS WATER GRASS GRASS WATER GRASS@" +
                "WATER GROUND TREE GRASS GRASS WATER GRASS@" +
                "ROCK TREE GRASS ROCK TREE GRASS ROCK@" +
                "WATER GROUND TREE GRASS GRASS WATER GRASS@" +
                "ROCK TREE GRASS ROCK TREE GRASS ROCK@" +
                "GRASS GRASS WATER GRASS GRASS WATER GRASS@" +
                "WATER GROUND TREE GRASS GRASS WATER GRASS@";

    String[] rows = raw.split("@");
    String[][] data = new String[rows.length][rows.length];
    int i = 0;
    for(String row: rows) {
      data[i++] = row.split(" ");
    }
    return data;
  }

  public static int clamp(int value, int min, int max) {
    if(value < min) {
      return min;
    } else if(value > max) {
      return max;
    }
    return value;
  }

  public static void clearScreen() {
    System.out.print(ANSI_CLS + ANSI_HOME);
    System.out.flush();
  }

  public static void colorPrint(String color, String input) {
    System.out.print(color + input + ANSI_RESET);
  }


}
