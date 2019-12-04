# Abstract Factory Pattern - Creational Pattern
Cung cấp 1 interface để tạo 1 families của các đối tượng có liên quan hoặc phụ thuộc lẫn nhau, mà không chỉ định các lớp cụ thể của nó

Một hệ thống phân cấp gói gọn, dựa trên many platform và construction của 1 bộ sản phẩm ("product").

Bài toán
Cũng vẫn là cái cửa hàng ở góc phố kia. Sau một thời gian kinh doanh, nó đã trở nên sầm uất và phát triển hơn bao giờ hết.

Ông chủ cửa hàng khá là hài lòng, nhưng vẫn mong muốn nó sẽ phát triển hơn nữa. Ông quyết định mở rộng thực đơn của mình để có thể đáp ứng cho nhu cầu ẩm thực của khác hàng. Để tạo đa dạng món ăn, ông quyết định sẽ xây dựng thực đơn theo ngày và thực đơn đặc biệt.

Ông tuyển thêm một đống bếp phó và để anh bếp trưởng kia quản lý. Giờ thì anh bếp trưởng ko cần thiết phải nấu ăn nữa, mà đã lên chức thành người giám sát rồi.

Nhưng mà vấn đề ở đây, khách hàng vào nhộn nhịp, việc cung ứng nguyên liệu của anh phụ tá kia không kịp.

Và tất nhiên, điều này khiến ông chủ ko hài lòng rồi.

Giải pháp
Danh sách món ăn có rồi, tại sao ta không phân loại chúng ra, khi nào cần thì ta sẽ cung ứng toàn bộ. Thay vì việc phải lấy từng quả trứng, miếng thịt bò, ít rau củ như trước kia, thì giờ anh phụ bếp chỉ cần để chúng vào 1 cái khay, và khi nào cần thì mang lên ngay cho anh bếp trưởng.

Thế là, từ sáng sớm, anh phụ bếp hí húi xem cái danh sách, phân loại thành các nguyên liệu cho từng món ăn, rồi lúc khách hàng gọi, thì anh mang ngay vào cho mấy anh đầu bếp.

Tiến độ công việc giờ đã nhanh hơn, mà việc quản lý nguyên liệu cũng dễ dàng hơn trước, vì toàn bộ đã có anh phụ bếp nắm rồi.

Anh phụ bếp bây giờ, đã trở nên cao cấp hơn. Từ một Factory đơn giản, chỉ biết cung cấp trứng, thịt, thì giờ anh trở thành Abstract Factory - cung cấp được cả thực đơn.

Sau này nếu như cửa hàng mở rộng, ông chủ tuyển thêm 1 đội ngũ giúp việc phụ anh, thì công việc của anh sẽ nhàn hơn nhiều, chỉ cần ngồi chờ ngta bưng các nguyên liệu tới, và đem nó cho các đầu bếp là xong, ko cần vất vả ngồi xếp từ đầu như trước nữa.

Nếu như Factory quản lý việc tạo ra một bộ phận/ thuộc tính của đối tượng, thì abstract factory có vẻ nghiêng về việc nó dùng để tạo ra các đối tượng riêng biệt hơn. Trong ví dụ này, rõ ràng thực đơn món chính sẽ khác với thực đơn tráng miệng, mặc dù nó cũng được cấu tạo từ nước, đường, trứng, thịt này nọ.

Introduction
Abstract Factory Pattern says that just define an interface or abstract class for creating families of related (or dependent) objects but without specifying their concrete sub-classes.
An Abstract Factory Pattern is also known as Kit.
Theo như khái niệm trên, ta cần hiểu rằng, Abstract Factory có nhiệm vụ cung cấp 1 cách thức trừu tượng để cóp thể tạo ra 1 Families các đối tượng có liên quan/ phụ thuộc lẫn nhau 1 cách gián tiếp, mà không chỉ định trực tiếp các lớp cụ thể của nó.

