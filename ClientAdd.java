import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.time.*;


public class ClientAdd implements ActionListener {
	Container container;
	JButton submit, submitDel;
	JTextField name, surname, phone, email;
	JFormattedTextField date;
	JTextArea note;
	Client client;
	Clients clients;
	int formNo = 1;
	JCheckBox oferta, umowa, realizacja;
	JComboBox < String > status;
	JFrame frame;



	public ClientAdd(JFrame frame, Client client, Clients clients) {
		this.container = frame.getContentPane();
		this.client = client;
		this.frame = frame;
		this.clients = clients;
	}


	public void getForm() {

		JPanel content = new JPanel(null);

		this.name = new JTextField(this.client.getName());
		this.addToForm(this.name, "Imie", content, 1, 1);

		this.surname = new JTextField(this.client.getSurname());
		this.addToForm(this.surname, "Nazwisko", content, 1, 1);

		this.phone = new JTextField(this.client.getPhone());
		this.addToForm(this.phone, "Telefon", content, 1, 1);

		this.email = new JTextField(this.client.getEmail());
		this.addToForm(this.email, "Email", content, 1, 1);


		// String datef = new SimpleDateFormat("MM/dd/yy  HH:mm").format(this.client.getDate());
		// this.date = new JFormattedTextField(datef);
		// this.addToForm(date, "Data kontaktu", content, 1, 1);


		this.note = new JTextArea(this.client.getNote());
		JScrollPane sp = new JScrollPane(this.note);
		sp.setBounds(410, 30, 300, 200);
		content.add(sp);


		this.status = new JComboBox < String > ();
		status.addItem("Nowy klient");
		status.addItem("Przygotowanie oferty");
		status.addItem("Akceptacja oferty");
		status.addItem("Umówienie spotkania");
		status.addItem("Podpisanie umowy");
		status.addItem("Zlecenie w realizacji");
		status.addItem("Zakończony");

		status.setSelectedIndex(this.client.getStatusVal());
		this.addToForm(this.status, "Status", content, 1, 1);


		this.oferta = new JCheckBox("Oferta", this.client.getOferta());
		this.addToForm(this.oferta, "", content, 1, 1);

		this.umowa = new JCheckBox("Umowa", this.client.getUmowa());
		this.addToForm(this.umowa, "", content, 1, 1);

		this.realizacja = new JCheckBox("Realizacja", this.client.getRealizacja());
		this.addToForm(this.realizacja, "", content, 1, 1);


		this.submit = new JButton("Zapisz");
		this.submit.addActionListener(this);
		this.addToForm(this.submit, "", content, 1, 1);

		if (!this.client.isNew()) {
			this.submitDel = new JButton("Usuń");
			this.submitDel.addActionListener(this);
			this.addToForm(this.submitDel, "", content, 1, 1);
		}

		this.container.add(content, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object sorce = e.getSource();


		if (sorce == submit) {

			this.client.setName(this.name.getText());
			this.client.setSurname(this.surname.getText());
			this.client.setPhone(this.phone.getText());
			this.client.setEmail(this.email.getText());
			this.client.setStatus(this.status.getSelectedItem().toString());

			this.client.setOferta(this.oferta.isSelected());
			this.client.setRealizacja(this.realizacja.isSelected());
			this.client.setUmowa(this.umowa.isSelected());

			this.client.setStatusVal(this.status.getSelectedIndex());


			this.client.setNote(this.note.getText());

			if (this.client.isValid()) {

				if (this.client.isNew()) {
					this.clients.addAndSave(this.client);
					JOptionPane.showMessageDialog(null, "Dodano nowego klienta " + this.client.getName());
					ToolBar tb = new ToolBar(this.frame);
					tb.userList();
					this.frame.validate();

				} else {
					this.clients.saveAll();
					JOptionPane.showMessageDialog(null, "Zapisano " + this.client.getName());
					this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie dane prawidłowo");
			}
		}


		if (sorce == submitDel) {
			this.clients.remove(this.client);
			this.clients.saveAll();
			JOptionPane.showMessageDialog(null, "Usunięto " + this.client.getName());
			this.frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

	}


	public void addToForm(JComponent input, String labelName, JPanel content, int column, int row) {
		JLabel label;
		int lableWidth = 180;
		int space = 10;
		int height = 20;
		int width = 200;
		int x = space;
		int y = this.formNo * (height + space);

		this.formNo += row;

		if (labelName.length() > 0) {
			label = new JLabel(labelName);
			label.setBounds(space, y, lableWidth, height);
			content.add(label);
		}

		height = (height * row) + ((row - 1) * space);

		content.add(input);
		input.setBounds(lableWidth + space * 2, y, width, height);
	}

}