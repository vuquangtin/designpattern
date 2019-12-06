# Visitor Pattern - Behavioral Pattern
Đại diện cho 1 hoạt động được thực hiện dựa trên các yếu tố của cấu trúc đối tượng. Visitor cho phép ta xác định một operation mới mà không thay đổi các lớp có liên quan/phụ thuộc vào tới hoạt động đó.

Thực hiện đúng mục đích trên ít nhất 2 loại đối tượng khác nhau.

Double Dispatch

## Bài toán
Cửa hàng bánh kem giờ đã mở rộng hơn. Bây giờ không phải chỉ làm bánh mang đi, mà h đã có riêng một đại sảnh, cho khách vào ngồi ăn bánh và uống cf nhâm nhi nữa.

Tuy nhiên, nước uống ko phải là thế mạnh của ông chủ, nên ông quyết định cùng hợp tác với bạn mình.

Thế nhưng, điều này gây khó cho cô thu ngân, khi cô không thể biết thông tin giá cả của 2 bên, nên mỗi lần tính tiền, thường chạy đi chạy lại rất mất thời gian.

## Giải pháp
Sau một thời gian xem xét, ông chủ quyết định kêu bạn ông mang theo 1 cô thu ngân sang nữa.

Bây giờ, với mỗi order, người phục vụ sẽ phân loại ra thành 2 loại, loại đồ ăn thì để cửa hàng xử lý, loại đồ uống thì mang cho cô kia tính.

Rõ ràng việc tính tiền là một nhiệm vụ, nhưng đối tượng mà nó xử lý lại không giống nhau.

Một bên là tính theo giá ghi trên menu, một bên lại phụ thuộc vào option của khách hàng, ví dụ gọi trà sữa thêm hạt trân châu này nọ, thì rõ ràng việc tính toán nó sẽ phụ thuộc vào yêu cầu của khách hàng, chứ ko phải là đã được xác định trước.

Vì vậy ta không thể xây dựng chung một phương thức tính tiền cho cả 2 được (vì bản chất nó khác nhau mà).

Trong lập trình cũng vậy, đôi lúc ta cần thao tác trên các nhóm Object khác nhau, nhưng việc thao tác đó (logic) lại phụ thuộc vào từng loại object. Thay vì việc xây dựng một method tổng quát, thì ta sẽ tách riêng nó ra để có thể làm hệ thống linh động hơn.

Đó chính là mục đích của visitor.

Bản chất của Visitor đó là việc overload toán tử, phụ thuộc vào từng tham số đầu vào mà điều chỉnh hành vi cho phù hợp.

## Introduction
Trong tình huống thực tế, ta thường gặp những trường hợp tương tự. Ta có nhiều hoạt động riêng biệt và không liên quna cần phải thực hiện trên các đối tượng trong 1 cấu trúc tổng hợp không đồng nhất.

Ta sử dụng Visitor để tránh cho code bị bẩn (polluting) và không cần phải truy vấn từng node và chuyển con trỏ đến đúng loại trước khi thực hiện thao tác mong muốn.

Mục đích chính của Visitor đó là một abstract function có thể áp dụng cho 1 hệ thống phân cấp các đối tựng. Cách tiếp cận này khuyến khích việc sử dụng các Flyweight Element classes vì chức năng xử lý cần được loại bỏ khỏi danh sách trách nhiệm của chúng.

Những chức năng mới có thể dễ dàng thêm vào hệ thống phân cấp ban đầu bằng cách tạo ra 1 Visitor Subclass khác.

Trong đầu bài, ta đã nhắc tới khái niệm double dispatch. Visitor implement "double dispatch". Vậy double dispatch là gì?

Trong OOP, các object tương tác với nhau thông qua các message. Các OO Message này thường là các Single dispatch - operation này được thực hiện phụ thuộc vào 2 yếu tố, tên của request và kiểu người nhận.

