package com.proyecto1.TiendaProyecto.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "productoId")
    @JsonBackReference
    private Producto producto;

    //para que se muestre en el Json el id y nombre del producto en el detalle del pedido
    @JsonProperty("idProducto")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Long getIdPProducto() {
        return producto != null ? producto.getProductoId() : null;
    }

    @JsonProperty("nombreProducto")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getNombreProducto() {
        return producto != null ? producto.getNombreProducto() : null;
    }

}