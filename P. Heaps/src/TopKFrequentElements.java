import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer>[] list = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(list[value]==null) list[value] = new ArrayList<>();

            list[value].add(key);
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i=list.length-1; i>0 && k>0; i--) {
            if(list[i]!=null) {
                List<Integer> subList = list[i];
                result.addAll(subList);
                k -= subList.size();
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i=0; i<resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

//    public int[] topKFrequentEfficient(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int number : nums) {
//            map.put(number, map.getOrDefault(number, 0)+1);
//        }
//
//        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            maxHeap.add(entry);
//        }
//
//        List<Integer> result = new ArrayList<>();
//        while(result.size()<k) {
//            Map.Entry<Integer, Integer> entry = maxHeap.poll();
//            result.add(entry.getKey());
//        }
//
//        int[] resultArray = new int[result.size()];
//        for(int i=0; i<resultArray.length; i++) {
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
//    }
}
