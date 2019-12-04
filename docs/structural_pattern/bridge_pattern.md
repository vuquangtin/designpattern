# Bridge Pattern - Structural Pattern
Phân tách 1 sự trừu tượng từ implementation của nó để 2 cái có thể thay đổi 1 cách độc lập.

* Publish interface của 1 hệ thống phân cấp thừa kế, và che dấu việc implementation của nó trong hệ thống phân cấp của chính nó.
* Đóng gói và cô lập.

## Bài toán
Sau một thời gian kinh doanh, ông chủ quyết định chuyển sang một lĩnh vực khác : Làm bánh.

Việc làm bánh vừa có thể cung cấp thêm món tráng miệng cho khách hàng, hay phục vụ các em nhỏ, và cũng có thể bán ra trong các dịp đặc biệt. Thế là ông quyết định mở luôn một nhà hàng bên cạnh góc phố.Sau đó, ông bắt đầu thu thập các khảo sát về nhu cầu của khách hàng. Ông thấy rằng đa số khách hàng thích cái bánh hình tròn, và chỉ mua tặng trong dịp sinh nhật.

Vậy là ông thuê một ông thợ lành nghề, làm luôn cái khuôn hình tròn, và khắc sẵn các họa tiết trên đó. Chỉ cần đổ bột vào, cho vào lò và chờ 10 đến 15 phút, là ta đã có ngay một cái bánh sinh nhật xinh xắn mà ko cần phải làm thêm bất cứ thứ gì khác.

Tiện thể, ông làm luôn cái khuôn hình vuông dể sản xuất những chiếc bánh tráng miệng ăn điểm tâm hoặc nhâm nhi bên ly trà nóng.

Ông thấy nó cũng khá hợp lý, vì chả tốn quá nhiều thời gian, mà vẫn có được những sản phẩm tuyệt vời đến tay người dùng.

Tháng đầu tiên khai trường, cửa hàng đông ngùn ngụt. Khách hàng được phục vụ tận tình chu đáo mà ko phải chờ đợi lâu. Thợ làm bánh chỉ việc đổ nguyên liệu đã trộn sẵn vào, chờ 10p rồi mang ra cho khách hàng. Rất nhanh mà ko phức tạp.

Tuy nhiên, sau đó một tháng, ông lại gặp vấn đề. Lượng khách giảm rõ rệt vì cái khuôn cũ không còn phù hợp với thị hiếu. Giờ người ta chuộng cái bánh hình tam giác hoặc nhìn ngũ giác, lục giác mang cảm giác mới lạ hơn, và việc trang trí hoa lá hẹ ban đầu cũng ko còn phù hợp nữa.

Ông quyết định bổ sung thêm các khuôn bánh để phục vụ cho khách hàng. Ông mua thêm khuôn hình tròn, khuôn hình vuông, khuôn hình chữ nhật, ... được khắc sẵn những họa tiết trang trí khác nhau, đẹp hơn, sinh động hơn, và mọi thứ được giải quyết sau đó.

Tuy nhiên, một ngày đẹp trời, có một ông khách tới hỏi mua một cái bánh hình vuông, nhưng mà lại có họa tiết trang trí giống cái bánh hình tròn mà cửa hàng đã làm ra trước đó. Cô đầu bếp tìm mãi mà lại ko thấy có cái nào như vậy đành say sorry và để ông khách ra đi trong tiếc nuối.

Cô thưa lại với ông chủ, ông chủ ngồi suy nghĩ, và nhận ra rằng, hóa ra việc mình sử dụng các khuôn làm bánh đó, tuy nhanh nhưng mà lại ko thể chiều lòng được những thị hiếu của khách hàng. Vậy giờ phải làm sao để tách riêng hình dạng của những cái bánh (vuông, tròn, méo mó) ra, vừa có thể trang trí cho nó bằng những họa tiết hoa lá hẹ tùy chọn.

## Giải pháp
Rõ ràng trong trường hợp này, cái trang trí và hình dáng cái bánh, là 2 thứ độc lập và không phụ thuộc vào nhau. Sai lầm của ông chủ là đã cố gắng gắn kết nó lại với nhau một cách cứng nhắc. Vì vậy khi khách hàng đòi một cái bánh hình vuông với họa tiết trang trí của cái khuôn hình tròn, thì cửa hàng không đáp ứng được.

Chưa kể giờ đây, yêu cầu của ông chủ đưa ra ảnh hưởng đến toàn bộ cái khuôn cũ. Chúng ko thể sử dụng lại vì bất cứ một mục đích nào.

