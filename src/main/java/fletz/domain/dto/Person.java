package fletz.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Person implements Serializable {

    private static final long serialVersionUID = -3102168458826185474L;

    private String id;
    private String name;
    private String lastName;
}
