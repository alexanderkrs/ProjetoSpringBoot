package br.ueg.Armas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TBL_ARMA")
public @Data class Arma { 
	
	@Id
	@SequenceGenerator(
				name="amigo_sequence",
				sequenceName = "seq_amigo_id",
				allocationSize = 1,
				initialValue =1 
			)
	@GeneratedValue(
				strategy = GenerationType.SEQUENCE,
				generator = "amigo_sequence"	
			)
	@Column(name = "PK",nullable = false)
	private Integer id;
	private String marca;
	private String modelo;
	private Integer calibre;
}
