package bg.softuni.lection2.mobilele.model.entites;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private Instant updated;

    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    @PrePersist
    public void prePersist(){
        setCreated(Instant.now());
        setUpdated(Instant.now());
    }

    @PreUpdate
    public void preUpdate(){
        setUpdated(Instant.now());
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public BaseEntity setUpdated(Instant modified) {
        this.updated = modified;
        return this;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + updated +
                '}';
    }
}
