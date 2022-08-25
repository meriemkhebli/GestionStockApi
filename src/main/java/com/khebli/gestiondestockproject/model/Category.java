package com.khebli.gestiondestockproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name="category", schema = "public")
public class Category extends  AbstractEntity{

    @Column(name="code_category")
    private String code;

    @Column(name="designation_category")
    private String designation;

    @OneToMany(mappedBy="category")
    private List<Article> articles;

}