Sau bài học rút ra đó, ông chủ quyết định sẽ mua những cái khuôn bánh độc lập, và những họa tiết trang trí độc lập. Khi khách hàng cần một cái bánh hình tròn và với họa tiết trang trí A, thì ông sẽ kêu cô đầu bếp dùng cái khuôn hình tròn để đúc bánh, rồi sau đó lại đưa sang một cái khuôn nữa, để nó ép cái họa tiết kia vào theo yêu cầu của khách hàng.

Việc tách cái họa tiết trang trí - thuộc tính trừu tượng, ra khỏi cái bánh - thực thể - để chúng có thể hoạt động một cách độc lập, được gọi là Bridge Pattern.

Ý nghĩa của Bridge ở đây, đó là cầu nối - nối những thuộc tính trừu tượng với những thực thể. Từ đó, việc implements các thuộc tính trừu tượng đó, không làm ảnh hưởng đến cái thực thể ban đầu. Sau này, nếu như khách hàng muốn một cái bánh có hình con ong con bướm đang thịnh hành, thì ông chủ chỉ cần mua cái khuôn họa tiết đó về, chứ không cần phải mua luôn trọn bộ như trước kia.

Trong lập trình cũng vậy, vì thời gian gấp rút, muốn nhanh mà ta cứ gộp chung mọi thứ lại thành một. Điều này giống như cái Conversion của Product CRCT mà mình đã từng làm, chạy thì OK, nhưng để mở rộng thì ôi thôi : sửa rất nhiều, sửa xong ko biết cái cũ có còn chạy được ko nữa.

## Introduction
A Bridge Pattern says that just "decouple the functional abstraction from the implementation so that the two can vary independently".
The Bridge Pattern is also known as Handle or Body.
Trong bài toán trên, sai lầm của ông chủ đó là ghép nối mọi thứ thành 1 khối cứng nhắc. Chính điều này làm cho việc thay đổi behavior của Object trở nên khó khăn và đôi khi là không thể.

Bridge tách các behavior đó thành các đối tượng độc lập, sử dụng nó như các composition để "nhúng" vào Object, giúp nó thay đổi behavior/state tại thời điểm runtime.

Trong bài toán lập trình, ta gặp những trường hợp ứng dụng bi ràng buộc chặt chẽ vì việc sử dụng các phân lớp của 1 abstract base class để cung cấp các triển khai thay thế. Điều này làm cho việc binding trong quá trình compile time bị lock giữa interface và implementation. Và hậu của nó đó là Abstraction và Implementation không thể được mở rộng hoặc độc lập với nhau.

Trong java, 2 trường hợp của Polymorphing thường gặp nhất là Override và Overload. Overload là việc ta nạp chồng các phương thức, cung cấp tính đa hình tại compile time, và overwrite cung cấp cơ chế ghi đè cho phép ta đa hình trong quá trình run-time. Mỗi cái đều có 1 mục đích sử dụng khác nhau, nhưng nếu ta muốn 1 đa hình trong run-time thì ta cần nhắm tới đó là override. Bridge dựa vào cơ chế này. Thay vì việc ràng buộc chặt chẽ như kiểu của overload, thì nó tách riêng interface và implement thành 2 class độc lập, cho phép ta có thể thực hiện override 1 cách dễ dàng.

Bridge phân tách interface và implementation của thành phần thành các hệ thống phâ cấp thừa kế. Interface class chứa 1 con trỏ tới lớp triển khai trừu tượng. Con trỏ này được khởi tạo với 1 thể hiện của lớp triển khai cụ thể nhưng tất cả các tương tác tiếp theo từ interface class tới implement class đều được duy trì trong implement base class. Client tương tác với interface class và interface class này ủy thác toàn bộ request cho implementation class.

Interface Object được gọi là HANDLE, được client biến đến và sử dụng. Trong khi đó, implement object hoặc BODY được đóng gói an toàn nhawmnf đảm bảo nó có thể tiếp tục được phát triển hoặc đuuợc thay thế hoàn toàn, hoặc được chia sẻ trong quá trình run-time.

### Vậy, khi nào ta cần Bridge

Ta muốn binding implementation trong quá trình run-time. Ta có 1 danh sách các class là kết quả của việc ghép nối giữa interface và nhiều triển khai
Chia sẻ implementation giữa nhiều đối tượng
Cần 1 ánh xạ phân cấp class hierarchy
Và đây là những gì ta nhận được

