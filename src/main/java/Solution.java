import java.util.*;
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int c = map.getOrDefault(arr[i], 0);
            c++;
            map.put(arr[i], c);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : map.values()){
            pq.offer(val);
        }
        while(!pq.isEmpty() && k - pq.peek() >= 0){
            k -= pq.poll();
        }
        return pq.size();
    }
}