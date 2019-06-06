package com.mooc.model.course;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@ToString
@Entity
@Table(name="course_category")
@GenericGenerator(name = "jpa-assigned", strategy = "assigned")
public class CourseCategory implements Serializable {
    private static final long serialVersionUID = -906357110051689484L;
    @Id
    @GeneratedValue(generator = "jpa-assigned")
    @Column(length = 32)
    private String id;
    private String name;
    private String label;
    private String parentid;
    private String isshow;
    private Integer orderby;
    private Integer isleaf;
    @Ignore
    private List children;

}
