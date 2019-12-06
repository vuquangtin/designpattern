# Behavioral Pattern

## Observer
 _Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo và cập nhật một cách tự động._

## Iterator
 _Cung cấp một cách để truy xuất các thành phần của một đối tượng hợp nhất một cách tuần tự mà không cho thấy sự biểu diễn representation bên dưới của nó_

## Command
 _Đóng gói một yêu cầu request như một đối tượng, bằng cách đó cho phép bạn tham số hóa các client với các request khác nhau, các queue và log request, và hỗ trợ các hoạt động (operation) có thể “undo”._

## Strategy
 _Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng._

## Chain of responsibility 
 _Tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1 đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu theo chuỗi đó cho đến khi có đối tượng xử lý nó._

## Interpreter
 _Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể, cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong ngôn ngữ._

## Mediator
 _Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi sự tương tác của chúng 1 cách độc lập._

## Memento
 _Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái này sau đó._

## State
 _Cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó._

## Template method
 _Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. mẫu tm cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà không phải thay đổi cấu trúc thuật toán._

## Visitor
 _Biểu diễn 1 hoạt động (thao tác, thuật toán) được thực hiện trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1 phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác._