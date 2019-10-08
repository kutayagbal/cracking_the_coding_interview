package ch07_object_oriented_design.q11_file_system.solution;

public abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected String name;

	public Entry(String n, Directory p) {
		name = n;
		parent = p;
		created = System.currentTimeMillis();
		lastUpdated = System.currentTimeMillis();
		lastAccessed = System.currentTimeMillis();
	}

	public boolean delete() {
		if (parent == null)
			return false;

		return parent.deleteEntry(this);
	}

	public abstract int size();

	public String getFullPath() {
		if (parent == null)
			return name;

		return parent.getFullPath() + "/" + name;
	}

	public void changeName(String n) {
		name = n;
	}

	public long getCreated() {
		return created;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}

	public String getName() {
		return name;
	}

}
