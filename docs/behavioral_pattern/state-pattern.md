# State Pattern - Behavioral Pattern
Bản chất của State đó là làm Object thay đổi hành vi dựa trên trạng thái (State) của nó.

## Bài toán
Vẫn là câu chuyện ở cửa hàng góc phố thôi.

Công việc của anh phục vụ là tiếp đón khách hàng, nhận order và đưa cho anh đầu bếp.

Nhưng đó là khoảng thời gian lúc trước, từ ngày anh quen cô thu ngân, ví anh rỗng nhanh đi trông thấy. Vậy là anh xin ông chủ được làm thêm để kiếm thêm tiền.

## Giải pháp
Ông chủ cũng thoải mái và dễ tính, vậy là cho anh luôn chức dọn dẹp sau mỗi ngày.

Vậy là bây giờ, từ 8 đến 20h anh là anh phục vụ, từ 20h đến 22h anh lại là anh dọn dẹp.

Việc anh phục vụ - một người nhưng thay đổi công việc vào 2 giai đoạn - 2 state khác nhau, đó là bản chất của State Pattern.

Anh phục vụ bàn và anh lao công, cũng đều là 1 người, nhưng chức trách và nhiệm vụ của anh tại 2 thời điểm là khác nhau.

Tương tự như vậy, State Pattern đc ra đời để giải quyết vấn đề đó. Trong Pattern này, ta tạo nên các Objects đại diện cho các trạng thái khác nhau, và 1 context Object có thể thay dổi hành vi phụ thuộc vào trạng thái hiện tại của nó.

## Introduction
the class behavior changes based on its state
The State Pattern is also known as Objects for States
Trong các Monolithic Object, các Behavior của nó đều được dựa trên state của nó, và hành vi đó sẽ thay đổi khi trạng thái của đối tượng thay đổi ngay trong quá trình run-time. Nó có thể là các state và sử dụng if else để handle việc thay đổi, hoặc nó cũng có thể là 1 context, mà tại đó, khi context của nó thay đổi, các behavior của nó cũng thay đổi theo.

Ưu điểm và nhược điểm của việc sử dụng Pattern này, ta sẽ cùng đi sâu ở phần dưới.

## Implements
State Pattern là 1 giải pháp cho vấn đề làm thế nào để thực hiện hành vi phụ thuộc vào trạng thái.

Trong trường hợp này, khi ta có 1 đối tượng, và ta muốn thay đổi các behavior của đối tượng này, phụ thuộc vào trạng thái của nó, ta có thể có 2 sự lựa chọn, if else để thay đổi behavior hoặc sử dụng context.

If else thì đơn giản rồi, nó dễ xài, dễ sử dụng. Tuy nhiên, nó gặp vấn đề. Nếu 1 trạng thái ảnh hưởng tới nhiều dối tượng, chả nhẽ ta phải đi viết từng cái if else cho nó. Rồi khi có 1 trạng thái khác bổ sung, ta cũng phải truy lại cái list các đối tượng đó để mà thay đổi sao/?

Điều này là ko hiệu quả và sẽ dẫn đến những rắc rối về sau. Do đó ta sử dụng trường hợp thứ 2, Context

Context là 1 ngữ cảnh, tại ngữ cảnh đó thì các đối tượng sẽ có hành vi nào đó liên quan. Cách implement như sau:

Xác định 1 context để trình bay cho 1 interface duy nhất ra bên ngoài
Xác định 1 State abstract base class
Thay vì if else, ta cần represent cho mỗi trạng thái khác nhau, các lớp dẫn xuất/extends cái State Abstract class trên kia.
Xác định hành vi cụ thể của các lớp dẫn xuất trên kia
Xác định 1 con trỏ chỉ tới cái State hiện tại.
Để thay đổi state của State Machine, ta thay đổi lại con trỏ hiện tại là được.
Ưu điểm của cái này, khi ta cần có 1 trạng thái mới, ta chỉ cần bổ sung 1 lớp mới extends từ cái State Abstract trên kia là được.

Nhược diểm của nó thì sao? Nó ko giải quyết được những bài toán cụ thể. Ví dụ ta muốn có 1 vài trường hợp, khi trạng thái A thì Object có behavior này (A1), khi trạng thái B thì nó ko có behavior này (A1) thay vào đó là 1 Behavior khác (B1). Nếu theo cách tiếp cận thứ 2, trong State abstract base class ta bắt buộc phải khai báo abstract cả 2 method A1, B1. Trong khi đó, rõ ràng ta ko cần implement A1 trong đối tượng thứ 2. Đây là 1 sự dư thừa và cần phải xem xét cẩn thận.

