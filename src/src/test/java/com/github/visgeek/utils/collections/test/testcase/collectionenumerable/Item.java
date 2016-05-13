package com.github.visgeek.utils.collections.test.testcase.collectionenumerable;

class Item {
	Item(int value) {
		this.value = value;
	}

	private final int value;

	public final int value() {
		return this.value;
	}

	@Override
	public int hashCode() {
		return this.value;
	}

	@Override
	public boolean equals(Object paramObject) {
		boolean result = false;

		if (paramObject != null) {
			if (paramObject instanceof Item) {
				if (this.value() == ((Item) paramObject).value()) {
					result = true;
				}
			}
		}

		return result;
	}
}
