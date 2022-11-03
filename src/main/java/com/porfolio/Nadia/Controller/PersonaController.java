/*
BEnd


 */
package com.porfolio.Nadia.Controller;

import com.porfolio.Nadia.Entity.Persona;
import com.porfolio.Nadia.Interface.IPersonaService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "*")

//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://nadiapereyraportfolio.web.app/")
public class PersonaController {
    @Autowired 
    IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Integer id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    
     @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable("id") Integer id,
                              @RequestBody Persona pers){
        Persona persona = ipersonaService.findPersona(pers.getId());
        
        persona.setNombre(pers.getNombre());
        persona.setApellido(pers.getApellido());
        persona.setDescripcion(pers.getDescripcion());
        persona.setImg(pers.getImg());
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona(1);
    }
   
}