package esprit.paiment.DTO;

import lombok.Data;

@Data
public class OrderDTO{
    private Long id;
    private String deliveryAddress;
    private String status;
}
