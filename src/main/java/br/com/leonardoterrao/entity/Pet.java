package br.com.leonardoterrao.entity;

import javax.persistence.Entity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Pet extends PanacheEntity {

    public String name;
    
    public String breed;

}
