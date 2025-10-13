package pe.edu.upeu.sysventas.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.model.CarritoCompra;
import pe.edu.upeu.sysventas.model.CarritoCompra;
import pe.edu.upeu.sysventas.repository.CarritoCompraRepository;
import pe.edu.upeu.sysventas.repository.CarritoCompraRepository;
import pe.edu.upeu.sysventas.repository.ICrudGenericRepository;
import pe.edu.upeu.sysventas.repository.ICrudGenericRepository;
import pe.edu.upeu.sysventas.service.ICompCarritoService;

@RequiredArgsConstructor
@Service
public class CompCarritoServiceImp extends CrudGenericServiceImp<CarritoCompra,Long> implements ICompCarritoService {

    private final CarritoCompraRepository CarritoCompraRepository;

    @Override
    protected ICrudGenericRepository<CarritoCompra, Long> getRepo() {
        return CarritoCompraRepository;
    }
}
