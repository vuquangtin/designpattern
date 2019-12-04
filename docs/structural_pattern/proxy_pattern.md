# Proxy Pattern - Structural Pattern
Bản chất của Proxy đó là nó xây dựng một object, mang tính đại diện cho một đối tượng nào đó để thực thi công việc.

* Proxy được sử dụng cho 3 mục đích: 1. Virtual Proxy, Protected Proxy, Remove Proxy.
* Tuy nhiên, thông thường ta sử dụng proxy khi ta muốn quản lý/ hạn chế quyền truy cập vào một chức năng nào đó.

## Bài toán
Hôm nay ta tạm thời rời xa cửa hàng góc phố, để sang văn phòng luật sư đối diện.

Văn phòng luật sư đối diện đang có một khách hàng. Đó là một người phụ nữ. Cô ấy có một cuộc sống không hạnh phúc và quyết định ly hôn chồng.

Tuy nhiên, cô lại không hiểu rõ về luật pháp, không biết các thủ tục, cũng ko biết làm thế nào để có thể giành quyền nuôi con.

## Giải pháp
Vì vậy, cô đến văn phòng này, nhờ một luật sư đứng ra làm người đại diện để bảo vệ quyền lợi của mình.

Luật sư trong bài viết, đó là Proxy.

Proxy được dịch ra là Ủy quyền. Ủy quyền ở đây tức là ủy thác cho một người, làm người đại diện, thay mặt mình để thực hiện các công việc đặc biệt. Ở đây, người phụ nữ kia ủy quyền cho ông luật sư giải quyết tranh chấp, bởi thân chủ không đủ khả năng hiểu biết pháp luật để bảo về cho mình.

Trong lập trình cũng vậy. Nhiều khi vì một vấn đề nào đó, ta cần phải sử dụng một người Ủy quyền để thực hiện những công việc đặc biệt. Ví dụ như truy cập vào các tài nguyên giới hạn, hay tương tự như thế.

## Introduction
"provides the control for accessing the original object"
Proxy pattern is also known as Surrogate or Placeholder.
Đúng như cái tên của nó, Proxy là 1 Object đại điện cho một object khác.

Mục đích của Proxy cũng như tên gọi của nó, bảo vệ các đối tượng bên trong khỏi thế giới bên ngoài.

Ta sẽ không quá quan tâm vào định nghĩa, mà cùng đi vào chi tiết các thể hiện của nó để hiểu chính xác hơn những nhiệm vụ mà Proxy sẽ đảm nhiệm.

Virtual Proxy
Virtual Proxy được dùng trong môi trường mà có quá nhiều object truy cập đến hệ thống. Thay vì mỗi object mình cho nó một cái Session thì giờ đây, ta sử dụng các Proxy để làm điều đó. Mỗi Proxy đại diện cho một nhóm group để giải quyết công việc.

Bản chất của cái này là xây dựng một Proxy Pool. Mỗi request tới nó sẽ được sắp xếp để đưa vào các proxy cho phù hợp. Vì vậy, ta có thể tiết kiệm tài nguyên và chi phí.

Ví dụ như làm một trang tin tức phục vụ 100.000 lượt truy cập chẳng hạn.

Protected Proxy
Protected cần kiểm tra quyền hạn của Client trước khi thực hiện công việc. Giả sử như Client là admin khi đó họ có quyền thấy những chức năng khác của hệ thống. Nhưng nếu nó chỉ là một user bt thì nó sẽ chỉ thấy được những thứ đơn giản.

Protected Proxy được sử dụng khi ta muốn hạn chế quyền truy cập, hay là muốn xảy ra những sự cố không đáng có vì vượt quyền hạn.

Ví dụ như bạn ra cây ATM rút tiền, bạn gửi request rút tiền. ATM đóng vai trò như một Proxy, thực hiện giao dịch của bạn với ngân hàng và sau đó sẽ trả lại tiền cho bạn.

Nếu không có ATM, bạn sẽ phải chạy tới và làm việc trực tiếp với cô thu ngân. Cô thu ngân này sẽ lại vào kiểm tra hệ thống, vào gặp thủ quỹ lấy tiền và đưa bạn.

Nếu như ko có cả 2 cô trên, bạn tự vào nhà bank, tự mở tủ, tự lấy tiền, tự cập nhật tài khoản, và nghe thế thôi đã rất nguy hiểm rồi phải ko.

Remote Proxy
Remote Proxy có nhiệm vụ nhận request và chuyển đổi nó tới những Proxy khác, sau đó nhận kết quả và phản hồi lại cho Client.

Remote Proxy được sử dụng khi ta có 2 hệ thống communicate với nhau, và một trong 2 thằng đó hạn chế/ giới hạn các đối tác của nó.

