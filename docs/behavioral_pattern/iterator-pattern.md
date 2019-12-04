# Iterator Pattern - Behavioral Pattern
Bản chất của Iterator đó là cung cấp cách thức để duyệt qua các phần tử của 1 đối tượng tổng hợp một cách tuần tự mà không để lộ đại diện/ chi tiết bên trong của nó.

Nó tách rời các collection classes và algorithms. Bằng cách này ta có thể sử dụng cho các mục đích khác nhau như filter chẳng hạn.

Hỗ trợ "full object status" cho việc duyệt 1 collection

Polymorphic traversal.

## Bài toán
Quay lại nhà hàng góc phố. Hôm nay ông chủ quyết định xây dựng một menu thực đơn mới để phục vụ người dùng tốt hơn.

Menu của ông tổng hợp lại những món ăn mà nhà hàng có thể phục vụ. Những người khách cứ việc đến, tìm kiếm và gọi món rồi một lát sau sẽ được phục vụ liền.

Tuy nhiên, để cho dễ nhìn và dễ nhận biết, dưới mỗi món ăn ông đầu bếp sẽ phân loại món á hay âu, món chay hay mặn, món điểm tâm hay ăn chính.

Thế rồi có một ngày một gia đình ngoại quốc vào nhà hàng ông ăn. Nhưng mà có sự khác biệt. Bà mẹ thì theo đạo Phật chỉ ăn chay ko ăn thịt, ông bố thì theo đạo Hồi, ko chịu ăn bò, và cậu con của họ thì cái gì cũng xơi tuốt. Bàn đông nên chỉ còn 1 quyển sổ, và vậy là gia đình kia mất cả buổi cũng ko thể tìm được món ăn mà mình cần giữa một đống danh mục ngổn ngang.

## Giải pháp
Bởi vì thực đơn chỉ được phân loại theo một quy tắc mà ông chủ đã đặt ra nên nó trở nên cứng nhắc đối với người dùng khi họ muốn tìm kiếm.

Thế là ông chủ quyết định cho anh phục vụ nguyên một ngày để học các món ăn, khi khách tới, tùy vào yêu cầu mà anh ấy có thể tìm kiếm cho vị khách những món phù hợp với mong muốn của họ.

Trong bài toán này, anh phục vụ (sau khi đã đc đào tạo nhé) là iterator.

Iterator Pattern ra đời để giải quyết bài toán duyệt qua các phần tử của mảng mà không quan tâm tới bản chất các phần tử.

Nếu đã từng làm với Java, thì chắc chả ai là ko biết tới cái Hash Map. Và một trong số những cách duyệt qua các phần tử của Hash Map cũng được sử dụng 1 cái gọi là iterator. Chính xác thì hashmap là 1 ví dụ của việc implement Iterator Pattern trong Java.
```java
Iterator it = mp.entrySet().iterator();
while (it.hasNext()) {{'{'}}
    Map.Entry pair = (Map.Entry)it.next();
    System.out.println(pair.getKey() + " = " + pair.getValue());
    it.remove(); // avoids a ConcurrentModificationException
}
```
Iterator with array list.

Iterator<String> iterator = list.iterator(); while (iterator.hasNext()) {{'{'}}     System.out.println(iterator.next()); }
Và trong trường hợp này anh phục vụ cũng vậy, anh có thể lấy ra được danh sách các món ăn theo yêu cầu, mà ko cần quan tâm tới bản chất của món ăn đó ntn, là chay hay mặn, là ngọt hay béo ....

## Introduction
Trong một vài trường hợp, ta có 1 collection gồm các Object không có 1 điểm nào chung cả. Nhưng, ta muốn duyệt qua nó, tìm kiếm hay thao tác trên đó, vậy ta phải làm gì?

Collection trong java, với các Array, Set, HashMap đã support ta rất nhiều. Nhưng nên nhớ, khi khai báo 1 Array thì ta phải khai báo cùng 1 kiểu đối tượng. Trong trường hợp này ta ko thể sử dụng cách default được.

Do đó, mục đích của Iterator đó là trừu tượng hóa quá trình duyệt của các cấu trúc dữ liệu(data structure) khác nhau để thuật toán (algorithms) có khả năng giao tiếp với nhau (một cách trong suốt - tường minh).

to access the elements of an aggregate object sequentially without exposing its underlying implementation".
The Iterator pattern is also known as Cursor.
Một đối tượng tổng hợp (list) sẽ cung cấp cho ta 1 cách để truy cập vào các phần tử của nó mà không để lộ cấu trúc bên trong của nó. Ngoài ra ta cũng có thể muốn filter theo 1 cách thức khác nhau, tùy thuộc vào những gì ta cần thực hiện.

