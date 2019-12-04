# Builder Pattern - Creational Pattern
Tách việc xây dựng 1 đối tượng phức tạp ra khỏi biểu diễn của nó, để quá trình xây dựng có thể tạo ra các biểu diễn khác nhau.

Phân tích một biểu diễn phức tạp, tạo 1 trong số các mục tiêu

## Bài toán
Cửa hàng đã nhộn nhịp hơn xưa. Bây giờ cửa hàng ko tập trung vào tầng lớp bình dân nữa, mà giờ đây cửa hàng lại tập trung vào tâng lớp trung lưu và quý xờ tộc, những người có tiền.

Tất nhiên có tiền thì sẽ có quyền, và yêu cầu của họ sẽ phức tạp hơn, anh đầu bếp cũng mệt mỏi hơn khi chế biến, và anh phục vụ cũng phải học cách để chiều lòng khách hàng.

Một ngày nọ đẹp trời, một cô gái xinh xắn đi cùng một anh già dê vào nhà hàng. Anh già dê thì khá dễ tính, nhưng cô bồ thì khá chảnh chọe.

Cô nhìn vào thực đơn và gọi: "một dĩa bò xào khoai tây nha em."

Anh phục vụ hí hoái ghi vào.

À, mà dặn anh đầu bếp cho thêm ít nấm hương nữa nhé.

À quên, nhớ bỏ thêm ít tiêu cho cay đấy.

Lấy chị bánh mì sandwich thay vì bánh mì ổ nhé.

Nhớ là ít rau nhiều thịt nhé.

## Giải pháp
Tất nhiên thứ mà chị yêu cầu trên kia, chả nằm trong cái thực đơn của nhà hàng rồi. Anh phục vụ sau khi nghe xong, cất vội thực đơn, và bắt đầu lấy giấy ra ghi chép:

Bò xào khoai tây

thêm nấm
thêm tiêu,

thay bánh mì sandwich,
it rau nhiều bò
Và đưa mảnh giấy đó cho anh đầu bếp để anh đầu bếp căn

Trong trường hợp này, cái khai nguyên liệu - sản phẩm của anh phụ bếp - Abstract Factory kia tỏ ra vô dụng rồi. Tuy nhiên, anh đầu bếp vẫn có thể chế biến món ăn mà chị kia yêu cầu, nhờ vào cái miếng giấy anh phục vụ đưa.

Miếng giấy ấy là một ví dụ của Builder Pattern.

## Introduction
Builder Pattern says that "construct a complex object from simple objects using step-by-step approach"

Trong thực tế, đôi khi ta cần phải xây dựng các element từ 1 tập hợp phức tạp. Đặc tả của tập hợp (aggregate) này có thể tồn tai trên 1 secondary storage và 1 trong số các representation của nó cần được xây dựng trong 1 primary storage.

Bản chất của Builder là vậy, ta sẽ có 1 secondary storage, nơi ta xây dựng đối tượng này từng phần, và 1 primary storage, nơi ta trả lại sản phẩm cuối cùng.

Ngoài cái ví dụ trên kia, ta cũng hình dung lại quá trình làm bánh. Quá trình làm bánh đi qua các công đoạn, từ nhào bột, đem nướng tạo hình trang trí và đóng gói, đó cũng là các quá trình, nó nằm ở secondary storage. Chỉ khi nào cái bánh hoàn thành, nó mới được gửi sang cho bộ phận giao nhận, primary storage.

Vì vậy, khi phân tích, ta thấy Builder thường được sử dụng để tách các algorithms ra khỏi các interpreting (reading and parsing) lưu trữ nó trong 1 stored persistence machanism khỏi các thuật toán nhằm xây dựng và đại diện cho 1 trong nhiều sản phẩm mục tiêu. Trong tâm/ sự khác biệt của pattern này đó là xây dựng các tập hợp phức tạp.

Trong mô hình này, ta sẽ có 1 director và 1 builder. Director gọi các builder service để xây dựng từng phần theo các format bên ngoài. Bulder tạo ra 1 phần của đối tượng phức tạp mỗi lần nó được gọi, và duy trì tất cả trạng thái trung gian. Khi sản phẩm hoàn thành, client sẽ lấy kết quả từ Builder.

Điều này cho phép ta có thể kiểm soát tốt hơn quá trình xây dựng. Khác biệt hoàn toàn với các Creational Pattern khác, Builder pattern xây dựng sản phẩm từng bước dưới sự kiểm soát của Director.

Tóm lại, Builder tách biệt việc xây dựng 1 đối tượng phức tạo khỏi biểu diễn của nó, đẻ cùng 1 quy trình xây dựng có thể tạo ra các biểu diễn khác nhau.

