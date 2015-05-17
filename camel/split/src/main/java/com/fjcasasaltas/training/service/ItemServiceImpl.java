package com.fjcasasaltas.training.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void add(ItemDTO itemDTO) {
		log.info("Processing item [id={}, description={}]", itemDTO.getId(), itemDTO.getDescription());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
