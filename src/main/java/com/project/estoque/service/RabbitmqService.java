package com.project.estoque.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {   

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMensage(String nomeFila, Object mensage) {
		this.rabbitTemplate.convertAndSend(nomeFila,mensage);
	}
}
