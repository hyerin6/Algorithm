package matrix;
import java.util.Arrays;

// 데이터에 해당하는 클래스를 구현할 때,
// equals, hashCode, toString, compareTo 메소드를 재정의하는 것이 바람직하다.

public class Matrix implements Comparable<Matrix> {
	int[][] a;

	public Matrix(int[][] a) { this.a = a; }

	public int getRowCount() { return a.length; }

	public int getColCount() { return a[0].length; }

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Matrix) == false) return false;
		Matrix m = (Matrix)obj;
		return Arrays.deepEquals(this.a, m.a);
	}

	@Override
	public int hashCode() { return Arrays.deepHashCode(this.a); }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int r = 0; r < getRowCount(); ++r) {
			for (int c = 0; c < getColCount(); ++c)
				builder.append(String.format("%4d", a[r][c]));
			builder.append('\n');
		}
		return builder.toString();
	}

	@Override
	public int compareTo(Matrix matrix) {
		int size1 = this.getRowCount() * this.getColCount();
		int size2 = matrix.getRowCount() * matrix.getColCount();
		if (size1 != size2) return size1 - size2;

		for (int r = 0; r < getRowCount(); ++r)
			for (int c = 0; c < getColCount(); ++c)
				if (this.a[r][c] != matrix.a[r][c])
					return this.a[r][c] - matrix.a[r][c];
		return 0;
	}

	public static Matrix add(Matrix m1, Matrix m2) throws Exception {
		if (m1.getRowCount() != m2.getRowCount() || m1.getColCount() != m2.getColCount())
			throw new Exception("matrix dimensions mismatch");

		int[][] a1 = m1.a;
		int[][] a2 = m2.a;
		int[][] a3 = new int[m1.getRowCount()][m1.getColCount()];
		for (int r = 0; r < m1.getRowCount(); ++r)
			for (int c = 0; c < m1.getColCount(); ++c)
				a3[r][c] = a1[r][c] + a2[r][c];
		return new Matrix(a3);
	}

	public static Matrix subtract(Matrix m1, Matrix m2) throws Exception {
		if (m1.getRowCount() != m2.getRowCount() || m1.getColCount() != m2.getColCount())
			throw new Exception("matrix dimensions mismatch");

		int[][] a1 = m1.a;
		int[][] a2 = m2.a;
		int[][] a3 = new int[m1.getRowCount()][m1.getColCount()];
		for (int r = 0; r < m1.getRowCount(); ++r)
			for (int c = 0; c < m1.getColCount(); ++c)
				a3[r][c] = a1[r][c] - a2[r][c];
		return new Matrix(a3);
	}

	public static Matrix multiply(Matrix m1, Matrix m2) throws Exception {
		if (m1.getColCount() != m2.getRowCount())
			throw new Exception("matrix dimensions mismatch");

		int[][] a1 = m1.a;
		int[][] a2 = m2.a;
		int[][] a3 = new int[m1.getRowCount()][m2.getColCount()];
		for (int r = 0; r < m1.getRowCount(); ++r)
			for (int c = 0; c < m2.getColCount(); ++c)
				for (int i = 0; i < m2.getRowCount(); ++i)
					a3[r][c] += a1[r][i] * a2[i][c];
		return new Matrix(a3);
	}
}
