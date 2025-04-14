package esprit.commandegestion.DTO;

import lombok.Data;

@Data
public class ProductDto {
        private int id;
        private String artdesign;
        private float prix;
        private double qtestock;
        private int tauxremise;
        private String artimg;
        private String artdesc;
        private String artcategory;
        private String marque;
}
