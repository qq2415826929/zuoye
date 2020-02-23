

import java.util.*;

public class Ltriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tempa, thickness, i, j;
		Ltriangle ltriangle1 = new Ltriangle();
		Ltriangle ltriangle2 = new Ltriangle();
		tempa = ltriangle1.dhinput(2, 120, "底长");
		thickness = ltriangle1.dhinput(1, tempa, "厚度");

		for (i = 1; i <= tempa; i++) {
			if (i <= thickness) {
				for (j = 1; j <= thickness; j++)
					System.out.print("#");
			} else if (i > tempa - thickness) {
				for (j = 1; j <= i; j++)
					System.out.print("#");
			} else {
				for (j = 1; j <= i; j++) {
					if (j < thickness + 1)
						System.out.print("#");
					else if (j > i - thickness)
						System.out.print("#");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}

	}


	public int dhinput(int low, int high, String string) {
		int temp;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入直角等腰三角形的" + string + "(大小限制" + low + "-" + high + "):");
		temp = scanner.nextInt();
		while (temp == 0 || temp < low || temp > high) {
			System.out.println("等腰直角三角形的" + string + "必须大于等于" + low + ",小于等于" + high + ",请重新输入：");
			temp = scanner.nextInt();
		}
		return temp;
	}
}
