package com.intel.algorithm;

/**
 * Java API for cosine similarity KNN algorithm.
 *
 * Not support multi-thread.
 */
public class CosineSimilarity {

  private static Table<Integer> indicesTable;
  private static Table<Float> distancesTable;

  /**
   * 0 means no issue, -1 means issue occurs.
   *
   * Two csv files under oneDAL project can be used for test:
   * k_nearest_neighbors_train_data.csv
   * k_nearest_neighbors_test_data.csv
   *
   * @param trainDataPath  path to train data's csv file.
   * @param queryDataPath  path to test data's csv file.
   **/
  public native static int callNativeCosineSimilarity(int neighborCount,
      String trainDataPath, String queryDataPath);

  /**
   * Call by native code for init indicesTable.
   * Applicable for small amount of data.
   */
  public static void initIndicesTable(int rowCount, int columnCount) {
    indicesTable = new Table<>(rowCount, columnCount);
  }

  /**
   * Call by native code for init distancesTable.
   * Applicable for small amount of data.
   */
  public static void initDistancesTable(int rowCount, int columnCount) {
    distancesTable = new Table<>(rowCount, columnCount);
  }

  /**
   * Call by native code.
   */
  public static void setIndices(int ind, int indice) {
    indicesTable.setData(ind, indice);
  }

  /**
   * Call by native code.
   */
  public static void setDistances(int ind, float distance) {
    distancesTable.setData(ind, distance);
  }

  /**
   * API exposed to user.
   */
  public Table<Integer> getIndicesTable() {
    return indicesTable;
  }

  /**
   * API exposed to user.
   */
  public Table<Float> getDistancesTable() {
    return distancesTable;
  }

}
