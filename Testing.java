package clasesPropias;

public class Testing {
	public static void main(String[] args) {
		CollectionCustom<Integer> numeros = new CollectionCustom<Integer>(6);
		numeros.addFirst(1);
		numeros.addLast(2);
		numeros.add(3);
		numeros.add(4);
		numeros.remove(2);
		System.out.println(numeros);
		numeros.removeAll();
		System.out.println(numeros);
		System.out.println(numeros.empty());
		
	}
}
