package matrix;

public class Test1 {
	public static void main(String[] args) throws Exception {
		int[][] a1 = {{1, 2, 3},{4, 5, 6}};
		int[][] a2 = {{1, 1, 1},{2, 2, 2}};
		int[][] a3 = {{1, 2},{1, 2},{1, 2}};
		Matrix m1 = new Matrix(a1);
		Matrix m2 = new Matrix(a2);
		Matrix m3 = new Matrix(a3);

		System.out.println(Matrix.add(m1, m2));
		System.out.println(Matrix.subtract(m1, m2));
		System.out.println(Matrix.multiply(m1, m3));
	}
}
