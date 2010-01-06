package id.co.visitek.jproject.model.object;


public class Consultant extends User implements	IResource {
	private static final long serialVersionUID = 1L;
	int type;
	float load;
	float cost;
	
	public float getLoad() {
		return load;
	}

	public int getType() {
		return type;
	}

	public void setLoad(float load) {
		this.load = load;
	}

	public void setType(int type) {
		this.type = type;		
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

}
