package flaviodeangelis.u6w2d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private String avatar;

}
