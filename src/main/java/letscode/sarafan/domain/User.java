package letscode.sarafan.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usr")
@Data
@EqualsAndHashCode(of = { "id" })
public class User implements Serializable {

    @Id
    @JsonView({Views.IdName.class})
    private String id;

    @JsonView({Views.IdName.class})
    private String name;

    @JsonView({Views.IdName.class})
    private String userpic;

    private String email;

    @JsonView({Views.FullProfile.class})
    private String gender;

    @JsonView({Views.FullProfile.class})
    private String locale;

    @JsonView({Views.FullProfile.class})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastVisit;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "subscriber_id"),
            inverseJoinColumns = @JoinColumn(name = "channel_id"))
    @JsonIdentityReference
    @JsonIdentityInfo(
            property = "id",
            generator = ObjectIdGenerators.PropertyGenerator.class
    )
    @JsonView({Views.FullProfile.class})
    private Set<User> subscriptions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    @JsonView({Views.FullProfile.class})
    @JsonIdentityReference
    @JsonIdentityInfo(
            property = "id",
            generator = ObjectIdGenerators.PropertyGenerator.class
    )
    private Set<User> subscribers = new HashSet<>();

}
