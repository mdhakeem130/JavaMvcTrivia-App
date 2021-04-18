package trythis;

//This is model(java bean) class it is use to get data from databse and set
public class Bean {

	private String name, q1answer, q2answer;

	public void setName(String name) {
		this.name = name;
	}

	public void setQ1answer(String q1answer) {
		// TODO Auto-generated method stub
		this.q1answer = q1answer;
	}

	public void setQ2answer(String q2answer) {
		// TODO Auto-generated method stub
		this.q2answer = q2answer;
	}

	public String getName() {
		return name;
	}

	public String getQ1answer() {
		return q1answer;
	}

	public String getQ2answer() {
		return q2answer;
	}
}
