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
		Point p2 = new Point(2, 2);

		System.out.println("P1 = " + p1);
		System.out.println("P2 = " + p2);
		System.out.println();

		// Should return true since (2,3) == (2,3)
		Point p3 = p1.move(1, 0);
		System.out.println("P3 = P1 move (1,0)");
		System.out.println("P2 equals P3 = " + p2.equals(p3));
		System.out.println();

		Set<Point> s = new HashSet<>();
		s.add(new Point(2,2));
		System.out.println("S = " + s);
		System.out.println("S contains P2 = " + s.contains(p2));
		System.out.println("S contains P3 = " + s.contains(p3));
	}
}
