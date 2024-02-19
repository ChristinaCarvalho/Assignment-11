import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static <T> T[] createRandomArray(int arrayLength){
        Integer[] array = new Integer[arrayLength];        
        Random random = new Random();
        for(int i=0; i<arrayLength; i++){
            array[i] = Integer.valueOf(random.nextInt(100));
        }
        return (T[]) array;
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array){        
        for(int i=0; i<array.length; i++){
            boolean swapped = false;
            for(int j=0; j<array.length-i-1; j++){
                if(array[j].compareTo(array[j+1])>0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;                    
                    swapped = true;
                }
            }
            if (swapped != true){                 
                break;                
            } 
        }       
    } 

    public static <T extends Comparable<T>>void mergeSort(T[] array, int left, int right){
        if(right - left > 1){
            int mid = (left + right)/2;
            mergeSort(array, left, mid);
            mergeSort(array, mid, right);
            merge(array, left, mid, right);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right){
        T[] leftArray = Arrays.copyOfRange(array, left, mid);
        T[] rightArray = Arrays.copyOfRange(array, mid, right);
        int i=0, j=0;
        for(int k=left; k<right; k++){
            if(i == leftArray.length){
                array[k] = rightArray[j++];
            } else if(j == rightArray.length){
                array[k] = leftArray[i++];
            } else if(rightArray[j].compareTo(leftArray[i]) >= 0){
                array[k] = leftArray[i++];
            } else {
                array[k] = rightArray[j++];
            }
        }
    }

    public static void main(String[] args) throws Exception {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of Integer array:");
        int arrayLength = scanner.nextInt();

        Integer[] array = createRandomArray(arrayLength);
        Integer[] array2 = array.clone();
        System.out.println("Generated array of ints:");
        System.out.println(Arrays.toString(array));        

        bubbleSort(array);
        System.out.println("Sorted array using bubble sort:");
        System.out.println(Arrays.toString(array));
                
        mergeSort(array2, 0, array2.length);
        System.out.println("Sorted array using merge sort:");
        System.out.println(Arrays.toString(array2));

        //Testing with doubles
        Double[] array3 = {9.8, 8.7, 7.6, 6.5, 4.3, 1.2};
        Double[] array4 = array3.clone();
        System.out.println("\nTest array using doubles instead of ints:");
        System.out.println(Arrays.toString(array3));        

        bubbleSort(array3);
        System.out.println("Sorted doubles array using bubble sort:");
        System.out.println(Arrays.toString(array3));
                
        mergeSort(array4, 0, array4.length);
        System.out.println("Sorted doubles array using merge sort:");
        System.out.println(Arrays.toString(array4));

        scanner.close();
    }
}
