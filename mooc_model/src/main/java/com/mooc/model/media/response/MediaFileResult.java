package com.mooc.model.media.response;

import com.mooc.common.model.response.ResponseResult;
import com.mooc.common.model.response.ResultCode;
import com.mooc.model.media.MediaFile;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Data
@NoArgsConstructor
public class MediaFileResult extends ResponseResult {
    MediaFile mediaFile;
    public MediaFileResult(ResultCode resultCode, MediaFile mediaFile) {
        super(resultCode);
        this.mediaFile = mediaFile;
    }
}
