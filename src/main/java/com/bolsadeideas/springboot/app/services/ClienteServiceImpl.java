package com.bolsadeideas.springboot.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IClienteSpringDataDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	@Qualifier("clienteDaoJpa")
	private IClienteDao clienteDao;

	@Autowired
	private IClienteSpringDataDao clienteSpringDataDao;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll() {

		return clienteSpringDataDao.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable pageable) {

		return clienteSpringDataDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {

		Optional<Cliente> cliente = clienteSpringDataDao.findById(id);
		return cliente.isPresent() ? cliente.get() : null;
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {

		clienteSpringDataDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {

		clienteSpringDataDao.deleteById(id);
	}

}
