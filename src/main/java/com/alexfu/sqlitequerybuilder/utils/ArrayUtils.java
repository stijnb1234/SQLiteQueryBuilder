package com.alexfu.sqlitequerybuilder.utils;

public class ArrayUtils {
  public static String join(Object[] array, String delimeter) {
    String result = "";
    for (int i = 0, size = array.length; i < size; i++) {
      result += array[i].toString();
      if (i < size-1) {
        result += delimeter;
      }
    }

    return result;
  }
}