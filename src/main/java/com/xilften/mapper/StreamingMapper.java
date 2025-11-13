package com.xilften.mapper;

import com.xilften.controller.request.StreamingRequest;
import com.xilften.controller.response.StreamingResponse;
import com.xilften.model.StreamingModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static StreamingModel toStreaming(StreamingRequest request) {
        return StreamingModel
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toResponse(StreamingModel model) {
        return StreamingResponse
                .builder()
                .name(model.getName())
                .id(model.getId())
                .build();
    }


}
