# Design Pattern Overview
Design pattern - mẫu thiết kế là một sự implement của OOP. Nó ra đời để giải quyết những bài toán trong khi làm về hướng đối tượng bằng những cách thức tối ưu.

Những pattern này của nó đã được phân tích cũng như kiểm định do đó, vấn đề còn lại là phải hiểu về các design pattern này, cách nó implement và bài toán nào nên áp dụng nó.

Những ưu/nhược điểm của Design Pattern
Design pattern là những mấu thiết kế được sử dụng để giải quyết các bài toán đặc biệt trong lập trình hướng đối tượng. Nó đã đã được kiểm tra và phân tích tính đúng đắn rồi nên việc còn lại của ta chỉ là sử dụng đúng pattern cho từng vấn đề mà thôi, ko cần kiểm tra lại, đồng thời tránh khỏi các nhược điểm nếu phân tích và thiết kế sai.

Giống như bootstrap, nó là 1 template, vì vậy nó quen thuộc và dễ hiểu đối với các developer đã từng tìm hiểu qua cái này.

Nhược điểm của nó chính là phải hiểu về bản chất của nó, sử dụng đúng thì mới mang lại hiệu quả.

Có những trường hợp áp dụng nó vào là 1 cách thức chính xác, nhưng cũng có những trường hợp áp dụng nó lại khiến cho hệ thống trở nên cồng kềnh, rắc rối và khó hiểu. Đây cũng là mục đích chính của section nà, phân tích các Design pattern, tìm ra những ưu điểm, nhược điểm, và khi nào thì nên áp dụng nó.

Class Diagram
Trước khi cùng tìm hiểu vào các Design Pattern, trước hết ta cần tìm hiểu về Class Diagram. Hiểu được Diagram này mới hiểu được cách ta implement theo các diagram.

Trong Class Diagram, có 4 loại quan hệ.

Realization - Hiện thực hóa
Mối quan hệ giữa 1 class implement 1 interface được gọi là quan hệ realization, được biểu diễn bởi đường đứt nét có hình mũi tên tam giác chỉ vào interface.

Generation hay còn gọi là Inheritance (Quan hệ tổng quát hóa, quan hệ khái quát hóa, quan hệ kế thừa)
Đối tượng cụ thể (concrete) sẽ kế thừa các thuộc tính và phương thức của đối tượng tổng quát (general).

Quan hệ này được kí hiệu là A is-a B và thể hiện bằng một mũi tên trắng, chỉ từ class con lên class cha (Từ Concrete lên General).

Dependency - Phụ thuộc
Biểu diễn quan hệ giữa 2 phần tử trong mô hình mà nếu thay đổi ở phần tử này (phần tử độc lập) có thể gây ra thay đổi ở phần tử kia(phần tử phụ thuộc).

Quan hệ này được kí hiệu là A use-a B và được thể hiện bằng 1 mũi tên nét đứt từ đối tượng phụ thuộc (client) sang đối tượng độc lập (supplier).

Dependence thường sử dụng các khuôn mẫu sau:
use
Chỉ rằng ngữ nghĩa của lớp gốc phụ thuộc vào lớp ngọn, đặc biệt trong trường hợp lớp gốc dùng lớp ngọn làm tham số của nó.
permit
Chỉ rằng lớp gốc được quyền truy cập 1 cách đặc biệt vào lớp ngọn, chẳng hạn truy cập vào các thuộc tính protected, hay các method protected....
refine
Chỉ rằng lớp gốc ở 1 mức độ tinh thế cao hơn lớp ngọn.

Association - Kết hợp
Tập hợp các kết nối cùng loại (cùng ý nghĩa) giữa các object của 2 lớp tạo thành mối liên kết association , quan hệ giữa 2 tập hợp (2 lớp).

Là mỗi liên hệ giữa 2 lớp có role, role là tên vai trò của mối liên kết : vd như : của , cho , có , liên kết tới , trao đối với , …. (thường tên role có kèm theo 1 mũi tên để chỉ hướng quan hệ áp dụng từ lớp nào sang lớp nào)

