# Composite Pattern - Structural Pattern
Chuyển đổi các đối tượng thành 1 cấu trúc cây để thể hiện 1 hệ thống Whole-Part. Composite cho phép Client xử lý các đối tượng riêng lẻ và compositions objects một cách thống nhất.

Recursive Composite

Thư mục/Directories chứa các mục, mỗi mục/entries có thể là 1 thư mục/directory.

One-to-Many "HAS-A" up "IS A" hirarchy.

## Bài toán
Cửa hàng của ông chủ dạo gần đây thường bị khách hàng than phiền là để họ chờ đợi quá lâu, vào gọi đồ ăn mà 30p chưa lên được. Điều này làm ông chủ lấy làm khó chịu lắm.

Ông đắn đo suy nghĩ, nguyên nhân là gì nhỉ, tại cô phục vụ đưa Order cho anh đầu bếp chậm, hay tại anh phụ bếp làm việc không hiệu quả, hay là anh đầu bếp lại lười biếng ham chơi.

Vậy là cuối ngày, ổng tập hợp danh sách các nhân viên lại để xem xét xem trung bình họ làm một món ăn hết bao nhiêu, và nó có thật sự là chậm như lời khách hàng phàn nàn ko?

Nhưng, tính ntn nhỉ.

## Giải pháp
Việc phục vụ món ăn có nhiều công đoạn.

Đầu tiên, cô phục vụ sẽ đem menu lên cho khách hàng và đợi order món.

Sau đó, cô mang order đó gửi cho anh phụ bếp.

Anh phụ bếp căn cứ món ăn mà khách hàng yêu cầu, chuẩn bị nguyên liệu và mang vào cho anh đầu bếp.

Anh đầu bếp chế biến và trang trí món ăn.

Cô phục vụ lại hối hả mang cho khách hàng.

Mỗi công đoạn này đều tốn một thời gian nhất định. Tổng thời gian của nó là thời gian mà món ăn hoàn thành.

Vì vậy, chỉ cần mỗi nhân viên cung cấp ước lượng cho ông thời gian của mỗi quy trình của họ, thì ông dễ dàng tính được thời gian của từng món mà khách hàng yêu cầu.

Trong lập trình, ta cũng gặp những trường hợp tương tự. Một object có thể có nhiều đối tượng bên trong nó, và các đối tượng đó, có thể có các hành vi giống nhau. Ví dụ ở đây, món ăn tốn x thời gian, các công đoạn cũng tốn x' thời gian.

Nếu như ta tách các object ra độc lập, thì việc xây dựng nó sẽ rất phiền hà, khi ta phải lặp lại việc gọi các method ở nhiều chỗ khác nhau.

Thay vào đó, tại sao ta không gom nó thành một nhóm, và dùng một method cho toàn bộ.

Kĩ thuật đó gọi là Composite.

## Introduction
A Composite Pattern says that just "allow clients to operate in generic manner on objects that may or may not represent a hierarchy of objects".
Trong lập trình, đôi khi ta gặp trường hợp cần phải thao tác với 1 hệ thống phân cấp gồm tập hợp các đối tượng nguyên thủy(primitive) và hỗn hợp (composite). Xiệc xử lý 1 prmitive object được thực hiện bằng 1 cách, và việc xử lý 1 composite object lại được xử lý theo những cách khác nhau. Nếu muốn thao tác trên các đối tượng này, ta cần truy vẫn loại của từng đối tượng, và đó là điều ta không mong muốn.

Vì vậy, ta cần xác định 1 Abstract base class (Component) chỉ định hành vi cần được thực hiện thống nhất trên tất cả các đối tượng primitive và composite. Phân loại các primitive và Composite ra khỏi Component clas. Mỗi Component class chỉ ghép với abstract type component khi nó quản lý con của nó. Nói cách khác, ta sử dụng 1 Abstract class Component, biến mỗi Primitive và Composite về dưới dạng các Component class cùng với các Child- cũng là 1 Component của nó.

Ta có thể sử dụng Composite bất cứ khi nào ta có 1 "Composites that contain components, each of which could be a composite).

Để dễ quản lý, thì các method như addChild, removeChild, thường được định nghĩa trong Composite class. Nhưng thông thường ta sẽ gặp rắc rối vì điều này, đúng hơn ta phải quyết định lựa chọn giữa "safery" và "transparency" khi áp dụng nó.

Composite pattern nên được áp dụng khi một nhóm các object hoạt động tương tự như 1 object đơn - Tức là các object phải có behavior giống nhau.

Composite design pattern có thể được sử dụng để tạo ra một cấu trúc phân cấp (dù là đầy đủ hoặc 1 phần).

Nó cũng có thể được sử dụng khi ta muốn bổ sung các thành phần khác vào mà không làm thay đổi tới các đối tượng khác, đặc biệt trong trường hợp reponsibility - trách nhiệm của đối tượng có thể thay đổi theo thời gian.

## Implements
Dưới đây là các bước cần phân tích trước khi tiến hành implement

