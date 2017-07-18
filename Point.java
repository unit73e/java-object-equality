import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Iterator;

public class Point {
	final private int x;
	final private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point move(int x, int y) {
		return new Point(this.getX() + x, this.getY() + y);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Point) {
			Point that = (Point) other;
			return this.getX() == that.getX() &&
				this.getY() == that.getY();
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getX(), this.getY());
	}

	@Override
	public String toString() {
		return String.format("Point(%d,%d)", this.getX(), this.getY());
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		Point p3 = new Point(1, 2);
		Point p4 = new Point(2, 3);

		System.out.println("P1 = " + p1);
		System.out.println("P2 = " + p2);
		System.out.println("P3 = " + p3);
		System.out.println("P4 = " + p4);
		System.out.println();

		// Reflexive: !null(x) => x.equals(x)
		boolean reflexive = p1.equals(p1);
		System.out.println("P1.equals(P1) => true");
		System.out.println("Reflexive = " + reflexive);
		System.out.println();

		// Symmetric: !null(x,y) && x.equals(y) => y.equals(x)
		boolean symmetric = p1.equals(p2) && p2.equals(p1);
		System.out.println("P1.equals(P2) => P2.equals(P1)");
		System.out.println("Symmetric = " + symmetric);
		System.out.println();

		// Transitive: !null(x,y,z) && x.equals(y) && y.equals(z) => x.equals(z)
		boolean transitive = p1.equals(p2) && p2.equals(p3) && p1.equals(p3);
		System.out.println("P1.equals(P2) && P2.equals(P3) => P1.equals(P3)");
		System.out.println("Transitive = " + transitive);
		System.out.println();

		// Consistent: !null(x,y) => while (true) { x.equals(y) } || while (true) { !x.equals(y) }
		boolean consistent = true;
		for (int i = 0; i < 100; i++) {
			if (!p1.equals(p2)) {
				consistent = false;
				break;
			}
			if (p1.equals(p4)) {
				consistent = false;
				break;
			}
		}
		System.out.println("for (1..100) {!P1.equals(P3) && P1.equals(P3)}");
		System.out.println("Consistent = " + consistent);
		System.out.println();

		// Null Comparision: x.equals(null) == false
		boolean nullComparision = p1.equals(null) == false;
		System.out.println("P1.equals(null) => false");
		System.out.println("Null Comparision = " + nullComparision);
		System.out.println();
	}
}
