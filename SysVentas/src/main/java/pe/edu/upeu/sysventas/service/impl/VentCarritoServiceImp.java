package pe.edu.upeu.sysventas.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysventas.model.CarritoVenta;
import pe.edu.upeu.sysventas.model.CarritoVenta;
import pe.edu.upeu.sysventas.repository.CarritoVentaRepository;
import pe.edu.upeu.sysventas.repository.ICrudGenericRepository;
import pe.edu.upeu.sysventas.repository.ICrudGenericRepository;
import pe.edu.upeu.sysventas.repository.CarritoVentaRepository;
import pe.edu.upeu.sysventas.service.IVentCarritoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VentCarritoServiceImp extends CrudGenericServiceImp<CarritoVenta, Long> implements IVentCarritoService {

    private final CarritoVentaRepository carritoRepository;

    @Override
    protected ICrudGenericRepository<CarritoVenta, Long> getRepo() {
        return carritoRepository;
    }
    @Override
    public List<CarritoVenta> listaCarritoCliente(String dni) {
        return carritoRepository.listaCarritoCliente(dni);
    }
    @Transactional
    @Override
    public void deleteCarAll(String dniruc) {
        carritoRepository.deleteByDniruc(dniruc);
    }

}
