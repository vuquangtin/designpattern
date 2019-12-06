# Strategy Pattern - Structural Pattern
Xác định 1 họ/family các thuật toán, gói chúng lại và khiến cho chúng có thể hoán đổi cho nhau. Strategy Pattern cho phép thuật toán thay đổi độc lập với các clients sử dụng nó.

Nắm bắt được sự trừu tượng trong 1 giao diện, giấu chi tiết thực hiện trong các lớp dẫn xuất.

## Bài toán
Cửa hàng giờ đã mở rộng hơn, vì vậy khách hàng cũng đông hơn.

Hiện giờ ông chủ đã cho phép đặt bàn từ trước, nhưng lâu lâu lại có những khách hàng bùng kèo, làm cho ông chủ tức tối lắm. Vì vậy, ông quyết định sẽ bắt họ phải thanh toán một khoản nhỏ cho việc đặt chỗ, nhằm tránh các khách hàng thiếu trách nhiệm.

Tuy nhiên, cửa hàng hiện tại chỉ có mỗi quầy thu ngân tiền mặt làm nhiệm vụ thu tiền, mà khách hàng muốn đặt chỗ chả nhẽ lại phải mất công ra cửa hàng thanh toán.

## Giải pháp
Ngày hôm sau ông ra ngân hàng mở thẻ, cho phép khách hàng từ xa chuyển khoản.

Ông cũng đăng kí luôn cái quẹt thẻ, giờ khách hàng chỉ cần đến và roẹt cái là xong.

Vậy là bây giờ, sau khi ăn xong, khách hàng có thể lựa chọn, thanh toán bằng tiền mặt, chuyển khoản hay quẹt thẻ.

Rõ ràng ông chủ không biết trước khách hàng sẽ chọn hình thức thanh toán nào, tuy nhiên, với 3 option trên mọi vấn đề sẽ được giải quyết. Tuy nhiên, tùy vào từng option mà các hình thức làm việc sẽ khác nhau, ví dụ chuyển khoản thì cần thông tin tài khoản của cửa hàng, còn quẹt thẻ lại cần thông tin của khách hàng.

Việc ông chủ cung cấp 3 option cho khách hàng lựa chọn được gọi là Strategy Pattern.

## Introduction
defines a family of functionality, encapsulate each one, and make them interchangeable
The Strategy Pattern is also known as Policy
Khi ta tìm hiểu về OOP, ta đều biết O là đại diện của Open Closed, một trong số những nguyên lý vô cùng quan trọng mà ta cần phải tuân thủ.

Trong mô hình này, Stragegy đóng gói các chi tiết giao diện trong 1 lớp cơ sở, và che dấu việc thực hiện trong các lớp dẫn xuất. Để sử dụng, khách hàng có thẻ kết hợp với 1 giao diện và không phải trải qua biến động của việc thay đổi: không ảnh hưởng khi số lượng lớp dẫn xuất thay đổi và không ảnh hưởng khi việc triển khai thay đổi.

Nhìn ở phương diện của việc development, 1 phần mềm tốt là 1 phần mềm trong đó sự gắn kết được hạn chế tối đa và giảm thiểu khớp nối. Mô hình này là tất cả về việc giảm thiểu các khớp nối. Trong mô hình này, khách hàng chỉ ghép nối với 1 sự trừu tượng, và không hề nhận thức về sự trừu tượng đó cũng như không biết chi tiết bên trong nó. Đây là nguyên tắc gọi là tối thiểu khớp nối, minimize coupling.

Ngoài ra ta còn có 1 cụm từ cũng thường được sử dụng để minh họa cho điều này, Program to an interface, not an implementation.

## Implements
Dưới đây là các nguyên tắc khi implement cái Template Pattern này:

Xác định 1 thuật toán/behavior mà client muốn truy cập thông qua 1 flex point
Định nghĩa 1 signature cho thuật toán đó bằng 1 interface
Che dấu/đóng gói việc implement thuật toán này trong 1 derived class
Client tự kết nối tới inteface này trong quá trình run-time

## Advantages & Disadvantages
### Advantages
Nó cung cấp 1 sự thay thế cho các Subclass

Nó định nghĩa mỗi hành vi trong 1 class riêng biệt, điều này loại bỏ sự cần thiết cho các if-else condition.

Mở rộng dễ dàng hơn, việc kết hợp với các behavior mới mà không làm thay đổi ứng dụng

### Disadvantages
Vài dòng code, không đáng kể.

## Usage
Trước hết, khi ta cần có nhiều class cùng thực hiện 1 chức năng. Việc tách biệt nó rõ ràng giúp ta dễ quản lý và bổ sung nếu muốn

Thứ 2, đó là khi ta cần các biến thể khác của một thuật toán.

## Important things
Strategy giống như Template method ngoại trừ độ chi tiết của nó. Đối với template thì độ chi tiết của nó ở object, còn đối với trategy độ chi tiết nó ở mức method.

State giống với Strategy ở mục đích của nó. Chúng đều có giống nhau ở việc thay đổi ngữ cảnh của ứng dụng -> behavior thay đổi theo. Trong Strategy, việc này thể hiện qua việc client tự xác định strategy của mình.

Nếu như Strategy cho phép ta thay đổi bản chất của 1 Object, thì Decorate cho phép ta thay đổi lớp vỏ bên ngoài của nó.

Strategy, State, Bridge, và đôi khi cả Adapter có một cấu trúc giải pháp tương tự. Nó chỉ khác nhau ở mục đích sử dụng mà thôi.

Strategy có 2 cách implementation. Cách đầu tiên giống như State. Nó khác nhau ở thời gian ràng buộc. nếu như Strategy là sự liên kết 1 lần, tại thời điểm client xác định chọn strategy nào, trong khi đó State năng động hơn. Việc đổi state của 1 Object đổi toàn bộ hành vi của nó.

Strategy còn được sử dụng trong Flyweight để làm nó tốt hơn. Flyweight tách các phần chung và phần riêng ra, cố gắng sử dụng lại các phần riêng đó. Và Strategy có thể đóng góp trong quá trình này. Cách sử dụng thì tùy trường hợp.