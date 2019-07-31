package engine;

public class Util {

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
}
