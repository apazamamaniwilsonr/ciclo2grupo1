package pe.edu.upeu.sysventas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//crea un constructor con key y value
@AllArgsConstructor
@NoArgsConstructor
//get and seter
@Data
public class ComboBoxOption {
    String key;
    String value;

    @Override
    public String toString() {
        return value;
    }
}
