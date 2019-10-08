package ch03_stacks_and_queues.q6_animal_shelter.solution;

import java.util.Iterator;
import java.util.LinkedList;

import ch03_stacks_and_queues.q6_animal_shelter.AnimalShelter.Cat;
import ch03_stacks_and_queues.q6_animal_shelter.AnimalShelter.Dog;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0; // acts as timestamp

	public void enqueue(Animal a) {
		/*
		 * Order is used as a sort of timestamp, so that we can compare the insertion
		 * order of a dog to a cat.
		 */
		a.setOrder(order);
		order++;

		if (a instanceof Dog)
			dogs.add((Dog) a);
		else if (a instanceof Cat)
			cats.add((Cat) a);
	}

	public Animal dequeueAny() {
		/*
		 * Look at tops of dog and cat queues, and pop the queue with the oldest value.
		 */
		if (dogs.size() == 0) {
			return dequeueCats();
		} else if (cats.size() == 0) {
			return dequeueDogs();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}

	public abstract class Animal {
		private int order;
		protected String name;

		public Animal(String n) {
			this.name = n;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}

		/* Compare orders of animals to return the older item. */
		public boolean isOlderThan(Animal a) {
			return this.order < a.getOrder();
		}
	}

	public class Dog extends Animal {

		public Dog(String n) {
			super(n);
			// TODO Auto-generated constructor stub
		}
	}

	public class Cat extends Animal {

		public Cat(String n) {
			super(n);
			// TODO Auto-generated constructor stub
		}
	}

	public void print() {
		Iterator<Cat> itCat = cats.iterator();
		Iterator<Dog> itDog = dogs.iterator();

		Cat currentCat = itCat.hasNext() ? itCat.next() : null;
		Dog currentDog = itDog.hasNext() ? itDog.next() : null;

		while (currentDog != null || currentCat != null) {
			if (currentCat == null) {
				System.out.print("D,");
				currentDog = itDog.hasNext() ? itDog.next() : null;
				continue;
			} else if (currentDog == null) {
				System.out.print("C,");
				currentCat = itCat.hasNext() ? itCat.next() : null;
				continue;
			}

			if (currentCat.isOlderThan(currentDog)) {
				System.out.print("C,");
				currentCat = itCat.hasNext() ? itCat.next() : null;
			} else {
				System.out.print("D,");
				currentDog = itDog.hasNext() ? itDog.next() : null;
			}
		}

		System.out.println();

	}

}
