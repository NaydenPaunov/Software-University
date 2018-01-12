package gameStore.models;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email" , unique = true)
    @Pattern(regexp = "([^-_][a-zA-Z0-9\\._]+[^-_])@([a-zA-Z0-9]*\\.[a-zA-Z0-9]*)+",
    message = "Email not valid")
    private String email;

    @Column(name = "password")
    @Size(min = 6)
    @Pattern(regexp = "((?=.*[a-z]).*(?=.*[A-Z]).*(?=.*[0-9]).*).{6,}")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "buyer")
    private Set<Order> orders;

    @ManyToMany
    private Set<Game> games;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
//        if(this.games == null){
//            this.games = new HashSet<>();
//        }
//        this.games.addAll(games);
        this.games = games;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
