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
    public <T> void checksBeforeInsert(T check) {
        Request request = (Request) check;
        medicineService.notFound(request.getMedicine_id());
        userService.notFound(request.getUser_id());
    }

    @Override
    public <T> void checksBeforeUpdate(T check) {
        notFound((long) check);
    }

    @Override
    public <T> void checksBeforeDelete(T check) {
        notFound((long) check);
    }


    @Override
    public <T> Request prepareRecordForUpdate(Request requestFromBody, T requestId) {
        /*
         I get the record of request from database by request id
         and then update the status of this record
         and return that
        */
        Request pareparedRequest = requestRepository.findById((long) requestId);
        pareparedRequest.setStatus(requestFromBody.getStatus());
        return pareparedRequest;
    }
    public void notFound(long id) {
        if(!requestRepository.existsRequestById(id)){
            throw new RecordNotFoundException("This request not found");
        }
    }

}
