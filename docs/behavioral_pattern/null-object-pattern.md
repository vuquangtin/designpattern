# Null Object Pattern - Behavioral Pattern
Null Object có nhiệm vụ gói gọn sự vắng mặt của 1 đối tượng bằng cách cung cấp 1 sự thay thế có thể thay thế cho

## Bài toán
Một hôm, để nâng cao chất lượng phục vụ, ông chủ yêu cầu, khi một khách hàng vào, ta cần ghi lại thông tin của khách hàng đó để có thể nâng cao chất lượng dịch vụ. Giả sử khách hàng đi 2 người, 1 nữ 1 nam và gọi 2 ly 1 nước cam và 1 ly bia thì căn cứ theo cái danh sách mà đã order, để phục vụ có thể bưng món cho đúng người đúng vật.

Chuyện nhỏ như con thỏ, anh phục vụ trả lời. Bây giờ, cái danh sách Order của anh có thêm 1 cột, person và mọi thứ vẫn tốt lành cà.

Vào 1 ngày đẹp trời, có 1 cặp tình nhân vào quán. Họ có vẻ tức tối, kiểu như đang giận nhau thì phải. Khi anh phục vụ ra hỏi hai người ăn gì, thì anh người yêu trả lời, dĩa thịt chó. Trong khi đó cô bạn gái lại khó chịu, tôi chả thiết ăn uống gì.

## Giải pháp
Trong trường hợp này, anh phục vụ chả biết phải làm sao cả. Ông chủ yêu cầu phải cung cấp danh sách khách hàng và món ăn của từng người nhưng mà chị này lại chả ăn gì thế thì biết điền gì bây giờ. Nghĩ bụng, anh hí húi chép.

Nam chó, nữ ko có ăn gì.

Trong thực tế, ta có thể gặp những trường hợp tương tự như vậy. Ta có 1 method, method đó trả về 1/ 1 list các Objects. Tuy nhiên, không phải lúc nào cũng có dữ liệu trả về. Và vậy là ta phải handle 1 trường hợp, null.

Một ví dụ dễ hiểu hơn của Null Object đó là lỗi 404. Khi 1 lỗi này xảy ra, thay vì trả về null, ta có thể trả về 1 Null Object mà nó sẽ return 1 HTML page để show default message.

## Introduction
nothing will come of nothing
Null, đúng như tên gọi của nó, không có cái gì trả về cả. Trong 1 vài trường hợp, khi xử lý 1 đối tượng, ta phải handle trường hợp result của nó là 1 null object nếu ko muốn xảy ra các Exception. Tuy nhiên thử nghĩ xem, nếu ta muốn show ra 1 list, nhưng khi list đó empty ta phải show 1 default message. Điều đó đơn giản khi chỉ có 1 vài trường hợp như vậy, nhưng nếu số lượng nó lên quá nhiều thì lúc này việc dùng if không còn hiệu quả nữa, thay vào đó ta sử dụng Null Object Pattern như 1 giải pháp thay thế tuyệt vời hơn và dễ dàng mở rộng hơn.

Một vài trường hợp, 1 class required 1 collaboration nhưng lại ko cần nó làm bất cứ 1 điều gì. Tuy nhiên, class muốn đối xử với Collaboration không làm gì đó như cách mà nó đối xử với 1 Object khác thực sự cung cấp hành vi.

## Implements
Chìa khóa của Null Object Pattern đó là 1 abstract class xác định interface cho toàn bộ các đối tượng thuộc loại này. Null được xem như 1 đối tượng của Class này, vì vậy nó có thể được sử dụng ở bất cứ đâu đối tượng này cần thiết.

So sánh với việc sử dụng Null value, thì rõ ràng ta thấy trường hợp này ko cần kiểm tra điều kiện nào và code vẫn rõ ràng mà không có điều gì đáng phải bận tâm.

