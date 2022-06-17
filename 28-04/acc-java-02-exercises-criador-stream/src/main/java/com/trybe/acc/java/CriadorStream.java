package com.trybe.acc.java;

import java.util.List;
import java.util.stream.Stream;

public class CriadorStream {

  /**
   * criarDoItem - make a stream of a single item.
   * 
   * @param <T>  - the generic type of the item
   * @param item - the item for converting to a stream
   * @return - the stream of the item
   */
  public <T> Stream<T> criarDoItem(T item) {
    return Stream.of(item);
  }

  /**
   * criarDoArray - make a stream of an array.
   * 
   * @param <T>   - the generic type of the array elements
   * @param array - the array for converting to a stream
   * @return - the stream of the array
   */
  public <T> Stream<T> criarDoArray(T[] array) { // https://mkyong.com/java8/java-how-to-convert-array-to-stream/
    return Stream.of(array);
  }

  /**
   * criarDaLista - make a stream of a list.
   * 
   * @param <T>   - the generic type of the list elements
   * @param lista - the list for converting to a stream
   * @return - the stream of the list
   */
  public <T> Stream<T> criarDaLista(List<T> lista) {
    return lista.stream();
  }
}
