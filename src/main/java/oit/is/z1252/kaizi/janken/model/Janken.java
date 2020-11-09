package oit.is.z1252.kaizi.janken.model;

public class Janken {
  public static int jankenBattle(int myhand) {
    int comhand = 0;
    int result = (myhand - comhand + 3) % 3;
    return result;
  }

  public static String getresultString(int result) {
    if (result == 0) {
      return "あいこ";
    }
    if (result == 1) {
      return "まけ";
    }
    if (result == 2) {
      return "かち";
    }
    return "";
  }

  public static String getHandString(int hand) {
    if (hand == 0) {
      return "ぐー";
    }
    if (hand == 1) {
      return "ちょき";
    }
    if (hand == 2) {
      return "ぱー";
    }
    return "";
  }
}
