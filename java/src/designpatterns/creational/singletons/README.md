# Singleton Pattern

Mẫu singleton “`Đảm bảo rằng một lớp chỉ có duy nhất một thể hiện và cung cấp một biến toàn cục để truy cập nó`”. Bạn sử dụng mẫu Singleton khi bạn muốn `hạn chế việc sử dụng tài nguyên`(thay vì việc tạo không hạn chế số lượng đối tượng) hoặc khi bạn cần phải xử lý một `đối tượng nhạy cảm`, mà `dữ liệu của nó không thể chia sẻ cho mọi thể hiện`, như registry của Windows chẳng hạn.

### Một vài quy tắc quan trọng:
- Contructor  phải là private.
- Sử dụng static keyword.
- Có một public static method để class bên ngoài có thể làm việc với singleton class.

#### Cách 1: Thread-safe

```java
public class Database {
    
    private static Database singleObject;
    private int record;
    private String name;
    
    private Database(String n) {
        this.name = n;
        this.record = 0;
    }
    
    public void editRecord(String operation) {
        System.out.println("Performing a " + operation + " operation on record " + record + " in "
                + "database " + name);
    }
    
    public String getName() {
        return name;
    }
    
    public static synchronized Database getInstance(String n) {
        if (singleObject == null) {
	        singleObject = new Database("Product");
        }
        return singleObject;
    }
}
```
> **Note:** Với các cách này ta rõ ràng thấy rằng nếu có nhiều `nhiều thread` cùng đồng thời gọi method `getInstance` thì sẽ có `nhiều Singleton object được tạo ra` và phá với code của chúng ta. Vậy nên để tránh trường hợp trên trong khi chạy nhiều thread thì ta thêm `synchronized keyword` vào `getInstance()`.

####  Cách 2: Tối ưu cách 1

```java
public class Database {
	private static Database singleObject;
	private int record;
    private String name;
    
	private Database(String n) {
		this.name = n;
        this.record = 0;
	}

	public void editRecord(String operation) {
        System.out.println("Performing a " + operation + " operation on record " + record + " in "
                + "database " + name);
    }
    
    public String getName() {
        return name;
    }
    
    public static Database getInstance(String n) {
        if(singleObject == null) {
			synchronized(Database.class) {
				if(null == singleObject) {					 
					singleObject = new Database("Product");
				}
			}
		}
        return singleObject;
    }
}
```
> **Note:** Ta thấy ở cách này mình không dùng `synchronized` ở `getInstance()` nữa mà mình dùng `synchronized(){ }`. Với chỉ một thay đổi nhỏ này sẽ có một sự thay đổi lớn trong khi chạy chương trình với lượng `thread lớn`.

#### Bài viết còn chưa nêu lên một số vấn đề khi `reflection` và `serializable` khi thực hiện với singleton và sẽ bổ sung sau.