Bây giờ, ta xây dựng 1 List A với 1 Iterator dành riêng cho nó. Sau đó ta lại xây dựng một List B với iterator của riêng nó. Và càng ngày số lượng List càng tăng. Một ngày đẹp trời ta lại có bài toán duyệt và xử lý các object của cả List A và B trong cùng 1 interface. Và điều đó khiến ta ko biết cần phải làm chính xác những gì khi có quá nhiều interface cần thao tác với cái collection của chúng ta. Ta có thể dự đoaán ra các trường hợp khác nhau nhưng khó để có thể handle chúng hoàn toàn. Vì vậy, ta cần cung cấp 1 giao diện thống nhất để duyệt qua nhiều đối tượng tổng hợp (polymorphic iteration).

Iterator cho phép ta thực hiện điều này. Ý tưởng của pattern này đó là tách trách nhiệm của việc truy vập và duyệt ra khỏi đối tượng tổng hợp và đưa nó vào 1 Iterator object mà xác định một giao thức duyệt tiêu chuẩn.

Sự trừu tượng của Iterator là nền tảng cho một công nghệ mới nổi là "generic programming". Chiến lược này tìm các tách biệt rõ ràng giữa thuật toán và cấu trúc dữ liệu. Động lực của nó là thúc đẩy phát triển theo hướng component, tăng năng saats và giảm thiếu quản lý cấu hình.

Một ví dụ cho điều nà, nếu ta muốn support 4 loại dữ liệu như array, binary tree, linked list và hast table và 3 thuật toán sort, find và merge, theo sự tiếp cận truyền thống ta sẽ cần 4 x 3 = 12 function cần tạo. Trong khi nếu sử dụng Generic thì ta chỉ cần 4 + 3 chức năng.

với mỗi array ta cần implement đủ 3 cái function trên. Nên theo cách truyền thống ta cần 4 x 3 = 12. Với Generic Programming, cụ thể Iterator, ta chỉ cần implement 3 method cho toàn bộ tụi này và 4 vòng duyệt.

## Implements
Client sử dụng các collection interface để duyệt qua các phần tử của Object. Tuy nhiên, quyền truy cập trực tiếp vào các element bên trong collection được đóng gói bên trong 1 Abstract Class bổ sung - Iterator. Mỗi lớp dẫn xuất bộ sưu tập biết Itegration nào sẽ được tạo và trả về. Sau đó, Client dựa vào các interface được define trong Iterator base class.

Để implement 1 Iterator cần thực hiện các step sau:

1. Thêm 1 phương thức create_iterator vào collection class, và cấp quyền truy cập đặc quyền cho nó.
2. Thiết kế 1 lớp iterator có thể gói gọn việc duyệt qua các phần tử của collection class
3. Clients yêu cầu collection class tạo đối tượng iterator.
4. Client sử dụng first(), isDone(), next() và các protocol khác để truy câp các phần tử của collection class.
Một iterator thì cần có những method sau:

- Một Collection Interface để define những thuộc tính chung của nó:
	* addElement(Element)
	* removeElement(Element)
	* iterator (params)
- Một Iterator cho Collection đó:
	* boolean hasNext()
	* Element next()
- Các collection implement nó.
Còn cách sử dụng ấy hả, xem trong hash map của java ấy.

## Advantages & Disadvantages

### Advantages
Cung cấp 1 cơ chế duyệt qua các phần tử của 1 collection bất kì, đồng thời hỗ trợ các biến thể cho việc filter/ iterator

Đơn giản hóa giao diện cho collection.

## Usage
Khi ta muốn truy cập vào 1 collection mà không để lộ đại diện bên trong của nó

Khi có nhiều đối tượng cần được hỗ trợ trong collection.

## Summary
Xem lại về Interpreter, ta thấy abstract syntax tree của nó là composite. Do đó, ta cũng có thể áp dụng Iterator vầ Visitor thay thế.

Iterator có thể duyệt 1 Composite. Visitor có thể áp dụng hoạt động lên 1 Composite.

Polymophic Iterator dựa trên các Factory Method để tạo ra các Iterator thích hợp

Memento thường được kết hợp với Iterator. Một Iterator có thể sử dụng Memetor để lưu trữ trạng thái của 1 lần Lặp. Iterator lưu trữ Memeto trong nội bộ/ bên trong nó.