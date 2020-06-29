package scaa.wardrobe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class WardrobeUser {

    @NotNull
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    private boolean admin;

}
