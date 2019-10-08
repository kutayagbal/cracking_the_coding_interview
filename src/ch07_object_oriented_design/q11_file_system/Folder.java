package ch07_object_oriented_design.q11_file_system;

import java.util.Date;
import java.util.List;

public class Folder {
	private List<Folder> folders;
	private List<File> files;
	private String name;
	private Date createDate;
	private Date updateDate;
	private Folder parent;

	public Folder() {
		Date currentDate = new Date();
		createDate = currentDate;
		updateDate = currentDate;
	}

	public File searchFile(String name) {
		if (files != null) {
			for (File f : files) {
				if (f.getName().equals(name)) {
					return f;
				}
			}
		}

		return null;
	}

	public Folder searchFolder(String name) {
		if (folders != null) {
			for (Folder f : folders) {
				if (f.getName().equals(name)) {
					return f;
				}
			}
		}

		return null;
	}

	public void addFile(File f) {
		files.add(f);
		setUpdateDate(new Date());
	}

	public void addFolder(Folder f) {
		folders.add(f);
		setUpdateDate(new Date());
	}

	public void deleteFile(File f) {
		files.remove(f);
		setUpdateDate(new Date());
	}

	public void deleteFolder(Folder f) {
		folders.remove(f);
		setUpdateDate(new Date());
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		int result = 0;
		if (folders != null) {
			for (Folder folder : folders) {
				result += folder.getSize();
			}
		}

		if (files != null) {
			for (File file : files) {
				result += file.getSize();
			}
		}

		return result;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}

	public Date getCreateDate() {
		return createDate;
	}

}