Dưới đây là các step để implement:

Xác định 1 lớp hiện tại hoặc là 1 lớp mới đống vai trò là STATE MACHINE. Ta có thể gọi nó là WRAPPER.
Tạo 1 STATE BASE CLASS sao chép lại các phương thức của State Machine Interface. Các method này cần truyền vào 1 WRAPPER CLASS, vì sao? Vì đây là cách ta sẽ thay đổi trạng thái của nó. Ngoài ra nó có thể định nghĩa các phương thức mặc định nếu muốn.
Từ STATE BASE CLASS đó, ta xây dựng 1 list các Object đại điện cho các trạng thái khác nhau của đối tượng. Nếu cần ta có thể override các phương thức hiện tại nếu muốn.
WRAPPER chứa bên trong 1 CURRENT STATE class.
Toàn bộ các yêu cầu từ client gửi đên wrapper class được ủy thác lại cho current State.
Các State method thay đổi CURRENT STATE trong WRAPPER CLASS cho phù hơp

## Advantages & Disadvantages
### Advantages
Trong một môi trường phức tạp, việc thay đổi behavior của đối tượng phụ thuộc vào trạng thái, nếu ko được quản lý 1 cách chặt chẽ, thì sẽ rất rắc rối và khó tránh khỏi những thiếu sót trong quá trình run-time

Nó giúp tách biệt giữa trạng thái và hành vi 1 cách minh bạch rõ ràng và độc lập với nhau

Việc bổ sung các trạng thái vào mô hình này cũng đơn giản.

### Disadvantages
Việc implement phức tạp, đòi hỏi cần phân tích đúng. Nếu đơn giản thì chỉ cần thay đổi trạng thái -> thay đổi các behavior thì đơn giản, nhưng từ behavior của object này lại tiếp tục thay đổi trạng thái của Machine thì đó là 1 điều cực kì khủng khiếp, đòi hỏi ta cần phải phân tích và kiểm tra cẩn thận.

## Usage
Khi hành vi của một đối tượng phụ thuộc vào trạng thái của nó mà nó cần có khả năng thay đổi hành vi khi trạng thái của nó thay đổi.

Khi ta có 1 đống operation lớn, các điều kiện phụ thuộc vào trạng thái của Object.

## Summary
Khi phân tích, State có 3 loại, loại thứ nhất phạm vi ảnh hưởng nhỏ, chỉ trong 1 Object, ta chỉ cần if else là được, loại thứ 2 liên quan tới 1 list các object, cần thay đổi behavior của các Object này khi trạng thái thay đổi, cái thứ 3 phức tạp hơn, các trạng thái có thể được thay thế ngay bên trong các behavior của từng Object. Cần phân tích kĩ khi áp dụng cái này.

Các STATE OBJECT (extends từ STATE abstract class) thường là các SINGLETONS.

Flyweight giải thích làm cách nào mà các State Objects có thể share với nhau. Đơn giản nó tách các phần chung thành 1 và chia các phần riêng thành các tham số và quy định các function truyền vào.

State còn có thể được sử dụng trong Intepreter để parsing context.

Strategies có 2 cách implementation, cách dầu tiên tương tự với State. Sự khác biệt giữa 2 Pattern này trong cách này đó là số ràng buộc. Trong Strategies sử dụng 1 liên kết, trong khi đó State thì linh hoạt hơn.

Cấu trúc của State và Bridge giống nhau. Bride chấp nhận 1 hệ thống phân cấp các Evelope class trong khi đó State chỉ cho phép 1. Hai Patterns này sử dụng cùng 1 cấu trúc đề giải quyết các vấn đề khác nhau. State cho phép hành vi của 1 đối tượng thay đổi với trạng thái của nso, trong khi đó Bridge tách rời sự trừu tượng khỏi việc thực hiện để 2 bên có thể thay đổi 1 cách độc lập.

Việc implement State được xây dựng trên mô hình Strategy Pattern. Sự khác biệt giữa State State và Strategy đó là sự ổn định. Với Strategy, sự lựa chọn Algorithms thường ổn định hơn. Trong khi đó, với State Pattern nó bị phụ thuộc vào trạng thái của context.