package br.com.fattoria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 255, message = "O comprimento do nome do produto deve ser entre 1 a 255 caractéres.")
    @NotNull(message = "O nome do produto não pode ser nulo.")
    @Column(nullable = false)
    private String nome;

    @Min(value = 0, message = "O preço do produto deve ser no mínimo 1.")
    @NotNull(message = "O preço do produto não pode ser nulo.")
    @Column(nullable = false)
    private Double price;

    @Min(value = 0, message = "Não pode-se ter menos que 0 produtos.")
    @NotNull(message = "A quantidade de produtos não pode ser nulo.")
    @Column(nullable = false)
    private Integer quantidade;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataDeCadastro = new Date();

    public Produto() {
    }

    public Produto(String nome, Double price, Integer quantidade, Date dataDeCadastro) {
        this.nome = nome;
        this.price = price;
        this.quantidade = quantidade;
        this.dataDeCadastro = dataDeCadastro;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public String toString() {
        return "Produto_{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", price=" + price +
                ", quantidade=" + quantidade +
                ", dataDeCadastro=" + dataDeCadastro +
                '}';
    }
}
