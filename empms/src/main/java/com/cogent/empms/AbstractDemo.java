package com.cogent.empms;

interface I1 {
	public void method1();
}

interface I2 {
	public void method2();
}

interface I3 {
	public void method3();
	public void method6();
	
}

interface I4 {
	public void method4();
	public void method7();
}
interface I5 {
	public void method5();
	public void method8();
}

public abstract  class AbstractDemo implements I1,I2, I3, I4, I5 {
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}
	
}

class Demo extends AbstractDemo {

	

	@Override
	public void method6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method7() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method8() {
		// TODO Auto-generated method stub
		
	}
	
}


