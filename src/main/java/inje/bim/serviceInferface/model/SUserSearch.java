package inje.bim.serviceInferface.model;

import org.bimserver.interfaces.objects.SUser;

/**
 * 사용자 검색 조건 model
 *
 * @author  유신일
 * @since	2019. 08. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일		수정자     수정내용
 *  -------------	----	 --------
 *  2019. 08. 29.	유신일	 최초 생성
 *  </pre>
 */
public class SUserSearch {
	private String name = "";
	private String username = "";

	/*
		전체 조회(-1)
	    ACTIVE(0)
	    DELETED(1)
	*/
	private int state = -1;

	/*
		전체 조회(-1)
		SYSTEM(0)
		ADMIN(1)
		USER(2)
		READ_ONLY(3)
	*/
	private int userType = -1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public boolean equals(Object obj) {
		SUser targetSUser = (SUser) obj;
		StringBuilder target = new StringBuilder();
		StringBuilder self = new StringBuilder();

		if(!this.getName().isEmpty()) {
			target.append(targetSUser.getName());
			self.append(this.getName());
		}
		if(!this.getUsername().isEmpty()) {
			target.append(targetSUser.getUsername());
			self.append(this.getUsername());
		}
		if(this.getState() > -1) {
			target.append(targetSUser.getState().getOrdinal());
			self.append(this.getState());
		}
		if(this.getUserType() > -1) {
			target.append(targetSUser.getUserType().getOrdinal());
			self.append(this.getUserType());
		}

		return target.toString().equals(self.toString());
	}

}