Đối tượng "factory" có trách nhiệm cung cấp dịch vụ tạo ra các Families entire cho platform. Khách hàng không được quyền tạo đối tượng trực tiếp, thay vào dó, họ yêu cầu "factory" thực hiện điều này cho họ.

Cơ chế này khiến việc trao đổi các sản phẩm trong cùng 1 family trở nên dễ dàng vì các "factory" chỉ xuất hiện 1 lần trong ứng dụng, nơi nó được khởi tạo. Application có thể dễ dàng bổ sung/ thay thế các families product này bằng cách tạo 1 concrete instance khác.

Trong Pattern này ta cần lưu ý: Abstract Factory là để lấy 1 "họ" các sản phẩm liên quan. Và khi ta cần lấy 1 family khác, ta tạo ra 1 concrete instance khác. Bao nhiêu bộ thì bấy nhiêu Instance.

Vì cái Abstract Factory được dùng rất phổ biến, nên nó nên được triển khai thường xuyên như 1 Singleton.

Ví dụ ta có object A được tạo thành từ đống B1, C2, D5, E4, Object B được tạo thành từ B2, C3, D1, E2, thì lúc này thay vì việc ta phải gọi 4 cái Factory cho mỗi lần tạo cái Object A, thì ta dùng luôn 1 Abstract Factory mà có thể gọi tới 4 Factory để tạo ra 4 Object đó.

Nếu ví dụ trên kia chưa đủ rõ ràng, ta sẽ sang 1 ví dụ khác có tính thực tiễn hơn.

Giả sử ta có 1 nhà máy sản xuất xe của Yamha, với các nhà máy con của nó như sản xuất vỏ, sản xuất động cơ, sản xuất khung xe, sản xuất bánh xe chẳng hạn. Mỗi nhà máy lại có các nhà máy con, nhà máy sản xuất vỏ xe Sirius, vỏ xe NVX, ...., chẳng hạn.

Giả sử ta cần build 1 cái xe Sirius, ta gọi các Factory sản xuất vỏ xe Sirius từ Factory Sản xuất vỏ xe, Factory sản xuất động cơ Sirius từ factory Sản xuất động cơ, ....

Điều này mang lại những phiền hà không cần thiết. Việc sử dụng các Factory như vậy làm code của ta không những không sạch hơn mà còn khó hiểu hơn rất là nhiều.

Thay vì như vậy, ta xây dựng 1 nhà máy sản xuất xe Sirius chẳng hạn, nhiệm vụ của nó là tự động đi vào trong các nhà máy kia, thu gom các Vật liệu cần thiết theo nhu cầu.

Và từ đây công việc của bạn sẽ đơn giản hơn rất nhiều, vì ta chỉ cần gọi nhà máy sản xuất xe Sirius, và nó sẽ mang lại cho ta các linh kiện theo yêu cầu. Đó là mục đích chính của Abstract Factory

Implements
Dưới đây là các checklist cần phân tích trước khi bắt đầu implement

Xác định xem "platform independence" và các service khởi tạo có phải là nguồn gốc của những vấn đề hiện tại ko
Tạo 1 ma trận giữa các "platforms" và "products"
Xác định factory interface bao gồm factory method cho mỗi product
Xác định các factory derived class cho mỗi platform. Factory này đóng gói toàn bộ các tham chiếu đến new operation.
Remove toàn bộ các tham chiếu đến new và sử dụng các factory methods để tạo ra các product objects.
Từ những requirment đó, thông thường, một Abstract Factory gồm những thành phần sau :

AbstractFactory : Định nghĩa một interface cho thao tác khởi tạo các Abstract Product
ConcreteFactory : Thực thi Abstract Factory để cho ra một đối tượng cụ thể
Factories
Ta cần lưu ý rằng, Abstract Factory cung cấp 1 interface để có thể tạo ra 1 family product, do đó, khi cần tạo 1 đống các object khác, ta cần tạo 1 Concrete Factory khác.

