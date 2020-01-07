# Template Method
> **Template Method** Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. Mẫu Template Method cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà không phải thay đổi cấu trúc thuật toán. <br/>

Template Method là một mẫu thiết kế hành vi xác định cấu trúc của thuật toán, nhưng cho phép các lớp con ghi đè các bước cụ thể của thuật toán mà không thay đổi cấu trúc của thuật toán.

Điều này có nghĩa là Template method giúp cho chúng ta tạo nên một bộ khung cho một vấn đề cần giải quyết. Trong đó các đối tượng cụ thể sẽ có cùng các bước thực hiện, nhưng trong mỗi bước thực hiện đó có thể khác nhau. Điều này sẽ tạo nên một cách thức truy cập giống nhau nhưng có hành động và kết quả khác nhau.
Pattern này đề nghị bạn nên break down thuật toán thành các step, đưa các step vào các method. Các method này có thể là abstract hoặc có default implementation.

## Lưu ý:
- Hook: đây là một optional step mới empty body. Một template method sẽ hoạt động khi cả khi một hook không bị ghi đè
- Thông thược ,các hook được đặt trước và sau các bước quan trọng của thuật toán, cung cấp cho các lớp con các điểm mở rộng bổ sung cho thuật toán.

## Cấu trúc của Template Method:

- Abstract Class: khai báo các phương thức đóng vai trò là các bước của thuật toán, thứ tự gọi các bước này. Các method có thể là abstract hoặc có default implementation.
- Concrete Classes: orverride lại các bước cần thiết, nhưng không được override phương thức template method.

##  Sử dụng Template Method khi:
- Khi bạn muốn client chỉ mở rộng các bước cụ thể của thuật toán, chứ không phải toàn bộ thuật toán hoặc toàn bộ thuật toán. Template Method sẽ giúp bạn break down một thuật toán thành các step nhỏ hơn, các step này có thể được dễ dàng mở rộng bởi các lớp con trong khi không phá vỡ cấu trúc của thuật toán.
- Khi bạn có nhiều đối tượng sử dụng chung thuật toán với một số thay đổi nhỏ. Và bạn muốn tất cả các class đó thay đổi khi bạn đổi thuật toán.

## Cách implement:
* B1: Phân tích thuật toán thành các step nhỏ. Xác định step nào là common cho tất cả các sub class, step nào là unique, không được override.
* B2: Tạo lớp abstract class, khi báo các method đại diện cho các bước của thuật toán. Step nào không cho phép class con override thì set "final" cho step đó. Một số step nên có default implementation, và subclass sẽ không bắt buộc override step này.
* B3: Nghĩ thêm về việc hook giữa các step của thuật toán.
* B4: Tạo các concrete class. Các class này sẽ implement tất các các class abstract method, và override method cần thiết cho chúng.


## Ưu điểm:
- Giảm duplicate code.
- Client cho override các step cần thiết, tránh sai sót.

## Nhược điểm:
- Một số client có thể bị giới hạn bởi cấu trúc của thuật toán.