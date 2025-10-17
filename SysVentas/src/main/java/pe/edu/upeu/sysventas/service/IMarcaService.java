package pe.edu.upeu.sysventas.service;

import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.dto.ComboBoxOption;
import pe.edu.upeu.sysventas.model.Marca;

import java.util.List;

public interface IMarcaService extends ICrudGenericService<Marca,Long>{
    List<ComboBoxOption> listarCombobox();

}
