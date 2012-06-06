package uniandes.cupi2.cutimizer.mundo.problemamaestro;

import java.util.ArrayList;

import uniandes.cupi2.cutimizer.mundo.Item;
import uniandes.cupi2.cutimizer.mundo.Contenedora;
import uniandes.cupi2.cutimizer.mundo.interfaces.IProblemaMaestro;

/**
 * @author SIERRRA
 */
public abstract class ProblemaMaestro implements IProblemaMaestro {

	/**
	 * La cota superior para las variables de decis�n
	 * 
	 * @uml.property name="cotaSuperior"
	 */
	private double cotaSuperior;

	/**
	 * Lista de items de sub contenedoras necesarias para ser cortadas
	 * 
	 * @uml.property name="items"
	 */
	private ArrayList<Item> items;

	/**
	 * Lista de contenedoras disponibles
	 */
	private ArrayList<Contenedora> contenedoras;

	/**
	 * El valor del precio de las contenedoras m�s altos
	 * 
	 * @uml.property name="precioMasAlto"
	 */
	private double precioMasAlto;

	/**
	 * N�mero de columnas agregadas
	 * 
	 * @uml.property name="numCol"
	 */
	private int numCol;

	/**
	 * Indica si el �ltimo problema ejecutado es la relajaci�n lineal
	 * 
	 * @uml.property name="relajacionLineal"
	 */
	private boolean relajacionLineal;

	/**
	 * Construye un objeto de tipo ProblemaMaestro
	 * 
	 * @param items
	 *            las items necesitadas
	 * @param contenedoras
	 *            las contenedoras de las cuales se dispone
	 */
	public ProblemaMaestro(ArrayList<Item> nDemandas,
			ArrayList<Contenedora> nLaminas) {
		setNumCol(1);
		this.items = nDemandas;
		this.contenedoras = nLaminas;
		asignarCotaSuperior();
		asignarPrecioMasAlto();
	}

	/**
	 * Asigna el valor de la cota superior para las variables de decisi�n
	 */
	private void asignarCotaSuperior() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getCantidad();
		}
		setCotaSuperior(total);
	}

	/**
	 * Asignar el precio m�s alto de todas las contenedoras
	 */
	private void asignarPrecioMasAlto() {
		double max = 0;
		for (int i = 0; i < contenedoras.size(); i++) {
			if (contenedoras.get(i).getPrecio() >= max)
				max = contenedoras.get(i).getPrecio();
		}
		setPrecioMasAlto(max);
	}

	/**
	 * Retorna el precio m�s alto
	 * 
	 * @return el precio m�s alto
	 * @uml.property name="precioMasAlto"
	 */
	public double getPrecioMasAlto() {
		return precioMasAlto;
	}

	/**
	 * Asingar el precio m�s alto
	 * 
	 * @param precioMasAlto
	 *            el precio m�s alto
	 * @uml.property name="precioMasAlto"
	 */
	private void setPrecioMasAlto(double precioMasAlto) {
		this.precioMasAlto = precioMasAlto;
	}

	/**
	 * Asigna la cota superior de las variables de decisi�n
	 * 
	 * @param cotaSuperior
	 *            de las variables de decisi�n
	 * @uml.property name="cotaSuperior"
	 */
	private void setCotaSuperior(double cotaSuperior) {
		this.cotaSuperior = cotaSuperior;
	}

	/**
	 * Retorna la cota superior de las variables de decisi�n
	 * 
	 * @return la cota superior
	 * @uml.property name="cotaSuperior"
	 */
	public double getCotaSuperior() {
		return cotaSuperior;
	}

	/**
	 * Retorna el arreglo de items
	 * 
	 * @return el arreglo de items
	 * @uml.property name="items"
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Retorna el n�mero de columnas que hay en el problema
	 * 
	 * @return el n�mero de columnas
	 * @uml.property name="numCol"
	 */
	public int getNumCol() {
		return numCol;
	}

	/**
	 * Asigna el n�mero de columnas que hay en el problema
	 * 
	 * @param numCol
	 *            el nuevo n�mero de columnas
	 * @uml.property name="numCol"
	 */
	public void setNumCol(int numCol) {
		this.numCol = numCol;
	}

	/**
	 * Muestra si el �ltimo problema corrido fue la relajaci�n lineal
	 * 
	 * @return si el �ltimo problema fue una relajaci�n lineal
	 * @uml.property name="relajacionLineal"
	 */
	public boolean isRelajacionLineal() {
		return relajacionLineal;
	}

	/**
	 * Cambia el valor de relajacionLineal
	 * 
	 * @param relajacionLineal
	 *            el nuevo valor
	 * @uml.property name="relajacionLineal"
	 */
	public void setRelajacionLineal(boolean relajacionLineal) {
		this.relajacionLineal = relajacionLineal;
	}



}
