package es.upo.cal;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import upo.es.qa.epd1.ListImplementation;

public class Tester_ListImplementation {

	private List<Integer> lista;
	private List<Integer> lista2;
	private Integer a;
	private Integer b;

	@BeforeClass
	public void constructor() {
		a = 3;
		b = 6;
		lista2 = new ListImplementation<Integer>();
		lista2.add(b);
		lista2.add(a);
	}

	@BeforeMethod
	public void beforeMethod() {
		lista = new ListImplementation<Integer>();
	}

	// ¿Devuelve true?
	@Test
	public void add() {
		assertTrue(lista.add(a));
	}

	// ¿Aumenta el tamaño al añadir, es el tamaño correcto?
	@Test
	public void add_size() {
		assertEquals(0, lista.size());
		lista.add(a);
		assertEquals(1, lista.size());
	}

	// ¿Se ha añadido?
	@Test
	public void add_contains() {
		lista.add(a);
		assertTrue(lista.contains(a));
	}

	// ¿Está colocado en la posición adecuada?
	@Test
	public void add_get() {
		lista.add(a);
		assertEquals(a, lista.get(0));
	}

	// ¿Reemplaza la posición 1, y adelanta el elemento anterior 1 posición?
	@Test
	public void add2_get() {
		lista.add(8);
		lista.add(b);
		lista.add(1, a);
		assertEquals(a, lista.get(1));
		assertEquals(b, lista.get(2));
	}

	// ¿Se añade toda la lista correctamente?
	@Test
	public void addAll() {
		lista.addAll(lista2);
		if (lista.size() == lista2.size()) {
			for (int i = 0; i < lista.size(); i++) {
				assertEquals(lista.get(i), lista2.get(i));
			}
		} else {
			assertTrue(false);
		}
	}

	// ¿Se añade toda la lista correctamente partiendo de una posición?
	@Test
	public void addAll2() {
		int posicion = 1;
		int size = lista.size();
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.addAll(posicion, lista2);
		if (lista.size() == size + lista2.size()) {
			for (int i = 0; i < lista2.size(); i++) {
				assertEquals(lista.get(i + posicion), lista2.get(i));
			}
		} else {
			assertTrue(false);
		}
	}

	// ¿Se borra la lista?
	@Test
	public void clear_isEmpty() {
		lista.add(a);
		lista.clear();
		assertTrue(lista.isEmpty());
	}

	// // ¿Son iguales todos los elementos de la lista?
	// @Test
	// public void clOne() {
	// lista = (ListImplementation<Integer>) lista2.clone();
	// for (int i = 0; i < lista.size(); i++) {
	// assertEquals(lista.get(i), lista2.get(i));
	// }
	// }
	//
	// // ¿Son iguales físicamente, representan la misma entidad?
	// @Test
	// public void clone_equals() {
	// lista = (ListImplementation<Integer>) lista2.clone();
	// assertTrue(lista.equals(lista2));
	// }

	// ¿La primera lista contiene todos los elementos de la segunda?
	@Test
	public void containsAll() {
		lista = lista2;
		assertTrue(lista.containsAll(lista2));
	}

	// ¿Devuelve la posición correcta? ¿Si hay más d eun elemento repetido
	// devuelve la primera posición en la que aparece?
	@Test
	public void indexOf() {
		lista2.add(a);
		assertEquals(1, lista2.indexOf(a));
	}

	// ¿Crea el iterator correctamente?
	@Test
	public void iterator2() {
		Iterator<Integer> it = lista2.iterator();
		int i = 0;
		while (it.hasNext()) {
			assertEquals(it.next(), lista2.get(i));
			i++;
		}
	}

	// ¿Devuelve la última posición?
	@Test
	public void lastIndexOf() {
		lista.add(a);
		lista.add(b);
		lista.add(b);
		assertEquals(2, lista.lastIndexOf(b));
	}

	// ¿Crea el iterator correctamente?
	@Test
	public void listIterator() {
		ListIterator<Integer> it = lista2.listIterator();
		int i = 0;
		while (it.hasNext()) {
			assertEquals(it.next(), lista2.get(i));
			i++;
		}
	}

	// ¿Crea el iterator correctamente partiendo de una posición?
	@Test
	public void listIterator2() {
		int posicion = 1;
		ListIterator<Integer> it = lista2.listIterator(posicion);
		int i = posicion;
		while (it.hasNext()) {
			assertEquals(it.next(), lista2.get(i));
			i++;
		}
	}

	// ¿Funciona el remove pasándole una posición?
	@Test
	public void remove() {
		lista.add(a);
		lista.remove(0);
		assertTrue(lista.isEmpty());
	}

	@Test
	public void remove2() {
		lista.add(a);
		lista.remove(new Integer(a));
		assertTrue(lista.isEmpty());
	}

	// {a,b,10}-{b,a} = {10}
	@Test
	public void removeAll() {
		lista.add(a);
		lista.add(b);
		lista.add(10);
		lista.removeAll(lista2);
		assertEquals(new Integer(10), lista.get(0));
	}

	// lista:{a,10} lista2:{b,a}
	@Test
	public void retainAll() {
		lista.add(a);
		lista.add(10);
		lista.retainAll(lista2);
		assertEquals(a, lista.get(0));
	}

	@Test
	public void set() {
		lista.add(a);
		lista.set(0, b);
		assertEquals(b, lista.get(0));
	}

	// ¿Son iguales todos los elementos de la sublista?
	@Test
	public void subList() {
		int posicion = 1;
		List<Integer> l = lista2.subList(posicion, lista2.size());
		for (int i = 0; i < l.size(); i++) {
			assertEquals(l.get(i), lista2.get(i + posicion));
		}
	}

	// ¿Son iguales todos los elementos de la lista?
	@Test
	public void toArray() {
		Object[] a = new Object[lista2.size()];
		a = lista2.toArray();
		if (a.length == lista2.size()) {
			for (int i = 0; i < lista2.size(); i++) {
				assertEquals(a[i], lista2.get(i));
			}
		} else {
			assertTrue(false);
		}
	}

	// ¿Son iguales todos los elementos de la lista?
	@Test
	public void toArray2() {
		Integer[] a = new Integer[lista2.size()];
		a = lista2.toArray(a);
		if (a.length == lista2.size()) {
			for (int i = 0; i < lista2.size(); i++) {
				assertEquals(a[i], lista2.get(i));
			}
		} else {
			assertTrue(false);
		}
	}

}
