package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import portoBackEnd.Caminhao;
import portoBackEnd.Patio;
import portoBackEnd.Transportadora;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.event.ActionEvent;

public class PainelCadastroCaminhao extends JPanel {
	private JTextField textPlaca;
	private JTextField textTransportadora;
	private JTable table;
	private Queue<Caminhao> caminhoes = new LinkedList<Caminhao>();

	public Queue<Caminhao> getCaminhoes() {
		return caminhoes;
	}

	public void setCaminhoes(Queue<Caminhao> caminhoes) {
		this.caminhoes = caminhoes;
	}

	/**
	 * Create the panel.
	 */
	public PainelCadastroCaminhao(Patio patio) {
		setBackground(Color.RED);
		setLayout(null);
		setSize(1200, 1800);

		JLabel lblCadastroDeCaminho = new JLabel("Cadastro de Caminh\u00E3o");
		lblCadastroDeCaminho.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblCadastroDeCaminho.setBounds(10, 25, 405, 51);
		add(lblCadastroDeCaminho);

		JLabel lblPlaca = new JLabel("Placa: *");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPlaca.setBounds(20, 87, 136, 14);
		add(lblPlaca);

		textPlaca = new JTextField();
		textPlaca.setBounds(184, 85, 178, 20);
		add(textPlaca);
		textPlaca.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (isNullOrEmpty(textPlaca.getText()) || isNullOrEmpty(textTransportadora.getText())) {
						JOptionPane.showMessageDialog(null, "Placa ou Transportadora n�o foram informadas!", "Informa��o",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Transportadora transportadora = new Transportadora(textTransportadora.getText());
						caminhoes.add(new Caminhao(textPlaca.getText(), transportadora));
						listarCaminhoes(caminhoes);
						patio.setCaminhoes(caminhoes);
						limparFormulario();
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Algo de errado aconteceu, tente novamente!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(273, 143, 89, 23);
		add(btnSalvar);

		JLabel lblNewLabel = new JLabel("Nome Transportadora: *");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 114, 142, 14);
		add(lblNewLabel);

		textTransportadora = new JTextField();
		textTransportadora.setBounds(184, 112, 178, 20);
		add(textTransportadora);
		textTransportadora.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 189, 484, 151);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Placa", "Nome Transportadora" }) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
	}

	public void listarCaminhoes(Queue<Caminhao> caminhoes) {
		DefaultTableModel dt = (DefaultTableModel) table.getModel();
		clearTable(dt);
		for (Caminhao caminhao : caminhoes) {
			dt.addRow(new String[] { caminhao.getPlaca(), caminhao.getTransportadora().getRazaoSocial() });
		}
	}
	
	private boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}
	
	private void limparFormulario() {
		textPlaca.setText("");
		textTransportadora.setText("");
	}
	
	private void clearTable(DefaultTableModel dt) {
		dt.setRowCount(0);
	}
}
