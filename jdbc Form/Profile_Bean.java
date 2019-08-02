
public class Profile_Bean {
	String id = null;
	String name = null;
	String mail = null;
	String mob = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		System.out.append(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String string) {
		this.mob = string;
	}

}
