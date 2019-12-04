# Object Pool Pattern - Creational Pattern
Object pool là một Pattern rất hữu ích khỉ sử dụng trong môi trường multiple threads, nơi mà ta cần giới hạn lại tài nguyên sử dụng để đảm bảo hiệu năng cho hệ thống.

Về mặt bản chất, Object Pool là một container chứa một số lượng cụ thể các Object. Thay vào việc liên tục tạo ra các Object mới, thì ta sẽ sử dụng 1 Object trong số Object Pools của nó.

Khi 1 Object được sử dụng, nó sẽ bị remove ra khỏi Object Pool này và nó sẽ không available trong Pool. Chỉ đến khi nó được sử dụng xong và trả về thì nó mới có thể được sử dụng tiếp được.

Mỗi một object trong pool đều có 1 vòng đời như nhau: creation, validation và destroy.

## Bài toán
Cửa hàng ngày càng đông, khác ra vào nườm nượp. Thế là ông chủ quyết định tuyển thêm 1 vài đầu bếp làm part-time nữa

Tuy nhiên, ông quên mất 1 việc, khi số lượng đầu bếp nhiều hơn, thì đồng nghĩa với việc các dụng cụ sử dụng trong kho cũng phải tăng.

Oái ăm thay, chi phí cho những vật tư đó rất nhiều tiền. Mà ông ko thể nào vì có 10 đầu bếp mà mua tới 10 cái lò nướng được

## Giải pháp
Cuối cùng ông quyết định, sẽ sử dụng lại toàn bộ những vật tư đó một cách thông minh.

Ông giao cho 1 người phụ tá làm nhiệm vụ quản lý cái này. Công việc của anh là sắp xếp và quản lý các vật tư.

Cửa hàng có 5 cái chảo, chúng được anh sắp xếp cùng 1 vị trí, mỗi khi có một đầu bếp cần xài, anh mang cho ông ta một cái.

Sau khi xài xong, họ sẽ có nhiệm vụ trả về chỗ cũ. Anh phục vụ lau rửa cái chảo và để lại trên giá, để những đầu bếp khác có thể xài.

Nếu 5 cái chảo đều đã được sử dụng, thì anh khuyên ông đầu bếp còn lại nên đi làm món nướng, trong thời gian chờ ai đó hoàn tất công việc của mình và cái chảo kia được trả về.

5 cái chảo đó là ví dụ của Object Pool, mỗi cái chảo là 1 Object

## Introduction
Object Pool Pattern says that "to reuse the object that are expensive to create".
Thông thường, khi một ứng dụng được triển khai thực sự, ngoài những vấn đề về implement này nọ, thì điều ta cần quan tâm nhất là hiệu năng. Đối với phần mềm, thì đó là việc một object được khởi tạo.

Về mặt bản chất, Object Pool là một container chứa một số lượng cụ thể/ hoặc không cũng được các Object. Thay vào việc liên tục tạo ra các Object mới, thì ta sẽ sử dụng 1 Object trong số Object Pools của nó.

Khi 1 Object được sử dụng, nó sẽ bị remove ra khỏi Object Pool này và nó sẽ không available trong Pool. Chỉ đến khi nó được sử dụng xong và trả về thì nó mới có thể được sử dụng tiếp được.

Mỗi một object trong pool đều có 1 vòng đời như nhau: creation, validation và destroy.

Object Pool giúp cho quản lý resource của hệ thống một cách tốt nhất. Nó có thể hiện hữu ở rất nhiều nơi, đặc biệt là trong các Application Server, data source pools, thread pools

Vì sao ta cần Pattern này
Singleton thì ko đủ, vì Singleton chỉ tạo ra 1 object duy nhất nên khi có nhiều thread cần nhiều object, ta ko thể sử dụng nó.

Prototype thì sao? Cũng có thể, nhưng đôi lúc Prototype lại ko đủ. Prototype dùng để clone toàn bộ/ 1 phần của Object, nhưng đôi khi ta cần 1 thứ khác đặc biệt hơn thế, ngoài phạm vi của Prototype.

Nếu ví dụ trên chưa đủ thuyết phục thì ta đi qua một ví dụ khác, Grab.

