package com.data.stracture.array;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ArrayDemo<E> {
	public static void main(String args[]) {
		ArrayDemo arrayDemo = new ArrayDemo();
		arrayDemo.arrayClass();
	}

	public void arrayClass() {
		System.out.println("###############基础数据类型##############");
		byte[] b = new byte[10];
		System.out.println("byte数组的默认值是：" + b[2] + "  长度：" + b.length);
		short[] s = new short[10];
		System.out.println("short数组的默认值是：" + s[1] + "  长度：" + s.length);
		char[] c = new char[10];
		System.out.println("char数组的默认值是：" + c[1] + "  长度：" + c.length);
		int[] a = new int[10];
		System.out.println("int数组的默认值是：" + a[1] + "  长度：" + a.length);
		float[] f = new float[10];
		System.out.println("float数组的默认值是：" + f[1] + "  长度：" + f.length);
		long[] l = new long[10];
		System.out.println("long数组的默认值是：" + l[1] + "  长度：" + l.length);
		double[] d = new double[10];
		System.out.println("double数组的默认值是：" + d[1] + "  长度：" + d.length);
		System.out.println("###############引用数据类型##############");
		String[] str = new String[10];
		System.out.println("String数组的默认值是：" + str[1] + "  长度：" + str.length);
		String str1 = new String("ssssssss");
		int length = str1.length();
		System.out.println("String对象的默认值是：" + str1 + "  长度：" + length);
		boolean[] bol = new boolean[10];
		System.out.println("boolean数组的默认值是：" + bol[1] + "  长度：" + bol.length);
		
		Integer[] arrays =  (Integer[]) Array.newInstance(Integer.class, 20);
		//String str2 = arrays.toString();
		for(int i= 0; i<arrays.length;i++) {
			System.out.println(arrays[i]);
		}

	}

	public List<E> mergeList(List<E> a, List<E> b) {
	    int aSize  = a.size();
	    int bSize = b.size();
	    int mergeSize = aSize + bSize;
        List<E> mergeList = new ArrayList<E>(mergeSize);
        int i = 0 ;
        int j = 0;

        while(i < aSize && j < bSize) {
         //  Collections.
//
//            if() {
//
//            }else {
//
//            }

        }

	    return mergeList;

    }

}
