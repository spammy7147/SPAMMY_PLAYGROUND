package hellojpa;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
