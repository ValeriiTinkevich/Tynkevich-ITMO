public class Lab1 {
	public static void Lab1(String[] args) {
		int even = 4;
		short[] a = new short[10];
		double[] x = new double[16];
		for (int i = 0; i < 10; i++) {
			a[i] = (short)even;
			even = even + 2;
		}
		for (int i = 0; i < 16; i++) {
			x[i] = (double) (Math.random() * 13.0) - 8.0;
		}

		double[][] c = new double[10][16];

		for (int i = 0; i < 10; i++) {
			for(int j = 0; j < 16; j++) {
				switch(a[i]) {
					case 4:
						c[i][j] = Math.asin(1/(Math.pow(Math.E, Math.pow(Math.cos(Math.atan(Math.cos(x[j]))), 2))));
						break;
					case 6:
					case 8:
					case 10:
					case 14:
					case 20:
						c[i][j] = Math.sin(Math.pow((Math.log(Math.abs(x[j])) / 4), 3));
						break;
					default:
						c[i][j] = Math.log(Math.abs(Math.asin(Math.pow(1/Math.pow(Math.E, Math.abs(x[j])), 2))));
						break;


				}
			}

		}
		for (int i = 0; i < 10; i++) {
			for(int j = 0; j < 16; j++) {
				System.out.printf("%.5f %n", c[i][j]);

			}
		}
	}
}
