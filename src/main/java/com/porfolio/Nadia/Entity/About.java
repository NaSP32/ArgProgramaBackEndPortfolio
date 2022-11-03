/*

 */
package com.porfolio.Nadia.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "about")
public class About implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAbout;

    @Size(min = 0, max = 600, message = "longitud incorrecta")
    private String descripcion;

    public About() {
    }

    public About(String descripcion) {

        this.descripcion = descripcion;
    }

}
