import java.util.Set;
import java.util.HashSet;

public class ColoredPoint extends Point {

	final private Color color;

	public ColoredPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof ColoredPoint) {
			ColoredPoint that = (ColoredPoint) other;
			return this.getColor() == that.getColor() &&
				super.equals(that);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return String.format("ColoredPoint(%d,%d,%s)",
				this.getX(), this.getY(),
				this.getColor());
	}

	public static void main(String[] args) {
		Point p = new Point(1, 2);
		ColoredPoint cp = new ColoredPoint(1, 2, Color.RED);

		System.out.println("P = " + p);
		System.out.println("CP = " + cp);
		System.out.println();

		// Should be true since X,Y are the same
		System.out.println("P equals CP = " + p.equals(cp));
		// Should be true for the same reason above
		//
		// However returns false because P is not a ColoredPoint
		// The implementation is not symmetric
		System.out.println("CP equals P = " + cp.equals(p));
		System.out.println();

		Set<Point> s1 = new HashSet<Point>();
		s1.add(p);
		System.out.println("S1 = " + s1);
		// Should be true since P equals CP
		//
		// However returns false because equality is not symmetric
		// (CP does not equal P)
		System.out.println("S1 contains CP = " + s1.contains(cp));
		System.out.println();

		Set<Point> s2 = new HashSet<Point>();
		s2.add(cp);
		System.out.println("S2 = " + s2);
		// Should be true since P equals CP
		System.out.println("S2 contains P = " + s2.contains(p));
	}
}
