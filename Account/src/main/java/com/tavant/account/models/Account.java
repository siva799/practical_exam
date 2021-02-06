package com.tavant.account.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
	
	@Id
	private int accountId;
	private String accountNumber;
	private String accountName;
	private String email;
	private Integer accountCode;
	
}
