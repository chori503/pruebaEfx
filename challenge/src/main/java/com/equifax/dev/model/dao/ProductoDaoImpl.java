package com.equifax.dev.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.equifax.dev.model.entity.ClienteProducto;
import com.equifax.dev.model.entity.Productos;
import com.equifax.dev.utils.DaoUtils;

@Component
public class ProductoDaoImpl extends GeneralDao implements ProductoDao {

	@Autowired
	DaoUtils eUtils;

	@SuppressWarnings("unchecked")
	public List<Productos> findAllActiveProdByCliente(Long cliId) {
		String hqlQuery = eUtils.getQByName("pdoCte.getAllActivesByCteId");
		boolean active=true;
		try {
			List<ClienteProducto> list = (List<ClienteProducto>) findByHQuery(hqlQuery, new Object[] { cliId, active });
			Productos prod;
			List<Productos> prodList = new ArrayList<Productos>();
			for (ClienteProducto cp : list) {
				prod = new Productos(cp.getIdProducto().getIdProducto(), cp.getIdProducto().getNombreProducto(),
						cp.getIdProducto().getFechaCreacion(), cp.getIdProducto().getEstado());
			prodList.add(prod);
			}
			return prodList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Collections.EMPTY_LIST;
	}

}
