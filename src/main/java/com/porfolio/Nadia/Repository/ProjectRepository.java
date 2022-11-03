/*
Interfaz del proyecto
 */
package com.porfolio.Nadia.Repository;

import com.porfolio.Nadia.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
}