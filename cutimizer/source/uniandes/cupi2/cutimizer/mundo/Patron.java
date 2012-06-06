package uniandes.cupi2.cutimizer.mundo;

import java.util.ArrayList;

import uniandes.cupi2.cutimizer.mundo.interfaces.IPatron;

/**
 * Modela un patr�n de corte
 * 
 * @author SIERRRA
 */
public abstract class Patron implements IPatron {

	/**
	 * La cantidad del patron que se requiere en la soluci�n
	 */
	private int cantidad;

	/**
	 * La identificaci�n del patr�n
	 */
	private int id;

	/**
	 * El conjunto de items en el patr�n
	 */
	private ArrayList<ItemSolucion> items;

	/**
	 * El precio del patr�n
	 */
	private double precio;

	/**
	 * Indicaciones de c�mo cortar esta patr�n
	 */
	private String indicacionesCorte;

	/**
	 * Construye un nuevo Patron con los par�metros dados y sin indicaciones de
	 * corte
	 * 
	 * @param items
	 * @param precio
	 * @param id
	 * @param cantidad
	 */
	public Patron(ArrayList<ItemSolucion> items, double precio, int id,
			int cantidad) {
		this.cantidad = cantidad;
		this.asignarPrecio(precio);
		this.items = items;
		this.id = id;
		indicacionesCorte = "No existen indicaciones de corte para este patr�n";
	}

	/**
	 * Construye una nueva instancia con las indicaciones de corte dadas
	 * 
	 * @param items
	 * @param precio
	 * @param id
	 * @param cantidad
	 * @param indicaciones
	 */
	public Patron(ArrayList<ItemSolucion> items, double precio, int id,
			int cantidad, String indicaciones) {
		this.cantidad = cantidad;
		this.asignarPrecio(precio);
		this.items = items;
		this.id = id;
		this.indicacionesCorte = indicaciones;
	}

	/**
	 * Da la cantidad del item con medidas especificadas hay en este patron
	 * 
	 * @param alto
	 *            el alto del item
	 * @param ancho
	 *            el ancho del item
	 * @param espesor
	 *            el espesor del item
	 * @return la cantidad del item en este patron
	 */
	@Override
	public int darCantidadItem(int alto, int ancho, int espesor) {
		int cantidad = 0;
		for (ItemSolucion is : items) {
			Item i = is.getRepresentado();
			if (i.getAlto() == alto && i.getAncho() == ancho
					&& i.getEspesor() == espesor)
				cantidad++;
		}
		return cantidad;
	}

	/**
	 * Devuelve los items del patron
	 * 
	 * @return la estructura de datos con los patrones
	 */
	@Override
	public ArrayList<ItemSolucion> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Patr�n #" + id + ": " + cantidad + " l�mina(s) de "
				+ darEspesorContenedora() + " mm";
	}

	@Override
	/**
	 * Da indicaciones de c�mo cortar la l�mina para obtener el patr�n
	 */
	public String darIndicacionesDeCorte() {
		return indicacionesCorte;
	}

	@Override
	/**
	 * Da una descripci�n del patr�n
	 */
	public String darDescripcion() {
		String patron = "Patr�n " + id + " - l�mina de "
				+ darEspesorContenedora() + " mm de espesor" + '\n';
		patron += "Costo unitaro " + precio + '\n';
		patron += "Costo total " + darPrecio() + '\n' + '\n';

		patron += "Descripci�n de los items" + '\n' + '\n';
		int contador = 1;
		for (ItemSolucion item : items) {
			patron += contador + ". " + item.toString();
			contador++;
		}

		return patron;
	}

	@Override
	/**
	 * Da la cantidad necesidad del patr�n
	 */
	public int darCantidad() {
		return cantidad;
	}

	/**
	 * Da el precio
	 * 
	 * @return the precio
	 */
	@Override
	public double darPrecio() {
		return precio * cantidad;
	}

	/**
	 * Asignar un nuevo precio al patr�n
	 * 
	 * @param precio
	 *            the precio to set
	 */
	public void asignarPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * Modifica la cantidad necesitada del patr�n
	 */
	@Override
	public void asignarCantidad(int nCantidad) {
		cantidad = nCantidad;
	}

	/**
	 * Retorna el espesor de la contenedora de donde sale el patr�n
	 */
	public int darEspesorContenedora() {
		return items.get(0).getRepresentado().getEspesor();
	}



}
