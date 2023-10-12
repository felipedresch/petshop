package petshop;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import petshop.Cliente;
import petshop.Pet;
import java.awt.Color;
import javax.swing.JCheckBox;

public class Petshop {

	private JFrame frame;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private JTextField txtData;
	private JTextField txtHora;
	private JTextField txtServico;
	private JTextField txtPreco;
	private JTextField txtRemoverCPF;
	private JTextField txtNomeCliente;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCPF;
	private JTextField txtNomePet;
	private JTextField txtEspecie;
	private JTextField txtRaca;
	private JTextField txtIdadePet;
	private JTextField txtRemoverCliente;
	private JTextField txtCpfRemoverPet;
	private JTextField txtNomePetRemover;
	private JTextField txtCpfDonoPet;
	private JTextField txtCpfConsulta;
	private JTextField txtTentativa;
	private JLabel lblDica;
	private JLabel lblNivel;
	private JLabel lblTentativas;
	private JLabel lblPalavra;
	private JLabel lblLetras;
	private JLabel lblPalpites;
	private int erros = 0, z = 0, contador = 0, tentativas = 0;
	private boolean x = true;
	private boolean proximo = false;
	private Niveis niveis;
	private String palavra;
	private int r1;
	private int r2;
	private JLabel lblTentativasFeitas;
	private char[] espacosChars;
	private String[] espacos;
	private char[] palpitesErrados;

	private boolean errou;
	private char verifica;
	private JPanel panelEasterEggComeco;
	private JTextField txtNomeClienteConsulta;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Petshop window = new Petshop();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Petshop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Pet pet = new Pet(null, null, null, null, null);
		Cliente cliente = new Cliente(null, null, null, null);

		int a = 0;

		String linhaPet = null;
		String linhaConsultas = null;
		String linhaCliente = null;

		File Cadastro = new File("Cadastro");
		Cadastro.mkdir();
		File Pets = new File("Cadastro/Pets.txt");
		File Clientes = new File("Cadastro/Clientes.txt");
		File Consultas = new File("Cadastro/Consultas.txt");

		try {
			Pets.createNewFile();
			Clientes.createNewFile();
			Consultas.createNewFile();
			FileReader frPets = new FileReader(Pets);
			FileReader frClientes = new FileReader(Clientes);
			FileReader frConsultas = new FileReader(Consultas);
			BufferedReader brPets = new BufferedReader(frPets);
			BufferedReader brClientes = new BufferedReader(frClientes);
			BufferedReader brConsultas = new BufferedReader(frConsultas);

			linhaPet = brPets.readLine();
			while ((linhaPet != null)) {
				String[] textoSeparado = linhaPet.split(", ");
				String nomePet = textoSeparado[a];
				String especie = textoSeparado[a + 1];
				String raca = textoSeparado[a + 2];
				String idade = textoSeparado[a + 3];
				String cpfDono = textoSeparado[a + 4];
				Pet pets = new Pet(nomePet, especie, raca, idade, cpfDono);
				cliente.getPets().add(pets);
				linhaPet = brPets.readLine();
			}

			linhaConsultas = brConsultas.readLine();
			while ((linhaConsultas != null)) {
				String[] textoSeparadoo = linhaConsultas.split(", ");
				String data = textoSeparadoo[a];
				String hora = textoSeparadoo[a + 1];
				String preco = textoSeparadoo[a + 2];
				String servico = textoSeparadoo[a + 3];
				String cpfConsulta = textoSeparadoo[a + 4];
				String nomeClienteConsulta = textoSeparadoo[a + 5];
				Consulta consultas = new Consulta(data, hora, servico, preco, cpfConsulta, nomeClienteConsulta);
				pet.getConsultas().add(consultas);
				linhaConsultas = brConsultas.readLine();
			}

			linhaCliente = brClientes.readLine();
			while ((linhaCliente != null)) {
				String[] textoSeparadooo = linhaCliente.split(", ");
				String nomeDono = textoSeparadooo[a];
				String telefone = textoSeparadooo[a + 1];
				String cpf = textoSeparadooo[a + 2];
				String endereco = textoSeparadooo[a + 3];
				Cliente clientess = new Cliente(nomeDono, telefone, cpf, endereco);
				clientes.add(clientess);
				linhaCliente = brClientes.readLine();
			}

			frPets.close();
			frConsultas.close();
			frClientes.close();
			brPets.close();
			brClientes.close();
			brConsultas.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		frame = new JFrame();
		frame.setBounds(100, 100, 649, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel panelOpcoes = new JPanel();
		panel.add(panelOpcoes, "name_12097434299500");
		panelOpcoes.setLayout(null);

		JLabel lblSelecioneAOpo = new JLabel("Selecione a op\u00E7\u00E3o desejada no menu acima");
		lblSelecioneAOpo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelecioneAOpo.setBounds(145, 151, 325, 19);
		panelOpcoes.add(lblSelecioneAOpo);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(229, 221, 157, 23);
		panelOpcoes.add(btnSair);

		JLabel titulo = new JLabel("PET SH  P");
		titulo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 42));
		titulo.setBounds(179, 33, 265, 65);
		panelOpcoes.add(titulo);
		
