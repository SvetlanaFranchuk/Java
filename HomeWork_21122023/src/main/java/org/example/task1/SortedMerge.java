package org.example.task1;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortedMerge extends RecursiveTask<String[]> {
    private String[] arr;

    public SortedMerge(String[] arr) {
        this.arr = arr;
    }

    @Override
    protected String[] compute() {
        if (arr.length <= 1){
            return arr;
        } else {
            int middle = arr.length / 2;
            String[] leftArr = Arrays.copyOfRange(arr, 0, middle);
            String[] rightArr = Arrays.copyOfRange(arr, middle+1, arr.length);

            SortedMerge leftTask = new SortedMerge(leftArr);
            SortedMerge rightTask = new SortedMerge(rightArr);

            invokeAll(leftTask, rightTask);

            String[] leftResult = leftTask.join();
            String[] rightResult = rightTask.join();

            return merge(leftResult, rightResult);
        }
  }

    private String[] merge(String[] leftResult, String[] rightResult) {
        String[] arrMerged = new String[leftResult.length + rightResult.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;
        while (leftIndex < leftResult.length && rightIndex < rightResult.length) {
            if (leftResult[leftIndex].length() < rightResult[rightIndex].length()) {
                arrMerged[mergeIndex++] = leftResult[leftIndex++];
            } else {
                arrMerged[mergeIndex++] = rightResult[rightIndex++];
            }
        }

        while (leftIndex < leftResult.length) {
            arrMerged[mergeIndex++] = leftResult[leftIndex++];
        }

        while (rightIndex < rightResult.length) {
            arrMerged[mergeIndex++] = rightResult[rightIndex++];
        }

        return arrMerged;
    }
}
