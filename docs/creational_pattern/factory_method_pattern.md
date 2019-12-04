# Factory Method Pattern - Creational Pattern
Factory pattern che dấu hoàn toàn việc khởi tạo object, ta không thể sử dụng toán tử new để lấy được object mà ta muốn, thay vào đó, Factory sẽ cung cấp cho ta 1 interface để làm việc đó.

Factory Pattern được dùng trong trường hợp ta có một nhóm object, và muốn code trở nên thống nhất đồng thời che dấu đi việc khởi tạo của chúng. Client chỉ cần gọi interface với tham số mà ta cung cấp, và mọi thứ sẽ ok hết thôi.

Tóm lại, nó là một Factory - Nhà máy - và nhiệm vụ của nó là sản xuất object.

## Bài toán
Trong những lần trước, ta đã hiểu nhầm về Pattern này. Chính xác thì chưa hiểu đủ.

Tên của nó ko phải là Factory Pattern mà là Factory Method Pattern. Method ở đây để ghi chú rằng nó là 1 phương thức để cung cấp 1 Object, chứ đôi khi không cần phải xây dựng 1 Object riêng để handle điều đó. Việc tạo ra 1 đối tượng Factory đảm nhận việc đó cũng tốt, nhưng nên lưu ý, nó là Factory Method, nên chính hàm static của 1 Class nào đó cũng được hiểu là 1 thể hiện của Pattern này.

Đối với Design Pattern, ta cần phải ghi nhớ, nó là 1 mẫu thiết kế, 1 quy tắc. Do đó, ta ko cần dựa vào chính xác những step được mô tả, mà thay vì vậy, ta chỉ cần nắm rõ cách mà ngta phân tích nó và code dựa vào requirement đó, thay vì 1 cấu trúc cứng nhắc.

Ở nhà hàng nọ có 1 anh đầu bếp rất tài ba. Vì khả năng nấu nướng tuyệt vời của mình nên lúc nào cửa hàng của anh cũng đông khách. Anh luôn phải tất bật làm việc, từ đi chuẩn bị rau củ, đến rã đông cá cua, rồi băm chặt đủ thứ.

Cửa hàng ngày càng đông, sức anh ko làm được. Thế là một hôm, anh mới than phiền với ông chủ về điều này.

Và ông chủ hứa sẽ tuyển cho anh một trợ lý.

## Giải pháp
Trợ lý của anh chả biết gì về ẩm thực. Tất nhiên, tiền thuê đầu bếp lúc nào cũng rẻ hơn tiền thuê đứa rửa bát mà.

Và nhiệm vụ của nó là sẵn sàng cung cấp cho anh các loại thực phẩm mà anh cần. Anh chỉ việc yêu cầu và nó sẽ mang tới cho anh chỉ sau vài giây.

Từ đó, anh đầu bếp chỉ hí húi bên cái bếp lửa của mình và mọi việc còn lại đã có anh phụ bếp này lo.

Anh trợ lý / phụ bếp này chính là Factory.

Trong lập trình cũng vậy, có đôi khi ta có quá nhiều object, và ta muốn quản lý việc khai báo chúng, khi đó ta sử dụng Factory như một anh trợ lý, để cung cấp các object theo yêu cầu.

Nếu như cửa hàng mở rộng thêm, và ông chủ tuyển thêm một anh đầu bếp khác nữa, thì anh ta cũng chỉ cần quan tâm tới việc nấu nướng của mình, còn việc cung ứng nguyên liệu, vẫn là do anh phụ bếp này quản lý. Và khi anh ấy yêu cầu Trứng gà, thì chắc chắn anh ta ko mất thời gian để đi tìm nó giữa la liệt đống trứng ngỗng.

## Introduction
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but let the subclasses decide which class to instantiate.
The Factory Method Pattern is also known as Virtual Constructor.
Nhiệm vụ của Factory Method đó là khởi tạo các đối tượng, nó có chút tương đồng với Template Pattern, thực hiện 1 thuật toán.

Một Super class chỉ định cho toàn bộ các tiêu chuẩn và các hành đồng sau đó ủy thác việc khởi tạo này cho các Derived class.

Factory Method làm cho một thiết kế có thể tùy chỉnh nhiều hơn và chỉ phức tạp 1 chút. Các mẫu thiết kế khác thường yêu cầu khởi tạo 1 lớp mới, trong khi đó Factory Method lại chỉ yêu cầu thêm 1 thao tác mới.

Ta thường sử dụng Factory như 1 cách thức tiêu chuẩn để khởi tạo 1 đối tượng, tuy nhiên, trong những trường hợp này thì nó không cần thiết: Nếu lớp được khởi tạo không bao giờ bị thay đổi, hoặc việc khởi tạo chỉ diễn ra trong nhất thời và các lớp con có thể dễ dàng ghi đè nó.

Factory Method tương tự như Abstract Factory nhưng nó không chú trọng đến tính Family. Thay vào đó nó chú trọng tới Object.

Thường Factory Method được quy định bởi framework, và được implement bởi người dùng.

## Implements
Một định nghĩa phổ biến của Factory Method đó là một static method của 1 lcass trả về 1 đối tượng thuộc loại đó. Nhưnmg nó không giống như 1 Constructor. Đối tượng trả về có thể là một thể hiện của 1 lớp con.

Không giống như constructor, một đối tượng hiện có có thể được sử dụng lại, thay vì một đối tượng mới được tạo. Và một đặc điểm nữa, các Factory Method thường sẽ có những tên riêng biệt, thay vì 1 cái tên chung nhưu Constructor.

