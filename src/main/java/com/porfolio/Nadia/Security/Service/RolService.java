/*
 
 */
package com.porfolio.Nadia.Security.Service;

import com.porfolio.Nadia.Security.Entity.Rol;
import com.porfolio.Nadia.Security.Enums.RolNombre;
import com.porfolio.Nadia.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional /*sincroniza la base de datos, persistencia*/
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}