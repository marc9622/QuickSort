import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    QuickSort q = new QuickSort();
    int[] array;

    if(args.length == 0) {
      array = q.createRandomArray(100000, 100000);
    }
    else{
      array = q.StringArrayToIntArray(args);
    }
    System.out.println(Arrays.toString(array));
    long time = System.nanoTime();
    q.sort(array, 0, array.length - 1);
    time = System.nanoTime() - time;
    System.out.println(Arrays.toString(array));
    System.out.println("It took " + time + " nanoseonds to sort, which is " + (time / 1000000d) + " milliseconds, and " + (time / 1000000000d));

    // long time = 0;
    // for(int i = 0; i < 10000; i++) {
    //   long temp = System.nanoTime();
    //   q.sort(array, 0, array.length - 1);
    //   time += System.nanoTime() - temp;
    //   q.shuffleArray(array);
    //   System.out.println(i + " " + time / 1000000000l);
    // }
  }

  public void sort(int[] array, int start, int end) {
    if(start >= end)
      return;

    int pivot = end;

    while(true) {
      int smaller = findSmallerInt(array, pivot, start, end);
      int larger  = findLargerInt (array, pivot, start, end);

      if(smaller == -1) {
        swapElements(array, pivot, start);
        pivot = start;
        break;
      }
      if(larger == -1) {
        break;
      }
      if(smaller < larger) {
        swapElements(array, pivot, larger);
        pivot = larger;
        break;
      }

      swapElements(array, smaller, larger);
    }

    sort(array, start, pivot - 1);
    sort(array, pivot + 1, end);
  }

  public int findSmallerInt(int[] array, int compare, int start, int end) {
    for(int i = end; i >= start; i--)
      if(i != compare && array[i] < array[compare])
        return i;
    return -1;
  }

  public int findLargerInt(int[] array, int compare, int start, int end) {
    for(int i = start; i <= end; i++)
      if(i != compare && array[i] > array[compare])
        return i;
    return -1;
  }

  public void swapElements(int[] array, int a, int b) {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

  public int findMax(int[] array) {
    int max = 0;
    for(int i : array)
      max = i > max ? i : max;
    return max;
  }

  public int[] createRandomArray(int length, int max) {
    int[] ints = new int[length];
    for(int i = 0; i < length; i++)
      ints[i] = (int)(Math.random() * max);
    return ints;
  }

  public int[] shuffleArray(int[] array) {
    for(int i = 0; i < array.length; i++) {
      int a = array[i];
      int index = (int)(Math.random() * array.length);
      array[i] = array[index];
      array[index] = a;
    }
    return array;
  }

  public int[] StringArrayToIntArray(String[] args) {
    int[] ints = new int[args.length];
    for(int i = 0; i < args.length; i++) {
      ints[i] = Integer.parseInt(args[i]);
    }
    return ints;
  }
}