Trong Double Dispatch, Operation được thực thi dụa vào tên của Yêu cầu và kiểu của TWO RECEIVER. TWO RECEIVER ở đây bao gồm kiểu của Visitor và kiểu của Element mà nó Visit. Vì vậy nó mới có tên là Double Dispatch.

## Implements
Việc implement được tiến hành như sau: Trong mô hình này, ta gom các dối tượng cần được hỗ trợ thành 1 nhóm, sử dụng 1 Element interface để gom nó lại. và sử dụng 1 Visitor, cũng là 1 abstract class để truy xuất qua từng loại đối tượng này. Từ đó, ta xác định 2 loại đối tượng trong mô hình này bao gồm:

Element và Concrete Subclass Element
Visitor và Concrete Subclass của Visitor.
Đầu tiên, ta tạo 1 Visitor class hierarchy. Visitor class này định nghĩa 1 pure virtual methods visit(). Mỗi method này nhận duy nhất là 1 argument, 1 pointer hoặc 1 tham chiếu đến 1 original Element Derived class
Mỗi Operation phải được mô hình hóa với 1 lớp dẫn xuất cụ thể của Visitor Hierarchy. Vì vậy, các method visit() được khai báo trong Visitor hierarchy giờ đây phải được implement trong các lớp dẫn xuất của nó. Lưu ý, method visit() này là pure virtual nên chắc chắn những thằng con phải implement nó.
Add 1 single pure method accept() cho Element base class. Tương tự với visit() trong Visitor, accept() của Element cũng chỉ chấp nhận 1 đối số duy nhất, là 1 pointer hoặc 1 tham chiếu đến Visitor class ở trên.
Lại tương tự như Visitor, mỗi Concreted subclass của Element hierarchy cũng cần implement accept() method bằng cách đơn giản là gọi lại visiter.visit() method ở trên kia, chuyển con trỏ này là đối số duy nhất.
Toàn bộ visitor và element đã được setup xong. Nếu client cần thực hiện 1 operation, nó sẽ tạo 1 instance của Visitor Oject, call accept() method trên mỗi Element object, và truyền vào đó là visitor Object.
Đầu tiên, ta khai báo 1 Abstract Class Element. Nó có 1 method là accept(). accept() này nhận đầu vào là 1 Visitor.
Ta tiếp tục khai báo các Derived subclass cho Element class ở trên. Nói là class nhưng nó cũng có thể là interface. Mỗi derived subclass này cần overwrite lại các method accept() ở trên cho hợp lý.
Tạo 1 Visitor abstract class. Visitor này có 1 list các abstract method visit. Mỗi method này nhận đầu vào là 1 pointer hoặc tham chiếu đến danh sách các derived subclass Element trên kia.
Tạo các Visitor Derived class implement từ Visitor interface kia ra. Mỗi concrete class này sẽ implement 1 list các abstract method visit trên kia.
Khi muốn thực hiện 1 operation nào đó, ta for each các element trên kia, và cho các element trên kia gọi method accept với đối số là các Concrete Derived Visitor mà ta đã tạo.
Trong mô hình này, ta dễ dàng thêm vào các operation hoặc tiện ích mới. Chỉ cần add new Visitor derived class. Nhưng nếu như subclass trong aggregate node hierarchy (Element hierarchy) không ổn định, việc giữ cho các lớp con của Visitor subclass đồng bộ, đòi hỏi phải kiểm soát chặt chẽ và nghiêm ngặt. Ta lưu ý, Visitor sử dụng double dispatch, nên nếu có 1 lớp con được bổ sung, Visitor cần add thêm các visit() method có liên quan.

Một ứng dụng nữa của Visitor đó là biểu thị cho việc phân rã chức năng, tách các thuật toán khỏi cấu trúc dữ liệu. Trong operation rõ ràng thuật toán được implement trong Concrete subclass của Visitor, nó tách biệt hoàn toàn với Element. Do đó, ta có thể gọi nó như vậy. Ngoài ra, nó còn biết đến với 1 mục đích khác, full object status behavior.

