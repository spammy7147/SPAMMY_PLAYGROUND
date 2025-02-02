package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ")
public class Member {
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name ="LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "product")
    private List<Product> products = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
}
