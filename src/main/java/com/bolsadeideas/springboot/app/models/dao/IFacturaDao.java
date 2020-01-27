package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.app.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long> {

	@Query("select f Factura f join fetch Cliente f.cliente c join fetch ItemFactura l.items l join fetch l.producto where f.id=?1")
	public Factura fetchByIdWithClientWithItemsWithProducto(Long id);

}
