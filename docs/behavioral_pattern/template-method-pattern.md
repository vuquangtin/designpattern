# Template Method Pattern - Behavioral Pattern
Bản chất của Template Pattern đó là nó định nghĩa sẵn một cấu trúc các method sẽ thực hiện, sau đó cho các thằng con override các method đó theo từng bản chất của nó.

Template được sử dụng khi ta có sẵn một cấu trúc từ trước, và muốn mở rộng nó thêm.

## Bài toán
Quay sang cửa hàng làm bánh nhòm ngó tí nào. Đối với B thì cuộc đời chỉ ăn và uống mà thôi.

Cửa hàng dạo này hoạt động cũng bình thường. Ngoài các bánh sinh nhật, bánh kỉ niệm, bánh ăn liền kia ra thì nay nó còn cung cấp thêm 1 dịch vụ khác, đó là bánh cưới.

Quy trình làm 1 cái bánh, dù là loại nào cũng chỉ theo đúng các bước, nhào bột, đổ khuôn, phết kem và trang trí.

Nhưng không có 1 thợ nào có đủ khả năng làm tất cả các loại bánh này. Điều này làm cho uy tín của cửa hàng bị giảm sút. Ông quyết định thay đổi cơ cấu nhân sự của mình.

## Giải pháp
Sau một thời gian dài tìm hiểu, ông quyết định sẽ chuyên môn hóa công việc của mình.

Ông nhận thấy rằng, việc làm bánh chỉ gồm 3 bước, nhào bột, đem nướng và trang trí. Các giai đoạn kia có thể khác nhau trong từng bước, nhưng cơ bản nó cần tuân thủ đúng nguyên tắc này.

Việc nhào bột thì đã có máy làm, nhưng đôi khi khách hàng muốn ăn bánh trứng, có lúc lại là bánh chocolate hoặc bánh nhân nho khô.

Việc trang trí thì cần tạo hình, phết kem, cắm bông lá cành và ghi chữ.

Mỗi công đoạn lại có các thủ thuật khác nhau, các ông đầu bếp ko ai giỏi toàn bộ, chỉ có người quen cái này và cũng có người quen cái kia.

Thay vì lúc trước ông có 5 dầu bếp, thì giờ đây ông phân thành 3 nhóm, nhóm bánh ăn liền, nhóm bánh sinh nhật và nhóm bánh cưới.

Và mặc dù nhân sự bị thay đổi, nhưng công đoạn làm bánh vẫn như cũ, vẫn gồm 3 bước, theo đúng thứ tự, nhào bột, đem nướng và trang trí và nó vẫn tiến hành bình thường. Sự thay đổi về mặt tổ chức khiến các bánh được sản xuất chất lượng hơn và đẹp đẽ hơn.

Đó là ví dụ của Template Method Design Pattern.

## Introduction
just define the skeleton of a function in an operation, deferring some steps to its subclasses
Về mặt bản chất, Template Method định nghĩa 1 bộ xương-skeleton của một thuật toán trong một hoạt động, trì hoãn một số step trong đó và đưa trách nhiệm đó cho các lớp con.

Method Template cho phép các lớp con xác định lại 1 số bước nhất định của thuận toán mà không làm thay đổi cấu trúc của thuật toán.

Trong mô hình này, Base Class khai báo các Placeholder trong khi đó các derived class implement các Placeholder Algorithm này.

## Implements
Việc implement tuân thủ các step sau:

Component Design cần xác định những bước step nào của algorithm là bất biến/standard và các step nào là biến thể / có thể là biến thể. Các lớp bất biến/standard được triển khai trong 1 Base Class, trong khi đó các biến thể kia được đưa vào các lớp con.
Component cũng define 1 method chính, templateMethod, method này quy định thứ tự các bước. Đồng thời nó cũng cho phép các Derived class có thể mở rộng hoặc thay thế một số bước của các step này.
Template Method Design Pattern được sử dụng rộng rãi trong các Framework. Mỗi Framework implement các invariant/standard pieces của 1 domain và định nghĩa các placeholder cho phép tùy chỉnh của khách hàng. Khi ta thực hiện điều này, framework trở thanh trung tâm của ứng dụng và các customization options kia chỉ đóng vai trò như những thứ bổ sung. Cấu trúc điều khiển đảo ngược này được gọi là Nguyên tắc Hollywood Don't call us, we'll call you.

Từ những phân tích trên, việc implement Template Pattern được thực hiện như sau:

Kiểm tra Algorithm và quyết định các step nào là tiêu chuẩn, các step nào là đặc thù với từng bước hiện tại.
Xác đinh 1 lớp trừu tượng (abstract class) để lưu trũ "framework".
Di chuyển templateMethod và định nghĩa của các standard step sang 1 base class (abstract class trên kia)
Define các Placeholder hoặc các hook trong base class cho mỗi yêu cầu triển khai khác nhau. Các phương thức này có thể là một lớp mặc định, hoặc cũng có thể là 1 abstract method.
Gọi các hook method từ template Method
Update lại các lớp hiện tại mà có mối quan hệ is-a với new abstract base class. Remove các duplicate method trong các class này bằng việc đối chiếu với các standard method trong abstract class.
Kiểm tra lại các chi tiết đặc thù của việc implement trong các lớp dẫn xuất.
Dưới đây là các lưu ý khi implement

Các bước thực hiện trong Template phải là cố định và được định nghĩa là final để tránh các lớp con ghi đè nó.

Việc kế thừa thường mang mục đích tái sử dụng các method của cha, nhưng trong trường hợp này, lớp cha lại gọi các method của lớp con. Cái này được gọi là "Don't call us, we will call you".

Các method trong base class mà ta ko muốn các lớp con ghi đè được gọi là Hooks. Nó có thể bị ghi đè bởi các lớp con, nếu muốn ngăn chặn thì ta phải set final cho nó.

## Advantages & Disadvantages
### Advantages
Mở rộng 1 lớp có sẵn mà không làm thay đổi cấu trúc của nó.

Việc sử dụng template khiến cấu trúc trở nên linh hoạt hơn, tính reuse tốt hơn. Ta có thể thoải mái mở rộng các class hiện tại bằng cách extend nó từ cái gốc ra/ cũng có thể extend từ chính các child class/derived class của nó và override lại các method đã có.

### Disadvantages
Nó không có quá nhiều nhược điểm, chỉ cần phân tích kĩ lưỡng tí là được.

## Usage
Khi ta có 1 lớp các class có cùng chức năng và ta muốn gom các method chung của nó lại để tránh việc trùng lặp code.

Khi ta muốn mở rộng 1 class có sẵn mà không muốn thay đổi cấu trúc bên trong của nó.

Khi ta muốn thay đổi một templateMethod bằng việc bổ sung/thay đổi các step của nó mà không làm thay đổi object hiện tại.

## Important things
Về mặt cơ bản, Strategies và Template Pattern khá giống nhau, nó chỉ khác nhau ở mức độ chi tiết của nó.

Template method sử dụng inheritance để thay đổi 1 phần của thuật toán, trong khi đó Strategy sử dụng ủy quyền để thay đổi toàn bộ thuật toán. Sự khác biệt ở đây là 1 bên chỉ thay đổi 1 phần, 1 bên thay đổi toàn bộ.

Strategy thay đổi logic của các đối tượng riêng lẻ, trong khi đó, Template Method thay đổi login của toàn bộ các lớp.

Factory Method à 1 specialization của Template Method.