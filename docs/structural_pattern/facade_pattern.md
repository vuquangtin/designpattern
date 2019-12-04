# Facade Pattern - Structural Pattern

Cung cấp 1 giao diện hợp nhất cho 1 tập các giao diện trong 1 hệ thống con. Facade định nghĩa 1 giao diện cao cấp hơn giúp subsystem dễ sử dụng hơn..

Bao bọc 1 hệ thống con phức tạp với 1 giao diện đơn giản hơn.

## Bài toán
Ta cùng quay lại cửa hàng góc phố nhé :)

Cửa hàng ngày càng đông, nhân viên thì ko đủ. Nhưng mà ông chủ keo, nên quyết định sẽ thay đổi phương pháp phục vụ.

Từ giờ, khách hàng vào cửa hàng, tự xem thực đơn, tự order món, tự đưa cho anh phục vụ.

Anh phục vụ chỉ việc ngồi một chỗ, nhận Order, rồi đưa cho đầu bếp.

Còn khách hàng thì lại tiếp tục ngồi chờ để tự nhận món ăn, tự bưng ra, tự chủ động thanh toán tiền.

Ông chủ nghĩ rằng việc này sẽ không phải tốn thêm nhân sự nữa, thế là lại tiết kiệm một đống tiền.

Tuy nhiên, mọi thứ ko như ông nghĩ. Chỉ ngày đầu áp dụng, cửa hàng ông đã rối tung rối mù lên. Những khách hàng quen thì không sao, nhưng những khách mới vào thì bỡ ngỡ, chả biết đi đâu để gọi đồ, cũng chả biết khi nào đến lượt mình, cũng chả biết nhận món ăn từ đâu. Mọi thứ cứ thế rối tung rối mù lên

## Giải pháp
Rõ ràng là quyết định của ông chủ là một quyết định sai lầm. Quy trình quá phức tạp khiến cho mọi thứ rối tung lên.

Và ông chủ nhận ra rằng, vị trí của anh giúp việc là vô cùng quan trọng. Vì vậy, ổng cũng chịu cúi đầu tuyển thêm một anh nữa vào làm.

Thế là từ giờ, cửa hàng có thêm một anh phục vụ. Hai anh tự phân công công việc cho nhau, một anh thì lo việc order và tính tiền, một anh thì chịu trách nhiệm đưa order đến tay ông đầu bếp, rồi chờ mang món ăn ra cho khách hàng.

Trong ví dụ này, thì 2 anh giúp việc, chính là 2 Facade.

Trong lập trình cũng vậy, có đôi khi ta có những method mà quá trình xử lý nó quá phức tạp. Nó là tập hợp của nhiều method con và nó có thể xảy ra ở bất cứ đâu trong hệ thống.

Thay vì để nó rải rác như vậy, ta sẽ gom nó lại làm một, và chỉ cung cấp một interface để client có thể tương tác với hệ thống thông qua nó. Đó là ý nghĩa của Facade Pattern

Nhìn một khía cạnh khác, Facade cũng tương tự như Factory, chỉ khác ở chỗ, Factory che dấu việc khởi tạo Object, còn Facade che dấu các method bên trong nó hoạt động ntn.

## Introduction
A Facade Pattern says that just "just provide a unified and simplified interface to a set of interfaces in a subsystem, therefore it hides the complexities of the subsystem from the client".
Facade thảo luận về việc đóng gói 1 hệ thống con phức tạp trong 1 đối tượng inteface duy nhất. Điều này làm giảm các "đường cong học tập" - nói nôm na là hiểu về các method bên trong cũng như bản chất của sub-system, để tận dụng thành công subsystem này.

Ngoài ra nó cũng thúc đẩy việc tách rời 1 subsystem từ nhiều client của nó. Ví dụ trong Sadlier, nó có thể có ClassLink. Renassance, thì để tương thích với cái hệ thống hiện tại, ta cần tạo cho nó 1 subsystem. Nhưng rõ ràng với mỗi client thì các implement nó khác nhau, dù cái interface giữa 2 bên là giống nhau. Do đó, dùng Facade dể có thể phân biệt rạch ròi giữa 2 client này, tránh chồng chéo

