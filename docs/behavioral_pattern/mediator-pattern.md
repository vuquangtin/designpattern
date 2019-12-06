# Mediator Pattern - Behavioral Pattern
Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.

Design an intermediary to decouple many peers.

Promote the many-to-many relationships between interacting peers to "full object status".

## Bài toán
Cửa hàng góc phố là một ví dụ điển hình của mô hình này.

Một ngày nọ, thấy anh phục vụ cũ cứ mãi tán gái và ham chơi, nên ông quyết định đuổi việc anh ta ngay sáng hôm đó.

Vì đuổi gấp nên ko có ai để khách gọi order, vì vậy ông chủ quyết định dán ngay trước cửa hàng dòng chữ, Tự liên hệ đầu bếp để được phục vụ.

Và vậy là những người khách cứ chạy loạn xạ ngầu lên, vào bếp để order, làm xong anh đầu bếp cũng lủi thủi mang ra, mà chả biết phải mang ra cho bàn nào.

## Giải pháp
Rõ ràng, vị trí của anh giúp việc trong cửa hàng là ko thể thiếu.

Mặc dù anh ta lười biếng, nhưng anh ta có vai trò quan trọng trong việc điều phối các yêu cầu của khách hàng đến bộ phận thích hợp cũng như điều phối các yêu cầu của đầu bếp đến khách hàng cần thiết.

Nhận ra điều này, ông chủ phải tự đi xin lỗi, gọi điện và mong anh quay lại giúp cửa hàng.

Anh phục vụ trong mô hình này là Mediator, và khu vực sảnh và khu vực bếp, đó là 2 khu vực tách biệt trong hệ thống.

Tất nhiên là một câu chuyện giả tưởng thôi, chứ quán mà ko có phục vụ thì sao đc. Nhưng cái ví dụ này thường xuất hiện rất nhiều trong những hệ thống lập trình vì thiếu khâu phân tích ngay từ ban đầu.

## Introduction
to define an object that encapsulates how a set of objects interact
Mục đích của mediator đó là xác đinh 1 đói tượng đóng gói một tập hợp các tương tác của nhiều đối tượng. Khái niệm này nghe có vẻ mơ hồ và khó hiểu, vì vậy ta sẽ đi vào ví dụ sau, để hiểu rõ hơn bản thân nó.

Ban đầu lúc ta phát triển phần mềm, ta xây dựng vài class và các interactive giữa các class đó để thu được những kết quả muong muốn. Nhưng dần dần, logic ngày càng trở nên phức tạp khi số lượng function/feature tăng lên. Sau đó, ta bắt buộc phải thêm vào nhiều class, nhiều interact method. Code vẫn chạy, các class vẫn có thể tương tác với nhau. Nhưng sẽ khó để có thể bảo trì và mở rộng nó.

Mediator ra đời để giải quyết vấn đề này.

Mục đích của Mediator đó là giảm độ phức tạp giữa việc giao tiếp của nhiều object hoặc class.Pattern này cung cấp một lớp trung gian có khả năng xử lý các giap tiếp giữa các lớp khác nhau, và hồ trợ khả năng bảo trì nhờ việc tách các class một cách lỏng lẻo. Điều này không những giảm sự phụ thuộc (bằng cách không cho các object liên lạc với nhau trực tiếp ), mà nó còn cho phép ta thay đổi tương tác giữa các Object 1 cách độc lập với nhau.

ĐIều này cũng giưps nó biến các mối quan hệ many-to-many giữa các interacting peers thành "full-object-status"

Một ví dụ dễ hiểu hơn của Mediator đó là control tower của sân bay. Các pilot muốn hạ cacsnh/ cất cánh đều phải thông qua tháp điều khiển chứ ko liên hệ với các phi công khác. Việc có thể cất cánh/hạ cánh được quy định bởi tháp điều khiển. Điều quan trọng trong mô hình này, đó là tòa tháp không kiểm soát việc bay của từng phi cơ, nó chỉ tồn tại để thực thi các ràng buộc trong terminal area mà thôi.

## Implements
Việc phân vùng system thành nhiều đối tượng thường giúp tăng tính reuse nhưng việc tăng mối liên hệ/liên kết/ giao tiếp giữa các đối tượng sẽ làm giảm tính reused lại. Vì vậy Mediator ra đời đóng vai trò như một đối tượng trung gian, đóng gói tất cả các kết nối và là trung tâm giao tiếp. Đồng thời nó chịu trách nhiệm kiểm soát và điều phối các tương tác của client, thúc đẩy loose coupling bằng các giữa cho các đối tượng ko liên hệ/liên kết/giao tiếp với nhau một cách cụ thể/rõ ràng.

Do đó, Mediator thúc đẩy/biến đổi một hệ thống "many to many" thành 1 "full object status". Mô hình hóa các inter-relationship giữa các object với một đối tượng giúp tăng khả năng đóng gói và cho phép hành vi của các mối quan hệ đó được sửa đổi và mở rộng thông qua các sub-class.

Điều này thể hiện như thế nào? Giả sử ta có 1 chức năng liên quan tới object A và object B thuộc 2 class khác nhau. Về cơ bản ta sẽ xây dựng 1 method để từ A tương tác sang B hoặc ngược lại. Đối với Mediator thì ta ko làm thế. Thay vào đó, ta xác định 1 Object có vai trò Mediator và nó có 1 method trong đó nhận vào 2 tham số là object A và object B. Nếu như A và B thay đổi, thông qua việc extend hoặc đại loại, ta sẽ chỉ cần mở rộng/extend cái method đó ra thành 1 method mới để support trường hợp sau mà thôi.

