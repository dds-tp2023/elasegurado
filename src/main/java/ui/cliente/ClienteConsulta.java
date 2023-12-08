package ui.cliente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dto.BusquedaClienteDTO;
import dto.ClienteDTO;
import dto.UsuarioDTO;
import enums.TipoDocumento;
import gestores.GestorCliente;
import ui.menus.MenuProductorSeguro;
import ui.poliza.PolizaAlta1;
import utils.DocumentFilterLimit;

@SuppressWarnings("serial")
public class ClienteConsulta extends JPanel {
	private JFrame ventana;
	private JPanel panelPolizaAlta;
	private GridBagConstraints gbc;
	private GridBagConstraints gbcBusquedaCliente;
	private GridBagConstraints gbcBusquedaClienteBotones;
	private GridBagConstraints gbcResultadoBusqueda;
	private JPanel panelBusquedaCliente;
	private JPanel panelBusquedaClienteBotones;
	private JPanel panelResultadoBusqueda;
	private JLabel lblNumCliente;
	private JTextField txtNumCliente;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblTipoDocumento;
	private JComboBox<String> cbTipoDocumento;
	private JLabel lblNumDocumeto;
	private JTextField txtNumDocumento;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JTable tablaResultadoBusqueda;
	private DefaultTableModel modeloTablaResultadoBusqueda;
	private JScrollPane scrollTablaResultadoBusqueda;
	private JButton btnPaginaAnterior;
	private JButton btnPaginaSiguiente;
	private JButton btnSeleccionar;
	private JButton btnCancelar;

	private GestorCliente gestorCliente = GestorCliente.getInstancia();

	private UsuarioDTO usuarioDTO;
	
	private List<ClienteDTO> clientesDTO;

	private int paginaActual = 0;
	
	private Integer cantidadRegistros;
	
	public ClienteConsulta(JFrame ventana, JPanel panelPolizaAlta,UsuarioDTO usuarioDTO) {
		this.ventana = ventana;
		this.panelPolizaAlta = panelPolizaAlta;
		this.usuarioDTO = usuarioDTO;
		this.gbc = new GridBagConstraints();
		this.gbcBusquedaCliente = new GridBagConstraints();
		this.gbcBusquedaClienteBotones = new GridBagConstraints();
		this.gbcResultadoBusqueda = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.panelBusquedaCliente = new JPanel();
		this.panelResultadoBusqueda = new JPanel();
		this.armarPaneles();
		this.armarContenido();
	}

	private void armarPaneles() {
		panelBusquedaCliente.setLayout(new GridBagLayout());
		panelBusquedaCliente.setBorder(BorderFactory.createTitledBorder("Búsqueda de Cliente"));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		this.add(panelBusquedaCliente, gbc);

		panelResultadoBusqueda.setLayout(new GridBagLayout());
		panelResultadoBusqueda.setBorder(BorderFactory.createTitledBorder("Resultado de Búsqueda"));
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(panelResultadoBusqueda, gbc);
	}

