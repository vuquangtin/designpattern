package designpatterns.gof.behavioral.visitor.inline2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>Visitor</h1>Diễn tả 1 hoạt động (thao tác, thuật toán) được thực hiện
 * trên các phần tử của 1 cấu trúc đối tượng. Visitor cho phép bạn định nghĩa 1
 * phép toán mới mà không thay đổi các lớp của các phần tử mà nó thao tác
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/designpattern">https://github.com
 *      /vuquangtin/designpattern</a>
 *
 */
class EnterpriseUser implements User {
	private String name;
	private List<String> vacantJobs = new ArrayList<String>();

	public EnterpriseUser(String name) {
		this.name = name;
		vacantJobs = Arrays.asList("测试工程师", "软件工程师");
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitEnterpriseInfo(this);
	}

	public String getEnterpriseInfo() {
		return String.format("企业用户信息:公司名%s", name);
	}

	public String getVacantJobsInfo() {
		return String.format("%s招聘的岗位:%s", name, vacantJobs.toString());
	}
}

class JobInfoVisitor implements Visitor {
	@Override
	public String visitPersonInfo(PersonUser personUser) {
		return personUser.getWantedJobsInfo();
	}

	@Override
	public String visitEnterpriseInfo(EnterpriseUser enterpriseUser) {
		return enterpriseUser.getVacantJobsInfo();
	}
}

class JobManager {
	private List<User> users = new ArrayList<User>();

	public void addUser(User user) {
		users.add(user);
	}

	public int getUserCount() {
		return users.size();
	}

	public String visitUserInfo(Visitor visitor) {
		StringBuilder message = new StringBuilder();
		for (User user : users) {
			message.append(user.accept(visitor)).append("\n");
		}

		return message.toString();
	}
}

class PersonUser implements User {
	private String name;
	private List<String> wantedJobs = new ArrayList<String>();

	public PersonUser(String name) {
		this.name = name;
		wantedJobs = Arrays.asList("开发工程师", "网页设计师");
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visitPersonInfo(this);
	}

	public String getPersonInfo() {
		return String.format("个人用户信息:姓名%s", name);
	}

	public String getWantedJobsInfo() {
		return String.format("%s应聘的岗位:%s", name, wantedJobs.toString());
	}
}

interface User {
	String accept(Visitor visitor);
}

class UserInfoVisitor implements Visitor {
	@Override
	public String visitPersonInfo(PersonUser personUser) {
		return personUser.getPersonInfo();
	}

	@Override
	public String visitEnterpriseInfo(EnterpriseUser enterpriseUser) {
		return enterpriseUser.getEnterpriseInfo();
	}
}

interface Visitor {
	String visitPersonInfo(PersonUser personUser);

	String visitEnterpriseInfo(EnterpriseUser enterpriseUser);
}