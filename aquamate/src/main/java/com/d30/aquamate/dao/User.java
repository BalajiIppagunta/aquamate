package com.d30.aquamate.dao;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
    private String userid;
	private String password;
	private String secretkey;
	
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the secretkey
	 */
	public String getSecretkey() {
		return secretkey;
	}
	/**
	 * @param secretkey the secretkey to set
	 */
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [" + (userid != null ? "userid=" + userid + ", " : "")
				+ (password != null ? "password=" + password + ", " : "")
				+ (secretkey != null ? "secretkey=" + secretkey : "") + "]";
	}
	
	

	

}
