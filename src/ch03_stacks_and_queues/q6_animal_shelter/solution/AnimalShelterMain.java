package ch03_stacks_and_queues.q6_animal_shelter.solution;


public class AnimalShelterMain {

	public static void main(String[] args) {
		AnimalQueue s = new AnimalQueue();
		s.enqueue(s.new Dog("a"));
		s.enqueue(s.new Dog("b"));
		s.enqueue(s.new Cat("x"));
		s.enqueue(s.new Dog("c"));
		s.enqueue(s.new Cat("y"));
		s.enqueue(s.new Cat("z"));
		s.enqueue(s.new Dog("e"));
		
		s.print();
		
		s.dequeueAny();
		
		s.print();
		
		s.dequeueCats();
		
		s.print();
		
		s.dequeueCats();
		
		s.print();
		
		s.dequeueDogs();
		
		s.print();
		
		s.dequeueDogs();
		s.dequeueDogs();
		s.print();
		s.dequeueCats();
		s.print();
		
	}

}
