# Observer Design Pattern - Behavioral Pattern
Bản chất của Observer - người quan sát : đó là nó sẽ ghi nhận sự thay đổi của 1 object nào đó, và thông báo cho các object khác.

Cái này thường gặp nhiều, thường thì là tình huống, khi một object thay đổi, nó kéo theo các object khác thay đổi theo. Redux của facebook sử dụng chính là cái pattern này.

## Bài toán
Quay lại nhà hàng cuối phố.

Mỗi ngày nhân viên phục vụ lại nhận order của khách hàng, sau đó mang vào bếp đưa cho các anh đầu bếp.

Sau đó, cứ một khoảng thời gian, anh lại chạy vào, tìm xem có đầu bếp nào đã hoàn thành món ăn và mang ra cho khách hàng.

Tuy nhiên, anh phục vụ cũng lười nên lâu lâu mới vào kiểm tra một lần. Vì vậy đôi khi khiến cho khách hàng ko hài lòng vì đợi lâu.

Điều này khiến ông chủ không hài lòng, ông quyết định phải sửa đổi lại cách làm việc.

## Giải pháp
Sau một thời gian suy xét, ông chủ quyết định như sau:

Chia khu vực nội bộ làm hai, khu vực bếp và khu vực phục vụ.

Mỗi ngày, người phục vụ sẽ đưa các order vào một xấp giấy và chồng trước bếp, một anh phụ bếp sẽ lấy nó, phân chia cho các đầu bếp. Sau đó khi đầu bếp nấu xong, họ để qua một bên, và người phụ bếp này lại đi thu thập và mang ra khu dịch vụ để.

Sau đó, anh ta thông báo cho các nhân viên phục vụ để họ có thể biết, và quay vào quầy lấy và mang ra cho khách hàng.

Anh phụ bếp trong tình huống này là Observer.

Khi có một sự thay đổi (món ăn đã sẵn sàng) thì Observer sẽ notify lên cho các object đang listen nó biết. Khách hàng là người ko cần biết, ông chủ là người không cần biết, chỉ có anh phục vụ là cần biết thôi.

## Introduction
just define a one-to-one dependency so that when one object changes state, all its dependents are notified and updated automatically
Observe xác định một phụ thuộc one-to-many giữa nhiều object khác nhau. Khi trang thái của 1 đối tượng bị thay đổi, tất cả các object phụ thuộc vào nó cần được thông báo và cập nhật tự đông.

