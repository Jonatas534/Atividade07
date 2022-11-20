package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import control.DisciplinaControle;
import model.Disciplina;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCRUDDisciplina extends JInternalFrame {

	private Disciplina objeto;
	private DisciplinaControle controle = new DisciplinaControle();

	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textSigla;
	private JTextField textCargaHoraria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDDisciplina frame = new TelaCRUDDisciplina();
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
	public TelaCRUDDisciplina() {
		setBounds(100, 100, 450, 300);

		JLabel lblTitulo = new JLabel("Cadastro de Disciplina");
		lblTitulo.setFont(new Font("Rockwell", Font.PLAIN, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTitulo, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblCodDisciplina = new JLabel("Codigo :");
		lblCodDisciplina.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textCodigo = new JTextField();
		textCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textNome = new JTextField();
		textNome.setColumns(10);

		JButton btnInserir = new JButton("inserir");
		btnInserir.setFont(new Font("Rockwell", Font.PLAIN, 12));
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				objeto = new Disciplina(null, textNome.getText(), textSigla.getText(), textCargaHoraria.getText());
				controle.inserir(objeto);
				JOptionPane.showMessageDialog(null, "Disciplina cadastrado com sucesso");
				textCodigo.setText(String.valueOf(objeto.getCodigo()));

			}
		});

		JButton btnAlterar = new JButton("alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Código: if (objeto != null) {
					objeto.setNome(textNome.getText());
					objeto.setSigla(textSigla.getText());
					controle.alterar(objeto);
					JOptionPane.showMessageDialog(null, "Disciplina alterado com sucesso.");
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
					JOptionPane.showMessageDialog(null, "Disciplina excluído com sucesso.");
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
					textSigla.setText(objeto.getSigla());
				} else {
					JOptionPane.showMessageDialog(null, "Não há Disciplina com esse código");
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

		JLabel lblSiglaDiscipina = new JLabel("Sigla :");
		lblSiglaDiscipina.setFont(new Font("Rockwell", Font.PLAIN, 14));

		JLabel lblCargaHoraria = new JLabel("CargaHoraria :");
		lblCargaHoraria.setFont(new Font("Rockwell", Font.PLAIN, 14));

		textSigla = new JTextField();
		textSigla.setColumns(10);

		textCargaHoraria = new JTextField();
		textCargaHoraria.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCargaHoraria)
						.addComponent(lblCodDisciplina)
						.addComponent(lblNome)
						.addComponent(lblSiglaDiscipina))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnFechar, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addComponent(btnInserir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCodDisciplina)
							.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnAlterar))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNome)
							.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnInserir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(btnExcluir)
							.addGap(18)
							.addComponent(btnConsultar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSiglaDiscipina)
								.addComponent(textSigla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCargaHoraria)
								.addComponent(textCargaHoraria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFechar)
					.addContainerGap(34, Short.MAX_VALUE))
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