Vì Facade là điểm truy cập duy nhất cho hệ thống con, nên ta có thể giới hạn lại các tính năng và tính linh hoạt mà client có thể cần.

Khi sử dụng Facade, ta cần biến nó thành 1 người ủng hộ/ người hỗ trợ đơn giản. Tránh không biến nó thành god object, hoặc 1 nhà tiên tri biết tuốt.

Về bản chất, Facade là 1 Factory của Interface. Nhìn chung thì Facade cũng giống như Abstract Factory, chỉ khác ở chỗ Abstract Factory cung cấp Factory của Object, thì Facade cung cấp Factory của Interface mà thôi.

Facade đóng gói một sub-system phức tạp vào trong 1 interface. Điều này làm giảm sự phức tạp của ứng dụng và có thể tách rời các sub-system từ nhiều client khác nhau. Mặt khác, nếu như Facade là điểm truy cập của các sub-system, thì nó sẽ hạn chế các feature và cũng như sự linh hoạt mà các power user có thể cần.

Một ví dụ nữa của Facade đó là dịch vụ chăm sóc khách hàng qua điện thoại. Người ta có thể có các nhu cầu cần tư vấn hoặc giải đáp về đặt hàng, thanh toán, và giao nhận, nhưng rõ ràng chỉ cần 1 cổng thông tin chăm sóc khách hàng là đủ.

## Implements
Việc implement cần được phân tích theo các bước sau:

Xác định 1 giao diện đơn giản, thống nhất cho hệ thống con hoặc thành phần.
Thiết kế 1 lớp "Wrapper" để bao bọc subsystem.
Facade/Wrapper nắm bắt sự phức tạp và hợp tác giữa các component, và ủy thác cho các phương thức thích hợp.
Client chỉ sử dụng/được ghép nối với Facade.
Xem xét nơi mà cần thiết sử dụng Facade

## Advantages & Disadvantages
### Advantages
Bảo vệ client khỏi sự phức tạp của sub-system components.

Tạo nên sự lỏng lẻo giữa client và các sub-system của nó

### Disadvantages
Việc xác định các interface và gom nó lại là điều cần xem xét kĩ lưỡng. Ta sử dụng Facade để tạo thành các access points chứ không phải là gom lại toàn bộ và trở thành 1 god-object.

## Usage
Khi ta muốn cung cấp một inteface đơn giản cho một complex sub-system

Khi có quá nhiều sự phụ thuộc tồn tại giữa client và các implementation class/ abstract class.

## Summary
Facade có nhiệm vụ thay vì để các interface một cách riêng lẻ, thì Facade nhóm nó lại trong 1 inteface lớn hơn, và dùng nó như 1 access point cho các sub-system components.

Khi sử dụng facade, ta cần chú ý tới việc nhóm các interface như thế nào, tránh trường hợp gom nó lại thành 1 god-class.

## Important things
Trong phần này, ta cùng discuss để nhận thấy sự khác biệt giữa Facade và các Design Pattern khác.

Đối với Adapter, Facade define một inteface mới, trong khi Adapter sử dụng lại inteface cũ. Mục đích của Adapter đó là làm cho 2 interface hiện có (1 cái cũ, 1 cái mới) hoạt động cùng nhau thay vì xác định một interface hoàn toàn mới.

Flyweight chỉ ra cách tạo ra nhiều đối tượng nhỏ, trong khi Facade chỉ ra cách tạo ra 1 đối tượng "lớn", đại diện cho toàn bộ sub-system.

Mediator cũng tương tự như Facade ở chỗ nó trừu tượng hóa chức năng của các lớp hiện có. Mediator thường xuyên thêm các object khác vào cái hiện có để mở rộng sub-system, trong khi Facade không làm điều này.

Abstract Factory cũng có thể được sử dụng thay thế cho Facade để che dấu các Class đặc biệt của platform. Các Facade Object nàyu thường là các singleton vì chỉ cần 1 Facade object.

Adapter và Facade đều là wrapper. nhưng mà nó lại khác nhau ở loại wrap. Mục đích của Facade là tạo 1 interface đơn giản hơn trong khi Adapter là thiết kế/ sửa đổi 1 giao diện hiện có. Facade wrap nhiều object lại làm 1, trong khi đo, Adapter chỉ wrap 1 object mà thôi.