package mini.bigtech.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mini.bigtech.type.Role;
import mini.bigtech.type.UserStatus;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private UUID externalId;

  @Column(unique = true, nullable = false, length = 320)
  private String email;

  @Column(unique = true, length = 64)
  @Pattern(regexp = "^[a-z0-9_]{3,64}$")
  private String username;

  @Column(nullable = false)
  private String fullName;

  @Column(unique = true, length = 16)
  @Pattern(regexp = "^\\+\\d{1,15}$")
  private String phone;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false, length = 32)
  private Set<Role> roles;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 16)
  private UserStatus status = UserStatus.ACTIVE;

  @Column(length = 8)
  private String language;

  @Column(length = 64)
  private String timezone;

  private LocalDate birthDate;

  @Column(length = 1024)
  private String avatarUrl;

  @JdbcTypeCode(SqlTypes.JSON)
  private Map<String, Object> attributes;

  @CreatedDate
  @Column(nullable = false)
  private OffsetDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = false)
  private OffsetDateTime updatedAt;

  @Version
  private long version;

  @PrePersist
  @PreUpdate
  private void prePersist() {
    if (email != null) email = email.trim().toLowerCase();
    if (username != null) username = username.trim().toLowerCase();
  }
}
