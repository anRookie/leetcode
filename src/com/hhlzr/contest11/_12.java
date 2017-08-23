package com.hhlzr.contest11;
import java.util.List;

public class _12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

	static public boolean isConvex(List<List<Integer>> points) {
		boolean b = true;
		int up = points.get(0).get(1);
		int left = points.get(0).get(0);
		int right = points.get(0).get(0);
		int bottom = points.get(0).get(1);
		int Ax = 0;
		int Ay = 0;
		int Bx = 0;
		int By = 0;
		int Cx = 0;
		int Cy = 0;
		int Dx = 0;
		int Dy = 0;
		float Kad = 0;
		float Kac = 0;
		float Kbc = 0;
		float Kbd = 0;
		int num1 = 0;
		int num2 = 0;
		int num4 = 0;
		int num3 = 0;
		List<Integer> l;
		for (int i = 0; i < points.size(); i++) {
			l = points.get(i);
			if (l.get(0) <= left) {
				left = l.get(0);
				Dx = l.get(0);
				Dy = l.get(1);
				num1 = i;
			}

			if (l.get(0) >= right) {
				right = l.get(0);
				Cx = l.get(0);
				Cy = l.get(1);
				num2 = i;
			}
			if (l.get(1) <= bottom) {
				bottom = l.get(1);
				Ax = l.get(0);
				Ay = l.get(1);
				num3 = i;
			}
			if (l.get(1) >= up) {
				up = l.get(1);
				Bx = l.get(0);
				By = l.get(1);
				num4 = i;
			}
		}
		int juxing = 0;
		System.out.println("Ax:"+Ax+"Ay:"+Ay+"Bx:"+Bx+"By:"+By+"Cx:"+Cx+"Cy:"+Cy+"Dx:"+Dx+"Dy:"+Dy);
		if ((Dx - Ax) == 0) {
			Kad = (float) -999999.0;
			juxing++;
		} else
			Kad = (Dy - Ay) / (Dx - Ax);
		if ((Cx - Ax) == 0) {
			Kac = (float) 999999.0;
			juxing++;
		} else
			Kac = (Cy - Ay) / (Cx - Ax);
		if ((Dx - Bx) == 0) {
			Kbd = (float) 999999.0;
			juxing++;
		} else
			Kbd = (Dy - By) / (Dx - Bx);
		if ((Cx - Bx) == 0) {
			Kbc = (float) -999999.0;
			juxing++;
		} else
			Kbc = (Cy - By) / (Cx - Bx);
		float Kax = 0;
		float Kbx = 0;
		List<Integer> x;
		System.out.println("numD:"+num1+"numC:"+num2+"numA:"+num3+"numB:"+num4);
		System.out.println("Kad:"+Kad+"Kac:"+Kac+"Kbd:"+Kbd+"Kbc:"+Kbc);
		for (int j = 0; j < points.size(); j++) {
			if (j == num1 || j == num2 || j == num3 || j == num4)
				;
			else {
				x = points.get(j);
				if ((x.get(0) - Ax) == 0)
					Kax = (float) -999999.0;
				else
					Kax = (x.get(1) - Ay) / (x.get(0) - Ax);
				if ((x.get(0) - Bx) == 0)
					Kbx = (float) -999999.0;
				else
					Kbx = (x.get(1) - By) / (x.get(0) - Bx);
				if (points.get(j).get(0) > left && points.get(j).get(0) < right && points.get(j).get(1) > bottom
						&& points.get(j).get(1) < up) {
					System.out.println(j);
					System.out.println(Kax);
					System.out.println(Kbx);
					if (juxing == 2)
						b = false;
					if ((Kax < Kad || Kax > Kac) && (Kbx < Kbc || Kbx > Kbd))
						b = false;
				}
			}
		}
		return b;
	}
}
