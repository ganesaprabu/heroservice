package com.example.heroservice.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.heroservice.model.Hero;
import com.example.heroservice.util.HeroUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class HeroController {

	@GetMapping("/api/getHeros")
	public List<Hero> getHeros(){
		return HeroUtil.getHerosList();
	}
	
	@GetMapping("/api/getHeros/{id}")
	public Hero getHeros(@PathVariable("id") Integer id){
		return HeroUtil.getHerosList().stream().filter(obj -> obj.getId() == id).findAny().get();
	}
	
	@PostMapping("/api/getHero")
	public Hero getHeros(@RequestBody String payload) throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		Hero hero = objectMapper.readValue(payload, Hero.class);
		System.out.println("--------------------- Hashcode --------------------- ");
		System.out.println(hashPayload(payload));
		System.out.println("--------------------- Hashcode --------------------- ");
		Hero updatedHero = HeroUtil.getHerosList().stream().filter(obj -> obj.getId() == hero.getId()).findAny().get();
		return updatedHero;
	}
	
	private String hashPayload(String payload) {
	    // Add a salt to the payload
	    String salt = "your-salt-value"; // Change this to your actual salt value
	    payload = payload + salt;

	    try {
	        // Create MessageDigest instance for SHA-256
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        // Add payload bytes to digest
	        md.update(payload.getBytes());
	        // Get the hash's bytes
	        byte[] bytes = md.digest();
	        // Convert bytes to hex string
	        return bytesToHex(bytes);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        // Handle NoSuchAlgorithmException
	        return null;
	    }
	}
	
	private String bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return result.toString();
	}

}
