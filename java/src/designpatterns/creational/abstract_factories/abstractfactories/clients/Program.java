package abstractfactories.clients;

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
abstract class IElectronicProduct {
	// Common property
	private String name;

	private String memory;

	private String description;

	// Common Method / Function / Behaviour
	abstract String getMemory();

	abstract void setMemory(int value);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
}

// AbstractProduct - 1
abstract class ILaptop extends IElectronicProduct {
	private String warrantyPeriod;

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	private String modelDetails;
}

// AbstractProduct - 2
abstract class IMobile extends IElectronicProduct {
	private String warrantyPeriod;
	private String modelDetails;
	private String phoneType;

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType
	 *            the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
}

// 'AbstractFactory' Interface
interface IProduct {
	ILaptop createLaptopProduct(LaptopTypeDetails laptopTypeDetails)
			throws Exception;

	IMobile createMobileProduct(MobileTypeDetails mobileTypeDetails)
			throws Exception;
}

// 'Product-1' For Laptop
class GamingLaptop extends ILaptop {
	private String name;

	private String memory;

	public String description;

	public String warrantyPeriod;

	public String modelDetails;

	public String getMemory() {
		return memory;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	public void setMemory(int value) {
		memory = String.format("{0} {1}", value, "TB");
	}

	public GamingLaptop() {
		name = "HP Omen";
		memory = "1 TB";
		description = "It's famous Gaming laptop in india";
		warrantyPeriod = "1 Year";
		modelDetails = "HP OMEN Core i5 7th Gen -(16 GB / 1 TB HDD/ 128 GB SSD/ Windows 10 Home / 4 GB Graphics) 15 - ax249TX Gaming Laptop  (15.6 inch, Black)";
	}
}

// 'Product-2' For Laptop
class NormalLaptop extends ILaptop {
	private String name;

	private String memory;
	private String description;

	private String warrantyPeriod;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	private String modelDetails;

	public String getMemory() {
		return memory;
	}

	public void setMemory(int value) {
		memory = String.format("{0} {1}", value, "TB");
	}

	public NormalLaptop() {
		name = "Dell Inspiration";
		memory = "2 TB";
		description = "It's famous Gaming laptop in india";
		warrantyPeriod = "1.5 Year";
		modelDetails = "HP OMEN Core i5 7th Gen -(16 GB / 1 TB HDD/ 128 GB SSD/ Windows 10 Home / 4 GB Graphics) 15 - ax249TX Gaming Laptop  (15.6 inch, Black)";
	}
}

// 'Product-1' For Mobile Phone
class SmartPhone extends IMobile {
	private String name;

	private String memory;

	public String description;

	public String warrantyPeriod;

	private String modelDetails;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType
	 *            the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	// GSM or CDMA
	private String phoneType;

	public String getMemory() {
		return memory;
	}

	public void setMemory(int value) {
		memory = String.format("{0} {1}", value, "GB");
	}

	public SmartPhone() {
		name = "Lenovo Vibe K5 Note";
		memory = "8 GB";
		description = "It's famous Smart Phone in india";
		warrantyPeriod = "2 Year";
		modelDetails = "Lenovo Vibe K5 Note (Gold, 32 GB)  (3 GB RAM)";
		phoneType = "GSM";
	}
}

// 'Product-2' For Mobile Phone
class NormalPhone extends IMobile {
	private String name;

	private String memory;

	private String description;

	private String warrantyPeriod;

	private String modelDetails;

	// GSM or CDMA
	private String phoneType;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the warrantyPeriod
	 */
	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	/**
	 * @param warrantyPeriod
	 *            the warrantyPeriod to set
	 */
	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	/**
	 * @return the modelDetails
	 */
	public String getModelDetails() {
		return modelDetails;
	}

	/**
	 * @param modelDetails
	 *            the modelDetails to set
	 */
	public void setModelDetails(String modelDetails) {
		this.modelDetails = modelDetails;
	}

	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType
	 *            the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @param memory
	 *            the memory to set
	 */
	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(int value) {
		memory = String.format("{0} {1}", value, "MB");
	}

	public NormalPhone() {
		name = "Nokia 1600 ";
		memory = "256 MB";
		description = "It's famous Normal Phone in india";
		warrantyPeriod = "1 Year";
		modelDetails = "REBOXED Nokia 1600 256 MB Black RAM";
		phoneType = "CDMA";
	}
}

// 'ConcreteFactory' class
class ElectronicProduct implements IProduct {

