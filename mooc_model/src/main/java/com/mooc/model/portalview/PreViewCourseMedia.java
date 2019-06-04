package com.mooc.model.portalview;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by admin on 2018/2/27.
 */
@Data
@ToString
@Document(collection = "pre_view_course_media")
public class PreViewCourseMedia implements Serializable{

    private String teachplanId;

    private String mediaId;

    private String mediaFileOriginalName;

    private String mediaUrl;
    private String courseId;

}
