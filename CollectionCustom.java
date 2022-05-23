package clasesPropias;

import java.util.Arrays;

public class CollectionCustom<T> {
	private Object[] T;
	public int lenght;

	public CollectionCustom(int lenght) {
		T = new Object[lenght];
		this.lenght = lenght;
	}

	public void addFirst(Object first) {
		T[0] = first;
	}

	public void addLast(Object last) {
		int a = T.length;
		T[a - 1] = last;
	}

	public void add(Object add) {
		for (int i = 0; i < T.length; i++) {
			if (T[i] == null) {
				T[i] = add;
				break;
			}
		}
	}

	public Object remove(Object remove) {
		for (int i = 0; i < T.length; i++) {
			if (T[i] == remove) {
				T[i] = null;
				System.out.println(remove);
			}
		}
		return remove;
	}

	public void removeAll() {
		for (int i = 0; i < T.length; i++) {
			if (T[i] != null) {
				T[i] = null;
			}
		}
	}

	public boolean empty() {
		boolean a = false;
		for (int i = 0; i < T.length; i++) {
			if(T[i] == null) {
				a = true;
			}else {
				a = false;
			}
		}
		return a;
	}

	@Override
	public String toString() {
		return Arrays.toString(T);
	}

}