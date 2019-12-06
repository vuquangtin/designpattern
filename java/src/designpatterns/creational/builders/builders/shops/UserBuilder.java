package builders.shops;

import java.util.Date;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class UserBuilder {

	private Builder builder;
	@SuppressWarnings("unused")
	private int id;

	public UserBuilder(Builder builder) {
		this.builder = builder;
	}

	public int getId() {
		return builder.getId();
	}

	public void setId(int id) {
		this.id = id;
	}

	public static class Builder {
		private int id;
		private String name;
		private String email;
		private Date birthday;
		private int weight;
		private int height;
		private int groupId;
		private int companyId;

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setBirthday(Date birthday) {
			this.birthday = birthday;
			return this;
		}

		public Builder setWeight(int weight) {
			this.weight = weight;
			return this;
		}

		public Builder setHeight(int height) {
			this.height = height;
			return this;
		}

		public Builder setGroupId(int groupId) {
			this.groupId = groupId;
			return this;
		}

		public Builder setCompanyId(int companyId) {
			this.companyId = companyId;
			return this;
		}

		public UserBuilder build() {
			validate();
			return new UserBuilder(this);
		}

		private void validate() {
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}

		public Date getBirthday() {
			return birthday;
		}

		public int getWeight() {
			return weight;
		}

		public int getHeight() {
			return height;
		}

		public int getGroupId() {
			return groupId;
		}

		public int getCompanyId() {
			return companyId;
		}

	}

}
