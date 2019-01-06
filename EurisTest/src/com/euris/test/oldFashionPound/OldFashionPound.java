package com.euris.test.oldFashionPound;

public class OldFashionPound {
	private int p;
	private int s;
	private int d;
	private int a;

	final int MAX_D = 12;
	final int MAX_S = 20;

	public OldFashionPound() {

	}

	public OldFashionPound(int p, int s, int d) {
		this.p = p;
		this.s = s;
		this.d = d;
	}

	public OldFashionPound(int p, int s, int d, int a) {
		this.p = p;
		this.s = s;
		this.d = d;
		this.a = a;
	}

	public int getD() {
		return d;
	}

	public int getP() {
		return p;
	}

	public int getS() {
		return s;
	}

	public int getA() {
		return a;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void setP(int p) {
		this.p = p;
	}

	public void setS(int s) {
		this.s = s;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		if (this.a != 0) {
			return p + " £ " + s + " § " + d + "¢ - " + a + "a";
		} else {
			return p + " £ " + s + " § " + d + "¢ ";
		}
	}

}
