import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Iterator;

public class Point {
	private int x;
	private int y;

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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
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

		System.out.println("P1 = " + p1);
		System.out.println("P2 = " + p2);
		System.out.println();

		Set<Point> s = new HashSet<>();
		s.add(p1);
		System.out.println("S = " + s);
		// Should be true since P1 was added to S
		System.out.println("S contains P1 = " + s.contains(p1));
		// Should be true since P1 equals P2
		System.out.println("S contains P2 = " + s.contains(p2));
		System.out.println();

		// Should show Point(2,2)
		p1.setX(2);
		System.out.println("P1.X = 2 ");
		System.out.println("S = " + s);
		// Should return true
		//
		// However returns false because P1 is in the wrong hash bucket
		// and will never be found for that reason.
		//
		// Never use mutable fields for object equality since it will
		// cause problems when used in collections.
		System.out.println("S contains P1 = " + s.contains(p1));
		System.out.println("S contains " + p1 + " = " +
				s.contains(new Point(2,2)));
		System.out.println();
	}
}