Kí hiệu A has-a B và được biểu diễn bằng 1 gạch nối/ mũi tên không có chiều hoặc có chiều.

Ta ngầm hiểu khi nói A -- B điều đó có nghĩa hoặc là trong B có thuộc tính là A, hoặc trong A có thuộc tính là B. Cùng tìm hiểu thêm về 2 loại này nhé.

Aggregation - Quan hệ thu nạp
A và B có quan hệ Associate với nhau.
Trong A có chứa B
Nếu A bị hủy thì chưa chắc B đã bị hủy, đôi khi B còn được sử dụng ở 1 chỗ nào khác.
Nó còn được gọi là shared-aggregation.Một dạng của nối kết, trong đó một phần tử này chứa các phần tử khác.

kí hiệu Whole A – Part B : A được tạo ra từ nhiều B kết hợp lại, B có thể tạo ra độc lập mà ko phụ thuộc vào A. B cũng có thể thuộc một Whole C nào đó khác A.

Share ở đây có nghĩa, B có thể là bộ phận của 1 Whole khác. nên A bị thì chưa chắc B bị hủy.

Composition - Hợp thành
Mối quan hệ của cái này chặt chẽ hơn aggregation, nó còn được gọi là non-share aggregation.
Nó khác với cái trên ở chỗ, B là của riêng A, B ko tồn tại một mình mà luôn xuất hiện bên trong một A nào đó. Vì vậy A bị hủy thì B cũng đi luôn.
Tất nhiên là A chết thì B đi luôn, B đi luôn thì A vẫn còn.
Whole ở đây thể hiện B nằm trọn trong A, chỉ thuộc 1 mình A mà thôi.

Types of Design Patterns
Theo phân loại thì ta có khoảng 23 thằng, mỗi thằng lại có một mục đích sử dụng khác nhau, nhưng chủ yếu được phân thành bốn nhóm dưới đây :

S.N.	Pattern & Description
1	Creational Patterns
These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator. This gives program more flexibility in deciding which objects need to be created for a given use case.
2	Structural Patterns
These design patterns concern class and object composition. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities.
3	Behavioral Patterns
These design patterns are specifically concerned with communication between objects.
4	J2EE Patterns
These design patterns are specifically concerned with the presentation tier. These patterns are identified by Sun Java Center.
Nhóm Creational Patterns cung cấp cho ta cách thức để tạo nên object mà ko phải sử dụng constructor mặc định. Nói chính xác hơn thì nó cung cấp cho ta các cách để quản lý việc khởi tạo object.
Nhóm Structural Patterns focus chủ yếu vào các thành phần của object, sẽ đi chi tiết sau.
Nhóm Behavioral Patterns liên quan đến hành vi của object, cũng đi chi tiết sau.
J2EE Patterns đi chi tiết sau.
Creational Design Patterns
Nhóm Creational Design pattern cung cấp những giải pháp để khởi tạo object một cách tốt nhất phù thuộc vào từng tình huống cụ thể

Singleton Pattern
Singleton nhằm giới hạn số lượng Object được khởi tạo, và đảm bảo chỉ có 1 Object của lớp tồn tại trong JVM. Nghe thì có vẻ đơn giản nhưng lúc triển khai nó có vô vàn vấn đề cần quan tâm. Nếu muốn sử dụng cái này, vui lòng xem cách mà nó sẽ được handle để xác định xem cách thức nào là phù hợp nhất nhé.

Factory Pattern
Factory Pattern được sử dụng khi ta có một lớp các Object cùng loại (bằng Abstract Class hoặc Interface) và dựa trên điều kiện đầu vào.

Mô hình này chuyển trách nhiệm khởi tạo từ client đến các Factory, nhằm che dấu việc khởi tạo Object cũng như làm cho code trở nên gọn gàng hơn.

Ta có thể sử dụng các method static để tạo ra các interface phục vụ cho mục đích khởi tạo Object, hoặc cũng có thể tạo ra các Singleton cho những nhà máy này.

