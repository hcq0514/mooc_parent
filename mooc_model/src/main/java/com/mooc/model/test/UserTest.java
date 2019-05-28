package com.mooc.model.test;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@ToString
@Document(collection = "user_test")
public class UserTest {


    @Id
    private String id;
    private String name;

    @Column(name="create_time")
    private Date createTime;
}
