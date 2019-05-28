package com.mooc.model.media;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class MediaFileProcess_m3u8 extends MediaFileProcess {

    //ts列表
    private List<String> tslist;

}
