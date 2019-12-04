# Adapter Design Pattern - Structural Pattern
Chuyển đổi giao diện của 1 lớp thành 1 giao diện khác mà client mong đợi. Adapter cho phép các class có thể làm việc cùng nhau bỏ qua vấn đề giao diện không tương thích.

* Bao bọc 1 lớp hiện có với 1 giao diện mới.
* Công cụ giúp cho 1 thành phần cũ có thể tương thích với 1 hệ thống mới

## Bài toán

Một ngày đẹp trời, ông chủ quyết định sẽ nâng cấp toàn bộ máy móc cho các anh đầu bếp. Ổng mua đâu được bên Nhật về một mớ hàng xịn, kêu thợ vận chuyển tới lắp đặt này nọ.

Mọi việc sẽ ko có vấn đề gì nếu như : Nó chạy bằng điện 110v trong khi hệ thống điện của VN lại là 220v

Và giờ làm sao để có thể sử dụng được những thiết bị này : Hay thôi trả nó lại và mất thêm một khoản phí kha khá.

## Giải pháp

Lên google search một hồi, Ổng quyết định ra tiệm điện gần nhà, mua một cái ổn áp, đầu vào 220v, đầu ra có thể là 110v hoặc 220v. Vậy là hệ thống thiết bị mới này sẽ được nối riêng ra, thông qua một cục chuyển áp.

* Cục chuyển áp kia là một ví dụ của Adapter.
* Mục đích của nó là làm cho các thiết bị/ interface không tương thích, có thể hoạt động/ giao tiếp với nhau.

## Introduction

An Adapter Pattern says that just "converts the interface of a class into another interface that a client wants".
Reused là một trong những mục tiêu mà OOP nói riêng và các phương thức khác nói chung cố gắng tiếp cận đến. Điều gì sẽ xảy ra khi ta có 1 component với những chức năng tuyệt vời và muốn sử dụng lại nó nhưng hệ thống hiện tại lại ko cho phép ta làm điều đó.

* Adapter nói về việc tạo ra 1 intermediary abstraction có thể chuyển đổi hoặc ánh xạ 1 component cũ sang một hệt thống mới.
* Client gọi các phương thức trên đối tượng Adapter để chuyển hướng chúng thành các cuộc gọi tới lagacy component. Chiến lược này có thể được thực hiện bằng kế thừa (Object Adapter hoặc tổng hợp (Class Adapter)

Adapter có chức năng như 1 trình bao bọc, wrapper hoặc sửa đổi, modifier một lớp hiện có. Kết quả là ta có 1 lớp mới với các phương thức khác hoặc chuyển đổi lớp hiện tại.
Có hai loại Adapter phổ biến, Object Adapter và Class Adapter. Ví dụ về tờ giấy trên kia là một ví dụ về Object Adapter.

* Class Adapter: sử dụng kế thừa và extend một interface nào đó
Đối với trường hợp này, khi 1 class cha không tương thích với Interface A, ta sẽ tạo 1 thằng con Extend từ cái parent đó, thay đổi các Behavior để tương thích với cái Class đó.
* Object Adapter: sử dụng Java Composition
Đối với trường hợp này, ta tạo 1 Composition riêng implement cái interface trên. Sau đó, ta "nhúng" nó vào các Class mà ta muốn và sử dụng nó để gọi cái interface tương ứng. Cách này hiệu quả hơn, vì khi đó ta sẽ có 1 reusable class và có thể biến bất cứ Class nào cũng có thể tương thích với interface mà ta muốn.
## Implements

Để implement Pattern này, ta tuân thủ các bước sau:

* Xác định các đối tượng : Component muốn được cung cấp (Client) và thành phần cần thay đổi (Adaptee)
* Định nghĩa các interface mà client cần.
* Thiết kế 1 Wrap Class có thể impedance match adapter với Client.
* Adapter/Wrapper class maps client interface với adapter interface
* Client sử dụng / couple với new interface.
Trong mô hình này, ta luôn có 2 đối tượng cần quan tâm, đối tượng sử dụng dịch vụ và đối tượng cần cung cấp. Từ các yêu cầu đề ra của đối tượng sử dụng dịch vụ, client mà ta thiết kế lại các adapter thỏa mãn yêu cầu đó. Bản chất của Adapter chỉ đơn giản là vậy.
Như đã nói ở trên, có 2 cách implement cho trường hợp này. Dưới đây là chi tiết mô tả của 2 cách thức design cái Adaptee đó.

* Class Adapter: Triển khai theo mối quan hệ IS-A
* Object Adapter: Triển khai theo mối quan hệ HAS-A


Cái chức năng PlayMedia.js trong Sadlier là 1 ví dụ của Object Adapter.

Việc đầu tiên, ta quan tâm tới behavior của cái media, nó có thể là audio, video, ta ko cần quan tâm. Ta chỉ quan tâm tới các behavior của nó. Ví dụ renderLayout, play, pause, stop, changeVolume, changeToFullScreenMode. Từ những method này ta định ra được các behavior tương ứng.

Sau đó, ta tạo 1 object MEDIA_UTILS bên trong cái Object Util của ta, quyết định sẽ new audioPlayer hay videoPlayer thông qua 1 factory.

Và đổi các event của cái Util này thành MEDIA_UTILS.callTheMethod mà thôi.

JS khó viết oop hơn là TS nên cần cẩn thận khi xài nó, ko thì sẽ có những thứ ko chạy được :)

