package com.salcorps.springbootdemo3.security;

import com.salcorps.springbootdemo3.model.Person;
import com.salcorps.springbootdemo3.model.Roles;
import com.salcorps.springbootdemo3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EazySchoolUsernamePwdAuthenticationProvider
        implements AuthenticationProvider {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String email = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        // Getting the credentials from the database and then comparing them.
        Person person = personRepository.readByEmail(email);

        if(null != person && person.getPersonId() > 0
                && pwd.equals(person.getPwd()) && passwordEncoder.matches(pwd,person.getPwd())) {
            return new UsernamePasswordAuthenticationToken(
                    email, null, getGrantedAuthorities(person.getRoles()));
        } else {
            throw new BadCredentialsException("Invalid Credentials");
        }
    }

    // Below method always accept the roles received from the database.
    // Returning a list of granted-authorities.
    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
        // Once I fetch the role , I will append it with the prefix "ROLE_" + "".
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