Nhiều người cảm thấy thật phiền phức và ngu ngốc khi sử dụng Null vì nó quá đơn giản. nhưng nhìn ở 1 khía cạnh khác, Null Object luôn biết chính xác cần phải làm gì mà không cần tương tác với những đối tượng khác. Vì vậy trong thực tế nó lại rất thông minh.

## Advantages & Disadvantages
### Advantages
Đơn giản hóa việc check điều kiện null, thay vào đó ta sử dụng nó như 1 việc làm mặc định khi không có bất cứ 1 kết quả nào trả về. Việc này đảm bảo cho code trở nên thống nhất, cũng như loại bỏ đi sự lo lắng khi quên mất check null cho một method sẽ throw ra 1 Exception.

### Disadvantages
Thêm vài dòng code, có thể sẽ là 1 điều ko đáng kể.

Đôi khi có những trường hợp ta khó/không thể sử dụng nó. Việc sử dụng nó chỉ có hiệu quả và ý nghĩa khi method đó được sử dụng quá nhiều chỗ và ta cần phải handle cho trường hợp null, còn nếu ít quá thì thôi bỏ qua cũng được.

## Usage
Khi ta muốn code consistence và handle cho trường hợp không có 1 kết quả nào trả về mà không muốn thay đổi logic của chương trình hoặc mất quá nhiều thời gian để check điều kiện này ở bất cứ đâu.

## Summary
Null Object thường được implement dưới dạng 1 Singleton. Thông thường 1 đối tượng null không có bất cứ trạng thái nào, do đó, trạng thái của nó thường giống hệt nhau. Vì vậy việc sử dụng 1 Singleton ở đây là khá hợp lý.

Nếu 1 Client mong đợi 1 Null Object cư xử như cách này hay cách khác, khi đó ta cần tạo ra nhiều class Null Object để thỏa mãn. Trong trường hợp này, ta cần pluggin vài đối tượng/variable để điều khiển hành vi của nó tại runtime. (AbstractObject not having a well define)

Không được chuyển đổi 1 Null Object thành 1 Real Object. Nên nhớ nó là đại diện của không có Object nào cả. Nếu 1 Null Object ngừng việc cung cấp 1 nothing behavior và chuyển sang cung cấp 1 real behavior, thì nó đã không còn là 1 null object nữa. Do đó ta cần xem lại pattern này có nên áp dụng vào ngữ cảnh này hay không. Trong trường hợp này State Pattern hoặc Proxy Pattern sẽ chính xác hơn. Và lúc này ta sẽ có 1 Null State Pattern hoặc Null Proxy pattern thay cho Null Object Pattern. Lưu ý điểm này.

Null Object có thể là 1 trường hợp đặc biệt của Strategies Pattern. Strategy Pattern chỉ định ra các CConcreate Strategy như là các cách tiếp cận khác nhau để hoàn thành 1 nhiệm vụ. Nếu 1 trong những ConcreateStrategy đó không làm gì, thì nó có thể là 1 Null Object.

Null Object có thể là 1 trạng thái đặc biệt của State Pattern. Thông thường, một ConcreteState có 1 số phương thức không làm gì cả vì chúng không phù hợp với trạng thái đó. Nếu 1 ConcreteState cụ thể thực hiện hầu hết các phương thức của nó không làm gì hoặc ít nhất là trả lại 1 kết quả null, nó sẽ trở thành trạng thái không làm gì và xem như là 1 trạng thái null (null state).

Null Object còn đượp sử dụng trong Visitor Pattern để có thể truy cập 1 hệ thống phân cacpa 1 cách an toàn và xử lý cho null situation.

Null Object là 1 Concrete Collaboration Class đóng vai trò như 1 Collaboration cho client. Null behavior không được design để có thể trộn vào 1 đối tượng cần 1 hành vi không làm gì cả. Nó được sử dụng để thiết kế cho 1 class mà được uỷ thác cho collaboration tất cả các hành vi có thể hoặc không thể làm gì. Lưu ý điểm này, interface được dùng cho null, không phải dùng cho các class cần null behavior nhé.