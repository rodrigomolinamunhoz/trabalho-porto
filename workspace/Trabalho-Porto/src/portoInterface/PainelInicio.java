package portoInterface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class PainelInicio extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelInicio() {
		setBackground(Color.BLUE);
		setLayout(null);
		
		JLabel lblBemvindo = new JLabel("Bem-Vindo");
		lblBemvindo.setFont(new Font("Tahoma", Font.PLAIN, 90));
		lblBemvindo.setForeground(Color.BLACK);
		lblBemvindo.setBounds(0, 87, 450, 95);
		add(lblBemvindo);

	}

}
