package neusoft.soft.coffeestore.bean;

public class People {
	public int ID = -1;
	public String Name;
	public double Age;
	public float Height;
	
	@Override
	public String toString(){
		String result = "";
		result += "ID:" + this.ID + ",";
		result += "收货地址:" + this.Name + ",";
		result += "电话:" + this.Age + ",";
		result += "邮编:" + this.Height;
		return result;
	}
}
