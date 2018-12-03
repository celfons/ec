package br.com.vr.integrations.contracts;

import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface Kenan {
    @RequestLine("GET /kenan/{value}")
    List<String> unlockCard(@Param("value") Boolean value);
}
