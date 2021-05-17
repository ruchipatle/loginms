package com.example.googledemo;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lh.cif.workflow.model.UserMaster;
import com.lh.cif.workflow.security.CurrentUser;
import com.lh.cif.workflow.security.UserPrincipal;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello() {
    	
        return "hello";
    }
    
    @GetMapping("/user/me")
	public String getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		boolean isAdmin = false;
		Collection<? extends GrantedAuthority> userAuthorities = userPrincipal.getAuthorities();
		for(GrantedAuthority role : userAuthorities) {
			if(role.getAuthority().equals("Admin")) {
				isAdmin = true;
				break;
			}
		}
		return "User details are: "+userPrincipal.getEmail()+" "+userPrincipal.getName()+" "+userPrincipal.getUsername()+" "+userPrincipal.getId()+" "+userPrincipal.getAuthorities();
	}
 
}
