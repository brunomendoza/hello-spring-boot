package es.brunomendoza.lab.hellospringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pet")
@Data
@NoArgsConstructor
//@JsonIgnoreProperties({ "owner" }) // Avoid infinite recursion calls for owner and pet during JSON serialization.
public class Pet {
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private BigDecimal weight;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference // This annotation avoids also avoid infinite recursion. See Owner class.
    private Owner owner;
}
