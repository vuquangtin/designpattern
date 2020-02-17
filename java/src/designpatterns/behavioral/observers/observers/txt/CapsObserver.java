package observers.txt;
/**
 * <h1>Observer</h1> Định nghĩa một sự phụ thuộc 1-nhiều giữa các đối tượng để
 * khi một đối tượng thay đổi trạng thái, tất cả phụ thuộc của nó được thông báo
 * và cập nhật một cách tự động.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class CapsObserver extends Observer{
	
	public CapsObserver(Subject subject){
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println("Upper Case Chars: " + countUpperCase());
		System.out.println("Lower Case Chars: " + countLowerCase());
	}
	
	private int countLowerCase(){
		String str = subject.getState();
		int count = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(Character.isLowerCase(str.charAt(i)))
				count++;
		}
		return count;
	}
	
	private int countUpperCase(){
		String str = subject.getState();
		int count = 0;
		
		for(int i = 0; i < str.length(); i++){
			if(Character.isUpperCase(str.charAt(i)))
				count++;
		}
		return count;
		
	}

}