Đảm bảo rằng vấn đề mà ta đang gặp phải là việc thể hiện các mối quan hệ "Whole-Part" hierarchy.
Xem xét xem nó có đảm bảo: "Containers that contain containees, each of which could be a container." trước khi bắt đầu đi sâu hơn. Chia các domain concept thành containers class và containee class.
Tạo các interface chung nhất giúp cho các containers và containers có thể hoán đổi cho nhau. Nó nên chỉ định hành vi cần thực hiện thống nhất trên tất cả các containee và container objects.
Tất cả các Container và Containee đều được khai báo dưới dạng "IS-A" với interface (extend)
Tât cả các lớp container đều được khai báo mỗi quan hệ one-to-many "has a" với interface (implement)
Container class tận dụng tính đa hình để ủy thác cho các containee objects
Phương pháp quản lý các child objects (addChild, removeChild) nên được ddinjhj nghĩa trong Composite class
Thật không may, mong muốn xử lý các đối tượng Leaf và Composite objects có thể yêu cầu các phương thức này được nâng lên thành Abstract Component class.

Bản chất của composite đó là gom các object tương tự nhau thành một, implement method chung cho nó, sau đó sử dụng một cái thằng component để chứa toàn bộ, và cũng dùng component đó để thao tác hàng loạt.

Theo như nội dung trên, ta sẽ xây dựng nó như sau :

Xây dựng các interface khai báo các method chung.
Các nút lá
Composite object (chứa các nút lá ở trên).

## Advantages & Disadvantages
### Advantages
Ưu điểm của Composition đó là cho phép ta xây dựng các hệ thống phân cấp bao gồm các đối tượng nguyên thủy (Leaf) và phức tạp (Node)

Dễ dàng bổ sung thêm các components mới.

Cung cấp một cấu trúc linh hoạt với Class/Interface có thể quản lý.

### Disadvantages
Cấu trúc rắc rối, cần xem xét kĩ lưỡng trước khi tiến hành.

## Usage
Đã nói ở trên

## Summary
Composite và Decorate có cấu trúc tương tự nhau, cả 2 đều dựa trên recursive composition để tổ chức 1 cấu trúc open-closed objects.

Composite có thể được duyệt thông qua Iterator. Visitor có thể applied 1 số hoạt động trên 1 Composite. Composite cũng có thể sử dụng Chain of Responsibility để cho phép các thành phần của nó truy cập các thuộc tính global thông qua cha của nó. Nó cũng có thể sử dụng Decorate để ghi đè các thuộc tinas này trên các thành phần của Composition. Có nó thể sử dụng Observer để buộc 1 cấu trúc đối tượng với 1 cấu trúc đối tượng khác, và State để component có thể thay đổi hành vi khi trạng thái của nó thay đổi.

Composite có thể cho phép ta tách 1 Mediator khỏi các thành phần nhỏ hơn thông qua Recursive composite.

Decorate được thiết kế cho phép ta thêm trách nhiệm cho các đối tượng mà không cần phân lớp. Trọng tâm của Composite không phải chỉ là tô điểm mà là đại diện. Những ý định này mặc dù khác biệt nhưng lại bổ sung cho nhau. Vì vậy, Composite và Decorate thường được sử dụng trong quá trình xem xét.

Flyweight thường được kết hợp với các Composite để implement shared leaf node.

Safety" versus "Transparency" trade-offs
WHole point của Composite Pattern đó là Composite có thể được xử lý như 1 object nguyên tử. giống như 1 chiếc lá. Nếu ta muốn cung cấp 1 giao thức Iterator điều đó cũng khá tốt, nhưng ta sẽ sử dụng các pattern khác (Interator chẳng hạn) vì nó nằm ngoài phạm vi của Composite. Trọng tâm của Composite là cung cấp cho khách hàng khả năng thực hiện thao tác trên một đối tượng mà không cần biết rằng có bao nhiêu đối tượng bên trong.

Để có thể xử lý 1 tập các đối tượng không đồng nhất (atomically hoặc transparently) đòi hỏi child management interface phải được xác định tại lớp gốc của Composite class hierarchy ( Abstract Composite class). Tuy nhiên, việc này có thể mang tới một rủi ro là khách hàng có thể cô gắng làm các công việc khác như thêm và xóa các đối tượng cho các nút lá. Nhưng, nếu ta cooss gắng đảm bảo "design for safety" thì lúc này các child Management interface phải được khai báo trong Composite class và ta sẽ mất tính minh bạch vì leaf và Composite có các interface khác nhau.

Composite không bắt buộc ta phải biến tất cả các Components là Composites. Nó chỉ cho ta biết cách để đặt tất cả các hoạt động mà ta muốn xuwry lý thông nhất trong lớp Components. Nếu thêm, remove, hoặc các hoạt động tương tự không thể hoặc không được xuywr lý thống nhất thì không được đặt chúng trong lướp cơ sở thành phần. Tuy nhiền, cần nhớ rằng,