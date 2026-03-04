package com.xilften.mapper;

import com.xilften.controller.request.StreamingRequest;
import com.xilften.controller.response.StreamingResponse;
import com.xilften.model.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toResponse(Streaming model) {
        return StreamingResponse
                .builder()
                .name(model.getName())
                .id(model.getId())
                .build();
    }


}
