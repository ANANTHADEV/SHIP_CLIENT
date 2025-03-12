package com.proxy.controller;

import com.proxy.service.ServerServices;
import com.proxy.valueobject.RequestVO;
import com.proxy.valueobject.ResponseVO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author Aswin Dev D R
 */

@RestController
public class ServerController {
    private Logger logger = LoggerFactory.getLogger(ServerController.class);
    @Autowired
    private ServerServices serverServices;

    @PostMapping(value = "/processClientRequests")
    public ResponseEntity<List<ResponseVO>> serverResponse(@RequestBody List<RequestVO> requests){
        try{
          var response = serverServices.serverResponse(requests);
          logger.info("response"+Arrays.asList(response));
          return response;
        }catch (Exception e){
            logger.error("Error:serverResponse ",e);
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }
}
