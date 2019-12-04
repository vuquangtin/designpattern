# Prototype Pattern - Creational Pattern
Xác định rõ loại đối tượng để tạo bằng cách sử dụng 1 Prototypical Instance, và tạo các đối tượng mới bằng việc copy prototype này.

Chọn lọc và sử dụng 1 Instance của 1 class như vai trò của 1 nhà tạo giống của tất cả các instance khác trong tương lai

Khi ta thấy việc sử dụng new operator là nguy hiểm/ có hại.

## Bài toán
Giờ nhà hàng góc phố đã trở nên quá nổi tiếng và đông khách. Tuy nhiên điều đó vẫn chưa đủ để thỏa mãn ông chủ. Ông ấy quyết định phải trở nên nổi tiếng hơn nữa.

Tìm hiểu trên mạng, ông biết một vài website về dịch vụ ăn uống. Nó sẽ thay ông cung cấp dịch vụ để khách hàng có thể đặt bàn, chọn thực đơn, và mọi thứ sẽ sẵn sàng khi họ đến nơi, chỉ ngồi mà chén thôi.

Vậy là, cứ vào 9h sáng, những người quản lý những website đó liên hệ với cửa hàng để xin thực đơn cho buổi trưa ngày hôm nay. Và giờ đây, anh phục vụ lại có thêm một công việc khác. Trả lời điện thoại.

Tuy nhiên, riết rồi anh cũng chán khi phải trả lời đi trả lời lại một bảng thông tin mà cách dây mấy phút thôi anh vừa mới thông báo cho một người khác.

## Giải pháp
Chán nản về công việc của mình, anh quyết định, cứ sáng vào anh soạn một tin nhắn tự động, trả lời các cuộc gọi đến. Và từ đó, anh thảnh thơi tán tỉnh cô phục vụ mới vào.

Cái tin nhắn trả lời tự động kia là một ví dụ cụ thể của Prototype.

## Introduction
Prototype Pattern says that cloning of an existing object instead of creating new one and can also be customized as per the requirement.
Prototype chỉ định loại đối tượng cần tạo bằng cách sử dụng 1 prototype instance. Prototype instance của các product, thường được chế tạo trước khi sản xuất đầy đủ.

Trong hầu hết các Creational Pattern, ta luôn xem xét về việc sử dụng từ khóa new khi muốn khởi tạo đối tượng. Hầu hết những trường hợp này, new operator không phải là 1 lựa chọn đúng đắn vì việc lặp code -> vì quá trình khởi tạo quá rườm raf và vì ta muốn tiếp kiệm tài nguyên hệ thống.

Prototype cũng vậy, nó được xây dựng dựa trên việc hạn chế từ khóa new, và cung cấp 1 đối tượng mới từ 1 Instance đã có sẵn.

Trong Pattern này, ta khai báo 1 abstract base class chỉ định 1 clone method và duy trì 1 từ điển của các clonable của các concrete derived base class. Bất cứ class nào cần 1 poymorrphic constructor capability thì cần phải derived cái clone method ở abstract class, đăng kí prototype instance của nó và implement clone operator.

Sau đó, thay vì sử dụng toán tử new, client sẽ gọi method clone này trên abstract base class, cung cấp 1 chuỗi string hoặc kiểu dữ liệu liệt kê chỉ định lớp dẫn xuất cụ thể mà nó muốn.

## Implements
Việc implement tuân thủ các nguyên tâc sau:

Thêm 1 method clone vào product hierachy hiện tại.
Tạo 1 Registry để maintain ccache prototypical objects. Register có thể được đóng gói trong 1 Factory Class, hoặc trong 1 base class của Product Hierarchy.
Thiết kế 1 factory method với các param cần thiết ddeer có thể tìm chính xác prototype objects, sau đó, gọi method clone trên prototype đó, và trả lại result.
Client thay thế toàn bộ new operator bằng cách gọi factory method kia.
Nó cung cấp một cơ chế để sao chép original object thành một new object, và có thể sửa đổi nó - nếu cần.

Prototype sử dụng java cloning để copy object.


