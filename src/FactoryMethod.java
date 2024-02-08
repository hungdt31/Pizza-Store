// Product : Định nghĩa một khuôn mẫu (interface) của các đối tượng mà factory method tạo ra.
interface Product {
	public void printInfo();
}
// Concreteproduct: các lớp được cài đặt khuôn mẫu product.
class ProductA implements Product{
	public void printInfo() {
		System.out.println("Product A is created");
	}
}
class ProductB implements Product{
	public void printInfo() {
		System.out.println("Product B is created");
	}
}

// Creator: Khai báo createProduct, trả về kiểu đối tượng thuộc kiểu product. 
// Creator cũng có thể định nghĩa một cài đặt mặc định của factory method mà giá trị trả về là một đối tượng concreteproduct mặc định.
// Gọi createProduct để tạo đổi tượng kiểu product.
interface Creator {
    Product createProduct();
}
// ConcreteCrator: ghi đè createProduct để trả về một instance của concreteproduct.
class CreatorProductA implements Creator {
	public Product createProduct() {
		return new ProductA();
	}
}
class CreatorProductB implements Creator {
	public Product createProduct() {
		return new ProductB();
	}
}

public class FactoryMethod {
	public static void main(String[] args) {
		CreatorProductB creator_B = new CreatorProductB();
		CreatorProductA creator_A = new CreatorProductA();
		
		Product product_A = creator_A.createProduct();
		product_A.printInfo();
		Product product_B = creator_B.createProduct();
		product_B.printInfo();
	}
}

