package com.surendra.atm.model;

import com.surendra.atm.Constants;

public class StatusFactory {

    public static Status getSuccessStatus() {
        Status status = new Status();
        status.setStatus(Constants.STATUS_SUCCESS);
        return status;
    }

    public static Status getFailStatus() {
        Status status = new Status();
        status.setStatus(Constants.STATUS_FAIL);
        return status;
    }
}