Grab là 1 dịch vụ book xe ôm giá rẻ. Vấn đề nó cũng vậy. Các Object của nó (các tài xế) là 1 tài nguyên có hạn, và không phải lúc nào cũng đủ số lượng tài xế để đáp ứng nhu cầu người dùng.

Vì vậy, khi khách hàng muốn gọi điện, họ liên lạc lên tổng đài - Object Pools, đòi hỏi 1 Object. Tổng đài - Object Pools, xem danh sách các tài xế - Object đang rảnh và tiến hành trả về/ accept nếu có, hoặc để khách hàng chờ đợi với dòng chữ "Đang tìm tài xế gần nhất" trên màn hình thay cho việc thông báo, ê, tìm thằng khác đi, tao hết xe rồi.

## Implements
Ý tưởng của Object Pool đó là dùng để quản lý 1 tập hợp các objects để tái sử dụng. Khi client cần sử dụng Object, thay vì tạo ra 1 đối tượng mới ta sẽ sử dụng Pool để trả về đối tượng đã có sẵn.

Nếu toàn bộ đối tượng trong Pool trống, các Client khác muốn dùng nó thì phải chờ.

Do đó, đối với Pools, thường sẽ tiếp cận theo 2 cách sau đây

new 1 Instance nếu Object chưa có sẵn
Khởi tạo trước 1 Pool chứa danh sách Object luôn từ đầu.
Cách implement nó như sau:

Tạo 1 Object Pools, là 1 Abstract Class. Class này cần 1 Array List - pool để chứa danh sách các Object, cần 1 biến lưu trữ số lượng tối thiểu - minObjs, cần thêm 1 biến lưu trữ số lượng tối đa - maxObjs, và cần thêm 1 duration để chạy task quản lý các object trong pool.

Abstract này cũng cần các method khác như borrowObject, lấy ra 1 object từ Pool, returnObject, dưa trả lại 1 free object vào Pool, một shutdownPool nếu thấy cần thiết.

Sau đó, tất nhiên là 1 Concrete Object nào đó để đưa vào pool rồi.

Việc implement cái này phụ thuộc nhiều vào mục đích. Tuy nhiên, nó đều xây dựng trên nguyên tắc.

Cung cấp 1 method cho phép trả về 1 object từ pool. Method này kiểm tra xem trong pool có object free hay ko thì trả về, nếu chưa có và số lượng object trong pool ít hơn mức quy định thì khởi tạo 1 object khác và đưa vào pool, nếu số lượng object đã lớn hơn mức quy định thì thôi, trả về null cho nó khỏi có làm luôn.
Khi 1 object đã hoàn thành xong nhiệm vụ, nó sẽ được trả lại Object Pool. Object Pool mang object này đưa vào trong pool của nó thay vì destroy luôn cái object đó.
Một thread để chạy validate pool đó theo yêu cầu, để đảm bảo rằng số lượng object được lưu trữ trong pool không quá nhiều, tốn tài nguyên. method này được repeat theo thời gian của validation duration mà ta set vào trước đó, kiểm tra danh sách các Object trong pool, remove những thằng đang free quá lâu và đảm bảo số lượng object trong Pool lớn hơn hoặc bằng số lượng object mà ta quy định, hoặc shutdown luôn cái pool nếu muốn.
String Pool của Java cũng là 1 ví dụ của Object Pool, nó khác là vì String là immutable class nên nó sẽ ko cần phải trả về, và cũng có thể sử dụng mà không cần chờ các Object khác sử dụng xong.

Xem lại bài String Pool để biết thêm chi tiết. Tóm tắt, nếu ta sử dụng toán tử = để tạo 1 String, Java sẽ kiểm tra xem giá trị này có tồn tại trong String Pool của nó ko, nếu có thì trả về, nếu ko thì tạo 1 cái Object trong đó rồi return nó về. Toán tử này khác toán tử new, Với new String("abcdef") thì đó là 1 object độc lập. Nó nằm ở bộ nhớ khác (quên rồi) chứ không nằm trong Pool đâu nhé.

## Advantages & Disadvantages

### Advantages
Tăng hiệu suất của hệ thống bằng cách tận dụng những gì có sẵn. Tài nguyên ở đây gồm cả 2 thứ, tài nguyên khởi tạo - create và tài nguyên hủy bỏ - destroy. Chính điều này làm tăng hiệu năng của hệ thống khi không cần phải tạo quá nhiều instance

