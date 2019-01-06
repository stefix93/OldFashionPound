package com.euris.test.oldFashionPound;

public class Operations extends OldFashionPound {

	public OldFashionPound add(OldFashionPound o, OldFashionPound n) {
		int d1 = o.getD();
		int s1 = o.getS();
		int p1 = o.getP();

		int d2 = n.getD();
		int s2 = n.getS();
		int p2 = n.getP();

		if (s2 > MAX_S || d2 > MAX_D)
			throw new NumberFormatException("Number Format is not correct!");

		if (d1 + d2 >= MAX_D) {
			d1 = (d1 + d2) % MAX_D;
			s1 += (d1 + d2) / MAX_D;
		} else {
			d1 += d2;
		}

		if (s1 + s2 >= MAX_S) {
			s1 = (s1 + s2) % MAX_S;
			p1 += (s1 + s2) / MAX_S;
		} else {
			s1 += s2;
		}
		p1 += p2;

		return new OldFashionPound(p1, s1, d1);
	}

	public OldFashionPound sub(OldFashionPound o, OldFashionPound n) {
		int d1 = o.getD();
		int s1 = o.getS();
		int p1 = o.getP();

		int d2 = n.getD();
		int s2 = n.getS();
		int p2 = n.getP();

		if (s2 > MAX_S || d2 > MAX_D || s1 > MAX_S || d1 > MAX_D)
			throw new NumberFormatException("Number Format is not correct!");

		if (p1 < p2 || (p1 == p2 && s1 < s2) || (p1 == p2 && s1 == s2 && d1 < d2))
			throw new NumberFormatException("Negative value. Operation is not possible");

		// D STAGE
		s1 -= (d2 <= d1 ? 0 : 1);
		d1 = (d1 < d2 ? MAX_D - (d2 - d1) : d1 - d2);
		// S STAGE
		p1 -= (s2 <= s1 ? 0 : 1);
		s1 = (s1 < s2 ? MAX_S - (s2 - s1) : s1 - s2);

		p1 -= p2;

		return new OldFashionPound(p1, s1, d1);
	}

	public OldFashionPound prod(OldFashionPound o, int mol) {
		int d = o.getD();
		int s = o.getS();
		int p = o.getP();

		if (s > MAX_S || d > MAX_D)
			throw new NumberFormatException("Number Format is not correct!");
		if (p < 0 || s < 0 || d < 0 || mol < 0)
			throw new NumberFormatException("Negative values are not allowed.");

		int res_p = p * mol;
		int res_d = d * mol;

		p = res_p;

		if (res_d > MAX_D) {

			d = (res_d) % MAX_D;
			s += (res_d) / MAX_D;

		} else {

			d = res_d;

		}

		int res_s = s * mol;
		if (res_s > MAX_S) {

			s = (res_s) % MAX_S;
			p += (res_s) / MAX_S;

		} else {

			s *= mol;

		}

		return new OldFashionPound(p, s, d);
	}

	public OldFashionPound div(OldFashionPound o, int q) {
		int d = o.getD();
		int s = o.getS();
		int p = o.getP();
		int resto = 0;

		if (q < 0)
			throw new NumberFormatException("Unsupported negative quotients");

		int pa = p % q;

		p = p / q;
		if (pa > 0)
			s += pa * MAX_S;

		int sa = s % q;
		s = s / q;
		if (sa > 0)
			d += sa * MAX_D;

		int da = d % q;
		d = d / q;
		if (da > 0)
			resto += da;

		if (resto != 0)
			return new OldFashionPound(p, s, d, resto);
		return new OldFashionPound(p, s, d);
	}
}
