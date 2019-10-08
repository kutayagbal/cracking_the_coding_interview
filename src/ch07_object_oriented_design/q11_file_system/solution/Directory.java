package ch07_object_oriented_design.q11_file_system.solution;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
	protected List<Entry> contents;

	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry e : contents) {
			size += e.size();
		}

		return size;
	}

	public int numberOfFiles() {
		int count = 0;

		for (Entry e : contents) {
			if (e instanceof Directory) {
				count++; // Directory counts a file
				Directory d = (Directory) e;
				count += d.numberOfFiles();
			} else if (e instanceof File) {
				count++;
			}
		}

		return count;
	}

	public boolean deleteEntry(Entry e) {
		return contents.remove(e);
	}

	public void addEntry(Entry e) {
		contents.add(e);
	}

	public List<Entry> getContents() {
		return contents;
	}

}
