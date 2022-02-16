public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int c) {
        arr = new int[c];
        size = 0;
        capacity = c;
    }

    int left(int i) {
        return 2*i+1;
    }

    int right(int i) {
        return 2*i+2;
    }

    int parent(int i) {
        return (i-1)/2;
    }

    public void swap(int first, int second) {
        int temp = first;
        first = second;
        second = temp;
    }

    void insert(int x) {
        if (size==capacity) return;
        size++;
        arr[size-1] = x;
        for (int i=size-1; i!=0 && arr[i]<arr[parent(i)]; i=parent(i)) {
            swap(arr[i], arr[parent(i)]);
        }
    }

    //  Time Complexity : O(log(N)) || O(h)
    //  Auxiliary Space : O(h)
    void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = i;

	//  You could've added arr[smallest] instead of arr[i]
        if (left<size && arr[left]<arr[i]) {
            smallest = left;
        }

        if (right<size && arr[right]<arr[smallest]) {
            smallest = right;
        }

        if (i!=smallest) {
            swap(arr[i], arr[smallest]);
            minHeapify(smallest);
        }
    }

    //  Time Complexity : O(log(N)) || O(h)
    //  Auxiliary Space : O(h)
    int extractMin() {
        if (size==0) return -1;

        if (size==1) {
            size--;
            return arr[0];
        }

	int min = arr[0];
        swap(arr[0], arr[size-1]);
        size--;
        minHeapify(0);
        return min;
    }

    void decreaseKey(int i, int x) {
        arr[i] = x;
        while (i!=0 && arr[parent(i)]>arr[i]) {
            swap(arr[parent(i)], arr[i]);
            i=parent(i);
        }
    }

    //  In order to carry out delete operation, We need to perform decreaseKey() and then extractMin() operation.
    void delete(int i) {
        decreaseKey(i, -Integer.MAX_VALUE);
        extractMin();
    }

    //  Time Complexity : O(n)
    void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
    }
}

//  Implementation done using arraylist
/*
import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
      for(int i=(array.size()-2)/2; i>=0; i--) {
	siftDown(i, array.size()-1, array);
      }
      return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      int left = 2*currentIdx + 1;
      while(left <= endIdx) {
      	int right = 2*currentIdx + 2 <= endIdx ? currentIdx*2 + 2 : -1;
      	int idxToSwap;
      	if(right!=-1 && heap.get(right)<heap.get(left)) {
      	  idxToSwap = right;
      	}
      	else {
	  idxToSwap = left;
      	}
      	if(heap.get(idxToSwap)<heap.get(currentIdx)) {
	  swap(idxToSwap, currentIdx, heap);
	  currentIdx = idxToSwap;
	  left = 2*currentIdx + 1;
      	}
      	else {
      	  return;
      	}
      }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
      int parentIdx = (currentIdx-1)/2;
      while(currentIdx>0 && heap.get(currentIdx)<heap.get(parentIdx)) {
      	swap(currentIdx, parentIdx, heap);
      	currentIdx = parentIdx;
      	parentIdx = (currentIdx-1)/2;
      }
    }

    public int peek() {
      return heap.get(0);
    }

    public int remove() {
      swap(0, heap.size()-1, heap);
      int itemToRemove = heap.get(heap.size()-1);
      heap.remove(heap.size()-1);
      siftDown(0, heap.size()-1, heap);
      return itemToRemove;
    }

    public void insert(int value) {
      heap.add(value);
      siftUp(heap.size()-1, heap);
    }
    
    public void swap(int i, int j, List<Integer> heap) {
	Integer temp = heap.get(i);
	heap.set(i, heap.get(j));
	heap.set(j, temp);
    }
  }
}
*/
