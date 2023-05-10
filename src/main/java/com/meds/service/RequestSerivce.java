package com.meds.service;

import com.meds.errors.RecordNotFoundException;
import com.meds.model.Medicine;
import com.meds.model.Request;
import com.meds.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestSerivce extends MainService<Request, Long> {

    @Autowired
    private MedicineService medicineService;
    @Autowired
    private UserService userService;
    @Autowired
    private RequestRepository requestRepository;
    public RequestSerivce(RequestRepository requestRepository) {
        super(requestRepository);
    }


    @Override
    public <T> void checksBeforeInsert(T request) {
        Request req = (Request) request;
        medicineService.notFound(req.getMedicine_id());
        userService.notFound(req.getUser_id());
    }

    @Override
    public <T> void checksBeforeUpdate(T request) {
        Request req = (Request) request ;
        notFound(req.getId());
    }

    @Override
    public <T> void checksBeforeDelete(T check) {
        notFound((long) check);
    }



    @Override
    public <T> Request prepareRecordForUpdate(Request requestFromBody) {
        /*
         I get the record of request from database by request id
         and then update the status of this record
         and return that
        */
        Request pareparedRequest = requestRepository.findById(requestFromBody.getId());
        pareparedRequest.setStatus(requestFromBody.getStatus());
        return pareparedRequest;
    }
    public void notFound(long id) {
        if(!requestRepository.existsRequestById(id)){
            throw new RecordNotFoundException("This request not found");
        }
    }

}
