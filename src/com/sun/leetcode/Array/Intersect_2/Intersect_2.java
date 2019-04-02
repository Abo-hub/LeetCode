package com.sun.leetcode.Array.Intersect_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用Map来保存nums1中字符与其出现的次数，然后遍历nums2数组， 
 * 如果Map中的个数大于0，则将此字符加入到结果集中，随后map对应的值-1
 */
public class Intersect_2 {

    public static int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> tmp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            map.put(nums1[i], (value == null ? 0 : value) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                tmp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[tmp.size()];
        int i = 0;
        for (Integer e : tmp) {
            result[i++] = e;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        for (int i : intersect(nums1, nums2)) {
            System.out.print(i + ",");
        }
    }

}