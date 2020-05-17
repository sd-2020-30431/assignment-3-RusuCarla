package com.assignment.business_layer.mediator.response.commandResponse;

import com.assignment.business_layer.mediator.response.TResponse;
import com.assignment.presentation_layer.dto.StringObj;

public class GenerateReportResponse implements TResponse {
    StringObj stringObj;

    public GenerateReportResponse(StringObj stringObj) {
        this.stringObj = stringObj;
    }

    public StringObj getStringObj() {
        return stringObj;
    }

    public void setStringObj(StringObj stringObj) {
        this.stringObj = stringObj;
    }
}
