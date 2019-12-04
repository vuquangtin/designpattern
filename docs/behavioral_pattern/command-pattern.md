# Interpreter Pattern - Behavioral Pattern
Interpreter là một design pattern ít được sử dụng nhất vì tính đặc thù của nó.

Theo định nghĩa, nó được sử dụng để định nghĩa một biểu diễn ngữ pháp cho một ngôn ngữ và cung cấp một Thông dịch viên để xử lý ngôn ngữ này.

Ví dụ đơn giản nhất của nó là Google Translate, chỉ cần nhập vào một đoạn tiếng Việt và bụp cái, ta có thể chuyển sang tất cả các kiểu ngôn ngữ khác nhau.

Hay là cũng là 1 kiểu ngày tháng, mà ta có thể xuất ra những định dạng khác nhau. Ví dụ 20 - 12 - 2018 đổi thành 12 - 20 - 2010 hay 12/20/08 hay 20-Dec-18, .... Đó cũng là một thể hiện của Interpreter Pattern.

## Bài toán
________________________________
## Giải pháp
________________________________
## Introduction
________________________________
## Implements
Để sử dụng Interpreter ta cần implement các thành phần sau:

Interpreter Context Engine: thực hiện công việc diễn giải (interpretation)
Expression: consume the functionalities provided by the interpreter.
Client : Take input from user and decided which expression to use and then generate output for the user.

Interpreter cũng sử dụng if else để xác định output. Vậy liệu nó và cái Factory có khác nhau ko?

Về mặt bản chất, Factory nó trả lại object, còn ở đây thì nó trả lại/ sử dụng 1 method.

Condition trong Factory là điều kiện để phân biệt object, còn Condition trong Interpreter là điều kiện của ngữ cảnh - Context.

Giả sử trong bài toán phiên dịch, nếu như sử dụng Factory thì ta phải new rất nhiều nhiều nhiều Object, tùy thuộc vào tham số truyền vào. Tuy nhiên đối với Interpreter thì ta chỉ việc set cho cái Context ban đầu là được.

## Advantages & Disadvantages
Advantages
__________

Disadvantages
__________

Usage
__________

## Summary
Interpreter Pattern được sử dụng khi chúng ta có thể create một syntax tree cho Grammar mà ta đã có

Interpreter sử dụng rất nhiều error checking và expression, và code để process nó, nó sẽ vô cùng phức tạp khi grammar trở nên phức tạp và cung cấp hiệu quả. Tóm lại nếu ít thì dùng, nếu nhiều thì thôi ngh