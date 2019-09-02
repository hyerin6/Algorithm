package sort.counting;

public class Person {
	String name;
	String sex;
	String bloodType;

	public Person(String name, String sex, String bloodType) {
		this.name = name;
		this.sex = sex;
		this.bloodType = bloodType;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getBloodType() {
		return bloodType;
	}

	@Override
	public String toString() {
		return String.format("Person{%s, %s, %s}", name, sex, bloodType);
	}
}