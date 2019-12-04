# Decorate Pattern - Structural Pattern
Attach thêm 1 trách nhiệm bổ sung cho 1 đối tượng 1 cách năng động/ dynamic. Decorate cung cấp 1 sự thay thế linh hoạt cho các Subclass để mở rộng các chức năng.

Đóng gói đệ quy 1 core object vào bên trong 1 đối tượng để bổ sung các chức năng cho nó.

Wrapping a gift, putting it in a box, and wrapping the box.

## Bài toán
Ta quay lại với cửa hàng góc phố nào.

Những câu chuyện trước, ta biết rằng, cửa hàng của ông chủ vừa có đầu bếp tây, vừa có đầu bếp ta.

Dĩ nhiên là ông đầu bếp tây sẽ chuyên lo về các món tây, còn ông đầu bếp ta thì chỉ chuyên lo về các món Á Đông rồi.

Một ngày nọ, có một ông khách vào đòi ăn món Cá Mú hấp xì dầu phủ sốt Mayonnaise

Ông chủ không biết đối với thực đơn này sẽ giao cho ai, anh đầu bếp tây thì cũng ko đc, mà anh đầu bếp ta cũng ko xong.

## Giải pháp
Anh phục vụ biết chuyện, mới bảo ông rằng, giờ kêu anh đầu bếp Á Đông hấp cá, rồi mang sang cho anh đầu bếp Âu đổ sốt vào, thế là xong

## Introduction
A Decorator Pattern says that just "attach a flexible additional responsibilities to an object dynamically".
The Decorator Pattern is also known as Wrapper
Trong lập trình, đôi khi ta gặp bài toán, muốn thêm hành vi hoặc trạng thái cho các đối tượng riêng lẻ tại run-time. Ta suy nghĩ tới tính kế thừa của OOP nhưng nó không khả thi vì nó là static và nó sẽ applied cho toàn bộ class.

Để giải quyết vấn đề này, ta sử dụng Decorate. Decorate đóng gói đối tượng ban đầu bên trong 1 abstract wrapper interface. Cả decorate Object và Cỏe Object đều kế thừa từ abstract interface này. Interface sử dụng recursive composition để cho phép 1 số lượng không giới hạn các layer có thể được add vào 1 core object.

Ngoài ra, ta có thể tham khảo 1 ví dụ chính xác với decorate, đó là cây thông noel. Ta có thể trang trí nó bởi các hộp quà, cái chuông, những bóng đèn led hoặc mấy cái tất để đảm bảo cho mùa noel vui vẻ.

## Implements
Dưới đây là các bước cần thiết trong quá trình phân tích trước khi tiến hành applied pattern này.

Đảm bảo bối cảnh 1 Single-core (hoặc non-optional) Component và 1 số optional embellishemnt hoặc wrappers,, và 1 interface chung cho tất cả.
Tạo 1 interface chung nhất để cho phép các class có thể hoán đổi cho nhau.
Tạo 1 second level base class (DECORATE) để support các Optional WRAPPER class.
Core class và Decorate class kế thừa từ interface chung trên kia.
Decorate class khai báo 1 composition relationship (HAS A) với interface kia, và các thành viên dữ liệu này được khởi tạo trong constructor của nó.
Decorate class ủy quyền cho abstract interface kia.
Define 1 Decorate Derived class cho mỗi optional embllisment
Decorate Derived class thực hiện chức năng trình bao bọ của chungs, và ủy quyền cho Decorate Base Class.
Client Cấu hình loại và thứ tự của các đối tượng core và decorate.
Các bước triển khai nó bao gồm:

Component Interface - The interface or abstract class defining the methods that will be implemented.
Component Implementation - The basic implementation of the component interface
Decorator - Decorator class implements the component interface and it has a HAS-A relationship with the component interface. The component variable should be accessible to the child decorator classes, so we will make this variable protected.
Concrete Decorators - Extending the base decorator functionality and modifying the component behavior accordingly.
 
Một ví dụ nữa của Decorate Pattern đó là Directive trong Angular. Directive trong Angular là 1 taglib, mà ta có thể nhúng vào bất cứ đâu mà ta muốn. Khi element đó có 2 directive, nó sẽ chịu ảnh hưởng luôn của 2 thằng.

## Advantages & Disadvantages & Usage
### Advantages
Cung cấp một cách thức linh hoạt hơn so với kế thừa mặc định (static inheritance)

