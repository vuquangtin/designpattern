# Flyweight Pattern - Structural Pattern
Sử dụng việc chia sẻ để support một số lượng lớn thành các đối tượng nhỏ hơn

Thay thế các heavy-weight bằng các light-weight. Đây là lý do nó được gọi là flyweight.

## Bài toán
Ai cũng biết dãy số Fibonacci rồi phải không, công thức tổng quát của nó là n3 = n2 + n1. Và giờ ta cần tìm số Fibonacci thứ N chẳng hạn

Và ta sẽ sử dụng Flyweight để giải quyết bài toán đó, bằng cách sử dụng Flyweight.

Ta nhận ra rằng, để biết được kết quả của số F(n), ta cần biết kết quả của F(n - 1), F(n - 2). Để biết F(n - 1) ta lại cần biết F(n - 2), F(n - 3).

Rõ ràng giá trị của F(n - 2) được sử dụng ở trong phép tính F(n -1) và của bản thân nó. Do đó, nếu như ko có 1 cơ chế lưu trữ, ta lại phải mất thời gian để tính toán lại nó.

Vì vậy, ta xây dựng một hash map để lưu trữ các giá trị Fibonacci đã được tính, chỉ tính và thêm vào khi mà giá trị đó chưa có.

Ví dụ này chưa thật sự chuẩn xác đối với Flyweight. Mục đích của flyweight phức tạp hơn thế nhiều. Vì vậy ta cần xem xét lại nó.

Ví dụ ta sẽ có 1 chức năng chấm điểm, danh sách truyền vào của nó là các component. Mỗi component có 1 type khác nhau.

Giả sử ta cần grade 1 bài học với lesson A, điều gì ta sẽ cần làm. Hoặc ta find hết toàn bộ các Scoring Formula của cái này lên 1 lượt, chịu tốn chi phí cho các Component không xuất hiện trong Lesson, hoặc ta sẽ sử dụng Flyweight để chỉ cần load các Component cần thiết.

Nếu xài Flyweight, ta build 1 cái map chứa scoringFormular của nó. Cái này có 1 key là componentType. Đây là trạng thái ta dùng để nhận biết, phân biệt với mấy cái khác. Và ta cũng có 1 method score, với 2 params là correctAns và studentResponse.

Khi 1 Component chưa có trong Map, ta new 1 cái, push vào, và trả lại, nếu có rồi thì ta sẽ trả lại nó luôn. Đó là mục đích của Flyweight.

## Introduction
A Flyweight Pattern says that just "to reuse already existing similar kind of objects by storing them and create new object when no matching object is found".
Flyweight Pattern mô tả cách chia sẻ các đối tượng để chho phép sử dụng chúng bằng cách chia nhỏ thành các thành phần với chi phí thấp nhất. Mỗi flyweight sẽ được chia thành 2 phần, state-dependent (extrinsic) part, và state-independent (intrinsic).

Intrinsic state được lưu trữ/ chia sẻ trong các Flyweight Object, trong khi đó Extrinsic state được lưu trữ và tính toán bởi các client object và được chuyển tới các Flyweight khi các hoạt động của nó được gọi.

## Implements
Dưới đây là danh sách checklist cần phân tích trước khi tiến hành

* Đảm bảo rằng chi phí cho các đối tượng là 1 vấn đề đáng quan tâm, và client của class có thể và sẵn sàng tiếp thu trách nhiệm.
* Chia trạng thái của target class thành 2 phần, trạng thái có thể chia sẻ (instrinsis state) và trạng thái không thể chia sẻ (Extrinsic state)
* Remove các trạng thái không thể chia sẻ ra khỏi các thuôc tính của class và thêm nó vào danh sách đối số (tham số) của các phương thức bị ảnh hưởn
* Tạo 1 factory có thể lưu trữ và sử dụng lại các thể hiện của lớp hiện có.
* Client sử dụng Factory thay vì new operator để request các đối tượng.
* Client hoặc third party phải tra cứu và tính toán trạng thái không thể chia sẻ và cung cấp các trạng thái này dưới dạng các tham số đã liệt kê ở trên cho các method của class.
Bản chất của Flyweight đó là chia một cái lớn thành nhiều cái nhỏ, và tái sử dụng các cái nhỏ đó.

Vì vậy, nó thường được sử dụng trong môi trường mà ta cần xử lý nhiều thứ, trong đó kết quả của cái này có liên quan tới kết quả của 1 cái đã đc xử lý trước đó.

Hoặc cũng đơn thuần làm cache, lấy object lên khi nó ko tồn tại, hoặc trả ra ngay nếu nó tồn tại trong map

## Advantages & Disadvantages
### Advantages
Giảm số lượng của object

Giảm số lượng memory và storage khi object đã tồn tại

### Disadvantages
Flyweight là một Pattern mà cách thực hiện của nó khá phức tạp vì phải thay đổi nhiều. Do đó cần có 1 sự phân tích kĩ lưỡng trong việc chia tách các shareable state và non-shareable state khi áp dụng nó.

## Usage
Khi application sử dụng một số lượng lớn các object

Khi chi phí lưu trữ cao vì số lượng đối tượng quá lớn

Khi application không phụ thuộc vào danh tính đối tượng.

## Important things
Nếu Flyweight chỉ ra cách tạo nên các đối tượng nhỏ, thì Facade lại có ý nghĩa là tạo ra 1 đối tượng duy nhất đại diện cho toàn bộ subsystem.

Flyweight thường được kết hợp với Composite để thực hiện các nút lá có thể chia sẻ. Composite là 1 list các đối tượng, nên việc đối tượng có thể lặp lại nhiều lần là bình thường.

Các kí hiệu trong cây cú pháp trừu tượng của Interpretor có thể được chia sẻ bằng Flyweight.

Flyweight giải thích khi nào và làm thế nào để các đối tượng State có thể được chia sẻ.