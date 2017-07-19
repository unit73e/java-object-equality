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
			return that.canEqual(this) &&
				this.getColor() == that.getColor() &&
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

	@Override
	public boolean canEqual(Object other) {
		return other instanceof ColoredPoint;
	}

	public static void main(String[] args) {
		Point p = new Point(1, 2);
		ColoredPoint cp1 = new ColoredPoint(1, 2, Color.RED);
		ColoredPoint cp2 = new ColoredPoint(1, 2, Color.RED);
		ColoredPoint cp3 = new ColoredPoint(1, 2, Color.RED);
		ColoredPoint cp4 = new ColoredPoint(1, 2, Color.BLUE);

		System.out.println("P = " + p);
		System.out.println("CP1 = " + cp1);
		System.out.println("CP2 = " + cp2);
		System.out.println("CP3 = " + cp3);
		System.out.println("CP4 = " + cp4);
		System.out.println();

		// Should be false since P and CP have different types
		System.out.println("P equals CP1 = " + p.equals(cp1));
		// Should be true since the coordinates and colors are equal
		System.out.println("CP1 equals CP2= " + cp1.equals(cp2));
		// Should be true since the colors are different
		System.out.println("CP1 equals CP4= " + cp1.equals(cp4));
		System.out.println();

		// Symmetric: !null(x,y) && x.equals(y) => y.equals(x)
		boolean symmetric = cp1.equals(cp2) && cp2.equals(cp1);
		System.out.println("CP1 equals CP2 => CP2 equals CP1");
		System.out.println("Symmetric = " + symmetric);
		System.out.println();

		// Transitive: !null(x,y,z) && x.equals(y) && y.equals(z) => x.equals(z)
		boolean transitive = cp1.equals(cp2) && cp2.equals(cp3) && cp1.equals(cp3);
		System.out.println("CP1 equals CP2 && CP2 equals CP3 => CP1 equals CP3");
		System.out.println("Transitive = " + transitive);
		System.out.println();

		// Should return true since both are Point and the coordinates
		// are the same
		Point pA = new Point(1, 1) {
			@Override
			public int getY() {
				return 2;
			}
		};
		System.out.println("PA = Point(1,1) {Y = 2}");
		System.out.println("PA = " + pA);
		System.out.println("P equals PA = " + p.equals(pA));
		System.out.println();

		HashSet<Point> ps = new HashSet<>();
		ps.add(p);
		System.out.println("PS = " + ps);
		// Should be true since P was added to PS
		System.out.println("PS contains P = " + ps.contains(p));
		// Should be false since P does not equal CP1
		System.out.println("PS contains CP1 = " + ps.contains(cp1));
		// Should be true since P equals PA
		System.out.println("PS contains PA = " + ps.contains(pA));
	}
}
