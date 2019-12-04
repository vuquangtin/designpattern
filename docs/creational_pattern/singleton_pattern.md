# Singleton Pattern
Đảm bảo một lớp chỉ có 1 thể hiện và cung cấp 1 điểm truy cập global cho nó.

Just in time Initialization hoặc initialization on fisst use.

## Bài toán
Trong một công ti nọ, có rất nhiều nhân viên kế toán. Mỗi nhân viên kế toán này lo việc làm dịch vụ cho những công ti khác nhau.

Công việc thì nhiều, nhân viên thì ít, thế là mỗi ngày chúng phải thường xuyên đi lấy hồ sơ khách hàng.

Cả công ti chỉ có 1 các xe dịch vụ, mà lũ kế toán thì nhiều. Thế là suốt ngày chúng nó cãi nhau chí chóe đòi xe này nọ. Đã thế, cách xa 5km mà nó đi tới 1h chưa về.

Những điều này làm bà trưởng phòng thấy khó chịu lắm lắm.

## Giải pháp
Một ngày đẹp trời, có 1 con bé dở hơi xin vào làm. Nó vừa đen còn lắm lông, đã thế lại ko biết gì, nhưng lại là cháu của đứa bạn chí cốt.

Bà này thấy vậy trầm tư suy nghĩ mãi, nhận nó thì ko được, mà ko nhận nó thì lại mất lòng. Thôi thì cứ nhắm mắt đưa tay, cho nó vào làm chân sai vặt

Thế là từ đó về sau, bà cho nó đi thay lũ nhân viên đi lấy hồ sơ, và từ đó, công việc của tụi kia nhanh hơn hẳn, có muốn trốn đi chơi cũng ko còn cơ hội nữa.

Cái con sai vặt kia chính là Singleton - Một đối tượng duy nhất trong phòng, mà mọi người có quyền sử dụng nó để đi lấy hồ sơ cho mình. Ví dụ thì thấy ko sát nghĩa lắm nhưng thực chất là thế còn gì.

Trong lập trình, ở một vài trường hợp, ta chỉ muốn sử dụng một object để đảm nhận một nhiệm vụ nào đó duy nhất ở trong hệ thống, khi đó ta sử dụng mẫu thiết kế Singleto Ví dụ như các connect tới db, các Utils Object, các Object quản lý đọc file, ....

Quay lại những bài trước, anh phục vụ ở đây cũng là một singleton. Anh ấy đảm nhận việc cung cấp nguyên liệu cho các thực đơn cho những đầu bếp, và chỉ có duy nhất 1 anh như thế trong cửa hàng. Nhưng nếu ông chủ thương mà thuê thêm 1 anh khác nữa, thì khi đó anh này ko còn là Singleton nữa đâu nhé.

## Introduction
Singleton Pattern says that just "define a class that has only one instance and provides a global point of access to it".
Singleton là một mẫu design khá phổ biến, được sử dụng rất rất nhiều trong hệ thống.

Đôi khi trong một hệ thống, ta chỉ cần 1 và chỉ 1 instance của 1 object. Ngoài ra ta cũng cần quan tâm tới lazy initialization và global access tới nó.

Khi ta xem xét sử dụng Singleton Pattern, ta cần kiểm tra lại 3 tiêu chí sau:

Quyền sở hữu của single instance không thể phân phối một cách hợp lý. Nói cách khác, muốn hạn chế quyền truy cập/ khởi tạo.
Lazy Initialization là thực sự cần thiết
Global access
Nếu quyền sở hữu, khi nào, và làm sao việc khởi tạo xảy ra, và global access không phải là vấn đề, thì ta ko cần phải sử dụng Pattern này làm gì cho phiền phức.

Gọi là Singleton, nhưng đôi khi nó có thể được mở rộng để đáp ứng một vài yêu cầu đặc biệt.

Thường ta có 1 cách dễ nhất để tạo singleton, đó là sử dụng static method. Nhưng cách tiếp cận này không support subclassing của Singleton class.

## Implements
Để tạo ra một Singleton, ta cần làm các bước sau:

Khai báo 1 private static attribute trong single instance class.
Khai báo 1 public static accessor function trong clas này
THực hiện lazy initialization (creation on first use) trong accessor function
Biến toàn bộ các constructor của nó thành private hoặc protected
Client chỉ có thể sử dụng accessor function để thao tác với Singleton.

Dưới đây là các cách triển khai lazy loader.

### Static binding.
Cách đơn giản nhất để đảm bảo 1 object là duy nhất, đó là chúng ta sẽ khai báo static final và khởi tạo nó ngay từ thời điểm load class.

Nhược điểm của cái này đó là đôi lúc không sử dụng object đó nhưng nó vẫn được khởi tạo, vì vậy nó gây lãng phí và ảnh hưởng đến hiệu năng của hệ thống.

### Lazy Loader
Lazy holder tức là trì hoãn việc khởi tạo object. Khác với trường hợp static binding, cái này lúc đầu nó chưa init Instance vội, mà đợi khi có method getInstance - tức là khi nó được sử dụng - thì lúc này nó mới init lên.

