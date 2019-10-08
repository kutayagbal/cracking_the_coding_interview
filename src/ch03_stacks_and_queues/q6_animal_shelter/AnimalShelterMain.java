package ch03_stacks_and_queues.q6_animal_shelter;

public class AnimalShelterMain {

	public static void main(String[] args) {
		AnimalShelter s = new AnimalShelter();
		s.enqueue(s.new Dog());
		s.enqueue(s.new Dog());
		s.enqueue(s.new Cat());
		s.enqueue(s.new Dog());
		s.enqueue(s.new Cat());
		s.enqueue(s.new Cat());
		s.enqueue(s.new Dog());
		
		s.print();
		
		s.dequeueAny();
		
		s.print();
		
		s.dequeueCat();
		
		s.print();
		
		s.dequeueCat();
		
		s.print();
		
		s.dequeueDog();
		
		s.print();
	}
}
