package com.clazz.inner;

import com.clazz.inner.InnerClass.InnerClassA;
import com.clazz.inner.InnerClass.InnerClassB;
import com.clazz.inner.InnerClass.InnerClassB.InnerClassC;

/**
*
*@author Devonmusa
*@date   2017年7月8日
*/
public class InnerClassTest {

	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		
		InnerClassA innerClassA = innerClass.new InnerClassA();
		
		InnerClassB innerClassB = innerClass.new InnerClassB();
		
		InnerClassC innerClassC = innerClassB.new InnerClassC();
		
		System.out.println("innerClass=" + innerClass +", innerClassA="+ innerClassA +",innerClassB=" + innerClassB + ", innerClass=" + innerClassC);

	}

}