Tóm lại, ta có thể hiểu, mục đích của visitor đó là represent cho một hoạt động được thực hiện dựa trên các thành phần của cấu trúc đối tượng mà không thay đổi các class mà nó hoạt động,

Dưới đây là cách implement cụ thể

Đầu tiên, ta cần xác nhận hệ thống phân cấp hiện tại (Element hierarchy) là khá ổn định và các public interface của class này là đủ cho các Visitor class yêu cầu. Nếu 1 trong 2 không thỏa mãn, thì trong trường hợp này Visitor không phải là 1 lựa chọn đúng đắn. Lưu ý, Visitor sử dụng full object status, do đó, cần kiểm tra xem các operation của Visitor có thể dựa vào các public interface của class này để hoạt động được ko, và liệu Element Hierarchy này có ổn định hay ko.
Create Visitor Class base class với visit (Element x) method ứng với mỗi Element Delivery Type. (Do đó ta cần cấu trúc của Element này phải thật ổn định. Nếu nó có thay đổi, toàn bộ các Visitor có liên quan cần phải thay đổi.)
Add accept(Visitor v) method cho Element Hierarchy. Việc triển khai các method này trong các Derived Subclass của Element đều giống nhau, v.visit(this) Do là circle dependence nên việc khai báo các Element và Visitor subclass này phải được thực hiện xen kẽ, thêm cái Element nào thì phải bổ sung trên Visitor và update lại cho các Concreted subclass Visitor tương ứng.
Element hierarchy được ghép nối với Visitor base class, nhưng Visitor Hierarchy lại được couple với mỗi Element derived class. Nếu độ ổn định của Element Hierarchy là thấp và đô ổn định của hệ thống Visitor là cao, thì luc snafy ta cần xem xét việc hoán đổi vai trò của 2 thứ bậc. Nếu làm tốt điều này ta có thể giải quyết nhược điểm của nó đã được đề cập ở mục 1 và 2.
Create Visitor Derived class cho mỗi Operation, được thực hiện trên các đối tượng Element. visit() method implement dựa trên giao diện chung của Element public interface.
Client tạo các Visitor Object và chuyển từng đối tượng trong Element bằng method accept() của chính nó..

## Advantages & Disadvantages
### Advantages
dễ dàng bổ sung 1 hoạt động trên 1 list các object mà không làm thay đổi cấu trúc của các đối tượng đó.

### Disadvantages
Ban đầu, ta thấy nó rất ok, mọi thứ đều hoạt động tốt. Việc thêm các operator vào là cực kì dễ dàng, ta chỉ cần add các Concrete derived class và implement các operation bên trong chúng. Tuy nhiên, đó là đối với trường hợp thêm các Visitor, còn đối với các trường hợp thêm các Element thì sao. Có bao nhiêu Visitor, thì có bấy nhiêu method cần được tạo khi thêm 1 Element mới vào cấu trúc ban đầu. Do đó việc quản lý và đảm bảo cho chúng đồng bộ là yếu tố cần được xem xét.

## Usage
Trong nhiều trường hợp, ta muốn thực hiện 1 operation trên 1 list các đối tượng, hoặc tách algorithms ra khỏi cấu trúc dữ liệu của đối tượng để quản lý dễ dàng.

## Important things
Abstract Syntax tree của Interpreter là Composite. Vì vậy, ta có thể sử dụng Iterator và Visitor để thay thế cho Composit trong Interpretor pattern.

Iterator có thể đi qua 1 Composite. Visitor có thể apply 1 operation trên 1 composite.

Visitor Pattern giống như Command Pattern nhưng nó nhiều sức mạnh hơn vì Visitor có thể khởi tạo bất cứ thứ gì phù hợp với loại đối tượng mà nó gặp, trong khi Command thì chỉ 1/vài loại.

Visitor