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
		} else if (other instanceof Point) {
			Point that = (Point) other;
			return super.equals(that);
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
		ColoredPoint cpB = new ColoredPoint(1, 2, Color.BLUE);

		System.out.println("P = " + p);
		System.out.println("CP = " + cp);
		System.out.println("CPB = " + cpB);
		System.out.println();

		// Should be true since X,Y are the same
		System.out.println("P equals CP = " + p.equals(cp));
		// Should be false since the colors are different
		System.out.println("CP equals CPB= " + cp.equals(cpB));
		System.out.println();

		// Symmetric: x.equals(y) => y.equals(x)
		boolean symmetric = p.equals(cp) && cp.equals(p);
		System.out.println("P equals CP => CP equals P");
		System.out.println("Symmetric = " + symmetric);
		System.out.println();

		// Transitive: x.equals(y) && y.equals(z) => x.equals(z)
		//
		// However returns false because CP is red and CPB is blue
		boolean transitive = cp.equals(p) && p.equals(cpB) && cp.equals(cpB);
		System.out.println("CP equals P && P equals CPB => CP equals CPB");
		System.out.println("Transitive = " + transitive);
	}
}