Đây là một trong số các Design Pattern được sử dụng rộng rãi nhất.

Abstract Factory
Nếu Factory trả lại một Object, thì Abstract Factory trả lại một "factory".

Trong mô hình Abstract Factory, ta loại bỏ điều kiện if - else mà Factory sử dụng, thay vào đó ta sử dụng các Factory để trả lại dữ liệu cho phù hợp.

Builder
Builder ra đời nhằm giải quyết hạn chế của Factory và Abstract Factory. Factory chỉ tạo ra 1 Object dựa theo input đầu vào, do đó, khi Object phức tạp và được xây dựng từng phần thì cách thức này sẽ không giải quyết được.

Builder có nhiệm vụ xây dựng Object từng phần, và sau đó trả lại 1 Object toàn vẹn.

Nó sử dụng Inner class để làm điều đó.

Prototype
Gọi Prototype tạo Object cũng ko đúng, mà đúng ra nó có nghĩa là nhân bản. Tức là trước hết, ta phải có 1 Object đã được khởi tạo. Sau đó, ta quyết định copy nó một phần hoặc tất cả.

Prototype yêu cầu Object cần nhân bản phải cung cấp tính năng Copy.

Có 2 loại copy, shadow copy (Copy địa chỉ tham chiếu) hoặc deep copy (copy bằng giá trị) và chọn cách nào phụ thuộc vào quyết định của ta.

Object Pool
Giới hạn số lượng object tạo ra bằng 1 Pool. Các object trong pool được reuse và share giữa các client.

Khi các client cần 1 object, nó sẽ get từ pool. Sau khi mượn xong nó sẽ trả object lại pool - vị trí ban đầu để các client khác có thể sử dụng.

Trong pattern này, điều ta quan tâm đó là việc setup các giá trị min, max object trong pool cũng như điều chỉnh các behavior khi pool cạn kiệt object hơn là việc implement nó.

Structural Design Patterns
Structural Pattern cung cấp nhiều cách để tạo nên Class structure để tạo nên các class "lớn hơn" từ các class "nhỏ"

Adapter Pattern
Adapter được sử dụng để giúp cho 2 interface không tương thích, có thể hoạt động được với nhau.

Để làm được điều này, thì nó cần có 1 bộ chuyển đổi - Adapter.

Composite pattern
Composite được sử dụng khi ta có 1 cấu trúc mà trong 1 đối tượng chứa nhiều đối tượng, và cách mà ta xử lý 1 đối tượng, cũng chính là cách mà ta xử lý các đối tượng bên trong nó. Tóm lại, nó là 1 cấu trúc cây, với mối đối tượng là mỗi node.

Proxy Pattern
Mục đích của Proxy Pattern đó là cung cấp người đại diện cho một đối tượng khác để kiểm soát quyền truy cập vào đối tượng đó.

Nói một cách dễ hiểu thì Proxy được sử dụng khi ta muốn cung cấp quyền truy cập có kiểm soát của một chức năng.

Proxy pattern gồm có 3 loại, Visual Proxy để quản lý quyền truy cập tới tài nguyên của hệ thống, Protected Proxy để kiểm soát quyền hạn truy cập tới các tài nguyên cần được bảo vệ, và remove proxy, chuyển đổi yêu cầu của client đến các proxy khác.

Flyweight Pattern
Flyweight được sử dụng trong mục đích chia sẻ các đối tượng của một lớp. Giả sử ta có 1 bank các đối tượng, và ta muốn reuse lại chúng giữa các object khác thì Flyweight là một lựa chọn tuyệt với nhất.

Mục đích của flyweight đó là tách các phần chung vào 1 Object riêng biệt (flyweight) và đưa các sự khác biệt thành các param để reuse trong method của nó. Từ đó, thay vì phải khởi tạo nhiều Object cho nhiều properties khác nhau, thì ta chỉ cần init 1 Object và reuse chúng lại trong các tình huống khác, thông qua một cơ chế quản lý (có thể là hash map cũng có thể là cái khác).

