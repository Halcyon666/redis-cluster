package whalefall.vuemock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnModel {
    private Object data;
    private int code;
}
