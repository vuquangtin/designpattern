package prototypes.serializables;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * <h1>Prototype</h1> Xác định các kiểu của các object (đối tượng) muốn tạo ra
 * bằng cách sử dụng một prototype (khuôn mẫu,nguyên mẫu), và tạo ra những
 * object (đối tượng) mới bằng cách sao chép prototype này.
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
public class ProtoType implements Cloneable,Serializable{
	   private static final long serialVersionUID = 1L;  
	    private String string;  
	  
	    private SerializableObject obj;  
	  
	    /* 浅复制 */  
	    public Object clone() throws CloneNotSupportedException {  
	    	ProtoType proto = (ProtoType) super.clone();  
	        return proto;  
	    }  
	  
	    /* 深复制 */  
	    public Object deepClone() throws IOException, ClassNotFoundException {  
	  
	        /* 写入当前对象的二进制流 */  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	        ObjectOutputStream oos = new ObjectOutputStream(bos);  
	        oos.writeObject(this);  
	  
	        /* 读出二进制流产生的新对象 */  
	        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
	        ObjectInputStream ois = new ObjectInputStream(bis);  
	        return ois.readObject();  
	    }  
	  
	    public String getString() {  
	        return string;  
	    }  
	  
	    public void setString(String string) {  
	        this.string = string;  
	    }  
	  
	    public SerializableObject getObj() {  
	        return obj;  
	    }  
	  
	    public void setObj(SerializableObject obj) {  
	        this.obj = obj;  
	    }   
	  
	class SerializableObject implements Serializable {  
	    private static final long serialVersionUID = 1L;  
	}  
}