		JLabel labelCat = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img/gato.png")).getImage();
		labelCat.setIcon(new ImageIcon(img));
		labelCat.setBounds(45, 11, 135, 129);
		panelOpcoes.add(labelCat);
		
		JLabel labelCao = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/img/cao.png")).getImage();
		labelCao.setIcon(new ImageIcon(img2));
		labelCao.setBounds(446, 11, 135, 129);
		panelOpcoes.add(labelCao);
		
		JLabel labelPata = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/img/pata.png")).getImage();
		labelPata.setIcon(new ImageIcon(img4));
		labelPata.setBounds(354, 33, 32, 65);
		panelOpcoes.add(labelPata);

		JPanel panelAgendar = new JPanel();
		panel.add(panelAgendar, "name_12102018142800");
		panelAgendar.setLayout(null);

		JLabel lblData = new JLabel("Data da Consulta:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(32, 52, 179, 14);
		panelAgendar.add(lblData);

		JLabel lblHoraConsulta = new JLabel("Hora da Consulta:");
		lblHoraConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoraConsulta.setBounds(32, 114, 179, 14);
		panelAgendar.add(lblHoraConsulta);

		JLabel lblServico = new JLabel("Servi\u00E7o Desejado:");
		lblServico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServico.setBounds(32, 176, 179, 22);
		panelAgendar.add(lblServico);

		JLabel lblPreco = new JLabel("Pre\u00E7o do Servi\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPreco.setBounds(32, 246, 179, 22);
		panelAgendar.add(lblPreco);

		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtData.setBounds(32, 80, 179, 20);
		panelAgendar.add(txtData);
		txtData.setColumns(10);

		txtHora = new JTextField();
		txtHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHora.setColumns(10);
		txtHora.setBounds(32, 142, 179, 20);
		panelAgendar.add(txtHora);

		txtServico = new JTextField();
		txtServico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtServico.setColumns(10);
		txtServico.setBounds(32, 212, 179, 20);
		panelAgendar.add(txtServico);

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPreco.setColumns(10);
		txtPreco.setBounds(32, 282, 179, 20);
		panelAgendar.add(txtPreco);

		JButton btnSalvarConsulta = new JButton("Salvar");
		btnSalvarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtData.getText().equals("") || txtHora.getText().equals("") || txtServico.getText().equals("") || txtPreco.getText().equals("") || txtCpfConsulta.getText().equals("") || txtNomeClienteConsulta.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}else {
					boolean ocupado = false;
					for (int i = 0; i < pet.getConsultas().size(); i++) {
						String data = pet.getConsultas().get(i).getData();
						String hora = pet.getConsultas().get(i).getHora();
						
						if (data.equals(txtData.getText()) && hora.equals(txtHora.getText())) {
							ocupado = true;
						}
					}
					if (ocupado) {
						JOptionPane.showMessageDialog(null, "Este hor�rio est� indispon�vel!");
					}else {
						String data = txtData.getText();
						String hora = txtHora.getText();
						String servico = txtServico.getText();
						String preco = txtPreco.getText();
						String cpfConsulta = txtCpfConsulta.getText();
						String nomeClienteConsulta = txtNomeClienteConsulta.getText();
						Consulta consulta = new Consulta(data, hora, servico, preco, cpfConsulta, nomeClienteConsulta);
						pet.getConsultas().add(consulta);
						try {
							FileWriter fwConsultas = new FileWriter(Consultas, false);
							BufferedWriter bwConsultas = new BufferedWriter(fwConsultas);
							for (int i = 0; i < pet.getConsultas().size(); i++) {
								fwConsultas.write(pet.getConsultas().get(i).getNomeClienteConsulta() + ", "
										+ pet.getConsultas().get(i).getData() + ", " + pet.getConsultas().get(i).getHora()
										+ ", " + pet.getConsultas().get(i).getServico() + ", "
										+ pet.getConsultas().get(i).getPreco() + ", "
										+ pet.getConsultas().get(i).getCpfConsulta() + "\n");
							}
							bwConsultas.close();
							fwConsultas.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		btnSalvarConsulta.setBounds(353, 212, 179, 23);
		panelAgendar.add(btnSalvarConsulta);

		JButton btnLimparCocnsulta = new JButton("Limpar Campos");
		btnLimparCocnsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeClienteConsulta.setText("");
				txtCpfConsulta.setText("");
				txtData.setText("");
				txtHora.setText("");
				txtServico.setText("");
				txtPreco.setText("");
			}
		});
		btnLimparCocnsulta.setBounds(353, 248, 179, 23);
		panelAgendar.add(btnLimparCocnsulta);

		JLabel lblDadosDaConsulta = new JLabel("Dados da Consulta");
		lblDadosDaConsulta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDadosDaConsulta.setBounds(233, 14, 149, 14);
		panelAgendar.add(lblDadosDaConsulta);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpf.setBounds(281, 114, 46, 14);
		panelAgendar.add(lblCpf);

		txtCpfConsulta = new JTextField();
		txtCpfConsulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpfConsulta.setColumns(10);
		txtCpfConsulta.setBounds(281, 142, 326, 20);
		panelAgendar.add(txtCpfConsulta);

		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(281, 52, 179, 14);
		panelAgendar.add(lblNomeDoCliente);

		txtNomeClienteConsulta = new JTextField();
		txtNomeClienteConsulta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomeClienteConsulta.setColumns(10);
		txtNomeClienteConsulta.setBounds(281, 80, 326, 20);
		panelAgendar.add(txtNomeClienteConsulta);

		JPanel panelCancelar = new JPanel();
		panel.add(panelCancelar, "name_13953079583500");
		panelCancelar.setLayout(null);

		JLabel lblCancelamentoDeConsulta = new JLabel("Cancelamento de Consulta");
		lblCancelamentoDeConsulta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCancelamentoDeConsulta.setBounds(212, 11, 222, 14);
		panelCancelar.add(lblCancelamentoDeConsulta);

		JLabel lblDigiteOCpf = new JLabel("Digite  o  CPF  do  cliente  para realizar o cancelamento da consulta:");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(117, 95, 414, 21);
		panelCancelar.add(lblDigiteOCpf);

		txtRemoverCPF = new JTextField();
		txtRemoverCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRemoverCPF.setBounds(117, 123, 414, 20);
		panelCancelar.add(txtRemoverCPF);
		txtRemoverCPF.setColumns(10);

		JButton btnCancelarConsulta = new JButton("Cancelar Consulta");
		btnCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRemoverCPF.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}else {
					for (int i = 0; i < pet.getConsultas().size(); i++) {
						if (pet.getConsultas().get(i).getCpfConsulta().equals(txtRemoverCPF.getText())) {
							try {
								pet.getConsultas().remove(i);
								FileWriter fwConsultas = new FileWriter(Consultas, false);
								BufferedWriter bwConsultas = new BufferedWriter(fwConsultas);
								for (int j = 0; j < pet.getConsultas().size(); j++) {
									fwConsultas.write(
											pet.getConsultas().get(j).getData() + ", " + pet.getConsultas().get(j).getHora()
													+ ", " + pet.getConsultas().get(j).getServico() + ", "
													+ pet.getConsultas().get(j).getServico() + ", "
													+ pet.getConsultas().get(j).getCpfConsulta() + "\n");
								}
								bwConsultas.close();
								fwConsultas.close();
							} catch (IOException e2) {
								e2.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Consulta n�o encontrada! Verifique as informa��es inseridas.");
						}
					}
				}
			}
		});
		btnCancelarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelarConsulta.setBounds(252, 195, 142, 23);
		panelCancelar.add(btnCancelarConsulta);

		JButton btnLimpar_1 = new JButton("Limpar");
		btnLimpar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limpar TextArea do cancelar consulta
				txtRemoverCPF.setText("");
			}
		});
		btnLimpar_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar_1.setBounds(252, 229, 142, 23);
		panelCancelar.add(btnLimpar_1);

		JPanel panelCliente = new JPanel();
		panel.add(panelCliente, "name_14336746273800");
		panelCliente.setLayout(null);

		JLabel lblDadosDoCliente = new JLabel("Dados do Cliente");
		lblDadosDoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDadosDoCliente.setBounds(245, 11, 153, 14);
		panelCliente.add(lblDadosDoCliente);

		JLabel lblNomeCliente = new JLabel("Nome Completo:");
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCliente.setBounds(10, 64, 107, 20);
		panelCliente.add(lblNomeCliente);

		JLabel lblTelefone = new JLabel("Telefone para Contato:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 116, 141, 20);
		panelCliente.add(lblTelefone);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCPF.setBounds(10, 168, 107, 20);
		panelCliente.add(lblCPF);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndereco.setBounds(10, 220, 107, 20);
		panelCliente.add(lblEndereco);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomeCliente.setBounds(10, 87, 590, 20);
		panelCliente.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 139, 388, 20);
		panelCliente.add(txtTelefone);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 243, 590, 20);
		panelCliente.add(txtEndereco);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 191, 388, 20);
		panelCliente.add(txtCPF);

		JButton btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomeCliente.getText().equals("") || txtCPF.getText().equals("") || txtEndereco.getText().equals("") || txtTelefone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}else {
					int sim = 0;
					for (int i = 0; i < clientes.size(); i++) {
						String cpf = clientes.get(i).getCpf();
						String telefone = clientes.get(i).getTelefone();
						if (cpf.equals(txtCPF.getText()) || telefone.equals(txtTelefone.getText())) {
							sim++;
						}
					}
					if (sim > 0) {
						JOptionPane.showMessageDialog(null, "Cliente j� cadastrado");
					}else {
						String nomeCliente = txtNomeCliente.getText();
						String CPF = txtCPF.getText();
						String endereco = txtEndereco.getText();
						String telefone = txtTelefone.getText();
						Cliente cliente = new Cliente(nomeCliente, telefone, CPF, endereco);
						clientes.add(cliente);
						try {
							FileWriter fwClientes = new FileWriter(Clientes, false);
							BufferedWriter bwClientes = new BufferedWriter(fwClientes);
							for (int i = 0; i < clientes.size(); i++) {
								fwClientes.write(clientes.get(i).getNomeDono() + ", " + clientes.get(i).getTelefone() + ", "
										+ clientes.get(i).getCpf() + ", " + clientes.get(i).getEndereco() + "\n");
							}
							bwClientes.close();
							fwClientes.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					}
				}
				
				
			}
		});
		btnSalvarCliente.setBounds(438, 139, 131, 23);
		panelCliente.add(btnSalvarCliente);

		JButton btnLimparCliente = new JButton("Limpar Campos");
		btnLimparCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtTelefone.setText("");
				txtCPF.setText("");
				txtEndereco.setText("");
			}
		});
		btnLimparCliente.setBounds(438, 191, 131, 23);
		panelCliente.add(btnLimparCliente);

		JPanel panelPet = new JPanel();
		panel.add(panelPet, "name_14427532698800");
		panelPet.setLayout(null);

		JLabel lblDadosDoPet = new JLabel("Dados do Pet");
		lblDadosDoPet.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDadosDoPet.setBounds(252, 10, 118, 14);
		panelPet.add(lblDadosDoPet);

		JLabel lblNomePet = new JLabel("Nome do Pet:");
		lblNomePet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomePet.setBounds(20, 35, 104, 14);
		panelPet.add(lblNomePet);

		JLabel lblEspecie = new JLabel("Esp\u00E9cie:");
		lblEspecie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEspecie.setBounds(20, 89, 104, 14);
		panelPet.add(lblEspecie);

		JLabel lblRaca = new JLabel("Ra\u00E7a:");
		lblRaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRaca.setBounds(20, 143, 104, 14);
		panelPet.add(lblRaca);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(20, 197, 104, 14);
		panelPet.add(lblIdade);

		txtNomePet = new JTextField();
		txtNomePet.setBounds(20, 59, 360, 20);
		panelPet.add(txtNomePet);
		txtNomePet.setColumns(10);

		txtEspecie = new JTextField();
		txtEspecie.setColumns(10);
		txtEspecie.setBounds(20, 113, 360, 20);
		panelPet.add(txtEspecie);

		txtRaca = new JTextField();
		txtRaca.setColumns(10);
		txtRaca.setBounds(20, 167, 360, 20);
		panelPet.add(txtRaca);

		txtIdadePet = new JTextField();
		txtIdadePet.setColumns(10);
		txtIdadePet.setBounds(20, 221, 360, 20);
		panelPet.add(txtIdadePet);

		JButton btnSalvarPet = new JButton("Salvar");
		btnSalvarPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomePet.getText().equals("") || txtEspecie.getText().equals("") || txtRaca.getText().equals("") || txtIdadePet.getText().equals("") || txtCpfDonoPet.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}else {
					int sim = 0;
					for (int i = 0; i < cliente.getPets().size(); i++) {
						String nome = cliente.getPets().get(i).getNomePet();
						String especie = cliente.getPets().get(i).getEspecie();
						String raca = cliente.getPets().get(i).getRaca();
						String idade = cliente.getPets().get(i).getIdade();
						String cpfdono = cliente.getPets().get(i).getCPFDono();
						if (nome.equals(txtNomePet.getText()) && especie.equals(txtEspecie.getText()) && raca.equals(txtRaca.getText()) && idade.equals(txtIdadePet.getText()) && cpfdono.equals(txtCpfDonoPet.getText())) {
							sim++;
						}
					}
					if (sim > 0) {
						JOptionPane.showMessageDialog(null, "Pet j� cadastrado!");
					}else {
						String nomePet = txtNomePet.getText();
						String especie = txtEspecie.getText();
						String raca = txtRaca.getText();
						String idade = txtIdadePet.getText();
						String cpfDono = txtCpfDonoPet.getText();
						Pet pet = new Pet(nomePet, especie, raca, idade, cpfDono);
						cliente.getPets().add(pet);

						try {
							FileWriter fwPets = new FileWriter(Pets, false);
							BufferedWriter bwPets = new BufferedWriter(fwPets);
							for (int i = 0; i < cliente.getPets().size(); i++) {
								fwPets.write(cliente.getPets().get(i).getNomePet() + ", "
										+ cliente.getPets().get(i).getEspecie() + ", " + cliente.getPets().get(i).getRaca()
										+ ", " + cliente.getPets().get(i).getIdade() + ", "
										+ cliente.getPets().get(i).getCPFDono() + "\n");
							}
							bwPets.close();
							fwPets.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
					
			}
		});
		btnSalvarPet.setBounds(443, 133, 131, 23);
		panelPet.add(btnSalvarPet);

		JButton btnLimparPet = new JButton("Limpar Campos");
		btnLimparPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomePet.setText("");
				txtEspecie.setText("");
				txtRaca.setText("");
				txtIdadePet.setText("");
			}
		});
		btnLimparPet.setBounds(443, 187, 131, 23);
		panelPet.add(btnLimparPet);

		JLabel lblCpfDono = new JLabel("CPF Dono:");
		lblCpfDono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfDono.setBounds(20, 251, 86, 14);
		panelPet.add(lblCpfDono);

		txtCpfDonoPet = new JTextField();
		txtCpfDonoPet.setColumns(10);
		txtCpfDonoPet.setBounds(20, 275, 360, 20);
		panelPet.add(txtCpfDonoPet);

		JPanel panelRemoverPet = new JPanel();
		panel.add(panelRemoverPet, "name_466236207049200");
		panelRemoverPet.setLayout(null);

		JLabel lblRemoverPetDo = new JLabel("Remover Pet do Cadastro");
		lblRemoverPetDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemoverPetDo.setBounds(202, 11, 218, 14);
		panelRemoverPet.add(lblRemoverPetDo);

		JLabel lblDigiteOCpf_2 = new JLabel("CPF  do  dono do pet:");
		lblDigiteOCpf_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf_2.setBounds(10, 153, 208, 21);
		panelRemoverPet.add(lblDigiteOCpf_2);

		txtCpfRemoverPet = new JTextField();
		txtCpfRemoverPet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpfRemoverPet.setColumns(10);
		txtCpfRemoverPet.setBounds(10, 191, 399, 20);
		panelRemoverPet.add(txtCpfRemoverPet);

		JButton btnRemoverPet = new JButton("Remover Pet");
		btnRemoverPet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCpfRemoverPet.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
				}else {
					for (int i = 0; i < cliente.getPets().size(); i++) {
						if (cliente.getPets().get(i).getCPFDono().equals(txtCpfRemoverPet.getText())) {
							if (cliente.getPets().get(i).getNomePet().equals(txtNomePetRemover.getText())) {
								try {
									cliente.getPets().remove(i);
									FileWriter fwPet = new FileWriter(Pets, false);
									BufferedWriter bwPet = new BufferedWriter(fwPet);
									for (int j = 0; j < cliente.getPets().size(); j++) {
										fwPet.write(cliente.getPets().get(j).getNomePet() + ", "
												+ cliente.getPets().get(j).getEspecie() + ", "
												+ cliente.getPets().get(j).getRaca() + ", "
												+ cliente.getPets().get(j).getIdade() + ", "
												+ cliente.getPets().get(j).getCPFDono() + "\n");
									}
									bwPet.close();
									fwPet.close();
								} catch (IOException e2) {
									e2.printStackTrace();
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Pet n�o encontrado! Verifique as informa��es inseridas.");
						}
					}
				}
				
			}
		});
		btnRemoverPet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoverPet.setBounds(447, 115, 142, 23);
		panelRemoverPet.add(btnRemoverPet);

		JLabel lblNomeDoPet = new JLabel("Nome do Pet:");
		lblNomeDoPet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoPet.setBounds(10, 78, 208, 21);
		panelRemoverPet.add(lblNomeDoPet);

		txtNomePetRemover = new JTextField();
		txtNomePetRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomePetRemover.setColumns(10);
		txtNomePetRemover.setBounds(10, 116, 399, 20);
		panelRemoverPet.add(txtNomePetRemover);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// limpar campos remover pet
				txtNomePetRemover.setText("");
				txtCpfRemoverPet.setText("");
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimparCampos.setBounds(447, 190, 142, 23);
		panelRemoverPet.add(btnLimparCampos);

		JPanel panelRemoverCliente = new JPanel();
		panel.add(panelRemoverCliente, "name_466660030690500");
		panelRemoverCliente.setLayout(null);

		JLabel lblExcluirClienteDo = new JLabel("Remover Cliente do Cadastro");
		lblExcluirClienteDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExcluirClienteDo.setBounds(189, 11, 256, 14);
		panelRemoverCliente.add(lblExcluirClienteDo);

		JLabel lblDigiteOCpf_1 = new JLabel("Digite  o  CPF  do  cliente  para remov\u00EA-lo do cadastro:");
		lblDigiteOCpf_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf_1.setBounds(148, 99, 341, 21);
		panelRemoverCliente.add(lblDigiteOCpf_1);

		txtRemoverCliente = new JTextField();
		txtRemoverCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRemoverCliente.setColumns(10);
		txtRemoverCliente.setBounds(112, 126, 414, 20);
		panelRemoverCliente.add(txtRemoverCliente);

		JButton btnRemoverCliente = new JButton("Remover Cliente");
		btnRemoverCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRemoverCliente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo solicitado.");
				}else {
					for (int i = 0; i < clientes.size(); i++) {
						if (clientes.get(i).getCpf().equals(txtRemoverCliente.getText())) {
							try {
								clientes.remove(i);
								FileWriter fwClientes = new FileWriter(Clientes, false);
								BufferedWriter bwClientes = new BufferedWriter(fwClientes);
								for (int j = 0; j < clientes.size(); j++) {
									fwClientes.write(clientes.get(j).getNomeDono() + ", " + clientes.get(j).getTelefone()
											+ ", " + clientes.get(j).getCpf() + ", " + clientes.get(j).getEndereco()
											+ "\n");
								}
								bwClientes.close();
								fwClientes.close();

							} catch (IOException e2) {
								e2.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "Cliente n�o encontrado! Verifique as informa��es inseridas.");
						}
					}
				}
				
			}
		});
		btnRemoverCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRemoverCliente.setBounds(247, 191, 142, 23);
		panelRemoverCliente.add(btnRemoverCliente);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limpar textarea do remover cliente
				txtRemoverCliente.setText("");
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpar.setBounds(247, 220, 142, 23);
		panelRemoverCliente.add(btnLimpar);

