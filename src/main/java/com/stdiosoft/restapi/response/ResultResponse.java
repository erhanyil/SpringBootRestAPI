package com.stdiosoft.restapi.response;

import java.io.Serializable;

public class ResultResponse implements Serializable {

    protected boolean success;
    protected String message;

    public ResultResponse(boolean _s, String _m) {
        this.success = _s;
        this.message = _m;
    }

    public ResultResponse() {
        this.success = true;
        this.message = "";
    }

}
