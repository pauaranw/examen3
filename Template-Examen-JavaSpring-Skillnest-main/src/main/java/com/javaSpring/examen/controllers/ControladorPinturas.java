package com.javaSpring.examen.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.javaSpring.examen.models.Pintura;
import com.javaSpring.examen.models.Usuario;
import com.javaSpring.examen.services.ServicioPinturas;
import com.javaSpring.examen.services.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;

@Controller
public class ControladorPinturas {
    
    @Autowired
    private ServicioPinturas servicioPinturas;

    @Autowired
    private ServicioUsuarios servicioUsuarios;

    //Pantalla ver todas las pinturas
    @GetMapping("/pinturas")
    public String mostrarPinturas(HttpSession session, Model modelo){
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null){
            return "redirect:/";
        }
        List<Pintura> pinturas = this.servicioPinturas.obtenerTodasLasPinturas();
        Collections.sort(pinturas);
        modelo.addAttribute("pinturas", pinturas);
        return "pinturas.jsp";
    }

    //detalle pintura
    @GetMapping("/detail/{id}")
    public String detalle(@PathVariable("id")Long id, HttpSession session, Model modelo){
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null){
            return "redirect:/";
        }
        modelo.addAttribute("pintura", this.servicioPinturas.obtenerPinturaPorId(id));

        return "detalle.jsp";
    }

    //formulario agregar
    @GetMapping("/form/add")
    public String formAgregar(HttpSession session, Model modelo){
        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }
        modelo.addAttribute("pintura", new Pintura ());
        return "agregar.jsp";
    }

    // formulario editar
    @GetMapping("/form/edit/{id}")
    public String formEditar(@PathVariable("id") Long id, HttpSession session, Model modelo){
        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }
        modelo.addAttribute("pintura", this.servicioPinturas.obtenerPinturaPorId(id));
        return "editar.jsp";
    }

    //Procesamiento info agregar
    @PostMapping("/add")
    public String agregar(HttpSession session,
                        @Valid @ModelAttribute("pintura") Pintura pintura,
                        BindingResult validaciones){
        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }
        if (validaciones.hasErrors()){
            return "agregar.jsp";
        }
        this.servicioPinturas.creaPintura(pintura);
        return "redirect:/pinturas";
    }

    //procesar editar
    @PutMapping("/edit")
    public String editar(HttpSession session,
                        @Valid @ModelAttribute("pintura") Pintura pintura,
                        BindingResult validaciones){
        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }
        if (validaciones.hasErrors()){
            return "editar.jsp";
        }
        this.servicioPinturas.actualizarPinturas(pintura);
        return "redirect:/pinturas";
    }

    //borrar
    @DeleteMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Long id, HttpSession session) {

        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }
        this.servicioPinturas.eliminarPinturaPorId(id);
        return "redirect:/pinturas";
    }

    //mis compras
    @GetMapping("/buy/{id}")
    public String comprar(HttpSession session, Model modelo, @PathVariable("id") Long id) {

        Long idUduario = (Long) session.getAttribute("idUsuario");
        if (idUduario == null){
            return "redirect:/";
        }

        Usuario usuarioModificar = this.servicioUsuarios.obtenerPorId(idUduario);
        Pintura pinturaComprar = this.servicioPinturas.obtenerPinturaPorId(id);

        List<Pintura> pinturasUsuario = usuarioModificar.getComprados();
        pinturasUsuario.add(pinturaComprar);
        usuarioModificar.setComprados(pinturasUsuario);

        Integer stockPintura = pinturaComprar.getCantidad();
        stockPintura -= 1;
        pinturaComprar.setCantidad(stockPintura);


        this.servicioPinturas.actualizarPinturas(pinturaComprar);

        return "redirect:/compras";
    }

    //Pantalla ver todas mis compras
    @GetMapping("/compras")
    public String mostrarCompras(HttpSession session, Model modelo){
        Long idUsuario = (Long) session.getAttribute("idUsuario");
        if (idUsuario == null){
            return "redirect:/";
        }

        List<Pintura> pinturas = this.servicioUsuarios.obtenerPorId(idUsuario).getComprados();
        modelo.addAttribute("pinturas", pinturas);
        return "compras.jsp";
    }

}
