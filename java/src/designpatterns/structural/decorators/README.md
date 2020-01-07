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
