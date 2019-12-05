<div align="center">
<img src="https://github.com/alexprut/design-patterns-java/raw/master/logo.png" height="300" height="auto"/>
<h1>Design Patterns in Java</h1>
<p>Classic OOP Design Patterns from <a href="https://en.wikipedia.org/?title=Design_Patterns">GoF</a>, implemented in Java.</p>
</div>
<br />

Design Patterns Implemented (vi)
---------------------------
#### Structural
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-class-adapter.png) –
[Class Adapter](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/class_adapter)
— _Chuyển interface của một lớp thành interface khác mà các client mong muốn. Adapter để cho các lớp làm việc với nhau dù có thể các interface không tương thích._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-object-adapter.png) –
[Object Adapter](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/object_adapter)
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-facade.png) –
[Facade](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/facade)
— _Cung cấp một interface thống nhất cho một tập các interface trong một hệ thống con (subsystem). Façade định nghĩa một interface mức cao làm cho hệ thống con dễ dàng sử dụng hơn._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-composite.png) –
[Composite](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/composite)
— _Các đối tượng cấu thành các cấu trúc cây để mô tả bán toàn bộ hệ thống phần cấp. Composite để cho các client tác động các đối tượng riêng biệt và các thành phần của đối tượng một cách thống nhất._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-decorator.png) –
[Decorator](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/decorator)
— _Gán bổ sung các “trách nhiệm” (responsibility) cho một đối tượng một cách linh hoạt. Các decorator cung cấp một sự lựa chọn linh động cho lớp con để mở rộng tính năng_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-proxy.png) –
[Proxy](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/proxy)
— _Cung cấp một đối tượng thay thế hoặc giữ chỗ placeholder cho một đối tượng khác để truy xuất đến nó._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-flyweight.png) –
[Flyweight](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/flyweight)
— _Sử dụng việc chia sẻ để hỗ trợ số lượng lớn các dt fine-graied cỡ nhỏ 1 cách hiệu quả_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-bridge.png) –
[Bridge](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/bridge)
— _Tách một abstraction khỏi implementation của nó để cả hai có thể thay đổi độc lập nhau._

#### Creational
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-factory-method.png) –
[Factory Method](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/factory_method)
— _Cung cấp 1 giao diện để tạo ra đối tượng nhưng để lớp con quyết định kiểu đối tượng nào sẽ dc tạo._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-abstract-factory.png) –
[Abstract Factory](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/abstract_factory)
— _Cung cấp một interface để tạo ra 1 họ các object (đối tượng) có liên quan hoặc phụ thuộc lẫn nhau mà không chỉ rõ các lớp cụ thể của chúng (concrete classes)._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-prototype.png) –
[Prototype](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/prototype)
— _Xác định các kiểu của các object (đối tượng) muốn tạo ra bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những object (đối tượng) mới bằng cách sao chép prototype này._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-singleton.png) –
[Singleton](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/singleton)
— _Đảm bảo rằng một class (lớp) chỉ có duy nhất một instance (thể hiện), và cung cấp một điểm chung, toàn cục để truy cập vào lớp đó._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-builder.png) –
[Builder](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/builder)
— _Tách biệt việc xây dựng của một đối tượng phức tạp khỏi phần biểu diễn của nó sao cho cùng 1 tiến trình xây dựng có thể tạo ra các biểu diễn khác nhau._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-builder.png) –
[Simple Factory](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/builder)
— _Tạo ra các đối tượng mà không để lộ việc tạo ra đối tượng đó như thế nào khi sử dụng._

