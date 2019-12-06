# Chain of Responsibility Pattern - Structural Pattern
Bản chất của Chain of Responsibility Pattern đó là đưa 1 request thông qua một chuỗi các object - Chain, và để cho những phần tử trong chuỗi đó tự quyết định xem nó sẽ xử lý hay sẽ chuyển tiếp request đó đến phần tử/ đối tượng kế tiếp.

Nó thường được áp dụng khi mà ta có quá nhiều process trong một hệ thống, và ta không biết nên gửi nó chính xác từ đâu/ hay ta muốn cho cái hệ thống của ta trở nên lỏng lẻo.

## Bài toán
Một ví dụ đơn giản của Chain of responsibility - Chuỗi trách nhiệm, đó là thư chuyền tay.

Thư chuyền tay là cái trò mà lũ học sinh nào cũng khoái dùng. Bạn viết 1 lá thư, và muốn gửi cho một cô gái ngồi bàn đầu trong giờ học.

Tất nhiên bạn ko thể chạy lên và đưa trực tiếp cho cô ấy được rồi. Thay vào đó, bạn ghi tên của cô gái lên đó, và đưa lên cho cậu bạn ngồi bàn trên.

Cậu bạn ấy sẽ nhìn lên lá thư, và biết sẽ phải chuyển nó đến đâu. Và vậy là từ từ lá thư của bạn cũng đến đc. Khi cô ấy nhìn lên lá thư, thấy tên mình, cô ấy sẽ ngạc nhiên mở ra và đọc nó.

## Giải pháp
Đó là một ví dụ nho nhỏ về Chain of responsibility.

Mục đích của Chain of Responsibility đó là làm hệ thống lỏng lẻo hơn. Cùng xem xét nhé:

Giả sử hệ thống của bạn được phục vụ cho một mục đích nào đó, ví dụ như thanh toán. Bạn yêu cầu khách hàng điền vào những thông tin đó, rồi gửi lên hệ thống và sau đó xử lý.

Bạn thiết kế hệ thống dựa trên những yêu cầu đó, Gồm một chức năng post, một chức năng receive n process và một chức năng saving. Mọi thứ OK, ko có vấn đề gì cả.

Một ngày đẹp trời, một khách hàng quen phàn nàn rằng, tôi mua hàng rất nhiều nhưng mỗi lần như vậy lại phải điền lại cái hồ sơ đó. Tại sao anh không lấy hoặc cung cấp cho tôi những chức năng để có thể sử dụng lại những thông tin cũ.

Và ôi thôi, bạn nhận ra, hệ thống mình chỉ biết tuân thủ theo nguyên tắc như vậy, nó trở nên quá cứng nhắc và khó để thay đổi.

Chain of Responsibility ra đời nhằm mục đích đó, thay vì việc thiết kế một flow theo tiêu chuẩn, nó lại cung cấp một chuỗi các service.

Khi một request được gửi vào, Chuỗi sẽ xác định xem đối tượng/ service hiện tại có "trách nhiệm" xử lý nó hay không, nếu không nó sẽ giao đối tượng đó cho một service tiếp theo trong chuỗi.

## Introduction
avoid coupling the sender of a request to its receiver by giving multiple objects a chance to handle the request
Khi ta nói về Chain of Responsibility ta thường chỉ nghĩ đến đó là 1 chuỗi các object, mỗi object có 1 nhiệm vụ khác nhau. Điều này có thể đúng. Bởi bản chất của CoR là vậy. Tuy nhiên, thử nhìn nó theo 1 khía cạnh khác.

Giả sử bạn có 1 chuỗi các interface để handle 1 vấn đề/ request nào đó. Khi có 1 yêu cầu gửi từ client, ta sẽ phải phân vân không biết nên lấy cái interface nào ra để giải quyết. Lúc này CoR là một giải pháp vô cùng thuận lợi. Nó cung cấp 1 giao diện hợp nhất cho 1 tập hợp các giao diện trong một sub-system. Nói cách khác, nếu Facade là Factory của Interface, thì cái này cũng là 1 thứ tương tự, chỉ khác, nó không yêu cầu bạn phải lấy chính xác interface mà bạn cần, mà nó sẽ làm điều đó thay cho bạn.

Vì vậy, ta cũng có thể định nghĩa CoR là một giao diện cấp cao hơn giúp hệ thống con dễ sử dụng hơn. Và để làm được điều này, nó wrap một sub-system complex bằng 1 inteface đơn giản.

## Implements
Chain of Responsibility là 1 chuỗi các Object thành các "đường ống"-pipe. và để khách hàng quyết định "launches and leaves" các request của họ tại đầu đường ống.

Chain of Responsibility Pattern xâu chuỗi các receiving objects lại với nhau, và sau đó chuyển lần lượt message từ đối tượng này sang đối tượng khác cho đến khi nó được chuyển đến 1 đối tượng có khả năng xử lý message.

Số lượng và loại của các Handler Objects không được cho biết từ trước. Nó có thể được nạp vào 1 cách tự động và sử dụng cơ chế đệ quy để cho phép unlimited số lượng handle được liên kết.

Mỗi CoR gồm 2 phần, 1 list các delivery class đóng vai trò các node trong chuỗi và 1 base class đóng vai trò handle các request từ phía client - root of chain.

Các bước implement như sau:

