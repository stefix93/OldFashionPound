package com.euris.test.oldFashionPound;

public class Main {
	public static void main(String[] args) {

		OldFashionPound b = new OldFashionPound(10, 10, 10);
		Operations o = new Operations();

		System.out.println("Starting OldFashionPound: " + b.toString());

		System.out.println("Operation 1 - Adding to OldFashionPound:");
		OldFashionPound ofp_add = o.add(b, new OldFashionPound(0, 0, 10));
		System.out.println(ofp_add.toString());

		System.out.println("Operation 2 - Subtract from OldFashionPound:");
		OldFashionPound ofp_sub = o.sub(b, new OldFashionPound(9, 10, 11));
		System.out.println(ofp_sub.toString());

		System.out.println("Operation 3 - Multiply OldFashionPound by 3:");
		OldFashionPound ofp_mlt = o.prod(b, 2);
		System.out.println(ofp_mlt.toString());

		System.out.println("Operation 4 - Divide OldFashionPound by 3");
		OldFashionPound ofp_div = o.div(b, 3);
		System.out.println(ofp_div.toString());

	}
}
