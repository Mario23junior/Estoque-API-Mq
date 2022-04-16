package com.project.estoque.config;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import com.project.estoque.constant.RabbitmqConstantes;

@Component
public class RabbitMQConection {

	private final String NOME_EXCHANGE = "amq.direct";
	private AmqpAdmin amqAdmin;

	public RabbitMQConection(AmqpAdmin amdAdmin) {
		this.amqAdmin = amdAdmin;
	}


	private Queue Fila(String nameFile) {
		return new Queue(nameFile, true, false, false);
	}

	private DirectExchange trocaDireta() {
		return new DirectExchange(NOME_EXCHANGE);
	}

	private Binding relacionamento(Queue fila, DirectExchange troca) {
		Binding createRelation = new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(),
				fila.getName(), null);
		return createRelation;
	}

	@PostConstruct
	private void adiciona() {
		Queue filaName = this.Fila(RabbitmqConstantes.FILA_ESTOQUE);
		Queue filaPreco = this.Fila(RabbitmqConstantes.FILA_PREÇO);

		DirectExchange troca = this.trocaDireta();

		Binding ligacaoEstoque = this.relacionamento(filaName, troca);
		Binding ligacaoPreco = this.relacionamento(filaPreco, troca);

		this.amqAdmin.declareQueue(filaName);
		this.amqAdmin.declareQueue(filaPreco);

		this.amqAdmin.declareExchange(troca);

		this.amqAdmin.declareBinding(ligacaoEstoque);
		this.amqAdmin.declareBinding(ligacaoPreco);
	}
}
