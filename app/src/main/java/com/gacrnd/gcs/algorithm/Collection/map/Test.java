package com.gacrnd.gcs.algorithm.Collection.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Jack_Ou  created on 2020/11/27.
 */
public class Test {
    public static void main(String[] args) {
        testTreemap();
        //testLinkedHashMap();
    }

    public static void testTreemap(){
        TreeMap<Integer,String> map = new TreeMap<>(new xCompare());
        map.put(3,"value");
        map.put(2,"value");
        map.put(1,"value");
        map.put(5,"value");
        map.put(4,"value");
        System.out.println(map);

        TreeMap<String,String> map1 = new TreeMap<>();
        map1.put("aa","value");
        map1.put("ab","value");
        map1.put("bb","value");
        map1.put("cc","value");
        map1.put("cb","value");
        map1.put("ap","value");
        System.out.println(map1);
    }

    public static class xCompare implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return -i1.compareTo(i2);
        }
    }

    public static void testLinkedHashMap(){
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false);
        linkedHashMap.put("name1", "Jack1");
        linkedHashMap.put("name2", "Jack2");
        linkedHashMap.put("name3", "Jack3");
        System.out.println("开始时顺序：");
        Set<Map.Entry<String, String>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.get("name1");
        Set<Map.Entry<String, String>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

    }
}
