# State Pattern
> **State** cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.

State Pattern là một trong những Pattern thuộc nhóm behavior. Nó cho phép một đối tượng thay đổi hành vi của nó khi trạng thái nội bộ của nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó.

Mẫu pattern này đề nghị rằng bạn nên tạo các lớp trạng thái có thể có của một đối tượng và trích xuất tất cả các hành vi cụ thể của trạng thái vào các class này.
Thay vì tự mình thực hiện tất cả các hành vi, đối tượng ban đầu, được gọi là "context", tham chiếu đến một trong các đối tượng trạng thái đại diện cho trạng thái hiện tại của nó và ủy thác tất cả các công việc liên quan đến trạng thái cho đối tượng đó.

Để chuyển từ trạng thái này sang trạng thái khác, bạn có thể thay thế đối tượng của trạng thái đang hoạt động bằng đối tượng khác đại diện cho trạng thái mới đó. Điều này chỉ có thể làm được nếu tất cả các lớp trạng thái implement từ cùng một interface, và đối tượng context giao tiếp với các trạng thái thông qua interface này.

Sự khác biệt giữa State và Stategy là các đối tượng trạng thái có thể biết được nhau và có thể chuyển từ trạng thái này sang trạng thái khác, trong khi hầu hết các algorithm không biết về nhau.

## Cấu trúc của State Pattern:
- Context: lưu trữ một biến dùng để tham chiếu đối một trong các đối tượng state cụ thể và ủy thác (delegate) tất cả các method cho đối tượng state này. Context giao tiếp với state thông qua interface state. Context sẽ có một method setter state để có thể pass một đối tượng state mới vào cho nó.
- State Interface: định nghĩa các method của state.
- Concrete States: implement các state cụ thể, bạn có thể tạo thêm lớp abstract để tránh trùng lắp code. Các class này có thể có một biến tham chiếu đến đối tượng context. Thông qua tham chiếu này, đối tượng state có để lấy các thông tin cần thiết từ context, cũng như chuyển sang state mới.
- Cả context và concrete state đều có thể thay đổi chuyển trạng thái cho context.

## Sử dụng State Pattern khi:
- Khi bạn có một đối tượng có cách thức hoạt động khác nhau phụ thuộc vào trạng thái hiện tại của nó, số lượng trạng thái rất lớn và thay đổi thường xuyên. Pattern này khuyên bạn tách các state ra thành các đối tượng độc lập. Bạn có thể thêm mới hoặc thay đổi các đối tượng state với nhau, giúp giảm thời gian maintenance.
- Khi bạn có một đối tượng có nhiều điều kiện làm thay đổi cách hoạt động của đối tượng đó. State pattern cho phép bạn chuyển các điều kiện đó thành các phương thức của các class state tương ứng. Điều này giúp cho code của bạn sạch hơn, dễ maintenance hơn.
- Khi bạn có nhiều code trùng lặp trên các trạng thái, và các trạng thái chuyển đổi liên tục với nhau.

## Cách implement:
* B1: Quyết định một class làm đối tượng context. Nó có thể là class hiện tại đã có các code logic của các trạng thái.
* B2: Khai báo state interface. Interface này nên chứa các method cụ thể cửa tất cả các đối tượng state.
* B3: Định nghĩa các class state cụ thể, các class này implement từ interface ở bước 2. Có thể tạo abstract class để giảm thiểu duplicate code. Các class này nên chứa một đối tượng tham chiếu đến context. Lúc này bạn có thể thấy rằng đôi lúc state phải lấy dữ liệu từ context. Chứng ta có thể tạo các public method hoặc field trong context, hoặc sử dụng nesting classes.
* B4: Trong context class, thêm 1 field tham chiếu đến state interface được tạo ở bước 2. Ngoài ra tạo một class public setter state cho phép thay đổi giá trị state hiện tại của context.
* B5: Hoàn chỉnh logic trong các class state được tạo ở bước 3.
* B6: Để thay đổi state của context, bạn tạo một instance của state cần tạo, và pass nó vào context. Bạn có thể thực hiện điều này ở client, hoặc trong chính bản thân class state.

## Ưu điểm:
- Giúp chuyển trạng thái một cách rõ ràng.
- State độc lập.

## Nhược điểm:
- Phức tạp code.
- Khó debug, bởi bạn khó biết state hiện tại của context.