Chính điều này cho phép ta có thể đóng gói các Core ((common/engune) components vào 1 Subject Abstraction và các variable Component trong hệ thống Observe.

Trong mô hình này, đầu tiên ta cần define 1 object đóng vai trò là 1 "keeper" data modal/ business logic (SUBJECT).

Tiếp theo đó, ta cần ủy quyền cho các Object liên quan (Observer) có thể "xem" cái status mà nó liên quan.

Các Observer tự đăng kí với SUBJECT của nó khi nó được tạo. Và bất cứ lúc nào SUBJECT thay đổi, nó sẽ phát ra 1 thông báo tới các Observer của nó biết rằng nó đã thay đổi và mỗi Observer tự truy vấn tới SUBJECT, kiểm tra lại trạng thái và tiến hành các hoạt động mà nó chịu trách nhiệm liên quan.

Chính điều này cho phép ta có thể cấu hình các Observer 1 cách tự động tring quán trình run-time thay vì trong quá trình compile-time

Các PROTOCOL được miêu tả ở đây chủ yếu là các "pull" interaction Model. Thay vì SUBJECT phải "push" data thay đổi đến các OBSERVER, thì ở đây, mỗi OBSERVER có trách nhiệm "pull" các data của chủ thể mà nó quan tâm (window of view) từ SUBJECT. Push Model thỏa mãn tính reuse trong khi đó "push" Model kém hiệu quả hơn.

Cụ thế, mô hình "PUSH" được thể hiện như sau:

Ta có 1 SUBJECT, và 1 list các OBSERVER, Mỗi OBSERVER này cùng implement 1 phương thức, đó là updateState(newData).

Khi Subject thay đổi, ta for each list OBSERVER của SUBJECT, và lần lượt gọi các method observer.updateState(subject.getCurrentData()) để tiến hành thay đổi.

Rõ ràng Method này bị hạn chế, vì việc set cái interface observer.updateState với param mặc định khiến nó trở nên cứng nhắc hơn.

Khuyết điểm trên kia của nó, được thể hiện ở mô hình "PULL" ở dưới đây:

Cũng tương tự mô hình trên, nhưng thay vì cái updateState truyền vào 1 Data, ta lại dùng cho nó truyền vào 1 SUBJECt. Ta có thể thoải mái get các data của SUBJECT này và có thể lấy nó ra để import lại. Việc này sẽ khiến tính REUSE trở nên tốt hơn, khi việc quản lý behavior của Object trở nên linh hoạt hơn.

## Implements
Trước khi ta đi vào phần implement, ta nhìn qua về quá trình phân tích nó, bao gồm:

Phân biệt các core function (or independent) và optional function (or dependent)
Model cacs independence function với SUBJECT
Model các dependence function với hệ thống OBSERVER
SUBJECT được liên kết với các OBSERVER, theo 1 cách nào đó.
CLIENT tạo nhiều OBSERVER để test
OBSERVER register nó với SUBJECT
SUBJECT broadcast events cho toàn bộ các OBSERVER registered nó.
SUBJECT có thể "PUSH" thông tin của nó tới các OBSERVER hoặc các OBSERVER có thể "pull" thông tin họ cần từ SUBJECT.

## Advantages & Disadvantages
### Advantages
Ưu điểm đầu tiên của nó đó là giảm sự phụ thuộc giữa các OBJECTS và OBSERVER.

Cung cấp giải pháp cho các Broadcast-type comunication.

### Disadvantages
Nếu là trường hợp push, ta ko cần quan tâm, nhưng đối với trường hợp pull, việc nhiều Observer cùng tương tác trên một data có thể gây ra các lỗi lầm không đáng có. Điều lý tưởng đó là set cái state đó dưới dạng immutable để hạn chế Observer nào đó thay đổi data của nó, gây ảnh hưởng tới behavior của các Observer khác.

## Usage
Khi việc thay dổi state của 1 OBJECT có thể ảnh hưởng tới các OBJECTs khác mà cần giữ cho mối quan hệ của chúng trở nên lỏng lẻo

## Important Things
Như ta thấy, Chain of Responsibility, Command, Mediator và Observer được sử dụng để giải quyết các mà ta có thể tách rời SENDER và RECEIVER nhưng với sự đánh đổi khác nhau. CoR gửi cái message của SENDER tới một CHAIN OF POTENTIAL RECEIVER. Command thì khác, nó chỉ định SENDER-RECEIVER với 1 SUBCLASS, trong khi đó, MEDIATOR có SENDER và RECEIVER tham chiếu tới nhau 1 cách gián tiếp.

Đối với Observer thì khác, nó định nghĩa 1 inteface cho phép MULTIPLE RECEIVER có thể được cấu hình trong quá trình run-time. Đây chính là sự khác biệt giữa nó và các mô hình trên.

Mediator và Observer là các competing pattern. Sự khác iệt giữa chúng, đó là Observer phân phối các giao tiếp bằng cách giưới thiệu các OBSERVER object và SUBJECT object, trong khi Mediator object đóng gói giao tiếp giữa các object. Vì vậy, việc tái sử dụng của Observer là tốt hơn so với Mediator. Thử nghĩ mà xem, bạn có 1 list các Object khi thêm 1 Object vào, ta cân quan tâm lại business của list các Object đã tồn tại trước kia, nhưng điều đó là ko cần thiết đối với Observer, vì đơn giản nó tách biệt nhau.

Ngoài ra, ta có thể sử dụng Observer cho các Object register với Mediator. Lưu ý ở điểm này, Mediator chỉ điều phối, khi nhận được những request từ các Object kia. Giả sử ta có 1 cái sân bay, có n máy bay chờ hạ cánh, tức là có N object gửi yêu cầu, thì lúc này, sau khi ta chờ 1 máy bay hạ cánh xong, ta có thể dùng Observer để gửi tín hiệu tới cho những máy bay còn lại, thằng nào phản hồi đầu tiên thì ta cho thằng đó hạ cánh ở lần tiếp theo.