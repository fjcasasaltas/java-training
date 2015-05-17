package com.fjcasasaltas.training.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fjcasasaltas.training.service.ItemDTO;

public class LineProcessor implements Processor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String line = exchange.getIn().getBody(String.class);
		log.debug("Processing line {}", line);
		if (StringUtils.hasText(line)) {
			String[] fields = line.split(";");
			if (fields.length != 2) {
				throw new InvalidLineException();
			}
			if (!StringUtils.hasText(fields[0]) || !StringUtils.hasText(fields[1])) {
				throw new InvalidLineException();
			}
			Long id = null;
			try {
				id = Long.valueOf(fields[0]);
			} catch (Exception e) {
				throw new InvalidLineException();
			}
			String description = fields[1];
			exchange.getIn().setBody(new ItemDTO(id, description), ItemDTO.class);
		}
	}

}