#### Behavioral
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-template-method.png) –
[Template Method](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/template_method)
— _Định nghĩa 1 bộ khung của 1 thuật toán trong 1 chức năng (thao tác) chuyển giao việc thực hiện nó cho lớp con. mẫu tm cho phép lớp con định nghĩa lại cách thực hiện của 1 thuật toán mà không phải thay đổi cấu trúc thuật toán._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-strategy.png) –
[Strategy](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/strategy)
— _Định nghĩa tập hợp các thuật toán, đóng gói từng thuật toán lại, và làm chúng hoán đổi lẫn nhau. Strategy cho phép thuật toán biến đổi độc lập khi người dùng sử dụng chúng._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-state.png) –
[State](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/state)
— _cho phép 1 đối tượng thay đổi hành vi khi trạng thái của chính nó thay đổi. Đối tượng sẽ xuất hiện để thay đổi lớp của nó._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-command.png) –
[Command](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/command)
— _Đóng gói một yêu cầu request như một đối tượng, bằng cách đó cho phép bạn tham số hóa các client với các request khác nhau, các queue và log request, và hỗ trợ các hoạt động (operation) có thể “undo”._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-observer.png) –
[Observer](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/observer)
— _Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo và cập nhật một cách tự động._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-mediator.png) –
[Mediator](https://github.com/vuquangtin/designpattern/blob/master/src/com/designpatterns/gof/behavioral/mediator/gof/GOF.java)
— _Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi sự tương tác của chúng 1 cách độc lập._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-memento.png) –
[Memento](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/memento)
— _Không vi phạm tính đóng gói, nó nắm bắt và hiệu chỉnh trạng thái bên trong của đối tượng để đối tượng có thể được khôi phục về trạng thái này sau đó._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-iterator.png) –
[Iterator](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/iterator)
— _Cung cấp một cách để truy xuất các thành phần của một đối tượng hợp nhất một cách tuần tự mà không cho thấy sự biểu diễn representation bên dưới của nó_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-visitor.png) –
[Visitor](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/visitor)
— _Biểu diễn 1 hoạt động (thao tác, thuật toán) được thực hiện trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1 phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-chain-of-responsability.png) –
[Chain of Responsability](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/chain_of_responsibility)
— _Tránh sự liên kết trực tiếp giữa đối tượng gửi yêu cầu và đối tượng nhận yêu cầu, khi yêu cầu có thể dc sử lý bởi hơn 1 đối tượng. móc nối các đối tượng nhận yêu cầu thành 1 chuỗi và gửi yêu cầu theo chuỗi đó cho đến khi có đối tượng xử lý nó._
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-chain-of-responsability.png) –
[Interpreter](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/chain_of_responsibility)
— _Định nghĩa 1 biểu diễn ngữ pháp của 1 ngôn ngữ cụ thể, cùng với 1 thông dịch viên sử dụng biểu diễn này để diễn dịch các câu trong ngôn ngữ._

Design Patterns Implemented (En)
---------------------------
#### Structural
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-class-adapter.png) –
[Class Adapter](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/class_adapter)
— _allows classes with incompatible interfaces to work together by wrapping its own interface around that of an already existing class_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-object-adapter.png) –
[Object Adapter](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/object_adapter)
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-facade.png) –
[Facade](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/facade)
— _provides a simplified interface to a large body of code_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-composite.png) –
[Composite](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/composite)
— _composes zero-or-more similar objects so that they can be manipulated as one object_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-decorator.png) –
[Decorator](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/decorator)
— _dynamically adds/overrides behaviour in an existing method of an object_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-proxy.png) –
[Proxy](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/proxy)
— _provides a placeholder for another object to control access, reduce cost, and reduce complexity_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-flyweight.png) –
[Flyweight](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/flyweight)
— _reduces the cost of creating and manipulating a large number of similar objects_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-bridge.png) –
[Bridge](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/structural/bridge)
— _decouples an abstraction from its implementation so that the two can vary independently_

#### Creational
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-factory-method.png) –
[Factory Method](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/factory_method)
— _creates objects without specifying the exact class to create_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-abstract-factory.png) –
[Abstract Factory](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/abstract_factory)
— _groups object factories that have a common theme_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-prototype.png) –
[Prototype](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/prototype)
— _creates objects by cloning an existing object_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-singleton.png) –
[Singleton](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/singleton)
— _restricts object creation for a class to only one instance_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-builder.png) –
[Builder](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/creational/builder)
— _constructs complex objects by separating construction and representation_

#### Behavioral
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-template-method.png) –
[Template Method](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/template_method)
— _defines the skeleton of an algorithm as an abstract class, allowing its subclasses to provide concrete behavior_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-strategy.png) –
[Strategy](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/strategy)
— _allows one of a family of algorithms to be selected on-the-fly at runtime_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-state.png) –
[State](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/state)
— _allows an object to alter its behavior when its internal state changes_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-command.png) –
[Command](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/command)
— _creates objects which encapsulate actions and parameters_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-observer.png) –
[Observer](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/observer)
— _is a publish/subscribe pattern which allows a number of observer objects to see an event_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-mediator.png) –
[Mediator](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/mediator)
— _allows loose coupling between classes by being the only class that has detailed knowledge of their methods_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-memento.png) –
[Memento](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/memento)
— _provides the ability to restore an object to its previous state (undo)_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-iterator.png) –
[Iterator](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/iterator)
— _accesses the elements of an object sequentially without exposing its underlying representation_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-visitor.png) –
[Visitor](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/visitor)
— _separates an algorithm from an object structure by moving the hierarchy of methods into one object_
* [UML](https://github.com/alexprut/design-patterns-java/tree/master/src/main/resources/img/uml-chain-of-responsability.png) –
[Chain of Responsability](https://github.com/alexprut/design-patterns-java/tree/master/src/main/java/design_patterns/behavioral/chain_of_responsibility)
— _delegates commands to a chain of processing objects_

License
=======
Licensed under [MIT](https://github.com/vuquangtin/designpattern).