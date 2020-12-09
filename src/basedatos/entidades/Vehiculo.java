/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos.entidades;

import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author heracles
 */
public class Vehiculo {
    private int id;
    private String placa;
    private String propietario;
    private String tipoVehiculo;
    private Instant horaEntrada;
    private Instant horaSalida;
    private double valorPagado;
    private String estado;

    public Vehiculo(int id, String placa, String propietario, String tipoVehiculo, Instant horaEntrada, Instant horaSalida, double valorPagado, String estado) {
        this.id = id;
        this.placa = placa;
        this.propietario = propietario;
        this.tipoVehiculo = tipoVehiculo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.valorPagado = valorPagado;
        this.estado = estado;
    }
    
    public Vehiculo(String placa, String propietario, String tipoVehiculo, Instant horaEntrada, String estado){
        this.id = 0;
        this.placa = placa;
        this.propietario = propietario;
        this.tipoVehiculo = tipoVehiculo;
        this.horaEntrada = horaEntrada;
        this.horaSalida = null;
        this.valorPagado = 0;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public Instant getHoraEntrada() {
        return horaEntrada;
    }

    public Instant getHoraSalida() {
        return horaSalida;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public String getEstado() {
        return estado;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setHoraEntrada(Instant horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(Instant horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
