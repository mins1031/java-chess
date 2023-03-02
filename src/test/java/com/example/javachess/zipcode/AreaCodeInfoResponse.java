package com.example.javachess.zipcode;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "AreaCodeInfoResponse")
public class AreaCodeInfoResponse {

    @XmlElement(name = "cmmMsgHeader")
    private CmmMsgHeader cmmMsgHeader;

    @XmlElement(name = "file")
    private String file;

    public AreaCodeInfoResponse(CmmMsgHeader cmmMsgHeader, String file) {
        this.cmmMsgHeader = cmmMsgHeader;
        this.file = file;
    }
}

