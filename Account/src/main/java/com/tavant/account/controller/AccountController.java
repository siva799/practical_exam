package com.tavant.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tavant.account.exceptions.NoAccountFoundException;
import com.tavant.account.exceptions.NoDataFoundException;
import com.tavant.account.models.Account;
import com.tavant.account.repository.AccountRepository;


@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping
	public String getAccount() {
		return "hello from account";
	}
	
	@GetMapping("/all")
	public List<Account> getAllEmployees() throws NoDataFoundException{
		
		return Optional.ofNullable(accountRepository.findAll()).orElseThrow(
						()->new NoDataFoundException("no record found"));
		
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") Integer id) throws NoAccountFoundException {
		
		Optional<Account> optional = accountRepository.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			
			throw new NoAccountFoundException("record not found");
		}
	}
	
	@PostMapping("/add")
	public Account addAccount( @RequestBody Account accounts)throws NoDataFoundException {
		//return accountRepository.save(accounts);
		
		//we can provide blank object....{}-blank object
		if(accounts.getAccountNumber()==null) {
			throw new NoDataFoundException("provide the account ");
		}
		else {
			return accountRepository.save(accounts);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateaccount(@PathVariable (value = "id") 
	Integer id,@RequestBody Account account) throws NoDataFoundException{
		Account account1=accountRepository.findById(id).
				orElseThrow(()->new NoDataFoundException("No data to  be updated"));
		
		final Account updatedticket = accountRepository.save(account1);
		return ResponseEntity.ok(updatedticket);
	}
	
	@DeleteMapping("/{id}")
	public Map<String,Boolean> deleteticket(@PathVariable(value = "id") Integer id)
	throws NoDataFoundException{
		Account account1=accountRepository.findById(id).
				orElseThrow(()->new NoDataFoundException("no record found for deletion"));
		
		accountRepository.delete(account1);
		
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;

	}

}
