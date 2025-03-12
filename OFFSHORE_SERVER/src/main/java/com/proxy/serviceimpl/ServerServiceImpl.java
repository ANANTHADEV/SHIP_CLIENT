package com.proxy.serviceimpl;

import com.proxy.service.ServerServices;
import com.proxy.valueobject.RequestVO;
import com.proxy.valueobject.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ServerServiceImpl implements ServerServices {

    /**
     * @author Aswin Dev D R
     */
    private Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
    @Override
    public ResponseEntity<List<ResponseVO>> serverResponse(List<RequestVO> requests) {
        List<ResponseVO>responses = new ArrayList<>();
        try{
            for(RequestVO loop : requests){
                ResponseVO res = new ResponseVO();
                res.setResponseID(loop.getRequestId());
                res.setResponeData(loop.getRequestData()+ " -- Request has been processed");
                responses.add(res);
            }
            return  ResponseEntity.ok(responses);
        }catch (Exception e){
            logger.error("Error : serverResponse",e);
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }
}
