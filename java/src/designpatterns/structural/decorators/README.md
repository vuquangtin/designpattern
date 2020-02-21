# Decorator Pattern

Mục đích của mẫu Decorator là `"gắn kết thêm một số tính năng cho đối tượng một cách linh động"`. Sử dụng `lớp con để mở rộng chức năng cho đối tượng`. Trong source code lớp Computer là lớp ban đầu, lớp ComponentDecorator là 1 abstract khai báo các thành phần bọc Computer. 

> **Decorator** — Gán bổ sung các “trách nhiệm” (responsibility) cho một đối tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động cho lớp con để mở rộng tính năng

> **Note:** Đóng cho việc chỉnh sửa đổi, mở cho việc mở rộng.

```
	|-------------------------------------------------------|
	|	|--------------------------------------	|	|	
	|	|	|-----------------------|	|	|		
	|	|	|	Computer	|	|	|					
	|	|	|	description()	|	|	|
	|	|	|-----------------------|	|	|	
	|	|					|	|
	|	|		Disk			|	|	
	|	|		description()		|	|
	|	|--------------------------------------	|	|
	|							|
	|			Monitor				|	
	|			description()			|
	|-------------------------------------------------------|
```

@see https://stackoverflow.com/questions/6366385/use-cases-and-examples-of-gof-decorator-pattern-for-io

> InputStream is an abstract class. Most concrete implementations like BufferedInputStream, GzipInputStream, ObjectInputStream, etc. have a constructor that takes an instance of the same abstract class. That's the recognition key of the decorator pattern (this also applies to constructors taking an instance of the same interface).

When such a constructor is used, all methods will delegate to the wrapped instance, with changes in the way the methods behave. For example, buffering the stream in memory beforehand, decompressing the stream beforehand or interpreting the stream differently. Some even have additional methods that finally also delegate further to the wrapped instance. Those methods decorate the wrapped instance with extra behaviour.

Let's say that we have a bunch of serialized Java objects in a Gzipped file and that we want to read them quickly.

First open an inputstream of it:

```java
FileInputStream fis = new FileInputStream("/objects.gz");
```

We want speed, so let's buffer it in memory:

```java
BufferedInputStream bis = new BufferedInputStream(fis);
```

The file is gzipped, so we need to ungzip it:

```java
GzipInputStream gis = new GzipInputStream(bis);
```

We need to unserialize those Java objects:

```java
ObjectInputStream ois = new ObjectInputStream(gis);
```

Now we can finally use it:

```java
SomeObject someObject = (SomeObject) ois.readObject();
```

// ...
The benefit is that you have a lot of freedom to decorate the stream using one or more various decorators to suit your needs. That's much better than having a single class for every possible combination like ObjectGzipBufferedFileInputStream, ObjectBufferedFileInputStream, GzipBufferedFileInputStream, ObjectGzipFileInputStream, ObjectFileInputStream, GzipFileInputStream, BufferedFileInputStream, etc.

Note that when you're about to close the stream, just closing the outermost decorator is sufficient. It will delegate the close call all the way to the bottom.

```java
ois.close();
```