Tăng cường khả năng mở rộng của object bởi vì việc thay đổi được thực hiện bằng cách thêm các class mới hơn là update các class hiện tại.

Cho phép ta phát triển một loạt các chức năng của object từ các lớp có sẵn thay vì phải code toàn bộ các chức năng vào trong cùng một đối tượng. *

* Về mặt bản chất, Decorate cho phép class vừa có đặc điểm của cái này, vừa có đặc diểm của cái kia. Do đó, đây là điều quan trọng nhất trong số những ưu điểm của decorate. Điều này đồng nghĩa với việc, thay vì ta xây dựng 1 object với đầy đủ các method, thì ta có thể tách nó ra thành các object độc lập, nhắm vào từng chức năng cụ thể rồi gom nó lại thành 1 cục. Điều này đặc biệt hữu ích hơn nữa, khi các method đó đã được xây dựng trong các object đã có sẵn, ta có thể kế thừa nó, mà ko cần phải rewrite lại code.

### Disadvantages
Việc sử dụng decorate giúp ta có thể tạo các Class mới được extend từ các Class cũ thông qua 1 cơ chế linh hoạt hơn nhưng nó lại mang lại những rủi ro khi ta cần phải custom lại behavior của cái đó. Ta đều biết rằng, Decorate đưa các object kia thành 1 thành phần của nó, và từ đó mà behavior của nó có luôn những đặc điểm của thằng này lẫn thằng kia, nhưng đó cũng chính là vấn đề của đa kế thừa.

Chịu ảnh hưởng của quá nhiều object đói lúc khiến cho behavior của nó không còn đúng đắn nữa. Vì vậy ta cần xem xét kĩ lưỡng khi quyết định sử dụng decorate này. Hoặc khi sử dụng, thì các behavior của các Object mà nó sử dụng bên trong phải trở nên độc lập với nhau thì mới có thể tránh được điều này.

### Usage
Khi ta muốn tăng sự minh bạch và linh động và add thêm trách nhiệm - responsibility cho đối tượng mà không làm ảnh hưởng đến các đối tượng khác

Khi ta muốn thêm responsibility cho các dối tượng mà có thể thay dổi trong tương lai

Khi việc mở rộng function bằng việc sử dụng các subclass không thực tế, ví dụ như có quá nhiều sub-class được tạo để handle các trường hợp chẳng hạn.

### Important things
Adapter cung cấp 1 giao diện khác với chủ đề của nó, Proxy cung cấp 1 giao diện tương tự, trong khi đó Decorate lại cung cấp 1 giao diện nâng cao.

Adapter thay đổi object interface, Decorate nâng cao trách nhiệm của 1 đối tượng. Decorate minh bạch hơn cho khách hàng. Vì vậy, decorate hỡ trợ recursive composition, trong khi điều này là không thể đối với Adapter.

Composite và Decorate có cấu trúc tương tự nhau, phản ánh là cả 2 đều dựa vào Recursive Composition để tổ chức một open-ended number objects.

Một decorate có thể được xem như 1 Composite với chỉ 1 thành phần. Tuy nhiên, Decorate bổ sung thêm trách nhiệm cho đối tượng, và nó không dành cho việc thổng hợp các đối tượng.

Mục đích của decorate đó là bổ sung thêm trách nhiệm cho các đối tượng mà không phải thêm lớp (Subclass). Trong khi đó, Composite lại không phải là trang trí thêm/bổ sung mà là đại diện. Vì vậy, Composite và Decorate thường được cùng xem xét trong 1 vài trường hợp,

Composite có thể sử dụng Chain of Responsibility để cho phép các thành phần có thể truy cập các đối tượng toàn cầu thông qua parent của nó. Nó cũng có thể sử dụng Decorate để ghi đè các thuộc tính này lên từng phần của Composition.

Decorate và Proxy có mục đích khác nhau nhưng cấu trúc tương tự nhau. Cả 2 cung mô tả làm thế nào để cung cấp 1 mức độ giản tiếp cho 1 đối tượng khác, và việc triển khai giữu 1 tham chiếu đến 1 đối tượng mà họ chuyển tiếp yêu cầu.

Decorate cho phép ta có thể thay đổi skin của 1 đối tượng. Trong khi đó Strategy có thể cho ta thay đổi bản chất của 1 đối tượng.