	// 'Maintain ConcreteFactory-1'
	@Override
	public ILaptop createLaptopProduct(LaptopTypeDetails laptopTypeDetails)
			throws Exception {
		switch (laptopTypeDetails) {
		case Gaming:
			return new GamingLaptop();
		case Normal:
			return new NormalLaptop();
		default:
			throw new Exception();
		}
	}

	// 'Maintain ConcreteFactory-2'
	@Override
	public IMobile createMobileProduct(MobileTypeDetails mobileTypeDetails)
			throws Exception {
		switch (mobileTypeDetails) {
		case Smart:
			return new SmartPhone();
		case Normal:
			return new NormalPhone();
		default:
			throw new Exception();
		}
	}

}

// 'Client' Class
class Product {
	public Product() {
		System.out.println("Creating Product Factory");
	}

	// maintain laptop products
	public ILaptop laptopProduct(IProduct Product,
			LaptopTypeDetails laptopTypeDetails) {
		try {
			return Product.createLaptopProduct(laptopTypeDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// maintain mobile products
	public IMobile mobileProduct(IProduct Product,
			MobileTypeDetails mobileTypeDetails) {
		try {
			return Product.createMobileProduct(mobileTypeDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

// Different product that can be created by the factory
enum ProductDetails {
	MobilePhone, Laptop, ExternalHardDrive
}

enum LaptopTypeDetails {
	Gaming, Normal
}

enum MobileTypeDetails {
	Smart, Normal
}

/**
 * <h1>Abstract Factory</h1> Cung cấp một interface để tạo ra 1 họ các object
 * (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ
 * thể của chúng (concrete classes)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com

 *      /vuquangtin/designpattern</a>
 *
 */
public class Program {
	public static void main(String[] args) {
		IProduct electronicProduct = new ElectronicProduct();
		Product product = new Product();

		// -------------------------Laptop
		// product----------------------------------------------
		System.out
				.println("------------------------------------------Laptop Products------------------------------------------");

		for (LaptopTypeDetails laptopTypeDetail : LaptopTypeDetails.values()) {
			ILaptop laptopProduct = product.laptopProduct(electronicProduct,
					laptopTypeDetail);
			System.out
					.println("------------------------------------------{0} Laptop------------------------------------------"
							+ laptopProduct.toString());
			// System.out.println(
			// "Name: {0}, Memory: {1}, Description: {2}, Available Memory: {3},
			// Contract Period: {4}, Model Details: {5} ",
			// laptopProduct.Name, laptopProduct.Memory,
			// laptopProduct.Description, laptopProduct.GetMemory(),
			// laptopProduct.WarrantyPeriod, laptopProduct.ModelDetails);
			// System.out.println("Do you want to reset {0} memory?",
			// laptopProduct.Name);
			// // Console.Write("Press 1 to reset memory: ");
			// if (Convert.ToInt32(Console.ReadLine()) == 1) {
			// Console.Write("Enter Memory Capacity: ");
			// laptopProduct.SetMemory(Convert.ToInt32(Console.ReadLine()));
			// System.out.println("Current Reset Memory Value: {0}",
			// laptopProduct.GetMemory());
			// }
		}

		// -------------------------Mobile
		// product----------------------------------------------
		System.out
				.println("------------------------------------------Mobile Phone Products------------------------------------------");
		System.out
				.println("------------------------------------------Mobile Phone Products------------------------------------------");
		for (MobileTypeDetails mobileTypeDetail : MobileTypeDetails.values()) {
			IMobile mobileProduct = product.mobileProduct(electronicProduct,
					mobileTypeDetail);
			System.out
					.println("------------------------------------------{0} Phone------------------------------------------"
							+ mobileProduct.toString());
			// System.out.println(
			// "Name: {0}, Memory: {1}, Description: {2}, Available Memory: {3},
			// Contract Period: {4}, Model Details: {5}, Phone Type: {6} ",
			// mobileProduct.Name, mobileProduct.Memory,
			// mobileProduct.Description, mobileProduct.GetMemory(),
			// mobileProduct.WarrantyPeriod, mobileProduct.ModelDetails,
			// mobileProduct.PhoneType);
			// System.out.println("Do you want to reset {0} memory?",
			// mobileProduct.Name);
			// Console.Write("Press 1 to reset memory: ");
			// if (Convert.ToInt32(Console.ReadLine()) == 1) {
			// Console.Write("Enter Memory Capacity: ");
			// mobileProduct.SetMemory(Convert.ToInt32(Console.ReadLine()));
			// System.out.println("Current Reset Memory Value: {0}",
			// mobileProduct.GetMemory());
			// }
		}
		System.out.println("Press any key to exit");
		// Console.ReadLine();

	}
}