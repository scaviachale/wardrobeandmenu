package scaa.wardrobe.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class WardrobeUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Size(min = 5, max = 30)
    private String username;

    @NotEmpty
    @Email
    private String email;

    private boolean admin;

}
