package com.poc.springproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
//@Data
//@EqualsAndHashCode
//@ToString
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonFormat
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastname;

    @Column(name="age")
    int age;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TaskEntity> task;

  public UserEntity(String firstName, String middleName, String lastName, int age, String email) {
      this.name = firstName;
      this.middleName = middleName;
      this.name = lastName;
      this.age = age;
      this.email = email;
  }

    @Override
    public String toString() {
        return "User information:" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastname='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

}
