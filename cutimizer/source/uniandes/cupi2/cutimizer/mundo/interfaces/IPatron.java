package uniandes.cupi2.cutimizer.mundo.interfaces;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import uniandes.cupi2.cutimizer.mundo.ItemSolucion;

public interface IPatron 
{
	/**
	 * Todo patr�n debe saber dibujarse en el lienzo
	 * @param lienzo para dibujarse
	 * @parama escala la escala de representacion usada pixl/cm
	 */
	public void dibujarse(Graphics2D lienzo, int escala);

	/**
	 * Da la cantidad que hay de un item con medidas dadas en el patr�n
	 * @param alto
	 * @param ancho
	 * @param espesor
	 * @return la cantidad de dicho item en el patr�n
	 */
	int darCantidadItem(int alto, int ancho, int espesor);

	/**
	 * Da los items del patr�n
	 * @return los items
	 */
	public ArrayList<ItemSolucion> getItems();
	
	/**
	 * Da el precio total del patron
	 * @return el precio del patron
	 */
	public double darPrecio();
	/**
	 * Da la descripci�n del patr�n
	 * @return la descripci�n del patr�n
	 */
	public String darDescripcion();
	
	/**
	 * Da las indicaciones de corte del patr�n
	 * @return las indicaciones de c�mo cortar el patr�n
	 */
	public String darIndicacionesDeCorte();
	
	/**
	 * Da la cantidad de patrones necesitados en la soluci�n
	 * @return la cantidad de patrones
	 */
	public int darCantidad();
	
	/**
	 * Modifica la cantidad del patron por la nueva cantidad
	 * @param nCantidad la nueva cantidad
	 */
	public void asignarCantidad(int nCantidad);


	/**
	 * Crea la iamgen del patron en la ruta especificada y con los par�metros dados
	 * @param ruta la ruta de la imagen
	 * @param ancho el ancho de la imagen
	 * @param alto el alto de la imagen 
	 * @throws IOException si se produce un error escribiendo el archivo
	 */
	public void crearImagenPatron(String ruta) throws IOException;

}
