package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
Repouser repo;
@PostMapping("/api/user")
public ResponseEntity<User>postdata(@RequestBody User u)
{
return new ResponseEntity<>(repo.save(u),HttpStatus.CREATED)	;
}

@GetMapping("/api/user")
public ResponseEntity<List<User>>gettdata()
{
return new ResponseEntity<>(repo.findAll(),HttpStatus.CREATED)	;
}

@GetMapping("/api/user/{id}")
public ResponseEntity<User>getsingledata(@PathVariable int id)
{
	Optional<User>obj=repo.findById(id);
	{
		if(obj.isPresent()) 
		{
			return new ResponseEntity<>(obj.get(),HttpStatus.CREATED)	;
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.CREATED)	;
		}
	}
}
	@PutMapping("/api/user/{id}")
	public ResponseEntity<User>showdata(@PathVariable int id,@RequestBody User use)
	{
		Optional<User>obj=repo.findById(id);
		{
			if(obj.isPresent()) 
				
			{
				obj.get().setId(use.getId());
				obj.get().setName(use.getName());
				obj.get().setAddress(use.getAddress());
				obj.get().setPrice(use.getPrice());
				return new ResponseEntity<>(repo.save(obj.get()),HttpStatus.CREATED)	;
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.CREATED)	;
			}
}
	}
	@DeleteMapping("/api/user/{id}")
	public ResponseEntity<User>deletedata(@PathVariable int id)
	{
		Optional<User>obj=repo.findById(id);
		{
			if(obj.isPresent()) 
				
			{
				repo.deleteById(id);
				return new ResponseEntity<>(obj.get(),HttpStatus.CREATED)	;
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.CREATED)	;
			}
}
	}
	}