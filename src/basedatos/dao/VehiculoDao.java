/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos.dao;

import basedatos.entidades.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author heracles
 */
public class VehiculoDao extends AbstractDao<Vehiculo> {

    @Override
    public Vehiculo obtener(int id) {
        Vehiculo vehiculo = null;
        final String sql = "SELECT * FROM vehiculos WHERE id = ?";

        try (PreparedStatement ps = db.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.execute()) {
                final ArrayList<Vehiculo> vehiculos = generarVehiculos(ps.getResultSet());

                if (vehiculos.size() > 0) {
                    vehiculo = vehiculos.get(0);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "obtener(id): " + e.getMessage());
        }

        return vehiculo;
    }

    public Vehiculo obtener(String placa) {
        Vehiculo vehiculo = null;
        final String sql = "SELECT * FROM vehiculos WHERE placa = ?";

        try (PreparedStatement ps = db.connection.prepareStatement(sql)) {
            ps.setString(1, placa);
            if (ps.execute()) {
                final ArrayList<Vehiculo> vehiculos = generarVehiculos(ps.getResultSet());

                if (vehiculos.size() > 0) {
                    vehiculo = vehiculos.get(0);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "obtener(id): " + e.getMessage());
        }

        return vehiculo;
    }

    @Override
    public ArrayList<Vehiculo> obtener() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        final String sql = "SELECT * FROM vehiculos";

        try (Statement st = db.connection.createStatement()) {
            if (st.execute(sql)) {
                vehiculos = generarVehiculos(st.getResultSet());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "obtener(id): " + e.getMessage());
        }

        return vehiculos;
    }

    @Override
    public int agregar(Vehiculo elemento) {
        int id = 0;
        final String sql = "INSERT INTO vehiculos VALUES(null, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = db.connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, elemento.getPlaca());
            ps.setString(2, elemento.getPropietario());
            ps.setString(3, elemento.getTipoVehiculo());
            ps.setTimestamp(4, elemento.getHoraEntrada() == null ? null : Timestamp.from(elemento.getHoraEntrada()));
            ps.setTimestamp(5, elemento.getHoraSalida() == null ? null : Timestamp.from(elemento.getHoraSalida()));
            ps.setDouble(6, elemento.getValorPagado());
            ps.setString(7, elemento.getEstado());

            if (ps.executeUpdate() > 0) {
                final ResultSet rsgen = ps.getGeneratedKeys();
                rsgen.next();
                id = rsgen.getInt(1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "agregar: " + e.getMessage());
        }

        return id;
    }

    @Override
    public boolean modificar(Vehiculo elemento) {
        boolean fueModificado = false;
        final String sql = "UPDATE vehiculos SET placa = ?, propietario = ?, tipovehiculo = ?, horaentrada = ?, horasalida = ?, valorpagado = ?, estado = ? WHERE id = ?";
        try (PreparedStatement ps = db.connection.prepareStatement(sql)) {
            ps.setString(1, elemento.getPlaca());
            ps.setString(2, elemento.getPropietario());
            ps.setString(3, elemento.getTipoVehiculo());
            ps.setTimestamp(4, elemento.getHoraEntrada() == null ? null : Timestamp.from(elemento.getHoraEntrada()));
            ps.setTimestamp(5, elemento.getHoraSalida() == null ? null : Timestamp.from(elemento.getHoraSalida()));
            ps.setDouble(6, elemento.getValorPagado());
            ps.setString(7, elemento.getEstado());
            ps.setInt(8, elemento.getId());

            if (ps.executeUpdate() > 0) {
                fueModificado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "modificar: " + e.getMessage());
        }

        return fueModificado;
    }

    @Override
    public boolean eliminar(int id) {
        boolean fueEliminado = false;
        final String sql = "DELETE FROM vehiculos WHERE id = ?";

        try (PreparedStatement ps = db.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                fueEliminado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "modificar: " + e.getMessage());
        }

        return fueEliminado;
    }

    private ArrayList<Vehiculo> generarVehiculos(ResultSet rs) {
        final ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try {
            while (rs.next()) {
                vehiculos.add(new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("propietario"),
                        rs.getString("tipovehiculo"),
                        rs.getTimestamp("horaentrada")  == null ? null : rs.getTimestamp("horaentrada").toInstant(),
                        rs.getTimestamp("horasalida")  == null ? null : rs.getTimestamp("horasalida").toInstant(),
                        rs.getDouble("valorpagado"),
                        rs.getString("estado")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "generarVehiculos: " + e.getMessage());
        }

        return vehiculos;
    }
}
