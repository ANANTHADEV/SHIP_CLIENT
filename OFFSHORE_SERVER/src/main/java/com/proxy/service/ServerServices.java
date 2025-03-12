package com.proxy.service;

import com.proxy.valueobject.RequestVO;
import com.proxy.valueobject.ResponseVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServerServices {
    /**
     * @author Aswin Dev D R
     */
    public ResponseEntity<List<ResponseVO>> serverResponse(List<RequestVO> requests);
}
