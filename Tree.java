import java.util.Optional;
import java.util.Objects;

public class Tree<T> {

	final Optional<T> elem;
	final Optional<Tree<T>> left;
	final Optional<Tree<T>> right;

	public Tree(Optional<T> elem, Optional<Tree<T>> left, Optional<Tree<T>> right) {
		this.elem = elem;
		this.left = left;
		this.right = right;
	}

	public Optional<T> getElem() {
		return elem;
	}

	public Optional<Tree<T>> getLeft() {
		return left;
	}

	public Optional<Tree<T>> getRight() {
		return right;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Tree<?>) {
			Tree<?> that = (Tree<?>) other;
			return that.canEqual(this) &&
				this.getElem().equals(that.getElem()) &&
				this.getLeft().equals(that.getLeft()) &&
				this.getRight().equals(that.getRight());
		} else {
			return false;
		}
	}

	public boolean canEqual(Object other) {
		return other instanceof Tree<?>;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getElem(), this.getLeft(), this.getRight());
	}

	@Override
	public String toString() {
		String e = this.getElem().map(t -> t.toString()).orElse("_");
		String l = this.getLeft().map(t -> t.toString()).orElse("_");
		String r = this.getRight().map(t -> t.toString()).orElse("_");
		return String.format("Tree(%s,%s,%s)", e, l, r);
	}

	public static void main(String[] args) {
		Tree<Integer> t1 = new Tree<>(Optional.empty(), Optional.empty(), Optional.empty());
		Tree<String> t2 = new Tree<>(Optional.empty(), Optional.empty(), Optional.empty());
		Tree<Integer> t3 = new Tree<Integer>(
				Optional.of(1),
				Optional.of(
					new Tree<Integer>(
						Optional.of(2),
						Optional.empty(),
						Optional.empty()
					)
				),
				Optional.empty());
		Tree<Integer> t4 = new Tree<Integer>(
				Optional.of(1),
				Optional.of(
					new Tree<Integer>(
						Optional.of(2),
						Optional.empty(),
						Optional.empty()
					)
				),
				Optional.empty());
		Tree<Integer> t5 = new Tree<Integer>(
				Optional.of(1),
				Optional.empty(),
				Optional.of(
					new Tree<Integer>(
						Optional.of(2),
						Optional.empty(),
						Optional.empty()
					)
				));

		System.out.println("T1 = " + t1);
		System.out.println("T2 = " + t2);
		System.out.println("T3 = " + t3);
		System.out.println("T4 = " + t4);
		System.out.println("T5 = " + t5);

		// T1 equals T2 even though the generic type is different.
		//
		// This is because due to type erasure: the generic types are
		// removed in run-time.
		System.out.println("T1 equals T2 = " + t1.equals(t2));
		System.out.println("T3 equals T4 = " + t3.equals(t4));
		System.out.println("T3 equals T5 = " + t3.equals(t5));
	}
}
