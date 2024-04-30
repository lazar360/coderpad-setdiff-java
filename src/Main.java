import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // 1- return nothing when both the same in the same order
        Integer[] arr1 = {1,2,3, 4};
        Integer[] arr2 = {1,2,3,4};
        if (Arrays.equals(arr1, arr2)){
            System.out.println("");
        }

        // 2- return an added item when in a same order
        Integer[] arr3 = {1,2,3, 4};
        Integer[] arr4 = {1,2,3,4, 5};
        int minLength = arr3.length < arr4.length ? arr3.length : arr4.length;

        // 2.1 verify if arrays are in the same order
        boolean isInSameOrder = false;
        for (int i = 0; i < minLength; i++) {
            isInSameOrder = Objects.equals(arr3[i], arr4[i]);
        }

        // 2.2 return the added item
        Integer intToReturn = -1;
        if(isInSameOrder){
            intToReturn = arr3.length > arr4.length ? arr3[arr3.length-1] : arr4[arr4.length-1];
        }


        // 3- return a removed and added item when in a different order
        Integer[] arr5 = {1,2,3,4,5};
        Integer[] arr6 = {6,1,2,3,4};

        // 3.1 verify if arrays are equals
        boolean isEquals = Arrays.equals(arr5, arr6);

        // 3.1 verify if arrays are in the same order
        boolean isInSameOrder2 = false;
        for (int i = 0; i < minLength; i++) {
            isInSameOrder2 = Objects.equals(arr5[i], arr6[i]);
        }

        // 3.2 return the added item and removed item
        Integer intToRemove = -1;
        Integer intToAdd = -1;
        if(isInSameOrder2){
            intToReturn = arr5.length > arr6.length ? arr5[arr5.length-1] : arr6[arr6.length-1];
        } else {
            // 3.3 sort arrays
            Arrays.sort(arr5);
            Arrays.sort(arr6);

            // 3.4 find intToRemove
            for (int i = 0; i < arr5.length; i++) {
                if(!arr5[i].equals(arr6[i])){
                    intToRemove = arr5[i] > arr6[i] ? arr5[i] : arr6[i];
                }
            }

            // 3.5 find intToAdd
            Integer indexToEvaluate = -1;
            for (int i = 0; i < arr5.length; i++) {
                if(Objects.equals(intToRemove, arr5[i])){
                    indexToEvaluate = i;
                    intToAdd = ++arr6[indexToEvaluate-1];
                }
                if (Objects.equals(intToRemove, arr6[i])){
                    indexToEvaluate = i;
                    intToAdd = ++arr5[indexToEvaluate-1];
                }
            }
        }

        if (isEquals) System.out.println("");
        if (isInSameOrder2) System.out.println("return an added item= "+ intToReturn);
        if (intToRemove != -1) {
            System.out.println("return an item to remove= "+ intToRemove);
            System.out.println("return an item to add= " + intToAdd);
        }
    }
}
