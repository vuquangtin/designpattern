package iterators.tests;

public class Test {

	public static void main(String[] args) {
		Aggregate<String> mStringAggregate = new AggregateImp<>();
		mStringAggregate.add("hello");
		mStringAggregate.add("android");
		mStringAggregate.add("lab");
		Iterator<String> mIterator = mStringAggregate.iterator();
		while (mIterator.hasNext()) {
			System.out.println(mIterator.next());
		}
	}
}