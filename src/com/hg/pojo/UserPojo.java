/**
 * 
 */
package com.hg.pojo;

/**
 * @author 96458
 *此类是与数据库中字段名一致时的情况
 */
public class UserPojo {
	
		
		private int id;
		private String username;
		private String psw;
		
		

		@Override
		public String toString() {
			return "UserPojo [id=" + id + ", username=" + username + ", psw=" + psw + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPsw() {
			return psw;
		}
		public void setPsw(String psw) {
			this.psw = psw;
		}
		/*public UserPojo(int id, String username, String psw) {
			super();
			this.id = id;
			this.username = username;
			this.psw = psw;
		}*/
		

}