### Tách rời interface của Object.
Cải thiện khả năng mở rộng, có thể extend abstraction và implementation 1 cách độc lập
Ẩn detail implementation từ phía khách hàng.
Bridge còn được biết đến với HANDLE/BODY. Đây là 1 cơ chế gói gọn 1 lớp thực hiện bên trong 1 giao diện. Cái đầu tiên là BODY và cái tiếp theo là HANDLE. HANDLE được Client xèm là actual class nhưng công việc được thực hiện bởi BODY. Thành ngữ HANDLE/BODY có thể được sử dụng để phân tách một sự trừu tượng phức tạp thành các lớp nhỏ hơn, dễ quản lý hơn. Thành ngữ này có thể phản ánh việc chia sẻ tài nguyên bởi nhiều lớp kiểm soát vào nó.

## Implements
Dưới đây là các bước phân tích để triển khải Pattern này

Quyết định nếu có 2 khía cạnh như vậy trong ứng dụng. Tất nhiên nó phải có xuất hiện/tồn tại thì mới cần áp dụng chứ
Các khái niệm độc lập này có thể là abstraction/platform hoặc domain/cơ sở hạ tầng (infrastructure) hoặc front-end/back-end hoặc interface/implementation.
Thiết kế phân tách các concenrs: WHat does client want? What do platform provide?
thiế kế 1 inteface hướng nên tảng (platform oriented interface) là tối tiểu, cần thiết và đủ. Mục tiêu của nó là tách rời abstraction khỏi platform.
Xác định 1 derived class của interface cho mỗi platform.
Tạo 1 abstract base class mà "has-a" platform object và ủy thác các platform-oriented functionality cho nó.
Xác định các specialization abstraction class nếu muốn.
Trong Design, ta cũng sẽ sử dụng các properties, để quyết định các tính trừu tượng của nó.

Bản chất của Pattern này đó là sẽ tách những thuộc tính trừu tượng, biến nó thành các Interface, và sử dụng nhiều Class để implememts cho các Interface đó.

Khi đó, Object được tạo sẽ độc lập với các thuộc tính trừu tượng.


Việc implement diễn ra cũng đơn giản. Đầu tiên ta xác định các abstract method của Object.

Tách rời các Abstract đó ra, xây dựng Interface và 1 list các Concrete Object implement các Abstract method đó.

Thay thế method đó trong Object bằng chính Abstract Class đó. Và truyền nó vào trong quá trình run-time.

Thế là xong.

## Advantages & Disadvantages
Phần này đã nói ở trên.

### Advantages
Tách rời interface của Object.
Cải thiện khả năng mở rộng, có thể extend abstraction và implementation 1 cách độc lập
Ẩn detail implementation từ phía khách hàng.

### Disadvantages
phức tạp

## Usage
Ta muốn binding implementation trong quá trình run-time.
Ta có 1 danh sách các class là kết quả của việc ghép nối giữa interface và nhiều triển khai
Chia sẻ implementation giữa nhiều đối tượng
Cần 1 ánh xạ phân cấp class hierarchy

## Important things
Adapter làm cho mọi thứ hoạt động sau khi nó được design, còn Bridge làm mọi thứ hoạt động trước khi nó được tạo. Tại sao nói như vậy, Adapter cần tạo các interface để giúp 2 class có thể làm việc với nhau, trong khi đó, Bridge sửa đổi từ 1 đối tượng sẵn có, tách nó ra làm 2. Do đó, Bridge làm cho nó hoạt động trước khi nó được tạo.

* Bridge được thiết kế theo hướng up-front để cho abstraction và implementation được thay đổi độc lập. Adapter được trang bị theem để làm cho các lớp ko liên quan có thể làm việc cùng nhau.

* State, Strategy, và Bridge và Adapter (ở 1 mức độ nào đó) có thể có 1 solution structure tương tự. Tất cả dều sử dụng thành ngữ HANDLE/BODY. Nó chỉ khác nhau về ý nghĩa, là nó giải quyết các vấn đề khác nhau.

* Cấu trúc của State và Bridge là giống hệt nhau, chỉ khác, Bridge chấp nhận hệ thống phân cấp của các evelope class trong khi đó State chỉ cho phép 1. Hai mô hình sử dụng cùng 1 cấu trúc để giải quyết các vấn đề khác nhau, đối với State, đó là cho phép 1 đối tượng thay đổi cùng với trạng thái của nó, trong khi đó, đối với Bridge đó là tách rời trừu tượng ra khỏi việc thực hiện để 2 bên có thể thay đổi 1 cách độc lập.

Nếu interface class ủy quyền việc tạo các lớp triển khai của chúng, thay vì tự tạo/couple một cách trực tiếp, thì lúc này ta thường sử dụng Abstract Factory để tạo các đối tượng triển khai hơn là Bridge.