Nhược điểm của cái này đó chính là trong môi trường multiple thread, có thể xảy ra trường hợp 2 thread cùng gọi method getInstance này khi nó chưa được khởi tạo, và vô tình cả 2 cùng create lên 2 object. Điều này làm vi phạm tính chất của singleton. Do đó, trong kĩ thuật này người ta sẽ phải khai báo synchronized để đồng bộ hóa 2 thread này, và đảm bảo là chỉ có 1 method được gọi - được khởi tạo - instance này tại 1 thời điểm.

Chính vì cái synchronized mà hiệu năng của hệ thống sẽ chậm.

### Double Check Singleton
Double check Singleton là một kĩ thuật ra đời nhằm khác phục nhược điểm của cái Lazy Loader trên kia. Bản chất nó cũng là 1 lazy holder, và nó cũng tiếp cận theo cách - Chỉ khởi tạo object khi nó được sử dụng.

Tuy nhiên, thay vì synchronized cái method getInstance thì nó lại synchronized cái block code lúc khởi tạo object và sử dụng từ khóa volatile để cập nhật lại trạng thái của các thread khác khi thread này kết thúc.

Với kĩ thuật này, nó kiểm tra 2 lần, 1 lần check khi bắt đầu chuẩn bị new instance, một lần check trước khi khởi tạo object trong đoạn synchronized code và đó là lý do mà nó được gọi là Double Check.

Double Check giải quyết được vấn đề của Lazy Loader nhưng nó chưa phải là cách hay nhất.

### Lazy Holder
Kĩ thuật này được đánh giá là hay nhất trong việc khai báo một singleton

Như ta đã biết, Trong java, khi một class được sử dụng, thì nó mới được load vào bởi Class Loader. Và trong quá trình này, Class Loader sẽ làm các bước bao gồm loading, linking, initialization. Chính tại bước Initialization này các giá trị static của nó sẽ được init và khởi tạo

Chính nhờ yếu tố này, ta sẽ trì hoãn việc khởi tạo các instance bằng cách khai báo các inner class.

Chỉ khi inner class được gọi, nó mới được load vào thông quan Class Loader, khi nó đang load thì ko có thread nào có thể sử dụng, khi nó load xong rồi thì cũng đã init rồi. Vì vậy, cái này vừa ko phải lo vấn đề multiple thread, vừa không cần phải khai báo synchronized và vừa là lazy loaded. Do đó nó là tối ưu nhất.

### Enum
Tương tự Lazy holder, Class chỉ được load khi mà nó được gọi lần đầu tiên. Và tính chất của nó thì tương tự trên kia.

## Advantages & Disadvantages
### Advantages
Sử dụng 1 instance trong toàn hệ thống giúp ta tiết kiệm tài nguyên và chi phí, đặc biệt là với các Object mà cần nhiều tài nguyên.

Giới hạn số lượng Instance của class giúp ta kiểm soát nó dễ hơn.

### Disadvantages
Nhược điểm của nó là cần cẩn thận thực hiện theo 3 điều trên để tránh làm phá vỡ Pattern.

Trong môi trường multiple thread thì cần quan tâm tới việc data của nó có cần consistency giữa các thread hay ko?

Cách triển khai hơi phức tạp và cần cẩn thận trong môi trường đa nhiệm.

## Usage
Khi hệ thống chỉ cần 1 và chỉ 1 instance và cần cung cấp 1 global point để truy cập vào nó.

Ví dụ trong môi trường multiple thread, và database application. Đặc biệt là logging, catching, thead pools, configuration, setting.

## Important things
Abstract Factory, Builder, và Prototype đều có thể sử dụng singleton trong quá trình thực hiện.

Facade objects thường là các singleton, bởi vì chỉ cần 1 đối tượng Facade mà thôi. Xem facade pattern ở mục duwois.

State object thường là singleton

Ưu điểm của Singleton so với global variable là ta hoàn toàn chắc chắn về số lượng instance khi ta sử dụng Singleton, và ta có thể thay đổi quyết đinh và quản lý bất kì một number instance. Ví dụ như Object pool chẳng hạn.

Singleton là 1 trong số các pattern được sử dụng không phù hợp nhất. Singleton chỉ nên được sử dụng khi 1 lớp phải có chính xác 1 instance, không hơn không kém. Thường ta hay sử dụng Singleton trong 1 nỗ lực sai lầm để thay thế cho các biến global. Nếu ta sử dụng singleton với ý định và mục đích như 1 global object, thì đó ko phải là singleton. đó chỉ là ta đổi tên cái global variable đó mà thôi.

Vậy, trường hợp nào Singleton là ko cần thiết. Đơn giản nhất, hầu hết là ko cần thiết. Cụ thể hơn, khi việc pass 1 object resource như 1 tham chiếu đến 1 đối tượng cần nó đơn giản, thay vì để các đối tượng truy cập đến các global resources. Vấn đề thực sự của singleton đó là Pattern này cung cấp cho ta một lý do hợp lý để không cần suy nghĩ cẩn thận về khả năng visible của 1 đối tượng.

Và điều cuối cùng, mục đích của Singleton không phải là Global object. Vì vậy, khi sử dụng cái Singleton này cần xem xét cái này. Singleton phải thỏa mãn 3 yếu tố ở trên: Ownership, Lazy initialyze và Global Access.