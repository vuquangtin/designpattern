package utilities;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import sun.management.VMManagement;

@SuppressWarnings("restriction")
public class FindJavaProcessId {

	public static void main(String[] args) {

		try {
			RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
			Field jvmField = runtimeMXBean.getClass().getDeclaredField("jvm");
			jvmField.setAccessible(true);

			VMManagement vmManagement = (VMManagement) jvmField
					.get(runtimeMXBean);
			Method getProcessIdMethod = vmManagement.getClass()
					.getDeclaredMethod("getProcessId");
			getProcessIdMethod.setAccessible(true);
			Integer processId = (Integer) getProcessIdMethod
					.invoke(vmManagement);
			System.out.println(processId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}