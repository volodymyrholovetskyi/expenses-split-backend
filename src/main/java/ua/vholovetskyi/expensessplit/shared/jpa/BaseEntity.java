package ua.vholovetskyi.expensessplit.shared.jpa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(of = "uuid")
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;
    protected String uuid = UUID.randomUUID().toString();

    @Version
    protected long version;
}
