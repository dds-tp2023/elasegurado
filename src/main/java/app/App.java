package app;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ui.login.InicioSesion;
import utils.HibernateUtil;
import java.awt.event.WindowAdapter;

public class App {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		JFrame ventana = new JFrame();
		ventana.addWindowListener(
				new WindowAdapter()
				{
					@Override
					public void windowClosing(WindowEvent windowEvent)
					{
						HibernateUtil.shutdown();
					}
				}
		);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventana.setTitle("El Asegurado - Inicio de Sesión");
		ventana.setContentPane(new InicioSesion(ventana));
		ventana.setVisible(true);
	}
}