	private void armarContenido() {
		lblNumCliente = new JLabel("Número Cliente");
		gbcBusquedaCliente.gridx = 0;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.anchor = GridBagConstraints.WEST;
		gbcBusquedaCliente.insets = new Insets(10, 10, 10, 10);
		panelBusquedaCliente.add(lblNumCliente, gbcBusquedaCliente);
		
		txtNumCliente = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtNumCliente.setDocument(new DocumentFilterLimit(11));
		gbcBusquedaCliente.gridx = 1;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.weightx = 0.33;
		gbcBusquedaCliente.anchor = GridBagConstraints.CENTER;
		gbcBusquedaCliente.fill = GridBagConstraints.HORIZONTAL;
		panelBusquedaCliente.add(txtNumCliente, gbcBusquedaCliente);
		
		lblApellido = new JLabel("Apellido");
		gbcBusquedaCliente.gridx = 2;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.weightx = 0;
		gbcBusquedaCliente.anchor = GridBagConstraints.WEST;
		gbcBusquedaCliente.fill = GridBagConstraints.NONE;
		panelBusquedaCliente.add(lblApellido, gbcBusquedaCliente);
		
		txtApellido = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtApellido.setDocument(new DocumentFilterLimit(40));
		gbcBusquedaCliente.gridx = 3;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.weightx = 0.33;
		gbcBusquedaCliente.anchor = GridBagConstraints.CENTER;
		gbcBusquedaCliente.fill = GridBagConstraints.HORIZONTAL;
		panelBusquedaCliente.add(txtApellido, gbcBusquedaCliente);
		
		lblNombre = new JLabel("Nombre");
		gbcBusquedaCliente.gridx = 4;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.weightx = 0;
		gbcBusquedaCliente.anchor = GridBagConstraints.WEST;
		gbcBusquedaCliente.fill = GridBagConstraints.NONE;
		panelBusquedaCliente.add(lblNombre, gbcBusquedaCliente);
		
		txtNombre = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtNombre.setDocument(new DocumentFilterLimit(40));
		gbcBusquedaCliente.gridx = 5;
		gbcBusquedaCliente.gridy = 0;
		gbcBusquedaCliente.weightx = 0.33;
		gbcBusquedaCliente.anchor = GridBagConstraints.CENTER;
		gbcBusquedaCliente.fill = GridBagConstraints.HORIZONTAL;
		panelBusquedaCliente.add(txtNombre, gbcBusquedaCliente);
		
		lblTipoDocumento = new JLabel("Tipo Documento");
		gbcBusquedaCliente.gridx = 0;
		gbcBusquedaCliente.gridy = 1;
		gbcBusquedaCliente.weightx = 0;
		gbcBusquedaCliente.anchor = GridBagConstraints.WEST;
		gbcBusquedaCliente.fill = GridBagConstraints.NONE;
		panelBusquedaCliente.add(lblTipoDocumento, gbcBusquedaCliente);
		
		cbTipoDocumento = new JComboBox<>();
		gbcBusquedaCliente.gridx = 1;
		gbcBusquedaCliente.gridy = 1;
		gbcBusquedaCliente.anchor = GridBagConstraints.CENTER;
		gbcBusquedaCliente.fill = GridBagConstraints.HORIZONTAL;
		panelBusquedaCliente.add(cbTipoDocumento, gbcBusquedaCliente);
		cbTipoDocumento.addItem("SELECCIONAR");
		List<String> tiposDocumentos = new ArrayList<String>();
		for(TipoDocumento tipoDoc : TipoDocumento.values()) {
			tiposDocumentos.add(tipoDoc.toString());
		}
		tiposDocumentos.sort((s1,s2) -> s1.compareTo(s2));
		for(String s : tiposDocumentos) {
			cbTipoDocumento.addItem(s);
		}
		cbTipoDocumento.setSelectedItem("DNI");
		
		lblNumDocumeto = new JLabel("Número Documento");
		gbcBusquedaCliente.gridx = 2;
		gbcBusquedaCliente.gridy = 1;
		gbcBusquedaCliente.anchor = GridBagConstraints.WEST;
		gbcBusquedaCliente.fill = GridBagConstraints.NONE;
		panelBusquedaCliente.add(lblNumDocumeto, gbcBusquedaCliente);
		
		txtNumDocumento = new JTextField();
		// Limitar la cantidad de caracteres usando un DocumentFilter
		txtNumDocumento.setDocument(new DocumentFilterLimit(20));
		gbcBusquedaCliente.gridx = 3;
		gbcBusquedaCliente.gridy = 1;
		gbcBusquedaCliente.anchor = GridBagConstraints.CENTER;
		gbcBusquedaCliente.fill = GridBagConstraints.HORIZONTAL;
		panelBusquedaCliente.add(txtNumDocumento, gbcBusquedaCliente);
		
		panelBusquedaClienteBotones = new JPanel();
		panelBusquedaClienteBotones.setLayout(new GridBagLayout());
		gbcBusquedaCliente.gridx = 0;
		gbcBusquedaCliente.gridy = 2;
		gbcBusquedaCliente.gridwidth = 6;
		gbcBusquedaCliente.weightx = 1;
		gbcBusquedaCliente.insets = new Insets(0, 0, 0, 0);
		panelBusquedaCliente.add(panelBusquedaClienteBotones, gbcBusquedaCliente);
		
		btnBuscar = new JButton("Buscar");
		gbcBusquedaClienteBotones.gridx = 0;
		gbcBusquedaClienteBotones.gridy = 0;
		gbcBusquedaClienteBotones.weightx = 1;
		gbcBusquedaClienteBotones.anchor = GridBagConstraints.EAST;
		gbcBusquedaClienteBotones.fill = GridBagConstraints.NONE;
		gbcBusquedaClienteBotones.insets = new Insets(10, 10, 10, 10);
		panelBusquedaClienteBotones.add(btnBuscar, gbcBusquedaClienteBotones);
		btnBuscar.addActionListener(e -> {
			
			if(!ingresoAlMenosUnCriterio()){
				mensajeCriterioDeBusqueda();
			}
			else {
				BusquedaClienteDTO criterios = new BusquedaClienteDTO();
				criterios.setNroCliente(txtNumCliente.getText());
				criterios.setApellido(txtApellido.getText());
				criterios.setNombre(txtNombre.getText());
				criterios.setTipoDocumento(cbTipoDocumento.getSelectedItem().toString());
				criterios.setDocumento(txtNumDocumento.getText());
				clientesDTO = gestorCliente.buscarClienteSegunCriterio(criterios);
				if(clientesDTO.size()==0) {
					modeloTablaResultadoBusqueda.setRowCount(0);
					String mensaje = "No existen clientes que cumplen con los criterios ingresados";
					int confirmado = JOptionPane.showOptionDialog(this, mensaje, "INFORMACIÓN", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Dar de Alta Cliente", "Aceptar" }, "Dar de Alta Cliente");
					if (confirmado == 0) {
						ventana.setTitle("Menú - Productor de seguro");
						ventana.setContentPane(new MenuProductorSeguro(ventana,usuarioDTO));
						ventana.setVisible(true);
					}
				}else {
					try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/configuracion.txt"))) {
			       
						br.readLine();
						String filaDeseada = br.readLine();
						cantidadRegistros = Integer.parseInt(filaDeseada);
			            
			        } catch (IOException e1) {
			            
			        }
					modeloTablaResultadoBusqueda.setRowCount(0);
					for(int i = 0; i<cantidadRegistros; i++) {
						ClienteDTO c = clientesDTO.get(i);
						modeloTablaResultadoBusqueda.addRow(new Object[] { c.getId(),c.getApellido(),c.getNombre(),c.getTipoDocumento(),c.getDocumento()});
					}
					btnPaginaSiguiente.setEnabled(true);
				}
			
			}
			
		});
		
		btnLimpiar = new JButton("Limpiar");
		gbcBusquedaClienteBotones.gridx = 1;
		gbcBusquedaClienteBotones.gridy = 0;
		gbcBusquedaClienteBotones.weightx = 0;
		gbcBusquedaClienteBotones.anchor = GridBagConstraints.CENTER;
		panelBusquedaClienteBotones.add(btnLimpiar, gbcBusquedaClienteBotones);
		btnLimpiar.addActionListener(e -> {
			txtNumCliente.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
			txtNumDocumento.setText("");
			cbTipoDocumento.setSelectedItem("DNI");
		});
		
		modeloTablaResultadoBusqueda = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Para que las celdas no sean editables
                return false;
            }
        };
		modeloTablaResultadoBusqueda.addColumn("Número Cliente");
		modeloTablaResultadoBusqueda.addColumn("Apellido");
		modeloTablaResultadoBusqueda.addColumn("Nombre");
		modeloTablaResultadoBusqueda.addColumn("Tipo Documento");
		modeloTablaResultadoBusqueda.addColumn("Número Documento");
		for (int i = 0; i < 10; i++) {
			modeloTablaResultadoBusqueda.addRow(new Object[] { "" });
		}
		
		tablaResultadoBusqueda = new JTable(modeloTablaResultadoBusqueda);
		tablaResultadoBusqueda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaResultadoBusqueda.setAutoCreateRowSorter(true);//Habilitar ordenamiento por columna
        tablaResultadoBusqueda.getTableHeader().setReorderingAllowed(false); // No permitir reordenar columnas
        int rowHeight = tablaResultadoBusqueda.getRowHeight();
        int numRowsToShow = 10; //El tamaño de la tabla es de 10 filas, si tiene más se desplaza con la barra
        tablaResultadoBusqueda.setPreferredScrollableViewportSize(new Dimension(tablaResultadoBusqueda.getPreferredSize().width, rowHeight * numRowsToShow));
             
        scrollTablaResultadoBusqueda = new JScrollPane(tablaResultadoBusqueda);
        gbcResultadoBusqueda.gridx = 0;
        gbcResultadoBusqueda.gridy = 0;
        gbcResultadoBusqueda.gridwidth = 2;
        gbcResultadoBusqueda.weightx = 1;
        gbcResultadoBusqueda.fill = GridBagConstraints.HORIZONTAL;
        gbcResultadoBusqueda.insets = new Insets(10, 10, 10, 10);
        panelResultadoBusqueda.add(scrollTablaResultadoBusqueda, gbcResultadoBusqueda);
        
     // Crear botones de paginación
        btnPaginaAnterior = new JButton("Anterior");
        btnPaginaAnterior.setEnabled(false);
        gbcResultadoBusqueda.gridx = 0;
        gbcResultadoBusqueda.gridy = 1;
        gbcResultadoBusqueda.gridwidth = 1;
        gbcResultadoBusqueda.weightx = 0.5;
		gbcResultadoBusqueda.anchor = GridBagConstraints.EAST;
		gbcResultadoBusqueda.fill = GridBagConstraints.NONE;
		panelResultadoBusqueda.add(btnPaginaAnterior, gbcResultadoBusqueda);
        btnPaginaAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginaAnterior();
            }
        });

        btnPaginaSiguiente = new JButton("Siguiente");
        btnPaginaSiguiente.setEnabled(false);
        gbcResultadoBusqueda.gridx = 1;
        gbcResultadoBusqueda.gridy = 1;
		gbcResultadoBusqueda.anchor = GridBagConstraints.WEST;
		panelResultadoBusqueda.add(btnPaginaSiguiente, gbcResultadoBusqueda);
        btnPaginaSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paginaSiguiente();
            }

        });
        
        btnSeleccionar = new JButton("Seleccionar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		this.add(btnSeleccionar, gbc);
		btnSeleccionar.addActionListener(e -> {
			if(tablaResultadoBusqueda.getSelectedRow() == -1) {
				mensajeSeleccionarCliente();
			}else {
				Integer id = (Integer) tablaResultadoBusqueda.getValueAt(tablaResultadoBusqueda.getSelectedRow(), 0);
				ClienteDTO clienteDTO = gestorCliente.findCliente(id); 
				ventana.setTitle("Póliza - Alta - 1");
				ventana.setContentPane(new PolizaAlta1(ventana, new MenuProductorSeguro(ventana,usuarioDTO), usuarioDTO, clienteDTO));
				ventana.setVisible(true);
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(btnCancelar, gbc);
		btnCancelar.addActionListener(e -> {
			String mensaje = "¿Deseas cancelar la búsqueda de cliente?";
			int confirmado = JOptionPane.showOptionDialog(this, mensaje, "CONFIRMACIÓN", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, new Object[] { "SI", "NO" }, "SI");
			if (confirmado == 0) {
				ventana.setTitle("Póliza - Alta - 1");
				ventana.setContentPane(panelPolizaAlta);
				ventana.setVisible(true);
			}
		});
	}

	private boolean ingresoAlMenosUnCriterio() {
		int contador=0;
		if(!txtNumCliente.getText().isBlank()) contador++;
		if(!txtApellido.getText().isBlank()) contador++;
		if(!txtNombre.getText().isBlank()) contador++;
		if(!cbTipoDocumento.getSelectedItem().toString().equals("SELECCIONAR")) contador++;
		if(!txtNumDocumento.getText().isBlank()) contador++;
		return contador!=0;
	}

	private void mensajeCriterioDeBusqueda() {
		String mensaje = "Debe ingresar al menos un criterio de busqueda";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	private void mensajeSeleccionarCliente() {
		String mensaje = "Debe seleccionar un cliente";
		JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	private void paginaAnterior() {
		if (paginaActual > 0) {
            paginaActual--;
            updateTable();
        }
		if(paginaActual == 0) {
			btnPaginaAnterior.setEnabled(false);
			btnPaginaSiguiente.setEnabled(true);
		}
		
	}
	
	// Método para actualizar la tabla con los datos de la página actual
    private void updateTable() {
        int startRow = paginaActual * cantidadRegistros;
        int endRow = Math.min((paginaActual + 1) * cantidadRegistros, clientesDTO.size());

        modeloTablaResultadoBusqueda.setRowCount(0);
		for(int i = startRow; i<endRow; i++) {
			ClienteDTO c = clientesDTO.get(i);
			modeloTablaResultadoBusqueda.addRow(new Object[] { c.getId(),c.getApellido(),c.getNombre(),c.getTipoDocumento(),c.getDocumento()});
		}
		if((paginaActual + 1) * cantidadRegistros >= clientesDTO.size()) btnPaginaSiguiente.setEnabled(false);
    }


	private void paginaSiguiente() {
		int totalRows = clientesDTO.size();
        int startRow = (paginaActual + 1) * cantidadRegistros;
        if (startRow < totalRows) {
            paginaActual++;
            updateTable();
        }
        if(paginaActual != 0) btnPaginaAnterior.setEnabled(true);
	}

}