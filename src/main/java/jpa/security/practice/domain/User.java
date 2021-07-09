package jpa.security.practice.domain;

import jpa.security.practice.domain.listener.Auditable;
import jpa.security.practice.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

}