Facade Pattern
Mục đích của Facade là giúp cho client Application dễ dàng tương tác với hệ thống. Nó che dấu việc implement các service bên trong và chỉ cung cấp 1 interface ra bên ngoài để Client có thể dễ dàng tương tác.

Về mặt bản chất, Facade khá giống với Factory, chỉ khác, Factory trả về các Object, còn Facade sẽ trả lại các service dựa vào tham số đầu vào.

Bridge Pattern
Bridge được dùng để tách các interface ra khỏi implementation và che dấu việc implement từ phía client.

Nói thì khó hiểu vậy thôi chứ thực ra Bridge nso xây dựng một list các Interface, và tùy vào tham số đầu vào, nó quyết định interface nào sẽ được gọi.

Bridge cũng giống như là Facade, chỉ khác, Facade là cung cấp 1 service dựa vào tham số đầu vào, còn Bridge là nhiều interface phụ thuộc vào nhiều tham số đầu vào.

Về bản chất, việc implement Bridge tuân thủ theo quan niệm "Composition" - HAS A hơn là Inheritance - IS A.

Decorator Pattern
Decorate được sử dụng khi ta muốn thay đổi/ mở rộng behavior của Object tại thời điểm run-time.

Ta có 2 cách để có thể thực hiện điều này, sử dụng thừa kế IS-A hoặc là Sử dụng composite - HAS A, tuy nhiên, dùng cách nào thì nó cũng sẽ ảnh hưởng lên object hiện tại và nó có thể gây ảnh hưởng cho bất cứ thành phần nào của class.

Còn đối với decorate, ta có thể sử dụng các feature của nó 1 cách độc lập. Và ở đó, ta có thể xây dựng 1 Object, vừa có tính năng B, vừa có tình năng C.

Behavioral Design Patterns
Behavioral Design Patterns
Behavioral design pattern cung cấp các giải pháp cho sự tương tác tốt hơn giữa các object và cung cấp các mối quan hệ lỏng lẻo và linh hoạt để có thể mở rộng 1 cách dễ dàng.

Template Method Pattern
Template được sử dụng khi ta muốn trì hoãn việc implement các method.

Bản chất của template đó là nó các bước để thực hiện 1 service và nó có thể cung cấp các method chung hoặc giao việc implement các method đó cho lớp con.

Nó được sử dụng khi ta có 1 cấu trúc gồm các method bất di bất dịch, và ta muốn chính những thằng con sẽ quyết định xem nó sẽ implement các method đó ntn.

Điểm lưu ý trong cái design này đó là ta không thể thay đổi thứ tự các method được thực hiện.

Mediator Pattern
Mediator được sử dụng để cung cấp một phương tiện truyền thông tập trung giữa các đối tượng khác nhau trong một hệ thống.

Nếu không có mediator, các Object sẽ phải trực tiếp tương tác với nhau và khiến cho các thành phần của hệ thống bị kết nối với nhau chặt chẽ.

Thay vì vậy, Mediator cung cấp một giải pháp trung gian giữa các đối tượng để giao tiếp và giúp cho việc implement trở nên linh hoạt hơn.

Air Traffic là một ví dụ cụ thể cho cái này. Mỗi chuyến bay ko thể biết được lịch trình của nhau, thay vì vậy chúng thông qua Air Traffic để nhờ nó điều khiển và quản lý hành trình các chuyến bay.

Chain of Responsibility Pattern
Chain of Responsibility được sử dụng để hạn chế tính cứng nhắc của việc thiết kế ra các service.

Thay vào việc ta xây dựng các service để handle request từ client 1 cách cứng nhắc, thì giờ đây ta xây dựng một chuỗi các service để giải quyết điều này.

Một request sẽ được gửi đến một entry point - đầu chuỗi, và di chuyển xuyên qua các Objec bên trong chuỗi, thằng nào có liên quan, nó sẽ tự động handle việc đó, còn nếu ko nó sẽ gửi request đó cho thằng tiếp theo trong chuỗi.

