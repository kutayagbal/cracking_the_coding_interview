package ch03_stacks_and_queues.q6_animal_shelter;

import java.util.Iterator;
import java.util.LinkedList;

import ch03_stacks_and_queues.q6_animal_shelter.solution.AnimalQueue.Cat;
import ch03_stacks_and_queues.q6_animal_shelter.solution.AnimalQueue.Dog;

public class AnimalShelter {
	private LinkedList<Cat> cats;
	private LinkedList<Dog> dogs;
	private int currentIndex = 0;

	public AnimalShelter() {
		this.cats = new LinkedList<>();
		this.dogs = new LinkedList<>();
	}

	public void enqueue(Animal animal) {
		if (animal instanceof Cat) {
			animal.index = currentIndex;
			cats.add((Cat) animal);
			currentIndex++;
		} else if (animal instanceof Dog) {
			animal.index = currentIndex;
			dogs.add((Dog) animal);
			currentIndex++;
		} else {
			System.out.println("wrong animal for shelter");
		}
	}

	public Animal dequeueAny() {
		if (cats.isEmpty() && dogs.isEmpty()) {
			System.out.println("empty shelter");
			return null;
		}

		if (cats.element().index < dogs.element().index) {
			return cats.remove();
		} else {
			return dogs.remove();
		}
	}

	public Cat dequeueCat() {
		if (cats.isEmpty()) {
			System.out.println("no cats in shelter");
			return null;
		}

		return cats.remove();
	}

	public Dog dequeueDog() {
		if (dogs.isEmpty()) {
			System.out.println("no dogs in shelter");
			return null;
		}

		return dogs.remove();
	}

	public int animalCount() {
		return cats.size() + dogs.size();
	}

	public int catCount() {
		return cats.size();
	}

	public int dogCount() {
		return cats.size();
	}

	public boolean isEmpty() {
		return cats.isEmpty() && dogs.isEmpty();
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

			if (currentCat.index < currentDog.index) {
				System.out.print("C,");
				currentCat = itCat.hasNext() ? itCat.next() : null;
			} else {
				System.out.print("D,");
				currentDog = itDog.hasNext() ? itDog.next() : null;
			}
		}

		System.out.println();

	}

	public class Animal {
		String name;
		int index;
	}

	public class Cat extends Animal {
	}

	public class Dog extends Animal {
	}
}
