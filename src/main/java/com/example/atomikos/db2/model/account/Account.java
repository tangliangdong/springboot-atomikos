/**
*@Author: tangliangdong
*@Date: 2019-12-6
*/
package com.example.atomikos.db2.model.account;
import com.gonghui.pay.common.mybatis.annotation.UUID;
import javax.persistence.Id;
import javax.persistence.Column;
/**
* @ClassName: Account
* @Description:
* @author tangliangdong
* @date 2019-12-6
*/
public class Account{
	
	//
	@UUID
    @Id
    @Column(name="name")
	private String name;


	public void setName(String value) {
		this.name = value;
	}
	public String getName() {
		return this.name;
	}
}

