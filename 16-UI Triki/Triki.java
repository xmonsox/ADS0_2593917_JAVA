import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triki extends JFrame{

	int ganador;
	int turno;
	char tablero_interno [][];
	JLabel tablero_lbls [][];
	JLabel etq_usuario; 

	public Triki(){
		this.ganador = 0;
		this.turno = 1;
		initComponents();
	}

	public void initComponents(){

		JPanel contPrincipal = new JPanel();
		contPrincipal.setLayout(new GridBagLayout());
		contPrincipal.setBorder( BorderFactory.createEmptyBorder(5, 5, 5, 5) );
		GridBagConstraints restriccion = new GridBagConstraints();

		etq_usuario = new JLabel("-");
		etq_usuario.setFont(new Font("Arial black", Font.BOLD, 30));
		etq_usuario.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 0;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 1;
		restriccion.weightx = 3;
		restriccion.insets = new Insets(5,5,5,5);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add(etq_usuario, restriccion);

		tablero_interno = new char [3][3];
		tablero_lbls = new JLabel [3][3];
		for (int i=0; i<tablero_lbls.length; i++) {
			for (int j=0; j<tablero_lbls[i].length; j++) {
				tablero_lbls[i][j] = new JLabel();
				tablero_interno[i][j] = '-';
				tablero_lbls[i][j].setFont(new Font("Snap ITC",Font.BOLD,65));
				tablero_lbls[i][j].setOpaque(true);
				tablero_lbls[i][j].setBackground( Color.white );
				tablero_lbls[i][j].setHorizontalAlignment( JLabel.CENTER );
				restriccion.gridy = (i+1);
				restriccion.gridx = j;
				restriccion.gridheight = 1;
				restriccion.gridwidth = 1;
				restriccion.weighty = 1;
				restriccion.weightx = 1;
				restriccion.fill = GridBagConstraints.BOTH;
				restriccion.insets = new Insets(5,5,5,5);
				contPrincipal.add( tablero_lbls[i][j], restriccion );

				final int fila = i;
                final int columna = j;
                MouseAdapter evento = new MouseAdapter(){
                    @Override
	                public void mouseClicked(MouseEvent e) {
	                    marcarCasilla( fila, columna);
	                }             
                };
                this.tablero_lbls[i][j].addMouseListener(evento);
			}
		}
		add(contPrincipal);
		setTitle("Tres en Linea");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setVisible(true);

		imprimirTablero();
		ganoPartida();
	}

	public void imprimirTablero(){
		this.etq_usuario.setText( (this.turno==1)? "Usuario":"IA" );
		this.etq_usuario.setForeground( (this.turno==1)? Color.black:Color.red );
		for (int i=0; i<tablero_interno.length; i++) {
			for (int j=0; j<tablero_interno[i].length; j++) {
				this.tablero_lbls[i][j].setText( String.valueOf(this.tablero_interno[i][j]) );
			}
		}
		revalidate();
	}

	public void marcarCasillaUser(int fila, int columna){
		if( this.tablero_interno[fila][columna]=='-'){
			System.out.println("U");
			marcarCasilla(fila, columna);
			ganoPartida();
			
			this.turno = (this.turno%2)+1;
			if(this.turno==2 && this.casillaVacia()){
				System.out.println("M");
				this.validaMaquina();
				
				ganoPartida();
				this.turno = (this.turno%2)+1;
			}

		}else{
			System.out.println("La Posicion es invalida.");
		}
	}

	public boolean casillaVacia(){
		boolean correcto = false;
		for (int i=0;i<this.tablero_interno.length;i++){
			for(int j=0;j<this.tablero_interno[i].length;j++){
				if(this.tablero_interno[i][j] == '-'){
					correcto = true;
					break;
				}
			}
		}
		return correcto;
	}
	public void marcarCasilla(int fila, int columna){
		char ficha = (this.turno==1)? 'X':'0';
		this.tablero_interno[fila][columna] = ficha;
		this.tablero_lbls[fila][columna].setForeground( (this.turno==1)? Color.black:Color.red );
		this.imprimirTablero();
	}

	public void ganoPartida(){
		for (int i = 0; i < 3; i++) {
			if (tablero_interno[i][0] == tablero_interno[i][1] && tablero_interno[i][0] == tablero_interno[i][2] && tablero_interno[i][0] != '-') {
				ganador = (tablero_interno[i][0] == 'X') ? 1 : 2;
				System.out.println("El ganador es el jugador " + ganador);
				return;
			}
		}
		for (int j = 0; j < 3; j++) {
			if (tablero_interno[0][j] == tablero_interno[1][j] && tablero_interno[0][j] == tablero_interno[2][j] && tablero_interno[0][j] != '-') {
				ganador = (tablero_interno[0][j] == 'X') ? 1 : 2;
				System.out.println("El ganador es el jugador " + ganador);
				return;
			}
		}
		if (tablero_interno[0][0] == tablero_interno[1][1] && tablero_interno[0][0] == tablero_interno[2][2] && tablero_interno[0][0] != '-') {
			ganador = (tablero_interno[0][0] == 'X') ? 1 : 2;
			System.out.println("El ganador es el jugador " + ganador);
			return;
		}
		if (tablero_interno[0][2] == tablero_interno[1][1] && tablero_interno[0][2] == tablero_interno[2][0] && tablero_interno[0][2] != '-') {
			ganador = (tablero_interno[0][2] == 'X') ? 1 : 2;
			System.out.println("El ganador es el jugador " + ganador);
			return;
		}
	}
	public void validaMaquina(){
		if(tablero_interno[0][0] == '0' && tablero_interno[0][1] == '0' && tablero_interno[0][2] == '-'){
			marcarCasilla(0,2);
		}else if(tablero_interno[0][0] == '0' && tablero_interno[0][2] == '0' && tablero_interno[0][1] == '-'){
			marcarCasilla(0,1);	
		}else if(tablero_interno[0][2] == '0' && tablero_interno[0][1] == '0' && tablero_interno[0][0] == '-'){
			marcarCasilla(0,0);	
		}else if(tablero_interno[1][0] == '0' && tablero_interno[1][1] == '0' && tablero_interno[1][2] == '-'){
			marcarCasilla(1,2);	
		}else if(tablero_interno[1][0] == '0' && tablero_interno[1][2] == '0' && tablero_interno[1][1] == '-'){
			marcarCasilla(1,1);	
		}else if(tablero_interno[1][2] == '0' && tablero_interno[1][1] == '0' && tablero_interno[1][0] == '-'){
			marcarCasilla(1,0);	
		}else if(tablero_interno[2][0] == '0' && tablero_interno[2][1] == '0' && tablero_interno[2][2] == '-'){
			marcarCasilla(2,2);	
		}else if(tablero_interno[2][0] == '0' && tablero_interno[2][2] == '0' && tablero_interno[2][1] == '-'){
			marcarCasilla(2,1);	
		}else if(tablero_interno[2][1] == '0' && tablero_interno[2][2] == '0' && tablero_interno[2][0] == '-'){
			marcarCasilla(2,0);	
		}else if(tablero_interno[0][0] == '0' && tablero_interno[1][0] == '0' && tablero_interno[2][0] == '-'){
			marcarCasilla(2,0);	
		}else if(tablero_interno[0][0] == '0' && tablero_interno[2][0] == '0' && tablero_interno[1][0] == '-'){
			marcarCasilla(1,0);	
		}else if(tablero_interno[2][0] == '0' && tablero_interno[1][0] == '0' && tablero_interno[0][0] == '-'){
			marcarCasilla(0,0);	
		}else if(tablero_interno[0][1] == '0' && tablero_interno[1][1] == '0' && tablero_interno[2][1] == '-'){
			marcarCasilla(2,1);	
		}else if(tablero_interno[2][1] == '0' && tablero_interno[0][1] == '0' && tablero_interno[1][1] == '-'){
			marcarCasilla(1,1);	
		}else if(tablero_interno[2][1] == '0' && tablero_interno[1][1] == '0' && tablero_interno[0][1] == '-'){
			marcarCasilla(0,1);	
		}else if(tablero_interno[0][2] == '0' && tablero_interno[1][2] == '0' && tablero_interno[2][2] == '-'){
			marcarCasilla(2,2);	
		}else if(tablero_interno[0][2] == '0' && tablero_interno[2][2] == '0' && tablero_interno[1][2] == '-'){
			marcarCasilla(1,2);	
		}else if(tablero_interno[2][2] == '0' && tablero_interno[1][2] == '0' && tablero_interno[0][2] == '-'){
			marcarCasilla(0,2);	
		}else if(tablero_interno[0][0] == '0' && tablero_interno[1][1] == '0' && tablero_interno[2][2] == '-'){
			marcarCasilla(2,2);	
		}else if(tablero_interno[0][0] == '0' && tablero_interno[2][2] == '0' && tablero_interno[1][1] == '-'){
			marcarCasilla(1,1);	
		}else if(tablero_interno[1][1] == '0' && tablero_interno[2][2] == '0' && tablero_interno[0][0] == '-'){
			marcarCasilla(0,0);	
		}else if(tablero_interno[2][0] == '0' && tablero_interno[1][1] == '0' && tablero_interno[0][2] == '-'){
			marcarCasilla(0,2);	
		}else if(tablero_interno[2][0] == '0' && tablero_interno[0][2] == '0' && tablero_interno[1][1] == '-'){
			marcarCasilla(1,1);	
		}else if(tablero_interno[1][1] == '0' && tablero_interno[0][2] == '0' && tablero_interno[2][0] == '-'){
			marcarCasilla(2,0);	
		}else if(tablero_interno[0][2] == '0' && tablero_interno[0][1] == '0' && tablero_interno[0][0] == '-'){
			marcarCasilla(0,1);	
		}

	}
}