Vì vậy, trong mô hình này, các Colleagues sẽ khoogn được kết hợp với nhau. Toàn bộ chúng giao tiếp thông qua mediator. Các mối quan hệ many-to-many sẽ được gỡ bỏ và thay thế bằng "full-object-status" và được gián tiếp lưu trữ ở 1 vị trí trung gian.

Từ những lý do trên, khi implement pattern này ta cần chú ý các điểm sau:

Xác định một tập hợp các Object sẽ có lợi khi tách rời lẫn nhau.
Đòng gọi tất cả những tương tác đó trong 1 Abstraction của new Class.
Tạo 1 thể hiện của lớp đó và sửa đổi để các đối tượng trên kia sẽ chỉ tương tác với Mediator.
Cân bằng nguyên tắc tách rời (principle of decoupling) với nguyên tắc phấn phối trách nhiệm đồng đều (principle of distributing)

Tránh tạo ra các đối tượng Controller/ God object.
Hiểu nôm na thì

Đầu tiên là ta phải tách thành 2 Zone độc lập rồi.

Sau đó thì xây dựng một Mediator để liên kết 2 cái đó. Tùy vào điều kiện mà ta sẽ xây dựng Mediator theo những mục đích khác nhau. Ví dụ dưới đây chỉ minh họa cho cái đó thôi

## Advantages & Disadvantages
### Advantages
Uu điểm đầu tiên cần kể đến của Mediator đó là nó khiến cho các decouple các Object. Điều này vô cùng rõ ràng khi tất cả các Object chỉ tương tác với Mediator chứ ko tương tác với nhau. Do đó, nó chỉ có duy nhất 1 mối liên hệ với Mediator mà thôi.

Chính điều trên khiến cho ta có thể đơn giản hóa các giao thức giữa các đối tượng, đồng thơi cũng đưa việc control các object một cách tập trung, vào từng Object với nhiệm vụ của riêng nó.

Khi các mối quan hệ trở nên lỏng lẻo, chức năng bị cô lập và giới hạn, thì rõ ràng việc quản lý các đối tượng này trở nên dễ dàng hơn nhiều vì lúc này ta ko cần phải pass các message cross objects.

Đồng thời, những đối tượng này không bao hàm các logic bên trong (vi dụ như check available check valid này nọ) nên ta chỉ cần tập trung cho việc communication của chúng. Về các logic đó, ta sẽ tập trung cho Mediator cho đầy đủ và chính xác hơn.

### Disadvantages
Rõ ràng ta thấy, có một vài action cơ bản, mà bỏ cai mediator vào, nó phức tạp hẳn, chạy lòng vòng. Nên đối với những cái design pattern này, chỉ đc áp dụng khi thực sự hiểu và thực sự cần, nếu ko, nó ko những ko mang lại lợi ích, mà còn khiến hệ thống trở nên rắc rối hơn.

## Usage
Trước hết, đó là message-based system. Chat application/message broadcast là một ví dụ.

Ngoài ra ta nên sử dụng nó trong những tình huống mà ở đó có nhiều Object communicate một cách phức tạp với nhau. Khi này ta sẽ cần sử dụng Mediator để làm đơn giản quá trình này (well-defined ways).

## Important thing
Trong Design Pattern, ta thấy CoR, Command, Mediator và Observer đều giải quyết vấn đề tách rời giữa người gửi và người nhân nhưng với các sự đánh đổi khác nhau. Trong CoR, requesst được chuyển từ người gửi tới 1 chuỗi các người nhận. Trong khi đó, Command chỉ định kết nối người gửi với người nhận thông qua 1 subclass. Mediator có người gửi và người nhận tham chiếu giấn tiếp lẫn nhau. Observer định nghĩa một giao diện tách rời cho phép nhiều receiver có thể được cấu hình trong run-time.

Mediator và Observer là những pattern cạnh tranh. Sự khác biệt giữa chúng là Observer phân phối các communication thông qua "observer" và "subject" trong khi mediator lại đóng gói giao tiếp giữa các đối tượng khác nhau. Do đó, việc sử dụng Observer có vẻ như dễ dàng hơn nhiều so với Mediator.

Mặt khác, Mediator có thể sử dụng Observer để tận dụng các colleagues có liên kết với nó.

Mediator và Facade có những nét tương tự nhau. Nó trừu tượng hóa chức năng của các lớp hiện có. Nếu Mediatr tóm tắt/tập trung giao tiếp giữa các object, nó thường thêm các "value"/newConnect/newMethod và được biết đến/tham chiếu bởi các colague object. ( giao thức đa chiều).

Trái ngược lại, Facade định nghĩa một giao diện đơn giản cho 1 sub-class. Nó không thêm chức năng mới và nó không được biết đến bởi các lớp con. Nó chỉ là 1 giao thức đơn hướng, trong đó, nó make request của các lớp con nhưng ko phải là ngược lại.

## Summary
Tóm lại, trong mô hình này, thay vì liên lạc trực tiếp với nhau thì nó sẽ thông qua một thằng trung gian.

Thằng trung gian này đóng vai trò điều phối, gửi thông tin từ bên này sang bên kia và ngược lại.

Có những điểm cần chú ý khi sủ dụng cái này bao gồm:

Mediator pattern is useful when the communication logic between objects is complex, we can have a central point of communication that takes care of communication logic.
Java Message Service (JMS) uses Mediator pattern along with Observer pattern to allow applications to subscribe and publish data to other applications.
We should not use mediator pattern just to achieve lose-coupling because if the number of mediators will grow, then it will become hard to maintain them.