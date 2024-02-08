/***************** Abstract Products ******************/
interface Button {
	void printInfo();
}

interface Checkbox {
	void printInfo();
}

enum Supplier {
	window,
	mac
}

/******************************************************/

/***************** Concrete Products ******************/
class WinButton implements Button {
	public void printInfo() {
		System.out.println("This is a Window Button.");
	}
}

class WinCheckbox implements Checkbox {
	public void printInfo() {
		System.out.println("This is a Window Checkbox.");
	}
}

class MacButton implements Button {
	public void printInfo() {
		System.out.println("This is a Mac Button.");
	}
}

class MacCheckbox implements Checkbox {
	public void printInfo() {
		System.out.println("This is a Mac Checkbox.");
	}
}

/******************************************************/

/***************** Abstract Factory *******************/
interface GUIFactory {
	Button createButton();

	Checkbox createCheckbox();
}

/******************************************************/

/***************** Concrete Factories *****************/
class WinFactory implements GUIFactory {
	public Button createButton() {
		return new WinButton();
	}

	public Checkbox createCheckbox() {
		return new WinCheckbox();
	}
}

class MacFactory implements GUIFactory {
	public Button createButton() {
		return new MacButton();
	}

	public Checkbox createCheckbox() {
		return new MacCheckbox();
	}
}

/******************************************************/

class Client {
	private GUIFactory guifactory;
	private Button button;
	private Checkbox checkbox;

	public Client(Supplier supplier) {
		switch (supplier) {
			case window:
				guifactory = new WinFactory();
				break;
			case mac:
				guifactory = new MacFactory();
				break;
			default:
				break;
		}
		if (guifactory == null) {
			System.out.println("Cannot find the supplier for the demand !");
			return;
		}
		button = guifactory.createButton();
		checkbox = guifactory.createCheckbox();
	}

	public void createUI() {
		if (button != null && checkbox != null) {
			button.printInfo();
			checkbox.printInfo();
		}
	}
}

public class AbstractFactoryMethod {
	public static void main(String[] args) {
		Supplier supplier = Supplier.window;
		Client client = new Client(supplier);
		client.createUI();
	}
}
