import javax.swing.table.AbstractTableModel;


public class ClientTable extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Status", "Imie", "Nazwisko", "Email", "Telefon", "Oferta", "Umowa"};
        private Clients list;
     
    

        ClientTable() {
            list = new Clients();
        }
     
        public ClientTable(Clients l) {
            setList(l);
        }
     
        public final void setList(Clients l) {
            list = l;
        }
     
        public Clients getList() {
            return list;
        }
     
        public int getRowCount() {
            return list.pobierzliste().size();
        }
     
        public int getColumnCount() {
            return columnNames.length;
        }
     
        public String getColumnName(int col) {
            return columnNames[col];
        }
     
        public Object getValueAt(int rowIndex, int columnIndex) {
            Client obj = list.getFromList(rowIndex);

            Object objArray[] = {obj.getStatus(), obj.getName(), obj.getSurname(), obj.getEmail(), obj.getPhone(),  obj.getOferta() ? "tak" : "nie" ,  obj.getUmowa() ? "tak" : "nie"};
            return objArray[columnIndex];
        }

}

