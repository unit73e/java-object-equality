import java.util.Set;
import java.util.HashSet;

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
	public String toString() {
		return String.format("Point(%d,%d)", this.getX(), this.getY());
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);

		System.out.println("P1 = " + p1);
		System.out.println("P2 = " + p2);
		System.out.println();

		// Should be true since P1 equals P2A
		Object p2a = p2;
		System.out.println("P2A = (Object) " + p2);
		System.out.println("P1 equals P2A = " + p1.equals(p2a));
		System.out.println();

		Set<Point> s = new HashSet<>();
		s.add(p1);
		System.out.println("S = " + s);
		// Should be true since P1 was added to S
		System.out.println("S contains P1 = " + s.contains(p1));
		// Should be true since P1 equals P2
		//
		// However returns false since `hashcode` is not implemented
		// according to `equals`
		System.out.println("S contains P2 = " + s.contains(p2));
		System.out.println();

	}
}