/////

		JPanel panelEasterEgg = new JPanel();
		panelEasterEgg.setBackground(new Color(240, 240, 240));
		panelEasterEgg.setForeground(new Color(0, 0, 0));
		panel.add(panelEasterEgg, "name_256682365225300");
		panelEasterEgg.setLayout(null);

		JLabel lblNewLabel = new JLabel("Jogo da forca:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(197, 11, 203, 38);
		panelEasterEgg.add(lblNewLabel);

		JButton btnTentativa = new JButton("OK");
		btnTentativa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTentativa.addActionListener(new ActionListener() {
			private String a;
			private String b = "";

			public void actionPerformed(ActionEvent e) {
				char[] arrayPalavraChar = palavra.toCharArray(); // transforma a palavra num array de char
				char[] arrayPalavraChar2 = palavra.toCharArray(); // transforma a palavra num array de char

				x = false;
				errou = false;
				verifica = ' ';

				String[] palpitesErradosString = new String[30];

				if (contador == palavra.length()) { // Se o contador tiver o tamanho da palavra, o jogador ganhou
					// parte 1 do nivel2
					JOptionPane.showMessageDialog(null, "Voc� passou de n�vel!!!");
					proximo = true;
					erros = 0;
					lblPalavra.setText("Palavra: ");
					lblPalpites.setText("Palpites: ");
					txtTentativa.setText("");
					z = 0;
					b = "";
					// x = false;
					errou = false;
					verifica = ' ';
					String[] palpitesErradosString2 = new String[30];

					palavra = niveis.getNivel2()[r2]; // bota a palavra sorteada no n�vel 1 na vari�vel "palavra"

					espacosChars = new char[palavra.length()]; // cria um array de char do tamanho da palavra sorteada
					espacos = new String[palavra.length()];
					palpitesErrados = new char[30];

					lblTentativas.setText("Tentativas: 4"); // informa que possuem 5 tentativas
					lblDica.setText("Dica: " + niveis.getDicas2()[r2]); // mostra a dica da palavra sorteada
					lblLetras.setText("Letras: " + palavra.length()); // informa quantas letras tem a palavra sorteada
					lblNivel.setText("N�vel Dif�cil"); // dificuldade do n�vel

					for (int i = 0; i < palavra.length(); i++) { // percorre a palavra soretada
						String labelPalavra = lblPalavra.getText();
						lblPalavra.setText(labelPalavra + "_  "); // bota os espa�os da palavra
					}
					if (contador == palavra.length()) { // Se o contador tiver o tamanho da palavra, o jogador ganhou
						// acabooou
						JOptionPane.showMessageDialog(null, "PARAB�NS!! VOC� GANHOU! =D");
						panelEasterEgg.setVisible(false);
						panelEasterEggComeco.setVisible(true);
						panelRemoverCliente.setVisible(false);
						panelCliente.setVisible(false);
						panelOpcoes.setVisible(false);
						panelCancelar.setVisible(false);
						panelAgendar.setVisible(false);
						panelPet.setVisible(false);
						panelRemoverPet.setVisible(false);
					} else {
						if (proximo == false) {
							// NIVEL 2
							contador = 0; // conta o n�mero de letras j� acertadas da palavra
							String palpite = txtTentativa.getText().toLowerCase();
							if (palpite.trim().equals("") & proximo == true) { // se apertar enter n�o d� erro
								JOptionPane.showMessageDialog(null, "Entrada inv�lida!");
							} else if (palpite.length() > 1) {
								JOptionPane.showMessageDialog(null, "Entrada inv�lida!");
								x = true;
							}
							char palpiteChar = palpite.toLowerCase().charAt(0);
							for (int i = 0; i < arrayPalavraChar2.length; i++) { // percorre array de char da palavra
								if (palpiteChar == espacosChars[i] & palpite.length() == 1) { // Verifica se a letra
									// certa ja foi digitada
									JOptionPane.showMessageDialog(null, "Letra correta j� digitada! tente outra vez.");
								}
								if (palpiteChar == palpitesErrados[i] & palpite.length() == 1) { // Verifica se a letra
									// errada j� foi
									// digitada
									JOptionPane.showMessageDialog(null, "Letra errada j� digitada! tente outra vez.");
									verifica = palpiteChar;
								}
							}
							for (int i = 0; i < palavra.length(); i++) { // fica rodando at� o tamanho da palavra
								// sorteada
								if (arrayPalavraChar2[i] == palpiteChar & x == false) {
									espacosChars[i] = palpiteChar; // Adiciona o palpite nos arrays espacos e
									// espacosChar
									espacos[i] = palpite;
								}
							}
							a = "";
							for (int i = 0; i < arrayPalavraChar2.length; i++) {
								if (espacosChars[i] == arrayPalavraChar2[i]) {
									a += espacos[i] + "  ";
								} else {
									a += "_  ";
								}
							}
							lblPalavra.setText("Palavra: " + a);

							if (palavra.contains(palpite) == false & verifica != palpiteChar & x == false) {
								erros++;
								errou = true;
								palpitesErrados[z] = palpiteChar;
								palpitesErradosString2[z] = palpite;
								z++;
								tentativas++;
								lblTentativasFeitas.setText("Tentativas Feitas: " + tentativas); // tentativas feitas
							}
							for (int i = 0; i < erros; i++) { // Percorre o array palpitesErrados
								if (errou == true & x == false) {
									if (palpitesErradosString2[i] != null) {
										b += palpitesErradosString2[i] + ", ";
									}
									lblPalpites.setText("Palpites: " + b);
								}
							}
							for (int i = 0; i < palavra.length(); i++) {
								if (espacosChars[i] == arrayPalavraChar2[i]) {
									contador++;
								}
							}
							if (erros == 5) { // Se o jogador usar as 5 chances, ele exibe a mensagem que perdeu
								JOptionPane.showMessageDialog(null, "Voc� Perdeu! =(");
							}
							errou = false;
							x = false;
						} else {
							proximo = false;
						}
					}
					// FIM DO NIVEL 2 parte 2
				} else {
					// parte 2 do nivel1
					contador = 0; // conta o n�mero de letras j� acertadas da palavra
					String palpite = txtTentativa.getText().toLowerCase();
					if (palpite.trim().equals("") & proximo == true) { // se apertar enter n�o d� erro
						JOptionPane.showMessageDialog(null, "Entrada inv�lida!");
					} else if (palpite.length() > 1) {
						JOptionPane.showMessageDialog(null, "Entrada inv�lida!");
						x = true;
					}
					char palpiteChar = palpite.toLowerCase().charAt(0);
					for (int i = 0; i < arrayPalavraChar.length; i++) { // percorre array de char da palavra
						if (palpiteChar == espacosChars[i] & palpite.length() == 1) { // Verifica se a letra certa ja
							// foi digitada
							JOptionPane.showMessageDialog(null, "Letra correta j� digitada! tente outra vez.");
						}
						if (palpiteChar == palpitesErrados[i] & palpite.length() == 1) { // Verifica se a letra errada
							// j� foi digitada
							JOptionPane.showMessageDialog(null, "Letra errada j� digitada! tente outra vez.");
							verifica = palpiteChar;
						}
					}
					for (int i = 0; i < palavra.length(); i++) { // fica rodando at� o tamanho da palavra sorteada
						if (arrayPalavraChar[i] == palpiteChar & x == false) {
							espacosChars[i] = palpiteChar; // Adiciona o palpite nos arrays espacos e espacosChar
							espacos[i] = palpite;
						}
					}
					a = "";
					for (int i = 0; i < arrayPalavraChar.length; i++) {
						if (espacosChars[i] == arrayPalavraChar[i]) {
							a += espacos[i] + "  ";
						} else {
							a += "_  ";
						}
					}
					lblPalavra.setText("Palavra: " + a);

					if (palavra.contains(palpite) == false & verifica != palpiteChar & x == false) {
						erros++;
						errou = true;
						palpitesErrados[z] = palpiteChar;
						palpitesErradosString[z] = palpite;
						z++;
						tentativas++;
						lblTentativasFeitas.setText("Tentativas Feitas: " + tentativas); // tentativas feitas
					}
					for (int i = 0; i < erros; i++) { // Percorre o array palpitesErrados
						if (errou == true & x == false) {
							if (palpitesErradosString[i] != null) {
								b += palpitesErradosString[i] + ", ";
							}
							lblPalpites.setText("Palpites: " + b);
						}
					}
					for (int i = 0; i < palavra.length(); i++) {
						if (espacosChars[i] == arrayPalavraChar[i]) {
							contador++;
						}
					}
					if (erros == 5) { // Se o jogador usar as 5 chances, ele exibe a mensagem que perdeu
						JOptionPane.showMessageDialog(null, "Voc� Perdeu! :(");
					}
					errou = false;
					x = false;
				}
			}
		});
		btnTentativa.setBounds(357, 78, 76, 23);
		panelEasterEgg.add(btnTentativa);

		lblDica = new JLabel("Dica: ");
		lblDica.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDica.setBounds(10, 113, 451, 23);
		panelEasterEgg.add(lblDica);

		lblNivel = new JLabel("N\u00EDvel ");
		lblNivel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNivel.setBounds(10, 281, 98, 18);
		panelEasterEgg.add(lblNivel);

		txtTentativa = new JTextField();
		txtTentativa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTentativa.setBounds(297, 80, 32, 20);
		panelEasterEgg.add(txtTentativa);
		txtTentativa.setColumns(10);

		JLabel lblDigiteUmaLetra = new JLabel("Digite uma letra: ");
		lblDigiteUmaLetra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDigiteUmaLetra.setBounds(151, 79, 144, 23);
		panelEasterEgg.add(lblDigiteUmaLetra);

		lblLetras = new JLabel("Letras: ");
		lblLetras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLetras.setBounds(10, 223, 76, 18);
		panelEasterEgg.add(lblLetras);

		lblTentativas = new JLabel("Tentativas: ");
		lblTentativas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTentativas.setBounds(10, 169, 144, 18);
		panelEasterEgg.add(lblTentativas);

		lblPalavra = new JLabel("Palavra: ");
		lblPalavra.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPalavra.setBounds(161, 275, 459, 23);
		panelEasterEgg.add(lblPalavra);

		lblPalpites = new JLabel("Palpites: ");
		lblPalpites.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPalpites.setBounds(161, 223, 457, 23);
		panelEasterEgg.add(lblPalpites);

		lblTentativasFeitas = new JLabel("Tentativas Feitas: ");
		lblTentativasFeitas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTentativasFeitas.setBounds(161, 169, 155, 18);
		panelEasterEgg.add(lblTentativasFeitas);

		panelEasterEggComeco = new JPanel();
		panel.add(panelEasterEggComeco, "name_391118446526500");
		panelEasterEggComeco.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Jogo da Forca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_1.setBounds(238, 22, 165, 28);
		panelEasterEggComeco.add(lblNewLabel_1);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random r = new Random();
				niveis = new Niveis();

				r1 = r.nextInt(10);
				r2 = r.nextInt(10);

				palavra = niveis.getNivel1()[r1]; // bota a palavra sorteada no n�vel 1 na vari�vel "palavra"

				espacosChars = new char[palavra.length()]; // cria um array de char do tamanho da palavra sorteada
				espacos = new String[palavra.length()];
				palpitesErrados = new char[30];

				lblTentativas.setText("Tentativas: 5"); // informa que possuem 5 tentativas
				lblDica.setText("Dica: " + niveis.getDicas1()[r1]); // mostra a dica da palavra sorteada
				lblLetras.setText("Letras: " + palavra.length()); // informa quantas letras tem a palavra sorteada
				lblNivel.setText("N�vel F�cil"); // dificuldade do n�vel

				for (int i = 0; i < palavra.length(); i++) { // percorre a palavra soretada
					String labelPalavra = lblPalavra.getText();
					lblPalavra.setText(labelPalavra + "_  "); // bota os espa�os da palavra
				}

				panelEasterEgg.setVisible(true);
				panelEasterEggComeco.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelCliente.setVisible(false);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverPet.setVisible(false);

			}
		});
		btnJogar.setBounds(238, 192, 136, 23);
		panelEasterEggComeco.add(btnJogar);

		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelOpcoes.setVisible(true);
				panelEasterEggComeco.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelCliente.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelEasterEgg.setVisible(false);
			}
		});
		btnNewButton.setBounds(238, 226, 136, 23);
		panelEasterEggComeco.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Clique em jogar para iniciar o jogo!");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(187, 106, 251, 20);
		panelEasterEggComeco.add(lblNewLabel_2);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnOpcoes = new JMenu("Consulta");
		menuBar.add(mnOpcoes);

		JMenuItem mntmAgendarConsulta = new JMenuItem("Agendar Consulta");
		mntmAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAgendar.setVisible(true);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelCliente.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnOpcoes.add(mntmAgendarConsulta);

		JMenuItem mntmCancelarConsulta = new JMenuItem("Cancelar Consulta");
		mntmCancelarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCancelar.setVisible(true);
				panelOpcoes.setVisible(false);
				panelAgendar.setVisible(false);
				panelCliente.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnOpcoes.add(mntmCancelarConsulta);

		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);

		JMenuItem menuItem = new JMenuItem("Cadastrar Cliente");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCliente.setVisible(true);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnCliente.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("Remover Cliente");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRemoverCliente.setVisible(true);
				panelCliente.setVisible(false);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnCliente.add(menuItem_1);

		JMenu mnPet = new JMenu("Pet");
		menuBar.add(mnPet);

		JMenuItem menuItem_2 = new JMenuItem("Cadastrar Pet");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPet.setVisible(true);
				panelRemoverCliente.setVisible(false);
				panelCliente.setVisible(false);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnPet.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Remover Pet");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRemoverPet.setVisible(true);
				panelRemoverCliente.setVisible(false);
				panelCliente.setVisible(false);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
				panelEasterEgg.setVisible(false);
				panelEasterEggComeco.setVisible(false);
			}
		});
		mnPet.add(menuItem_3);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpes.add(mntmSair);

		JMenuItem menuEasterEgg = new JMenuItem("?");
		menuEasterEgg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEasterEggComeco.setVisible(true);
				panelEasterEgg.setVisible(false);
				panelRemoverPet.setVisible(false);
				panelRemoverCliente.setVisible(false);
				panelCliente.setVisible(false);
				panelOpcoes.setVisible(false);
				panelCancelar.setVisible(false);
				panelAgendar.setVisible(false);
				panelPet.setVisible(false);
			}
		});
		mnOpes.add(menuEasterEgg);
	}
}