Factory Method định nghĩa một giao diện để tạo các đối tượng, nhưng cho phép các lớp con quyết định class nào sẽ được tạo.

Dưới đây là những điều cần thực hiện/phân tích trước khi implement

Nếu ta có 1 cấu trúc phân cấp ta cần xem xét xem có thể tạo 1 phương thức đa hình bằng cách khai báo 1 static class ngày trong lớp cơ sở.
Thiết kế các tham số cho Factory Method. Những đặc tính hoặc đặc điểm nào là cần thiết và đủ để để xác đính chính xác đối tượng nào cần khởi tạo.
Xem xét việc thiết kế một nhóm đối tượng(object pool) bên trong, cho phép các đối tượng được sử dụng lại thay vì được tạo từ đầu.
Xem xét việc che dấu các constructor kia bằng việc set private hoặc protected.
Ta lưu ý, mục đích của Factory Method đó là che dấu việc khởi tạo object và cung cấp 1 interface hỗ trợ điều đó. Nhưng nên nhớ, ta không cần thiết lúc nào cũng phải new 1 đối tượng mới hoàn toàn. Ta có thể kết hợp với Object Pool Pattern ở dưới kia để giảm thiểu chi phí cho việc khởi tạo đối tượng.

Trên nguyên tắc, Design Pattern chỉ là mẫu thiết kế. Ta sử dụng nó để tham khảo chứ không phải căn cứ vào nó để thiết kế. Vì vậy, việc phân tích kĩ lưỡng trước khi áp dụng sẽ giúp ta hạn chế/ giải quyết được các bài toán phát sinh sau này.

Nói thêm về việc che dấu constructor của Class.

Cách che dấu constructor của Class chỉ có thể thực hiện bằng cách khai báo private cho Constructor. Lúc này sẽ ko có bất cứ 1 Class nào có thể khởi tạo Class này bằng từ khóa new được cả.
Vậy làm sao để get được Object đó. Trong Object ta khai báo 1 method static, mà method này sẽ gọi tới cái private constructor kia. Khi này ta đã vô tình khiến cho việc create Object chỉ được thực hiện thông qua cái method static của ta.
Tiếp theo nữa ta tạo 1 Factory với cái tham số cần thiết, rồi dùng cái static method đó để khởi tạo Object dựa trên tham số đầu vào.

## Advantages & Disadvantages && Usage
### Advantages
Cho phép sub-class quyết định kiểu của Object cần được tạo

Tách constructor ra khỏi code, cho phép chỉ tương tác thông qua các Interface/ Abstract. Điều này cho phép reused lại code ở bất cứ đâu với những class implements/extends từ các Object đó.

Ưu điểm của Factory là dễ dàng thấy được. Nó che dấu đi logic khởi tạo của 1 đối tượng. Người dùng chỉ cần gọi thông qua 1 interface của Factory cung cấp mà thôi.

Mục đích của Factory là che dấu việc khởi tạo của các đối tượng và chỉ cung cấp 1 cách thức duy nhất thông qua Factory. Tuy nhiên nếu ta ko che dấu đi các constructor, hoặc bằng 1 cách nào đó mà có thể create Instance mà không thông qua Factory thì nguyên tắc này sẽ bị phá vỡ.

### Disadvantages
Việc khởi tạo các Object thông qua điều kiện của Tham số truyền vào trong factory nhiều khi không đủ. Với các object có việc khởi tạo phức tạp, ta cần thông qua Builder Pattern để đạt được điều này.

### Usage
Khi Class không biết những sub-class cần được khởi tạo

Khi ta muốn sub-class tự xác định/ chỉ định các đối tượng sẽ được tạo

Khi class parent quyết định nhường việc khởi tạo Object cho các Sub-Class của nó

## Important Things
Abstract Factory thường được triển khai với các Factory Method. nhưng chúng cũng có thể được thực hiện nhờ các Prototype

Factory Method thường được sử dụng trong Template Pattern.

Factoy Method tạo ra các Object thông qua tính thừa kế, trong khi đó, Prototype khởi tạo các Object thông qua sự ủy quyền.

Thông thường, các thiết kế sử dụng Factory lúc bắt đầu, vì nó ít phức tạp, dễ tùy biến, và dễ bổ sung các lớp con, nhưng nó sẽ phát triển theo hướng trừu tượng, bằng việc sử dụng Abstract Factory, Prototype hoặc Builder. Những Pattern này linh hoạt hơn và phức tạp hơn. Điều này được xác định bởi người thiết kế, xem ở đâu cần sự linh hoạt.

Prototype không yêu cầu Subclass, nhưng nó yêu cầu thao tác khởi tạo. Factory Method thì ngược lại, nó yêu cầu subclass nhưng lại không yêu cầu khởi tạo.

Ưu điểm của Factory Method đó là nó có thể trả về cùng 1 instame nhiều lần, hoặc có thẻ trả về 1 lớp con thay vì 1 đối tượng thuộc chính xác class đó.

Một vài Factory Method khuyến nghị rằng, để đảm bảo an toàn thì tất cả các constructor của đối tượng cần được bảo vệ.

từ khóa New được xem là yếu tôc có hại. Có một sự khác biết giữa việc request 1 đối tượng và khởi tạo 1 đối tượng mới. Toán tử new luôn tạo 1 đối tượng và không đóng gói việc tạo đối tương. Factory Method thực thi việc này và cho phép cung cấp 1 đối tượng được yêu cầu mà không cần ghép nối chặt chẽ với việc khởi tạo.