Đầu tiên, lớp cơ sở (base class/ main class) sẽ định nghĩa một "next" pointer. Mục đích của thằng này là liên kết giữa các Receive Object lại với nhau.
Sau đó, các delivery class sẽ implement các "đóng góp"-contribution của nó để xử lý yêu cầu. Nói nôm na là implement nhiệm vụ của nó. Ngoài ra, nó còn phải giữ một tham chiếu tới Base Class.
Khi một request được gửi đến Delivery Object, nếu nó không có nghĩa vụ/ không được implement việc handle request đó, nó sẽ dánh dấu request đó cần được "passed on", và gửi lại cho Base Class. Base Class nhận được request này, nó sẽ tiếp tục chuyển request đó đến cho một delivery tiếp theo và cứ như vậy request sẽ lần lượt đi từ thằng này sang thằng khác.
Client/ third party tạo và liên kết 1 chuỗi các object/ delivery để phục vụ cho quá trình xử lý request của nó.
Client launches & leaves các request với root of chain.
Việc implements nó gồm có những điểm cần lưu ý:

Các service phải được thiết kế nhằm 2 mục đích chính, xử lý request nếu như nó có trách nhiệm, và chuyển tiếp cho đối tượng khác.

Vì vậy, ta xây dựng một object với những method đó, đồng thời tạo ra một pipe để lưu trữ nó.

Và tất nhiên, request được gửi tới cho đối tượng đầu tiên của chuỗi rồi.

Một ví dụ dễ thấy của CoR, đó là try catch. Bản chất của Try Catch, nếu nó có trách nhiệm xử lý exception đó (catch) thì nó sẽ xử lý, nếu không, nó ném exception lên cho cái đoạn function/ block trên kia để xử lý.

Thêm 1 ví dụ nữa đó là máy ATM. ATM sẽ tùy vào số tiền mà quyết định bao nhiều tờ 500k, bao nhiêu tờ 200k, bao nhiêu tờ 100k để trả lại khách hàng

Lưu ý, một request có thể được/ và thường được xử lý bởi nhiều Delivery Object. Mô hình làm việc của Chain of Responsibility là dựa trên các message. Mỗi object có vai trò xử lý 1 message. CoR sử dụng bài toán đệ quy. Vấn đề việc tìm xem đối tượng nào xử lý tiếp theo là do Main Class quy định. Còn việc sẽ xác định đối tượng nào xử lý request là do Delivery Object quy định thông qua việc trả lại/ thay đổi message.

Giả sử ta có 1 Block với các Object A, B, C, D, E, F và 1 Root of Chain R. Khi 1 request c truyền vào, nó được gửi cho R. R chuyển tiếp nó lần lượt cho A, B, C. C nhận request, xử lý nó và trả về 1 message là b. R lại tiếp tục tìm trong list của mình các Object có nhiệm vụ handle nó, và nó lại tiếp tục được gửi cho B. B xử lý xong lại đối message thành f. F xử lý xong lại đổi message thành a. Đó mới là ý nghĩa thực sự của CoR.

Trong CoR, các delivery không tương tác trực tiếp với nhau mà thông qua Root of Chain. và, Client cũng ko biết gì về các delivery. Điều nó cần làm đó là gửi request tới cho R và kệ R xử lý. Đó chính là điều khiến cho Chain of Responsibility mang tính lỏng lẻo.

## Advantages & Disadvantages
### Advantages
Sử dụng CoR làm cho ứng dụng trở nên lỏng lẻo, giảm tính kết nối/ kết dính

Tăng thêm tính linh hoạt khi muốn add/assign resposibility cho các object. Chỉ việc tạo 1 Node và đưa vào thôi

Cho phép 1 tập hợp các Class hoạt động như 1. Các sự kiện được tạo ra trong 1 class có thể được gửi cho các class khác với sự trợ giúp của composition.

### Disadvantages
Nhược điểm lớn nhất của cái này đó là vòng lặp đệ quy. Điều này dẫn đến xảy ra các trường hợp 1 request được chuyển đi chuyển lại trong pipe mà không kết thúc được. Do đó, cần xem xét kĩ lưỡng khi áp dụng.

Việc sử dụng đúng nó là 1 vấn đề. không phải lúc nào cũng có thể xài.

## Usage
Khi có nhiều hơn 1 đối tượng có thể xử lý yêu cầu mà người xử lý không biết rõ nên dùng cái nào.

Khi ta cần 1 nhóm các object để xử lý 1 request 1 cách tự dộng

## Summary
Chain of Responsibility đơn giản hóa các kết nối giữa các Object. Thay vì người gửi và những người nhận phải duy trì tham chiếu đến các Receiver Candidate thì giờ đây, người gửi chỉ giữ 1 tham chiếu đến người đứng đầu chuỗi và mỗi người nhận chỉ giữ tham chiếu đến người kế nhiệm trực tiếp trong chuỗi.

Khi sử dụng Chain of Responsibility ta cần đảm bảo phải tồn tại một safety net để có thể "catch" tất cả mọi yêu cầu mà không được xử lý.

Điểm cuối cùng, cũng là điểm cần chú ý trong pattern này đó là nó không nên sử dụng trong trường hợp khi mỗi request chỉ được xử lý bởi 1 object hoặc khi client object bieets service nào sẽ handle request đó.

Sử dụng Chain of Responsiblity phải cực kì cẩn thận. Nếu xài ko đúng thì cái request đó sẽ gửi vòng vòng và không hồi kết vì Chain of Responsibility sử dụng bài toán đệ quy.