Hạn chế của cái này đó là nếu ko xây dựng ok, thì ta sẽ không biết cái request đó đi đâu về đâu, cũng như ko biết được nó có được xử lý hay ko.

Ví dụ của nó đó là cái Broadcast message mà ngày xưa học trên mạng, một IP phát ra 1 message cho toàn bộ hệ thống, nhưng chỉ có thằng nào có IP trùng với IP trong request đó thì nó mới được xử lý mà thôi.

Observer Pattern
Observer cung cấp giải pháp để ta có thể giúp các Object khác nhận biết được sử thay đổi trạng thái của 1 object mà nó đang lắng nghe.

Strategy Pattern
Strategy được sử dụng, khi ta có nhiều phương pháp giải quyết 1 vấn đề, và ta muốn để cho client xác định họ sẽ lựa chọn phương án nào để giải quyết ngay trong run-time.

Strategy còn được gọi là Policy Pattern. Nó định nghĩa nhiều thuật toán, và cho phép client truyền nó đi như một tham số.

Command Pattern
Command đóng vai trò như một người điều khiển để thực hiện các action của client, khi client đó không biết nên thực hiện điều đó ntn.

Command là 1 design pattern khó và phức tạp, cần phải hiểu kĩ thì mới sử dụng được. Tuy nhiên, việc mở rộng cái này là vô cùng dễ dàng.

State Pattern
State pattern được sử dụng khi ta muốn thay đổi hành vi của Object dựa trên trạng thái của nó.

Có 2 cách để ta làm điều này, cách thứ nhất ta tạo 1 state trong Object, và thêm điều kiện if - else trong behavior của nó. Cách này chỉ sử dụng khi Object đơn giản và không phức tạp.

Cách thứ 2: ta sử dụng composite - HAS A - biến nó thành 1 thành phần của Object, và xây dựng các behavior riêng biệt cho từng trạng thái, sau đó set nó vào Object như một tham số.

Visitor Pattern
Visitor được sử dụng khi ta muốn thực hiện một thao tác trên một đống các Object khác nhau.

Để làm được điều này, ta có thể xây dựng 1 interface cho riêng cái đống object đó, và cho cái đống đó implement cái interface đó. Tuy nhiên cách này ko thực sự hay.

Thay vào đó, đối với visitor, ta xây dựng một Object riêng, mà Object đó có 1 method process, nhận tham số đầu vào là các Object trong danh sách, rồi dựa vào Overriding của Java để mà thực thi cái đó.

Interpreter Pattern
BODY_CONTENT
Iterator Pattern
Iterator được sử dụng để cung cấp 1 tiêu chuẩn duyệt qua một nhóm các đối tượng.

Iterator không chỉ được sử dụng cho mục đích đó, mà nó còn có thể duyệt với điều kiện, tùy cách ta implements.

Hơn tất cả, nó cung cấp 1 tiêu chuẩn, và vì vậy nếu tuân thủ nó ta cũng có thể mở rộng dễ dàng hơn.

Memento Pattern
Memeto được sử dụng khi ta muốn lưu trữ trạng thái cũ của Object nhằm cho mục đích restore.

Summary
Sau khi đã đi qua một vài Interface cơ bản, thì giờ ta quay lại để thống kê lại mục đích của cái này như sau:

Pattern ra đời để giải quyết được sự nhập nhằng và không đồng bộ. Điều này thể hiện rõ qua các Factory Pattern, Builder

Pattern giải quyết được bài toán, khi ta đã có một hệ thống cũ và muốn nâng cấp nó lên, nhưng mà cái mới lại có thể ảnh hưởng tới cái cũ. Vậy phải làm sao để đảm bảo là cái mới và cái cũ không ảnh hưởng đến nhau. Bài toán này được giải quyết bởi các Pattern như : Adapter Pattern, Bridge Pattern

Mục đích của Design Pattern, đó là :

Code đồng bộ và thống nhất ngay từ ban đầu
Mở rộng dễ dàng mà không làm ảnh hưởng đến cái cũ - Đảm bảo nguyên lý Open - Close