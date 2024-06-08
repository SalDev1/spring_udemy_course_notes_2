package com.salcorps.springbootdemo3.service;


import com.salcorps.springbootdemo3.constants.EazySchoolConstants;
import com.salcorps.springbootdemo3.model.Person;
import com.salcorps.springbootdemo3.model.Roles;
import com.salcorps.springbootdemo3.repository.PersonRepository;
import com.salcorps.springbootdemo3.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepsoitory;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        // Encoding the passoword with the Bcrypt code.
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepsoitory.save(person);
        if(null != person && person.getPersonId() > 0){
            isSaved = true;
        }
        return isSaved;
    }
}