Lưu ý, audio không có fullScreen nhưng ta vẫn cần phải implement method này cho nó, nhưng tốt nhất là cho return false.

## Advantages & Disadvantages and Usage

### Advantages
Reused lại hệ thống cũ mà không cần implement lại quá nhiều

### Disadvantages
Có thể có những adapter không thể tương thích được. Trong trường hợp này cần thay đổi cách giải quyết.

### Usage
Muốn sử dụng lại 1 component trong 1 hệ thống đã có.

Mở rộng class hiện tại nhưng không muốn làm thay đổi nó.

### Important things
* Adapter làm cho mói thứ hoạt động sau khi nó được thiết kế. Trong khi đó, Bridge làm cho mọi thứ hoạc động trước khi nó tồn tại. Lưu ý, Bridge tách tính trừu tượng ra khỏi implement của nó, vì vậy, trước khi Object được thiết kế xong thì cái interface kia đã hoạt động rồi.

* Bridge được thiết kế up-front để cho sự trừu tượng (abstraction) và sự triển khai implement có thể thay đổi một cách độc lập. Trong khi đó, Adapter được trang bị thêm để giúp cho các class không liên quan có thể làm việc cùng với nhau.

* Adapter cung cấp 1 interface khác hoàn toàn với Subject của nó. Proxy cung cấp 1 giao diện tương tự. Decorate cung cấp 1 giao diện nâng cao.

* Adapter thay đổi giao diện của 1 đối tượng hiện có. Decorate tằng thêm 1 đối tượng khác mà không làm thay đổi interface của nó. Do đó, Decorator minh bạch hơn cho Application hơn là Adapter. Kế quả, Decorate thường được hỗ trợ cho các thành phần đệ quy, đây là điều không thể với Adapter.

* Facade định nghĩa 1 giao diện mới, trong khi Adapter sử dụng lại 1 giao diện cũ. Lưu ý, Adapter giúp cho 2 giao diện có thể làm việc với nhau, thay vì xác định 1 giao diện hoàn toàn mới.

IS-A and HAS-A in OOP.

* IS-A là mối quan hệ cha - con, trong đó thằng mới được extends từ thằng ban đầu. Trong mối quan hệ này, thì thằng mới kia có thể override các method của thằng cha lại cho phù hợp với ngữ nghĩa của nó.
* HAS-A thì sử dụng cách khác, nó đưa thằng cha vào làm một properties của thằng mới. Thằng mới chỉ có thể sử dụng lại các method của thằng ban đầu