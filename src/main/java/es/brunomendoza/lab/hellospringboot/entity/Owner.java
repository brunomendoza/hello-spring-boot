package es.brunomendoza.lab.hellospringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "owner")
@Data
@NoArgsConstructor
public class Owner {
    @Id
    private Long id;

    @EqualsAndHashCode.Exclude
    private String firstName;

    @EqualsAndHashCode.Exclude
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    // https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
    @JsonManagedReference // This annotation avoids also avoid infinite recursion. See Pet class.
    private Set<Pet> pets;
}