Advantages & Disadvantages
Advantages
Abstract Factory cô lập client từ những concrete (implementation) classes

Làm giảm bớt sự trao đổi của các familiar Objects (từ các Factory của nó) *

Thúc đẩy sự nhất quán giữa các đối tượng.

Disadvantages
Nhược điểm của Abtract Factory đó là phải xác định được các nhóm Object. Xác định sai thì đi tong luôn.

Usage
Khi muốn tách việc khởi tạo Object ra khỏi hệ thống **

Khi các đối tượng liên quan cần được sử dụng cùng với nhau

Khi ta muốn cung cấp 1 library các objects nhưng không muốn show các implementations mà chỉ thông qua các interface

Khi hệ thống cần được cấu hình với 1 trong nhiều family of objects.

* Vì sao ta bảo vậy. Giả sử ta có Factory A1 cung cấp các Object A1, Factory B1 cung cấp các object B1, A1, B1 là cùng kiểu.
Object A1 này được sử dụng dể tạo nên object và Object B1 dùng để tạo nên object B. Nếu như ta không xài cái Abstract Factory để giới hạn lại, thì có thể xảy ra 1 trường hợp, đó là khi tạo Object B, người ta vô tình dùng Factory A1. Do đó, việc sử dụng Abstract Factory để hạn chế sự trao đổi giữa các Family Class, bằng cách giới hạn lại nó theo đầu vào.

** Tách việc khởi tạo ra khỏi hệ thống, tức là thay vì việc sử dụng toán tử new, ta sử dụng các Abstract Factory và các interface của nó để lấy ra Object cần tạo.

Important things
Đôi khi ta sẽ gặp được sự cạnh tranh trong các Pattern thuộc nhóm Creational này. Ví dụ giữa Prototype và Abstract Factory đều có ích trong việc giải quyết vấn đề. Nhưng đôi lúc, nó là các phần bổ sung cho nhau. Abstract Factory có thể store 1 set các Prototype để sao chép và trả lại các product, Builder có thể sử dụng các Pattern khác để triển khai việc build từng phần của nó. Abstract Factory, Builder và Prototype cùng có thể sử dụng Singleton trong quá trình thực hiện.

Abstract Factory, Builder, và Prototype xác định 1 đối tượng Factory object, chịu tránh nhiệm biết và tạo 1 class product objects, và biến nó thành 1 tham số của hệ thống. Abstract Factory có các Factory object sản xuất các đối tượng của 1 só lớp.

Builder cũng có thể có 1 Factory object để build 1 complex product sử dụng các giao thức phức tạp tương ứng. Prototype cũng vậy, nó có thể sử dụng các Factory Object để build các product bằng việc copy các prototype object.

Abstract Factory class thường được implement với Factory Method, nhưng nó cũng có thể được implement bằng Prototype.

Abstract Factory có thể sử dụng thay thế cho các Facade để ẩn các platform-specific classes.

Builder tập trung vào việc xây dựng 1 đối tượng phức tạp theo từng bước. Trong khi đó Abstract Factory nhận mạnh việc tạo ra 1 family products

Builder return lại product ở step cuối cùng nhưng Abstract Factory lại trả lại đối tượng ngay lập tức.

Thông thường, designer sử dụng Factory Method tại thời điểm mới bắt đầu. Lúc này, Factory Method thể hiện rõ sức mạnh của nó ít phức tạp, dễ tùy chỉnh và số lượng các subclass được sinh ra. Tuy nhiên sau 1 thời gian, nó lại phát triển theo hướng hoặc là Abstract Factory hoặc là Protype hoặc là Builder vì những Pattern này linh hoạt hơn, phức tạp hơn. Khi Designer nhận ra rằng cần sử dụng nó ở 1 số vị trí để đảm bảo sự linh hoạt.