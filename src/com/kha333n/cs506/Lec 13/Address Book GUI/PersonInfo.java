class PersonInfo {

	String name;
	String address;
	String phoneNum;

	//parameterized constructor
	public PersonInfo(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		phoneNum = phone;
	}

	public void setName(String name){ this.name = name;}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}

	public String getName(){
		return name;
	}

	public String getAddress(){
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
}