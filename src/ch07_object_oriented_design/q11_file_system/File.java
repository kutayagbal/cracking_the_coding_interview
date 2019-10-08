package ch07_object_oriented_design.q11_file_system;

import java.util.Date;

public class File {
	private String name;
	private int size = 0;
	private String data;
	private Date createDate;
	private Date updateDate;
	private Folder parent;

	public File(String name) {
		this.name = name;
		Date currentDate = new Date();
		createDate = currentDate;
		updateDate = currentDate;
	}

	public void delete() {
		parent.deleteFile(this);
	}

	public String getName() {
		return name;
	}

	public void rename(String name) {
		this.name = name;
		updateDate = new Date();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		updateDate = new Date();
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