## Implements
Để xây dựng 1 Builder, ta cần tuân thủ các bước sau :

Bước 1. Quyết định xem 1 common input và many posible representation (or outputs) có phải là vấn đề ko. Nếu thực sự là vấn đề thì ta nên áp dụng. Đừng nên lạm dụng quá.
Bước 2. Đóng gói các parsing common inputs trong 1 Reader class
Bước 3. Thiết kế 1 standard protocol để tạo tất cả các posible output representations. Capture từng step của giao thức này trong 1 interface của Builder
Bước 4. Xác định 1 lớp dẫn xuất Builder cho mỗi target representation.
Client khởi tạo 1 Reader và 1 đối tượng Builder, sau đó đăng kí Builder với Reader đã tạo.
Client yêu cầu Reader xây dựng
Client yêu cầu Builder trả về.
Không chính xác như lần trước ta đã học, trong mô hình đó, 1 Builder chỉ xây dựng được 1 đối tượng mà thôi. Ở bài toán tổng quát hơn, ta sử dụng Builder như 1 công cụ để tạo ra nhiều đối tượng trong nhiều tập hợp khác nhau. Đó mới là cái hay của vấn đề.

Dưới đây là 1 ví dụ cơ bản về việc sử dụng 1 Builder để tạo ra 1 Object trong 1 ngữ cảnh xác định.

First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class. We should follow the naming convention and if the class name is Computer then builder class should be named as ComputerBuilder.
Java Builder class should have a public constructor with all the required attributes as parameters.
Java Builder class should have methods to set the optional parameters and it should return the same Builder object after setting the optional attribute.
The final step is to provide a build() method in the builder class that will return the Object needed by client program. For this we need to have a private constructor in the Class with Builder class as argument.

Giờ, ta sẽ đi qua 1 bài toán khác, phức tạp hơn. Ta có 1 cái report, nó có thể trả về data của ta dưới dạng bar graph, hoặc cũng có thể là linegrap, hoặc cũng có thể là circle grap.

Trong trường hợp này, đối tượng chúng ta cần là Report. Nhưng bản chất của Report đối với mỗi loại là khác nhau. Vậy, cách ta tiến hành như thế nào.

Đầu tiên, theo đúng nguyên tắc ở đầu, bước 1 ta quyết định sử dụng pattern này.

Bước 2, bước 3 Ta đóng gói các parsing common input của nó trong 1 Reader class, các standard protocal cuiar nó là các method. Do đó ta thấy cần có readData, addData, addListData, parseData, processData, setMin, setMax, setDisplayType chẳng hạn, là các method, và đưa nó vào 1 Interface có tên là ReportBuilder.

Bước 4, ta xây dựng 3 lớp dẫn xuất cho 3 cái builder kia, tên là CircleReportBuilder, BargraphReportBuilder, lineGraphReportBuilder và tiến hành implement các method kia.

giờ, nếu ta cần 1 CircleReportBuilder, ta khởi tạo/gọi 1 CircleReportBuilder, tiến hành readData, parseData, processData, setMin, setMax này nọ, và cuối cùng, gọi hàm get là được.

## Advantages & Disadvantages
Advantages
Giúp ta phân chia rõ ràng giữa constructor và representation của Object

Cung cấp cách tốt hơn để kiểm soát trong quá trình xây dựng 1 object

Hỗ trợ thay đổi các representation bên trong của các đối tượng

Disadvantages
Có chăng cũng chỉ là thêm vài dòng code mà thôi.

## Usage
Builder thường được dùng khi mà việc khởi tạo các Object phức tạp.

Khi ta muốn bổ sung thêm các builder method mà không cần quan tâm tới các object hiện tại - tăng khả năng mở rộng

## Important things
Các Creational là bổ sung. Builder có thể sử dụng các Pattern khác trong quá trình sử dụng. Abstract Factory, Builder và Prototype thường sử dụng Singleton trong quá trình triển khai

Builder chủ yếu tập trung vào việc xây dựng 1 đối tượng phức tạp theo từng bước. Abstract Factory cung cấp 1 family các products ( đơn giản hoặc phức tạp) trong khi đó Builder trả lại product ở bưới cuối cùng, khác với Abstract Factory, product sẽ được trả lại lập tức.

Builder thường xây dựng như 1 Composite. Nếu ta nhìn vào cái ví dụ thứ 2, ta có thể thấy rõ điều đó. Bản chất của Composite đó là tương tác với tất cả các đối tượng trong mẫu như nhau. Trong trường hợp này, 1 Builder có thể có nhiều concreted derived nhưng nó cùng tuân thủ 1 Interface, nên nó cũng như 1 Composite.

Thông thường, ta bắt đầu với Factory Method và phát triển theo hướng Abstract Factory, Prototype hoặc Builder.