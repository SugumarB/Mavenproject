package com.Framework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClassA {
	private void m1(int a) {
		
	}
private void m2(ArrayList<Integer> i) {

}
private void m3(Map<String, String>m) {
}
public static void main(String[] args) {
	ClassA a = new ClassA();
	a.m1(10);
   ArrayList<Integer>i = new ArrayList<Integer>();
   i.add(100);
   i.add(200);
a.m2(i);
Map<String, String>m = new LinkedHashMap<String,String>();
m.put("name", "ragu");
a.m3(m);
}
}
