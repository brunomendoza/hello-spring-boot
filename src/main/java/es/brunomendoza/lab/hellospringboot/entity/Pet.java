package es.brunomendoza.lab.hellospringboot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
public class Pet {
    @Id
    private Long id;
    private String name;
    private BigInteger weight;

    @ManyToOne
    private Owner owner;
}
