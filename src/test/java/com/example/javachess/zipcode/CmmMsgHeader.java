package com.example.javachess.zipcode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@ToString
@NoArgsConstructor
@XmlRootElement(name = "cmmMsgHeader")
public class CmmMsgHeader {
    @XmlElement(name = "requestMsgId")
    private String requestMsgId;
    @XmlElement(name = "responseMsgId")
    private String responseMsgId;
    @XmlElement(name = "responseTime")
    private String responseTime;
    @XmlElement(name = "successYN")
    private String successYN;
    @XmlElement(name = "day_DreturnCodeate")
    private String returnCode;
    @XmlElement(name = "errMsg")
    private String errMsg;

    public CmmMsgHeader(String requestMsgId, String responseMsgId, String responseTime, String successYN, String returnCode, String errMsg) {
        this.requestMsgId = requestMsgId;
        this.responseMsgId = responseMsgId;
        this.responseTime = responseTime;
        this.successYN = successYN;
        this.returnCode = returnCode;
        this.errMsg = errMsg;
    }
}
