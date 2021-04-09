/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.logic.vuelo;

import java.util.Date;

/**
 *
 * @author Bryan
 */
public class Vuelo {

    int idVuelo;
    String origen, destino;
    Date fechaIda, fechaRegreso;
    int cantidadPasajeros, descuento;

    public Vuelo(int idVuelo, String origen, String destino,
            Date fechaIda, Date fechaRegreso,
            int cantidadPasajeros, int descuento) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.cantidadPasajeros = cantidadPasajeros;
        this.descuento = descuento;
    }

    public Vuelo() {
        this(0, "", "", new Date(), new Date(), 0, 0);
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Date getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(Date fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("Id vuelo: %d%n", idVuelo));
        s.append(String.format("Origen: %s%n", origen));
        s.append(String.format("Destino: %s%n", destino));
        s.append(String.format("Fecha ida: %s%n", fechaIda));

        if (!fechaRegreso.toString().equals("")) {
            s.append(String.format("Fecha regreso: %s%n", fechaRegreso));
        }

        s.append(String.format("Cantidad Pasajeros: %d%n", cantidadPasajeros));
        s.append(String.format("Descuento: %d%n", descuento));
        return s.toString();
    }
}
