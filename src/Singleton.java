class Sun{
	// Tạo một biến static private là instance của class đó 
	// để đảm bảo rằng nó là duy nhất và chỉ được tạo ra trong class đó thôi
	private static Sun onlyOne = null;
	// Đặt constructor là private để client không thể khởi tạo object của class
	private Sun() {
		
	};
	// Tạo một public static method trả về instance vừa khởi tạo bên trên, 
	// đây là cách duy nhất để các class khác có thể truy cập vào instance của class này
	public static Sun getInstance() {
		if (onlyOne == null) {
			onlyOne = new Sun();
		}
		return onlyOne;
	}
}
public class Singleton {
	public static void main(String[] args) {
		Sun sun_obj1 = Sun.getInstance();
		Sun sun_obj2 = Sun.getInstance();
		if (sun_obj1 == sun_obj2) System.out.println("Có duy nhất một mặt trời");
	}
}
