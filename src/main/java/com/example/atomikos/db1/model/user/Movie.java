/**
*@Author: tangliangdong
*@Date: 2019-12-6
*/
package com.example.atomikos.db1.model.user;
import com.gonghui.pay.common.mybatis.annotation.UUID;
import javax.persistence.Id;
import javax.persistence.Column;
/**
* @ClassName: Movie
* @Description:
* @author tangliangdong
* @date 2019-12-6
*/
public class Movie{
	
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

