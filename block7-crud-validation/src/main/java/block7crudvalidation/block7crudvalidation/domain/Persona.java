package block7crudvalidation.block7crudvalidation.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.BatchSize;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    int id;
    @Size(min=6,max=10)
    @NotNull
    String usuario;
    @NotNull
    String password;
    @NotNull
    String name;
    String surName;
    @NotNull
    String companyEmail;
    @NotNull
    String personalEmail;
    @NotNull
    String city;
    @NotNull
    Boolean active;
    @NotNull
    Date createdDate;
    String imagenUrl;
    Date terminationDate;
}