Về Cloning trong Java ta có 2 cơ chế, Shadow Clone và Deep Clone. Mỗi cái này có 1 mục đích sử dụng riêng. Cần xem để quyết định lựa chọn cái nào cho đúng.

### Shadow Clone and Deep Clone
Nói nôm na thì shadow clone nó chỉ sao chép địa chỉ của các thuộc tính bên trong đối tượng. Khi có 1 update thực hiện, thì state của cái nguyên bản cũng bị thay đổi theo.

Deep Clone dùng cơ chế khác, nó sẽ new ra từng địa chỉ, và khi đó các Clone object nó độc lập với nhau, khi thay đổi cái này ko ảnh hưởng đến cái kia

### Java Clone là deep Copy.

Những lưu ý, clone có thể dùng để copy 1 object, hoặc cũng được dùng để copy nhiều object khác nhau. Cái này tùy thuộc vào việc ta implement nó như thế nào.

Đôi khi clone object nó sẽ ko phải chính xác 100% của prototype object, nó có thể thay đổi để phù hợp vào bài toán.

Nếu chỉ clone 1 object thì nó sẽ không có quá nhiều thứ để bàn, ở đây ta cần xây dựng 1 list các sản phẩm, và xem nó là 1 factory prototype. Vì điều này mà nó được sử dụng cho mục đích caching.

## Advantages & Disadvantages

### Advantages
Dễ thấy nhất, đó là giúp giảm nhu cầu phân lớp. Tại sao nói vậy, giả sử ta có 1 đối tượng, ta muốn tạo 1 đối tượng khác nhưng có những đặc điểm khác biệt, thì ta cần phải tạo thêm 1 class khác. Nhưng với cái này thì điều đó là ko cần thiết. Tiết kiệm class sẽ làm code dễ đọc hơn.

Che dấu sự phức tạp của việc khởi tạo object

Client có thể nhận được new Class mà không cần biết kiểu class cụ thể.

Tạo và remove class tại run-time. Kêu thế này nhưng thực ra cũng ko phải, cũng là class đó chỉ có điều thay đổi các properties của nó khác với lúc đầu thôi.

### Disadvantages
Nhược điểm của nó đó là cần lựa chọn đúng phương án Clone vì nếu làm không cẩn thận, thì sự thay đổi status của Object này cũng kéo theo sự thay đổi của Clonning của nó.

## Usage
Khi ta đã có 1 Class được khởi tạo từ trước

Khi chi phí để khởi tạo 1 đối tượng là quá cao và ta muốn reduce nó.

Khi ta muốn hạn chế số lượng Class trong Application.

Khi muốn che dấu việc khởi tạo đối với Client.

## Important things
Abstract Factory có thể sử dụng 1 set các Prototype để sao chép và trả lại các product object. Abstract Factory, Builder và Prototype có thể sử dụng Singleton trong quá trình triển khai.

Abstract Factory thường được triển khai cùng với các Factory nhưng chúng cũng có thể được thực hiện bằng các prototype.

Factory Method : creation thông qua thừa kế, Prototype : creation thông qua ủy quyền.

Thông thường ta đều start bằng Factory Method, sau đó phát triển theo Abstract Factory, Prototype và Builder.

Prototype không yêu cầu subclassing, nhưng nó yêu cầu thao tác initialization operation. Trong khi đó, Factory Method sử dụng subclassing nhưng không cần initialization. Đây là 2 điểm khác biệt rõ ràng nhất giữa 2 pattern này. Prototype luôn cần 1 object có sẵn, nhưng Factory Method thì ko.

Thường Composite và Decorate pattern thường sử dụng Prototype nhằm cải thiện hiệu năng. Bản chất của Composite là 1 list các object có liên quan, Decorate cũng tương tự như vậy.

Prototype rất hữu ích khi việc khởi tạo đối tượng rất tốn chi phí và ta có thể dự đoán trước một vài biến thể trên các tham số khởi tạo. Trong bối cảnh này, Prototype có thể tránh được việc creation from scratch và support cheap cloning của 1 pre-initialization prototype.

Prototype là pattern duy nhất trong creational pattern mà không require class. Nó chỉ require 1 object prototype mà thôi.