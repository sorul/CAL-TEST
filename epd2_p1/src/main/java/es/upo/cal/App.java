package es.upo.cal;

import java.util.ArrayList;
import java.util.List;

import upo.es.qa.epd1.ListImplementation;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<Integer> lista = new ListImplementation<Integer>();
		List<Integer> lista2 = new ListImplementation<Integer>();
		List<String> lista3 = new ListImplementation<String>();
		List<String> lista4 = new ListImplementation<String>();
		ArrayList<Integer> lista5 = new ArrayList<Integer>();
		ArrayList<Integer> lista6 = new ArrayList<Integer>();

		lista2.add(1);
		lista2.add(3);
		lista2.add(3);

		// lista3.add("a");
		// lista3.add("b");
		// lista3.add("c");

		lista4.add("d");
		lista4.add("e");
		lista4.add("f");

		lista3.addAll(lista4);

		System.out.println("tamaño:" + lista3.size());

		for (Object o : lista3) {
			System.out.println(o);
		}

		// for (Object o : a) {
		// System.out.println(o);
		// }

		// ListIterator<Integer> it = lista2.listIterator(2);
		// while (it.hasNext()) {
		// System.out.println(it.next());
		// }

	}
}