Nó có hiệu quả lớn nhất khi tốc độ khởi tạo của 1 Class cao

Quản lý các kết nối và cung cấp cách thức để có thể sử dụng lại - reuse và chia sẻ - share

Điều chỉnh linh hoạt số lượng tối đa object được tạo, như ở trên.

### Disadvantages
Trong Object Pool, thứ quan trọng nhất không phải implement mà là cần xác định số lượng các object tối đa trong pool. Nếu số lượng quá nhiều thì dễ dư thừa bộ nhớ, nếu số lượng quá ít thì không đủ.

Tương tự như vậy, ta cũng cần quản lý thời gian tồn tại tối đa của 1 đối tượng trong pool. Điều quan trọng ở đây đó là phải xác định xem có cần thiết hủy bỏ đối tượng để giải phóng bộ nhớ hay không. Nếu một object bị giữ bởi 1 client quá lâu thì ta có cần thiết set timeout để giải phóng nó cho đối tượng khác xài hay không. Và nếu khi 1 client chờ quá lâu khi tất cả các object trong pool đều bận thì ta cần làm gì, sẽ tiếp tục chờ hay throw 1 exception/

Một vấn đề cần xem xét nữa , đó là ta cần làm gì khi Pool không có bất cứ Object nào. Không có bất cứ Object không có nghĩa là pool trống, mà là toàn bộ các object đều đang busy. Khi này hoặc ta quyết định tạo thêm object cho đến khi nó đạt giá trị max, hoặc ta để client chờ, hoặc throw 1 exception ngay lập tức/ sau một khoảng thời gian chờ đợi.

Điều cuối cùng mà ta cần quan tâm, đó là trạng thái của Object sau khi trả về. Sau khi được các client "mượn", các object có thể bị "bẩn" đi, ta có cần để các object sạch trở lại, hay vẫn giữ nguyên trạng thái cũ, hay điểu chỉnh nó sang một trạng thái hợp lý nào đó. Nếu ta không làm tốt bước này có thể dẫn đến những nguy cơ như rò rỉ thông tin, data không nhất quán, hoặc behavior không chính xác.

## Usage
Khi một ứng dụng cần các đối tượng với chi phí khởi tạo lớn. Ví dụ connection trong database. Mỗi request = 1 connection thì ko có database nào chịu nổi cả, thay vì vậy ta dùng 1 pool để giới hạn lại số lượng này, vừa đảm bảo hiệu năng, vừa đảm bảo chất lượng service không gián đoạn.

Khi cần phục vụ các client cần cùng 1 resource ở những thời điểm khác nhau. Ví dụ Client A cần 1 resource, mà việc process này quá phức tạp, khi này nếu destroy luôn cái Object chịu trách nhiệm handle việc đó, thì khi Client B cũng cần cái resource đó, tại 1 thời điểm khác, nó sẽ trở nên tốn kém hiệu năng.

Một ví dụ tốt về cái usage thứ 2 là chức năng export của CMS. CMS có 1 table dùng để chứa các product đã được export. Nếu như bình thường, cái task export Product cần quá nhiều thời gian để làm, và làm xong thì shutdown luôn, thì khi có nhiều người cùng export 1 resource, chi phí đó sẽ đẩy lên cao. Thay vì vậy, mỗi lần process xong, nó lại add 1 record vào database, lưu đường dẫn tới file đó, để lần sau ai đó vào có thể lấy được zip file kia về mà ko tốn thời gian export lại. Tuy nhiên, dung lượng của Zip file quá lơn, nếu chỉ save mà ko xóa thì dần dần cái folder đó sẽ rất nặng. Vì vậy, sau 1 thời gian, hoặc khi có sự biến động, thì 1 số file không cần thiết trong đó sẽ được remove đi để tiết kiệm dung lươngk

## Summary
Object Pool là một pattern rất hay khi ta muốn sử dụng lại những tài nguyên của hệ thống, vì chi phí khởi tạo nó quá lớn.

Để tránh việc tràn bộ nhớ hay tương tự vậy, thì cần có cách kiểm soát số lượng trong pool hiệu quả.