Hoặc cũng có thể sử dụng để giảm tải/ cân bằng tải cho hệ thống lớn. Trong đó, các Proxy con đóng vai trò như các nhà phân phối, vừa xử lý request, vừa gửi nó đến những Proxy phù hợp khác. Xem ví dụ dưới đây để hiểu thêm.

Ví dụ của nó như là một trang web bán vé máy bay. Proxy nhận request của khách hàng, format nó lại và gửi tới một Proxy khác của Airline chẳng hạn.

Sau đó Airline này xử lý request, trả về phản hồi cho Proxy này. Proxy này lại gửi trả lại cho khách hàng.

Smart Proxy
Mục đích của Smart Proxy đó là cung cấp các lớp bảo mật bổ sung bằng các can thiệp vào các hành động cụ thế khỉ đối tượng được truy cập.

Các hình thức sử dụng điển hình:

Đếm số lượng tham chiếu đến đối tượng thực thể đó, để quyết định giải phóng tự động khi không còn tham chiếu. Cách thức này còn được gọi là Smart Pointer / Smart Reference Proxy
Loading 1 đối tượng lên memory khi nó được tham chiếu lần đầu. Điều này sẽ giúp tiết kiệm chi phí vì sử dụng nó như một cache vậy. Cái này chính là Cache Proxy ở dưới.
Kiểm tra xem đối tượng có bị lock trước khi truy cập để đảm bảo rằng không có đối tượng nào có thể tham chiếu đến nó. Cái này hữu ích trong môi trường Multiple thread, ta muốn đảm bảo rằng 1 action xảy ra sẽ không bị can thiệp bởi 1 action khác.
Monitor Proxy
Thiết lập các bảo mật trên đối tượng cần bảo vệ. ngăn không cho client truy cập tới một số trường quan trọng của đối tượng. Ngoài ra, nó còn có thể theo dõi, giám sát, ghi log việc truy cập, sử dụng đối tượng.

Firewall Proxy
Bảo vệ đối tượng khỏi các truy cập không tính nhiệm. Thông thường, firewall sẽ đi kèm với remote proxy, làm thành 1 bức tường để đảm bảo xác thực rằng truy cập là được phép.

Cache Proxy
Cache Proxy dùng để cung cấp không gian lưu trữ tạm thời cho các kế quả trả về của 1 đối tượng nào đó. Kết quả này sẽ được tái sử dụng cho các Client chia sẻ cùng 1 yêu cầu gửi đến. Về mặt bản chất thì cái này hơi hơi giống với flyweight.

Nó khác với Virtual Proxy ở điểm, virtual Proxy tạo ra 1 đối tượng trung gian để truy cập, còn nó là sử dụng để cache. Hai mục đích hoàn toàn khác nhau nhé.
Implements

Việc implement nó có lẽ ko có gì quá phức tạp nên ta không đi vào chi tiết, thay vào đó, ta sẽ phân tích vào 3 mục đích chính mà nó được sử dụng như sau:

## Advantages & Disadvantages
Advantages
Tùy thuộc vào từng loại proxy mà ta có những ưu điểm mà nó mang lại. Ví dụ

Visual Proxy cung cấp cách thức để truy cập vào các đối tượng public của hệ thống thông qua một proxy pool nhằm tiết kiệm tài nguyên

Protected Proxy cung cấp cơ chế bảo mật nhằm đảm bảo tính an toàn của hệ thống.

Remote Proxy cung cấp cách thức giao tiếp với các hệ thống khác để đạt được mục đích.

Smart Proxy cung cấp thêm các lớp bảo mật bổ sung bằng cách can thiệp vào các hành dộng cụ thể khi đối tượng được truy cập.

Disadvantages
__________

## Usage
Khi ta cần bảo vệ quyền truy cập vào 1 object nào đó.

Khi ta cần xây dựng 1 hệ thống lazy load để cải thiện hiệu năng

## Summary
Proxy có nhiệm vụ cung cấp 1 người đại diện hoặc 1 người giữ chỗ vcho 1 đối tượng để quản lý quyền truy cập vào đối tượng đó.

Sử dụng một mức độ bổ sung để hỗ trợ truy cập phân tán, kiểm soát thông minh

Sử dụng Wrapper và delegation (ủy quyền) để bảo về cấc thành phần khỏi những sự phức tạp không đáng có.

Phân biệt Proxy Pattern với các Pattern khác:

Đối với Proxy Pattern, cách thức của nó là tạo thành 1 lớp bảo vệ. Lớp bảo vệ này thường sẽ wrapper lại command của Object và quyết định sẽ xử lý nó như thế nào.

Trong khi đó, Adapter là việc xây dựng 1 Interface để tương thích với 1 Interface đã có. Về mặt mục đích là hoàn toàn khác nhau.

Decorate và Proxy cũng khác nhau về mặt mục đích, nhưng chúng có thể có 1 điểm chung ở vấn đề thiết kế, vì cùng sử dụng Wrapper.