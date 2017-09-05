package com.example.demo.api;

import com.example.demo.modal.vo.StudentVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.googlecode.jsonrpc4j.JsonRpcComment;
import com.googlecode.jsonrpc4j.JsonRpcMethod;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface DemoApiService {

    @JsonRpcMethod("list.all")
    @JsonRpcComment("演示用")
    List<StudentVO> listAll();
}
