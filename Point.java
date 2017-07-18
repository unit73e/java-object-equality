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
				this.getY() == that.getY() &&
				this.getClass().equals(that.getClass());
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
}
