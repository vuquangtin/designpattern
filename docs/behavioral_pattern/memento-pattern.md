# Memento Design Pattern - Behavioral Pattern
Bản chất của Memento đó là lưu trữ lại state của Object để có thể resume khi cần thiết.

Để làm được điều này, nó sử dụng một private inner class để lưu trữ thông tin object.

Memento được dùng khi ta có 1 list những action phức tạp và ta muốn lưu trữ các step của nó để có thể revert lại khi cần.

## Bài toán
Công việc của anh phục vụ đó là ghi các order của khách hàng. Tuy nhiên có những khách hàng rất kì cục, đang đọc giữa chừng thì đột nhiên lại thay đổi ý định. Điều này khiến cho cái ghi chép của anh trở thành công cốc, và anh lại phải xé đi để ghi lại tờ khác.

Anh ước rằng, có thể có 1 công cụ để mà giải quyết vấn đề đó

## Giải pháp
Vậy là anh nghĩ ra 1 cách. Thay vì viết 1 hàng liền tù tì các danh sách, thì giờ đây anh quyết định mỗi lúc khách hàng yêu cầu, anh lại thêm vào 1 dòng mới, nếu khách hàng cancel anh sẽ bỏ cái dòng đó đi. Cách này tuy ko giải quyết được triệt để vấn đề nhưng ít ra nó cũng khiến công việc của anh đỡ vất vảđi 1 chút.

Nếu là 1 người lập trình theo hướng OOP, ai cũng đều biết 4 thuộc tính cơ bản đó là tình trừu tượng (abstract), tính kế thừa (inheritance), tính đa hình (polymorphism), và tính đóng gói (encapsulation). Trong đó, tính đóng gói sẽ che dấu đi các state của đối tượng từ bên ngoài.

Trở lại với bài toàn này, khi ta muốn "revert" 1 object, tức là ta sẽ cần phải can thiệp vào state của nó, để revert lại trạng thái trước đó. Tuy nhiên, nếu ta can thiệp 1 cách thô bạo, thì ta đã vi phạm tính đóng gói của nó rồi.

Design này sẽ giải quyết vấn đề đó. Nó cho phép ta có thể revert lại 1 trạng thái trước đó mà vẫn tuân thủ tính đóng gói của OOP.

## Introduction
to restore the state of an object to its previous state
The Memento pattern is also known as Token.
Design này đảm bảo rằng tính bao đóng của OOP không bị vi phạm mà vẫn có thể "capture" và "externalize" các trạng thái bên trong của Object, cho phép ta có thể trả về trạng thái của đối tượng này trước đó.

Ta có thể xem nó như một cách để cung cấp 1 Checkpoint capability

Cung cấp khả năng undo/ roll back full object status.

## Implements
Trong pattern này, điều đầu tiên ta cần đó là 1 đói tượng cần được lưu trữ trạng thái của nó.

Khi có 1 client cần capture 1 trạng thái của đối tượng này (Originator), nó sẽ gửi 1 request đến Originator. Originator sẽ capture trạng thái của nó, khởi tạo 1 Mementor, save state của nó trong Memento đó và trả lại cho Client.

Client lúc này sẽ đóng vai trò như 1 Care Taker. Nó nhận các Memento của Originator, quản lý nó trong 1 array bên trong. Nếu cần để rollback lại 1 trạng thái bất kì nào đó mà nó đã lưu của Originator, nó sẽ trao lại Mementor cho Originator để có thể phục hồi..

Từ những điều trên, khi ta sử dụng Memento, ta cần xây dựng các đói tượng sau:

Originator - Object này cần "biết cách" để save lại bản thân nó cũng như khôi phục lại state của chính bản thân nó

CareTaker - Object biết cách why and when Originator cần save/ restore bản thân nó.

Memento - 1 hộp kín có thể được đọc/ghi bởi Orginator và dược quản lý bởi CareTaker.

Các bước implement như sau:

Xác định vai trò của care taker và Originator.
Tạo 1 Memento Class và khai báo Originator là 1 friend của nó
Care Taker cần biết khi nào cần "checkpoint" originator
Originator khởi tạo 1 Memento và copy trạng thái của nó sang Memento này
Care taker sẽ giữ cái Memento này như 1 checkpoint mà nó cần. Tuy nhiên nó sẽ ko thể nhìn thấy bên trong của Memento này được.
Care taker cần biết khi nào cần rollback originator
Originator tự rollback data của nó theo trạng thái bên trong của Memento.
Khái niệm friend ở đây có vẻ hơi không rõ ràng. Ta xem lại các access modifier. Friend là có thể nhìn thấy nhau. Đối với Java nó chính là các inner class miễn sao các method của nó không được truy cập từ bên ngoài để đảm bảo tính private cho Originator.

## Advantages & Disadvantages
### Advantages
Điều đầu tiên phải kể đến, đó là khả năng can thiệp vào internal state của object mà không vi phạm encapsulation.

Và nó khiến cho Originator trở nên đơn giản hơn

## Usage
Chính những tính chất trên mà nó thường được sử dụng cho các undo operation

Và ngoài ra nó cũng được sử dụng trong transaction.

## Summary
Command và Memento đóng vai trò là các magic token được truyền vào và gọi lại sau đó. Trong Command, token đại diện cho 1 request. Trong Memento, toker đại diện cho trạng thái bên trong của 1 Object tại 1 thời điểm cụ thể.

Polymorphism là điều quan trọng cần chú ý trong Command, nhưng không phải trong Memento bởi vì phạm vi của Memento rất hạn hẹp, hạn hẹp đến mức mà memento có thể được gửi đi như 1 giá trị (thay vì 1 object). Thứ mà memento hướng đến đó là đảm bảo encapsulation.

Command có thể sử dụng Memento để maintain trạng thái nhằm hỗ trợ cho Undo Operation

Memento thường được kết hợp với Iterator. Một Iterator sử dụng Memento để lưu lại trạng thái của 1 lần lặp. Nó lưu trừ Mementor ngay chính bên trong bản thân nó - thay thế cho CareTaker (Tức là thằng này vừa là Originator, vừa là CareTaker luôn).