package br.com.vr.integrations.contracts;

import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface Kenan {
    @RequestLine("POST /kenan/{value}")
    void unlockCard(@Param("value") Boolean value);
}
