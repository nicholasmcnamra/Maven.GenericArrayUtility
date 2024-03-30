package com.zipcodewilmington.arrayutility;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer numOccurrences = 0;
        for(int i = 0; i < this.inputArray.length; i++) {
            if (this.inputArray[i] == valueToEvaluate) {
                numOccurrences++;
            }
        }
        return numOccurrences;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        ArrayList<T> repeatingValues = new ArrayList<T>(Arrays.asList(this.inputArray));
        repeatingValues.addAll(Arrays.asList(arrayToMerge));
        int max_count = 0;
        T maxFreq = null;

        for(int i = 0; i < repeatingValues.size(); i++) {
            int count = 0;
            for (int j = 0; j < repeatingValues.size(); j++) {
                if (repeatingValues.get(i) == repeatingValues.get(j)) {
                    count++;
                }
            }
            if (count > max_count) {
                max_count = count;
                maxFreq = repeatingValues.get(i);
            }
        }
        return maxFreq;
//
//        return null;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> newArrayList = new ArrayList<>(Arrays.asList(this.inputArray));
        for (int i = 0; i < newArrayList.size(); i++) {
            if (newArrayList.get(i) == valueToRemove) {
                newArrayList.remove(i);
            }
        }
        T[] array = newArrayList.toArray((T[]) Array.newInstance(valueToRemove.getClass(), newArrayList.size()));
        return array;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer dupes = 0;
        ArrayList<T> inputArrList = new ArrayList<>(Arrays.asList(this.inputArray));
        inputArrList.addAll(Arrays.asList(arrayToMerge));
        for (int i = 0; i < inputArrList.size(); i++) {
            if (inputArrList.get(i) == valueToEvaluate) {
                dupes++;
            }
        }
        return dupes;
    }
}
