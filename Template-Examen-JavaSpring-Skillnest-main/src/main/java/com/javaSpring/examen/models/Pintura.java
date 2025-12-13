package com.javaSpring.examen.models;


import java.util.List;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pinturas")
public class Pintura implements Comparable<Pintura>{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Por favor proporciona el titulo" )
    @Size(min = 5, message = "Debe contener minimo 5 caracteres")
    private String titulo;

    @NotNull(message = "Por favor proporciona el año")
    @Positive(message = "Por favor ingrese un año valido y positivo")
    private Integer anio;

    @NotBlank(message = "Por favor proporciona la descripcion" )
    @Size(min = 10, max = 50, message = "Debe contener minimo 10 caracteres y un maximo de 50")
    private String descripcion;

    @NotBlank(message = "Por favor proporciona la URL de la imagen")
    @URL(message = "Por favor ingrese una url valida")
    @Pattern(regexp = "^(https?://.*\\.(jpg|jpeg|png|gif|webp))$",
    message = "La URL debe terminar en una extensión de imagen válida (.jpg, .png, etc.)")
    private String url;
    
    @NotNull(message = "Por favor proporciona una cantidad" )
    @PositiveOrZero(message = "Por favor ingrese una cantidad válida")
    private Integer cantidad;

    @NotNull(message = "Por favor proporciona el titulo" )
    @Positive(message = "El precio debe ser un número positivo")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario creador;

    @ManyToMany
    @JoinTable(name = "usuarios_pinturas", joinColumns = @JoinColumn(name = "id_pintura"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> compradores;    

    public Pintura() {
    }

    public Pintura(Long id, String titulo, Integer anio, String descripcion, String url, Integer cantidad, Double precio,
            Usuario creador) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.descripcion = descripcion;
        this.url = url;
        this.cantidad = cantidad;
        this.precio = precio;
        this.creador = creador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Pintura [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", descripcion=" + descripcion + ", url="
                + url + ", cantidad=" + cantidad + ", precio=" + precio + ", creador=" + creador + "]";
    }

    public List<Usuario> getCompradores() {
        return compradores;
    }

    public void setCompradores(List<Usuario> compradores) {
        this.compradores = compradores;
    }

    @Override
    public int compareTo(Pintura otra) {
        return this.titulo.compareTo(otra.titulo);
    }

    
}
