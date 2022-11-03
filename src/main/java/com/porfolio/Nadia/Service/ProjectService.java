/*

 */
package com.porfolio.Nadia.Service;
import com.porfolio.Nadia.Entity.Project;
import com.porfolio.Nadia.Entity.UsuarioInfo;

import com.porfolio.Nadia.Repository.ProjectRepository;
import com.porfolio.Nadia.Repository.UsuarioInfoRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class ProjectService implements IProjectService {
    
     @Autowired
     private ProjectRepository projRepo;
     
      @Autowired
    private UsuarioInfoRepository usuarioInfoRepo;

    @Override
    public List<Project> listaProyectosUsuario(Integer id) {
     return usuarioInfoRepo.findProjectsByUsuario(id);
    }

    @Override
    public Project buscarProyecto(Integer id) {
      return projRepo.findById(id).orElse(null);
    }

    @Override
    public Project guardarProyecto(Integer id,Project prj) {
       UsuarioInfo usuario = usuarioInfoRepo.findById(id).orElse(null);
       usuario.getProjects().add(prj);
       return projRepo.save(prj);
    }

    @Override
    public void eliminarProyecto(Integer id) {
     projRepo.deleteById(id);
    }

    @Override
    public Project editarProyecto(Integer id, Project prj) {
      Project proyectoEdit = projRepo.findById(id).orElse(null);
      proyectoEdit.setNombre(prj.getNombre());
      proyectoEdit.setDescripcion(prj.getDescripcion());
      proyectoEdit.setUrl_project(prj.getUrl_project());
      proyectoEdit.setImgProject(prj.getImgProject());
      return projRepo.save(proyectoEdit);
    }
    
}