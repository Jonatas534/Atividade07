package view;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import control.DisciplinaControle;
import control.ProfessorControle;
import model.Disciplina;
import model.Professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCRUDProfessor extends JInternalFrame {

	private Professor objeto;
	private ProfessorControle controle = new ProfessorControle();
	private JTextField textCodigo;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDProfessor frame = new TelaCRUDProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCRUDProfessor() {
		setBounds(100, 100, 450, 300);

		JLabel lblTitulo = new JLabel("Cadastro de Professor");
		lblTitulo.setFont(new Font("Rockwell", Font.PLAIN, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblCodigoProfessor = new JLabel("Codigo");
		lblCodigoProfessor.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textCodigo = new JTextField();
		textCodigo.setColumns(10);

		JLabel lblNomeProfessor = new JLabel("nome :");
		lblNomeProfessor.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textNome = new JTextField();
		textNome.setColumns(10);

		JButton btnInserir = new JButton("inserir");
		btnInserir.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objeto = new Professor(null, textNome.getText());
				controle.inserir(objeto);
				JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
				textCodigo.setText(String.valueOf(objeto.getCodigo()));
				limparTela();
			}
		});

		JButton btnAlterar = new JButton("alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					objeto.setNome(textNome.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Professor alterado com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há objeto a ser modificado.");
					limparTela();
				}
			}
		});
		btnAlterar.setFont(new Font("Rockwell", Font.PLAIN, 12));

		JButton btnExcluir = new JButton("excluir");
		btnExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (objeto != null) {
					controle.excluir(objeto);
					limparTela();
					JOptionPane.showMessageDialog(null, "Professor excluído com sucesso.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há objeto a ser excluído.");
				}

			}
		});
		btnExcluir.setFont(new Font("Rockwell", Font.PLAIN, 12));

		JButton btnConsultar = new JButton("consultar");

		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valor = Integer.parseInt(textCodigo.getText());
				objeto = controle.buscarPorId(valor);
				if (objeto != null) {
					textCodigo.setText(String.valueOf(objeto.getCodigo()));
					textNome.setText(objeto.getNome());
				} else {
					JOptionPane.showMessageDialog(null, "Não há Professor  com esse código");
					textCodigo.setText("");
				}

			}
		});

		JButton btnFechar = new JButton("fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnFechar.setFont(new Font("Rockwell", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodigoProfessor)
								.addComponent(lblNomeProfessor))
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(btnNewButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoProfessor)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInserir))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNomeProfessor)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAlterar))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnConsultar)
							.addGap(18)
							.addComponent(btnFechar)
							.addContainerGap(27, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(38))))
		);
		panel.setLayout(gl_panel);

	}

	public void limparTela() {

		if (objeto != null) {
			controle.excluir(objeto);
			objeto = null;
			textCodigo.setText("");
			textNome.setText("");
		}
	}
}
