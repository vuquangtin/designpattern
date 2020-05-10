package designpatterns.gof.behavioral.mediator.inline;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <h1>Mediator</h1> Định nghĩa 1 đối tượng đóng gói cách 1 tập hợp các đối
 * tượng tương tác. Mediator thúc đẩy sự khớp nối lỏng lẻo bằng cách ngăn không
 * cho các đối tượng đề cập đến nhau 1 cách rõ ràng và nó cho phép bạn thay đổi
 * sự tương tác của chúng 1 cách độc lập.
 * 
 * <br/>
 * 
 * Đèn giao thông có 3 màu: đỏ, vàng, xanh. Khi một đèn được mở thì những đèn
 * còn lại sẽ tắt. <br/>
 * Chương trình của chúng ta như sau: <br/>
 * <ul>
 * <li>Light: lớp chứa thông tin đèn giao thông, trạng thái (ON/OFF), giữ bộ
 * thông tin bộ điều khiển tín hiệu đèn (Mediator).</li>
 * <li>LightMediator : bộ điều khiển đèn thông thông, nhận thông báo khi một tín
 * hiệu đèn được mở, thực hiện tắt những đèn còn lại.</li>
 * <li>TrafficLightApp : khởi tạo Mediator, đăng ký các Light với Mediator. Thực
 * hiện bật các đèn theo khoảng thời gian 3 giây.</li>
 * </ul>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 * 
 *      /vuquangtin/designpattern</a>
 *
 */
public class AutoRotateTrafficLightApp {

	public static void main(String[] args) {

		LightMediator lightMediator = new LightMediator();
		Light[] lights = { new Light("Red", lightMediator), new Light("Green", lightMediator),
				new Light("Yellow", lightMediator) };

		int currentLightIndex = 0;
		Light light;
		while (true) {
			if (currentLightIndex >= lights.length) {
				currentLightIndex = 0;
			}
			light = lights[currentLightIndex];
			light.turnOn();
			timer();
			currentLightIndex++;
		}
	}

	private static void timer() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Light {

	enum State {
		ON, OFF
	}

	private String color;
	private LightMediator lightMediator;
	private State currentState;

	public Light(String color, LightMediator lightMediator) {
		this.color = color;
		this.currentState = State.OFF;
		this.lightMediator = lightMediator;
		lightMediator.registerLight(this);
	}

	public void turnOn() {
		this.currentState = State.ON;
		lightMediator.notifyMediator(this);
	}

	public void turnOff() {
		this.currentState = State.OFF;
		lightMediator.notifyMediator(this);
	}

	public String getColor() {
		return color;
	}

	public State getCurrentState() {
		return currentState;
	}

	@Override
	public int hashCode() {
		return color.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;

		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}

		Light light = (Light) obj;
		return color.equals(light.color);
	}
}

class LightMediator {
	private Set<Light> trafficSignals = new HashSet<>();

	public void registerLight(Light light) {
		trafficSignals.add(light);
	}

	public void unRegisterLight(Light light) {
		trafficSignals.remove(light);
	}

	public void notifyMediator(Light light) {
		System.out.printf("%s is turned %s \n", light.getColor(), light.getCurrentState());
		if (light.getCurrentState() == Light.State.ON) {
			turnOffAllOtherLights(light);
		}
	}

	private void turnOffAllOtherLights(Light light) {
		for (Light otherLight : trafficSignals) {
			if (!(light.equals(otherLight))) {
				otherLight.turnOff();
			}
		}
		System.out.println("---");
	}
}